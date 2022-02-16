package backend.repositories;

import backend.services.ConnectionJbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePassword {

    public void changePassword(String password, int id) throws SQLException {
        Connection connection = ConnectionJbdc.getConnection();

        String queryForChangePassword = """
                UPDATE users AS u
                SET u.password = ?
                WHERE u.id = ?""";

        PreparedStatement preparedStatementForChangePassword = connection.prepareStatement(queryForChangePassword);

        preparedStatementForChangePassword.setString(1, password);
        preparedStatementForChangePassword.setInt(2, id);

        preparedStatementForChangePassword.execute();
    }
}
