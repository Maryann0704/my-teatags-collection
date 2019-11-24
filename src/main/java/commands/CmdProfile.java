package commands;

import dao.Dao;
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

            if (FormHelper.pressedButton(req, "updateAc")) {
                String login = Validator.getString(req, "login", Patterns.LOGIN);
                String password = md5Hex(Validator.getString(req, "password", Patterns.PASSWORD));
                String email = Validator.getString(req, "email", Patterns.EMAIL);
                user.setLogin(login);
                user.setPassword(password);
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

        List<TeatagString> usersTeatags = Dao.getDao().teatag.getSelected(user.getId());
        req.setAttribute("usersTeatagsSize", usersTeatags.size());
        req.setAttribute("usersTeatags", usersTeatags);

        return null;
    }
}
