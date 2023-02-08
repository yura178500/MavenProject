package Model;

public interface EmployeeDAO {

    int getId();

    int getCity_id();

    String getFirst_name();

    void setFirst_name(String first_name);

    String getLast_name();

    void setLast_name(String last_name);

    String getGender();

    void setGender(String gender);

    int getAge();

    void setAge(int age);
}
