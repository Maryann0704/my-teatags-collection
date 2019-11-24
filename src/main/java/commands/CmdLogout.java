package commands;

import util.FormHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdLogout extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) {

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        if (user != null && FormHelper.pressedButton(req, "logout")) {
            session.invalidate();
            return Actions.INDEX.command;
        }

        if (user != null && FormHelper.pressedButton(req, "no"))
            return Actions.PROFILE.command;


        return null;
    }
}
