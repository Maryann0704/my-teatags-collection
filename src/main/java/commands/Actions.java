package commands;

import javax.servlet.http.HttpServletRequest;

public enum Actions {
    LOGIN (new CmdLogin()),
    LOGOUT (new CmdLogout()),
    SIGNUP (new CmdSignup()),
    EDITUSERS (new CmdEditUsers()),
    ERROR (new CmdError()),
    INDEX (new CmdIndex()),
    CATALOG(new CmdCatalog()),
    RESETDATABASE(new CmdResetDataBase()),
    PROFILE(new CmdProfile()),
    CREATETAG(new CmdCreateTag());

    public Cmd command;

    Actions(Cmd command) {
        this.command = command;
    }

    public static Cmd defineCommand(HttpServletRequest req) {
        String nameCommand = req.getParameter("command").toUpperCase();
        try {
            return Actions.valueOf(nameCommand).command;
        } catch (IllegalArgumentException e) {
            return Actions.ERROR.command;
        }
    }
}
