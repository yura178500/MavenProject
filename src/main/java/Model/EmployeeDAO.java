package Model;

import java.awt.*;

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
    // Добавление объекта
    void create(Employee employee);

    // Получение объекта по id
    Employee readById(int id);

    // Получение всех объектов
    default List<Employee> readAll() {
        return null;
    }
    // Изменение объекта по id
    void updateAgeById(int id, int age);
    // Удаление объекта по id
    void deleteById(int id);

    void updateEmployeeById(int id, int age);
}
