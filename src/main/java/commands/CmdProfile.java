package commands;

import dao.Dao;
import exceptions.SiteException;
import pojo.Teatag;
import pojo.TeatagString;
import pojo.User;
import util.FormHelper;
import util.Patterns;
import util.Tools;
import util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

public class CmdProfile extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {

        Dao dao = Dao.getDao();
        User user = Tools.isUserInSession(req);

        if (user == null) {
            return Actions.LOGIN.command;
        }

        if (FormHelper.isPost(req)) {

            if (FormHelper.pressedButton(req, "updateLogin")) {
                String login = Validator.getString(req, "login", Patterns.LOGIN);
                List<User> users = dao.user.getAll();
                for (User user1 : users) {
                    if (user1.getLogin().equals(login)) {
                        throw new SiteException("This login is busy");
                    }
                }
                user.setLogin(login);
                dao.user.update(user);
                return this;
            }

            if (FormHelper.pressedButton(req, "updatePass")) {
                String password = md5Hex(Validator.getString(req, "password", Patterns.PASSWORD));
                user.setPassword(password);
                dao.user.update(user);
                return this;
            }

            if (FormHelper.pressedButton(req, "updateMail")) {
                String email = Validator.getString(req, "email", Patterns.EMAIL);
                user.setEmail(email);
                dao.user.update(user);
                return this;
            }

            if (FormHelper.pressedButton(req, "deleteAc")) {
                dao.user.delete(user);
                HttpSession session = req.getSession();
                session.invalidate();
                return Actions.INDEX.command;
            }

            if (FormHelper.pressedButton(req,"createTag")) {
                return Actions.CREATETAG.command;
            }

            if (FormHelper.pressedButton(req,"deleteTag")) {
                Teatag teatag = dao.teatag.read(Validator.getLong(req, "deleteTag"));
                dao.teatag.delete(teatag);
                return this;
            }
        }

        List<TeatagString> userTeatags = Dao.getDao().teatag.getSelected(user.getId());
        req.setAttribute("userTeatagsSize", userTeatags.size());
        req.setAttribute("userTeatags", userTeatags);

        return null;
    }
}
