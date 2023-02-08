package Model;

public class Employee implements EmployeeDAO {
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private int age;
    private int city_id;



    @Override
    public int getId() {
        return id;
    }
    @Override
    public int getCity_id() {
        return city_id;
    }

    @Override
    public String getFirst_name() {
        return first_name;
    }
@Override
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Override
    public String getLast_name() {
        return last_name;
    }

    @Override
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city_id=" + city_id +
                '}';
    }
}
