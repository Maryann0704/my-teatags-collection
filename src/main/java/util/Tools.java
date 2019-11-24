package util;

import pojo.Teatag;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;

public class Tools {

    public static User isUserInSession(HttpServletRequest req) {
        Object objUser = req.getSession().getAttribute("user");
        if (objUser == null)
            return null;
        return (User) objUser;
    }

    public static void uploadImage(HttpServletRequest req, Teatag teatag) {
        try {
            String name = teatag.getNum_in_catalog()+".jpg";
            Part upload = req.getPart("upload");
            String path = req.getServletContext().getRealPath("/pictures") + File.separator + name;
            try (InputStream uploadStream = upload.getInputStream();
                 OutputStream imageFile = new FileOutputStream(path)
            ){
                byte [] buffer = new byte [300000];
                while (uploadStream.available()>0){
                    int size = uploadStream.read(buffer);
                    imageFile.write(buffer, 0, size);
                }
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}