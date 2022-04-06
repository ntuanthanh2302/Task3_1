package Model;

public class Area {
    private String name;
    private int longitude_left;
    private int longitude_right;
    private int latitude_top;
    private int latitude_bottom;

    public Area() {
    }

    public Area(String name, int longitude_left, int longitude_right, int latitude_top, int latitude_bottom) {
        this.name = name;
        this.longitude_left = longitude_left;
        this.longitude_right = longitude_right;
        this.latitude_top = latitude_top;
        this.latitude_bottom = latitude_bottom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLongitude_left() {
        return longitude_left;
    }

    public void setLongitude_left(int longitude_left) {
        this.longitude_left = longitude_left;
    }

    public int getLongitude_right() {
        return longitude_right;
    }

    public void setLongitude_right(int longitude_right) {
        this.longitude_right = longitude_right;
    }

    public int getLatitude_top() {
        return latitude_top;
    }

    public void setLatitude_top(int latitude_top) {
        this.latitude_top = latitude_top;
    }

    public int getLatitude_bottom() {
        return latitude_bottom;
    }

    public void setLatitude_bottom(int latitude_bottom) {
        this.latitude_bottom = latitude_bottom;
    }
}
