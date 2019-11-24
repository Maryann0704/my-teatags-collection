package commands;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public abstract class Cmd {
    public abstract Cmd execute(HttpServletRequest req) throws SQLException;

    @Override
    public String toString() {
        return this
                .getClass()
                .getSimpleName()
                .toLowerCase()
                .replace("cmd","");
    }

    public String getJsp(){
        return "/"+this.toString()+".jsp";
    }
}
