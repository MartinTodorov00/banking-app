package backend.repositories;

import backend.services.ConnectionJbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeUsername {

    public void changeUsername(String username, int id) throws SQLException {
        Connection connection = ConnectionJbdc.getConnection();

        String queryForChangeUsername = """
                UPDATE users AS u
                SET u.username = ?
                WHERE u.id = ?""";

        PreparedStatement preparedStatementForChangeUsername = connection.prepareStatement(queryForChangeUsername);

        preparedStatementForChangeUsername.setString(1, username);
        preparedStatementForChangeUsername.setInt(2, id);

        preparedStatementForChangeUsername.execute();
    }
}
