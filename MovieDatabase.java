import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieDatabase {
   public static void main(String[] args) {
      String url = "jdbc:mysql://localhost:3306/filmesdb";
      String username = "root";
      String password = "password";
      String query = "SELECT * FROM filmes";

      try {
         Connection connection = DriverManager.getConnection(url, username, password);
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query);

         while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("titulo");
            int year = resultSet.getInt("ano");
            String director = resultSet.getString("diretor");
            System.out.println(id+" "+title+" "+year+" "+director);
         }

         connection.close();
      } catch(SQLException e) {
         e.printStackTrace();
      }
   }
}