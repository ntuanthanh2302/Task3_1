package Model;

public class Alert implements Comparable<Alert> {
    private String mmsi;
    private String alert;
    private String name;
    private int longitude;
    private int latitude;
    private String time;

    public Alert() {
    }

    public Alert(String mmsi, String alert, String name, int longitude, int latitude, String time) {
        this.mmsi = mmsi;
        this.alert = alert;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.time = time;
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int compareTo(Alert o) {
        return this.getTime().compareTo(o.getTime());
    }

}
