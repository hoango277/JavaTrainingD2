package ttcs.dao;

import ttcs.entity.User;

import java.sql.*;

public class UserDAO {

    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test_jdbc", "root", "hoa0976271476");
    }

    public void insertUser(User user) {

        String query = "INSERT INTO users(full_name, email, password, exp_in_years,pro_skill) VALUES(?,?,?,?,?)";


        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            if (user.getExpInYears() != null) {
                statement.setInt(4, user.getExpInYears());
            } else {
                statement.setNull(4, java.sql.Types.INTEGER);
            }

            if (user.getProSkill() != null) {
                statement.setString(5, user.getProSkill());
            } else {
                statement.setNull(5, java.sql.Types.VARCHAR);
            }
            statement.executeUpdate();
            statement.close();
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void showAllUser() {
        String query = "SELECT * FROM users";

        try{
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("ID | FULLNAME | EMAIL");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " | " + resultSet.getString("full_name") + " | " + resultSet.getString("email"));
            }
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fetchUserById(int id)
    {
        String query = "SELECT * FROM users WHERE id = ?";
        try{
            Connection con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                System.out.println("User found!");
                System.out.println(rs.getInt("id") + " | " + rs.getString("full_name") + " | " + rs.getString("email"));
                System.out.println("exp in year: " + rs.getInt("exp_in_years"));
                System.out.println("pro_skill: " + rs.getString("pro_skill"));
            }
            else
            {
                System.out.println("User not exist!");
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUserById(int id)
    {
        String query = "DELETE FROM users WHERE id = ?";

        try{
            Connection con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            if(rs > 0)
            {
                System.out.println("Delete ser succesfull");
            }
            else
            {
                System.out.println("User not exist!");
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int login(String email, String password)
    {
        String query = """
               SELECT * FROM users
               WHERE email = ? AND password = ?
               """;
        try{
            Connection con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                if(rs.getString("exp_in_years") != null)
                {
                    System.out.println("Login admin successful!");
                    preparedStatement.close();
                    con.close();
                    return 1;
                }
                System.out.println("Login employee successful");
                preparedStatement.close();
                con.close();
                return 2;
            }
            else
            {
                System.out.println("Bad credentials");
                preparedStatement.close();
                con.close();
                return 3;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
