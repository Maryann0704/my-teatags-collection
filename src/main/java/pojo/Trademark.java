package pojo;

public class Trademark {

    private long id;
    private String trademark;

    public Trademark() {
    }

    public Trademark(long id, String trademark) {
        this.id = id;
        this.trademark = trademark;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    @Override
    public String toString() {
        return "Trademark{" +
                "id=" + id +
                ", trademark='" + trademark + '\'' +
                '}';
    }
}
