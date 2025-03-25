package ttcs;

import ttcs.menu.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_jdbc", "root", "hoa0976271476");

        Statement statement = con.createStatement();

        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "full_name VARCHAR(100) NOT NULL," +
                "email VARCHAR(100) UNIQUE NOT NULL," +
                "password VARCHAR(100) NOT NULL," +
                "exp_in_years INT," +
                "pro_skill VARCHAR(200)" +
                ")";

        statement.execute(createTableSQL);

        statement.close();
        con.close();

        Menu menu = new Menu();
        menu.showMenu();

    }
}
