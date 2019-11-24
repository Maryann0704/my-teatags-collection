package pojo;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TeatagString {

    private long id;
    private String trademark;
    private String subtitle;
    private double width;
    private double height;
    private Date inCollectionSince;
    private String numInCatalog;
    private String userName;

    public TeatagString() {
    }

    public TeatagString(long id, String trademark, String subtitle,
                        double width, double height,
                        Date inCollectionSince, String numInCatalog,
                        String userName) {
        this.id = id;
        this.trademark = trademark;
        this.subtitle = subtitle;
        this.width = width;
        this.height = height;
        this.inCollectionSince = inCollectionSince;
        this.numInCatalog = numInCatalog;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Date getInCollectionSince() {
        return inCollectionSince;
    }

    public void setInCollectionSince(Date inCollectionSince) {
        this.inCollectionSince = inCollectionSince;
    }

    public void setInCollectionSince(String inCollectionSince) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date utilDate = df.parse(inCollectionSince);
            this.inCollectionSince = new Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getNumInCatalog() {
        return numInCatalog;
    }

    public void setNumInCatalog(String numInCatalog) {
        this.numInCatalog = numInCatalog;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return  "id " + id +
                ", trademark " + trademark +
                ", subtitle " + subtitle +
                ", width x height " + width + " mm x " + height +
                " mm, in collection since " + inCollectionSince +
                ", num in catalog " + numInCatalog +
                ", user " + userName;
    }
}
