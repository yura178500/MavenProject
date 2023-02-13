package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name = "city")
public class City {
    @Column(name = "city_id")
    private int id;
    @Column(name = "city")
    private String city;

    public City() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public City(int id, String city) {
        this.id = id;
        this.city = city;
    }



    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return id == city1.id && city.equals(city1.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city);
    }


}
