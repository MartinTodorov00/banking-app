package backend.repositories;

import backend.services.ConnectionJbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePassword {

    public void changePassword(String password, int id) throws SQLException {
        Connection connection = ConnectionJbdc.getConnection();

        String queryForChangePassword = """
                UPDATE `password` AS p
                SET p.password = ?
                WHERE p.id = ?""";

        PreparedStatement preparedStatementForChangePassword = connection.prepareStatement(queryForChangePassword);

        preparedStatementForChangePassword.setString(1, password);
        preparedStatementForChangePassword.setInt(2, id);

        preparedStatementForChangePassword.execute();
    }
}
