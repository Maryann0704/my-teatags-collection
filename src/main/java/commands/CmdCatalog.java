package commands;

import dao.Dao;
import pojo.TeatagString;
import util.FormHelper;
import util.Validator;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdCatalog extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        List<TeatagString> teatags = dao.teatag.getSelected("");
        req.setAttribute("teatagsSize", teatags.size());
        int start = 0;
        if (FormHelper.pressedButton(req,"start"))
            start = Validator.getInt(req,"start");
        String limit = String.format(" LIMIT %s,10", start);
        teatags = dao.teatag.getSelected(limit);
        req.setAttribute("teatags", teatags);
        return null;
    }
}
