package Dao;

import Model.Employee;
import config.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    // final String user = "postgres";
   // final String password = "178500";
   // final String url = "jdbc:postgresql://localhost:5432/skypro";
   // Connection connection = DriverManager.getConnection(url, user, password);

   // public EmployeeDAOImpl(Connection connection) throws SQLException {
   // }
    @Override
    public void create(Employee employee) {
        // В ресурсах блока try создаем объект сессии с помощью нашего конфиг-файла
        // И открываем сессию
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            // Создаем транзакцию и начинаем ее
            Transaction transaction = session.beginTransaction();
            // вызываем на объекте сессии метод save
            // данный метод внутри себя содержит необходимый запрос к базе
            // для создания новой строки
            session.save(employee);
            // Выполняем коммит, то есть сохраняем изменения,
            // которые совершили в рамках транзакции
            transaction.commit();
        }
    }


    // @Override
   // public void create(Employee employee) {

        // Формируем запрос к базе с помощью PreparedStatement
      //  try (PreparedStatement statement = connection.prepareStatement("INSERT INTO employee (first_name,last_name, gender , age, city_id) VALUES ((?), (?), (?), (?),(?))")) {

            // Подставляем значение вместо wildcard
            // первым параметром указываем порядковый номер wildcard
            // вторым параметром передаем значение
        //    statement.setString(1, employee.getFirstName());
         //   statement.setString(2, employee.getLastName());
         //   statement.setString(3, employee.getGender());
         //   statement.setInt(4, employee.getAge());
         //   statement.setInt(5, employee.getcityId());


            // С помощью метода executeUpdate отправляем запрос к базе
         //   statement.executeUpdate();

   //     } catch (SQLException e) {
    //        e.printStackTrace();
    //    }
  //  }

  //  @Override
  //  public Employee readById(int id) {

    //    Employee employee = new Employee(connection);


        // Формируем запрос к базе с помощью PreparedStatement
     //   try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee INNER JOIN city ON employee.city_id = city.city_id AND id=(?)")) {

            // Подставляем значение вместо wildcard
      //      statement.setInt(1, id);

            // Делаем запрос к базе и результат кладем в ResultSet
       //     ResultSet resultSet = statement.executeQuery();

            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
      //      while (resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                // и присваиваем их полим объекта
        //        employee.setId(resultSet.getInt("id"));
         //       employee.setFirstName(resultSet.getString("first_name"));
         //       employee.setLastName(resultSet.getString("last_name"));
          //      employee.setGender(resultSet.getString("gender"));
          //      employee.setAge(resultSet.getInt("age"));
          //      int cityId = resultSet.getInt("city_id");

         //   }
     //   } catch (SQLException e) {
      //      e.printStackTrace();
      //  }
     //   return employee;
   // }
         @Override
         public Employee readById(int id) {
             // С помощью конфиг-файла получаем сессию, открываем ее
             // и через метод get получаем объект
             // В параметре метода get нужно указать объект какого класса нам нужен
             // и его id
             return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
         }

  //  @Override
   // public List<Employee> readAll() {

        // Создаем список, в который будем укладывать объекты
      //  List<Employee> employeeList = new ArrayList<>();

     //   try (PreparedStatement statement = connection.prepareStatement(
         //       "SELECT * FROM employee LEFT JOIN city ON employee.city_id=city.city_id")) {

         //   ResultSet resultSet = statement.executeQuery();
         //   while (resultSet.next()) {

           //     int id = resultSet.getInt("id");
            //    String firstName = resultSet.getString("first_name");
            //    String lastName = resultSet.getString("last_name");
             //   String gender = resultSet.getString("gender");
            //    int age = resultSet.getInt("age");
            //    int cityId = resultSet.getInt("city_id");

                // Создаем объекты на основе полученных данных
                // и укладываем их в итоговый список
            //    employeeList.add((new Employee(id, firstName, lastName, gender, age,cityId)));
        //    }
     //   } catch (SQLException e) {
     //       e.printStackTrace();
     //   }

     //   return employeeList;
  //  }
     @Override
     public List<Employee> readAll() {
         List<Employee> users = (List<Employee>)  HibernateSessionFactoryUtil
                 .getSessionFactory().openSession().createQuery("From Employee").list();
         return users;
     }


  //  @Override
  //  public void updateAgeById(int id, int age) {

   //     try (PreparedStatement statement = connection.prepareStatement(
      //          "UPDATE employee SET age=(?) WHERE id=(?)")) {

       //     statement.setInt(1, age);
       //     statement.setInt(2, id);

      //      statement.executeUpdate();
      //  } catch (SQLException e) {
       //     e.printStackTrace();
      //  }
   // }
      @Override
      public void updateAge(Employee employee) {
          try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
              Transaction transaction = session.beginTransaction();
              // Для обновления данных нужно передать в конструктор
              // объект с актуальными данными
              session.update(employee);
              transaction.commit();
          }
      }

   // @Override
  //  public void deleteById(int id) {

     //   try (PreparedStatement statement = connection.prepareStatement(
      //          "DELETE FROM employee WHERE id=(?)")) {

    //        statement.setInt(1, id);
      //      statement.executeUpdate();

     //   } catch (SQLException e) {
       //     e.printStackTrace();
      //  }
     @Override
     public void delete(Employee employee) {
         try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
             Transaction transaction = session.beginTransaction();
             // Для удаления объекта из таблицы нужно передать его в метод delete
             session.delete(employee);
             transaction.commit();
         }
     }
    }

