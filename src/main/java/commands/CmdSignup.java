package commands;

import dao.Dao;
import exceptions.SiteException;
import pojo.User;
import util.FormHelper;
import util.Patterns;
import util.Validator;

import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

public class CmdSignup extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) {

        Dao dao = Dao.getDao();

        if (FormHelper.isPost(req)) {
            User user = new User(0,
                    Validator.getString(req, "login", Patterns.LOGIN),
                    md5Hex(Validator.getString(req, "password", Patterns.PASSWORD)),
                    Validator.getString(req, "email", Patterns.EMAIL),
                    2);
            try {
                if (dao.user.create(user))
                    return Actions.PROFILE.command;
            }
            catch (SQLException e) {
                throw new SiteException("This login is busy");
            }
        }
        return null;
    }
}
