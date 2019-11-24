package pojo;

public class Material {

    private long id;
    private String material;

    public Material() {
    }

    public Material(long id, String material) {
        this.id = id;
        this.material = material;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", material='" + material + '\'' +
                '}';
    }
}
