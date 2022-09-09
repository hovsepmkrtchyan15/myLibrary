package maneger;

import db.DBConnectionProvider;

import model.User;

import java.sql.*;

public class UserManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void add(User user) {
        String sql = "Insert into user(name, surname, email, password) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());

            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                user.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByEmailAndPassword(String email, String password) {
        String sql = "Select * from user where email=? and password=? ";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                return getUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(1));
        user.setName(resultSet.getString(2));
        user.setSurname(resultSet.getString(3));
        user.setEmail(resultSet.getString(4));
        user.setPassword(resultSet.getString(5));
        return user;
    }
}
