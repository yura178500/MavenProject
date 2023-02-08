import java.sql.*;

public class Application {

    public static void main(String[] args) throws SQLException {

        // Создаем переменные с данными для подключения к базе
        final String user = "postgres";
        final String password = "178500";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        // Создаем соединение с базой с помощью Connection
        // Формируем запрос к базе с помощью PreparedStatement
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE city_id = (?)")) {

            // Подставляем значение вместо wildcard
            statement.setInt(1, 5);

            // Делаем запрос к базе и результат кладем в ResultSet
            final ResultSet resultSet = statement.executeQuery();

            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
            while (resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                String nameOfEmployee = "first_name: " + resultSet.getString("first_name");
                String cityOfEmployee = "city_id: " + resultSet.getString("city_id");
                int age = resultSet.getInt(5);

                // Выводим данные в консоль
                System.out.println(nameOfEmployee);
                System.out.println(cityOfEmployee);
               System.out.println("age: " + age);

            }
        }
    }
}


