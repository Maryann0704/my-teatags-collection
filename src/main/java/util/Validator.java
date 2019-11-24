package util;

import exceptions.SiteException;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Validator {

    public static String getString(HttpServletRequest req, String name, String pattern) {
        String value = req.getParameter(name);
        if (value.matches(pattern))
            return value;
        throw new SiteException("Incorrect value of " + name);
    }

    public static int getInt(HttpServletRequest req, String name) {
        try {
            return Integer.parseInt(req.getParameter(name));
        } catch (Exception e) {
            throw new SiteException("Incorrect value of "+name);
        }
    }

    public static double getDouble(HttpServletRequest req, String name) {
        try {
            return Double.parseDouble(req.getParameter(name));
        } catch (Exception e) {
            throw new SiteException("Incorrect value of "+name);
        }
    }

    public static Date getDate(HttpServletRequest req, String name) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date utilDate = df.parse(req.getParameter(name));
            return new Date(utilDate.getTime());
        } catch (Exception e) {
            throw new SiteException("Incorrect value of "+name);
        }
    }

    public static long getLong(HttpServletRequest req, String name) {
        try {
            return Long.parseLong(req.getParameter(name));
        } catch (Exception e) {
            throw new SiteException("Incorrect value of "+name);
        }
    }

    public static float getFloat(HttpServletRequest req, String name) {
        try {
            return Float.parseFloat(req.getParameter(name));
        } catch (Exception e) {
            throw new SiteException("Incorrect value of "+name);
        }
    }

}
