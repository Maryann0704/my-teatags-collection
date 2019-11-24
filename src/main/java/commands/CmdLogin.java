package commands;

import dao.Dao;
import exceptions.SiteException;
import org.apache.commons.codec.digest.DigestUtils;
import pojo.User;
import util.FormHelper;
import util.Patterns;
import util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;


public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {

        if (FormHelper.isPost(req)) {
            String login = Validator.getString(req, "login", Patterns.LOGIN);

            String where = String.format("WHERE login='%s'", login);
            List<User> users = Dao.getDao().user.getAll(where);
            Iterator<User> iterator = users.iterator();
            if (!iterator.hasNext()) {
                return Actions.SIGNUP.command;
            }
            User user = iterator.next();
            String passwordForm = DigestUtils.md5Hex(
                    Validator.getString(req, "password", Patterns.PASSWORD));
            String passwordBase = user.getPassword();
            if (passwordBase.equals(passwordForm)) {
                HttpSession session = req.getSession(true);
                session.setAttribute("user", user);
                return Actions.PROFILE.command;
            }
            else
                throw new SiteException("Incorrect password");
        }
        return null;
    }
}
