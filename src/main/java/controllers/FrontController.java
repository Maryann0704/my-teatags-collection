package controllers;

import commands.Actions;
import commands.Cmd;
import pojo.Role;
import pojo.Trademark;
import dao.Dao;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class FrontController extends HttpServlet {

    @Override
    public void init() {
        Dao dao = Dao.getDao();
        List<Role> roles = null;
        List<Trademark> trademarks = null;
        try {
            trademarks = dao.trademark.getAll();
            roles = dao.role.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("roles",roles);
        servletContext.setAttribute("trademarks", trademarks);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            process(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        try {
            process(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Cmd cmd = Actions.defineCommand(req);
            Cmd next = cmd.execute(req);

            if (next==null){
                getServletContext()
                        .getRequestDispatcher(cmd.getJsp())
                        .forward(req, resp);
            }
            else {
                resp.sendRedirect("do?command="+next.toString());
            }

        } catch (Exception e) {
            getServletContext().setAttribute("Error", getErrorTxt(e));
            resp.sendRedirect("do?command=Error");
        }
    }

    private static String getErrorTxt(Exception e) {
        return e.getMessage();
    }
}
