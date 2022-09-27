package api.pogo_classes;

public class ColorsData {
    private Integer id;
    public String name;
    public Integer year;
    public String color;
    public String pantone_value;

    public ColorsData() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    @SuppressWarnings("unused")
    public String getColor() {
        return color;
    }

    @SuppressWarnings("unused")
    public String getPantone_value() {
        return pantone_value;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
