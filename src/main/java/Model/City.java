package Model;

public class City {
    private int city_id;
    private String city;

    public City(int city_id, String city) {
        this.city_id = city_id;
        this.city = city;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
