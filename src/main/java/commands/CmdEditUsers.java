package commands;

import dao.Dao;
import pojo.User;
import util.FormHelper;
import util.Patterns;
import util.Validator;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

public class CmdEditUsers extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();

        if (FormHelper.pressedButton(req,"update")){
            User user = new User(
                    Validator.getLong(req, "id"),
                    Validator.getString(req,"login", Patterns.LOGIN),
                    md5Hex(Validator.getString(req,"password",Patterns.PASSWORD)),
                    Validator.getString(req,"email",Patterns.EMAIL),
                    Validator.getLong(req,"role_id")
            );
            dao.user.update(user);
            return this;
        }

        if (FormHelper.pressedButton(req,"delete")) {
            User user = dao.user.read(Validator.getLong(req, "id"));
            dao.user.delete(user);
            return this;
        }

        List<User> users = dao.user.getAll();
        req.setAttribute("AllUsers",users);

        return null;
    }
}
