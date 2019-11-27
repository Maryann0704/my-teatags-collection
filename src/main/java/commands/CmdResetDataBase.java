package commands;

import dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CmdResetDataBase extends Cmd{
    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        dao.resetDataBase();
        HttpSession session = req.getSession();
        session.invalidate();
        return Actions.INDEX.command;
    }
}
