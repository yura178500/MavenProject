package Model;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
public class Employee implements EmployeeDAO {
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private int age;
    private int city_id;

    public void setId(int id) {
        this.id = id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && city_id == employee.city_id && first_name.equals(employee.first_name) && last_name.equals(employee.last_name) && gender.equals(employee.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, gender, age, city_id);
    }
    public Employee(String first_name, String last_name, String gender, int age, int city_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city_id = city_id;
    }
    public Employee(int id, String first_name, String last_name, String gender, int age, int city_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city_id = city_id;
    }

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
    public Employee readById(int id) {
        return null;
    }

    @Override
    public List<Employee> readAll() {
        return null;
    }

    @Override
    public void updateAgeById(int id, int age) {

    }

    @Override
    public void deleteById(int id) {

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
    @Override
    public void create(Employee employee) {

        // Формируем запрос к базе с помощью PreparedStatement
        try(PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO employee (first_name,last_name, id, age) VALUES ((?), (?), (?))")) {

            // Подставляем значение вместо wildcard
            // первым параметром указываем порядковый номер wildcard
            // вторым параметром передаем значение
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setInt(3, employee.getAge());

            // С помощью метода executeQuery отправляем запрос к базе
            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }@Override
    public Employee readById(int id) {

        Employee employee = new Employee();
        // Формируем запрос к базе с помощью PreparedStatement
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee INNER JOIN city ON employee.city_id=employee.city_id AND id=(?)")) {

            // Подставляем значение вместо wildcard
            statement.setInt(1, id);

            // Делаем запрос к базе и результат кладем в ResultSet
            ResultSet resultSet = statement.executeQuery();

            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
            while(resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                // и присваиваем их полим объекта
                employee.setId(Integer.parseInt(resultSet.getString("id")));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(new Employee(resultSet.getInt("city_id"),
                resultSet.getString("first_name"),resultSet.getString("last_name")));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(Integer.parseInt(resultSet.getString("age")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }@Override
    public List<Employee> readAll() {

        // Создаем список, в который будем укладывать объекты
        List<Employee> bookList = new ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee INNER JOIN city ON employee.city_id=city.city_id")) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                int id = Integer.parseInt(resultSet.getString("city_id"));
                String first_name = resultSet.getString("first_name");
                City city = new City(resultSet.getInt("city_id"),
                        resultSet.getString("first_name"));
                int amount = Integer.parseInt(resultSet.getString("age"));


                // Создаем объекты на основе полученных данных
                // и укладываем их в итоговый список
                employeeList.add(new Employee(id, first_name, last_name, gender,age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }
    @Override
    public void updateEmployeeById(int id, int age) {

        try(PreparedStatement statement = connection.prepareStatement(
                "UPDATE employee SET age=(?) WHERE id=(?)")) {

            statement.setInt(1, age);
            statement.setInt(2, id);

            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteById(int id) {

        try(PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM employee WHERE id=(?)")) {

            statement.setInt(1, id);
            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
