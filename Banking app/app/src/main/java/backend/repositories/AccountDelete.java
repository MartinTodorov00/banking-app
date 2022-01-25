package backend.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class AccountDelete {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/smart_banking";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "1234";

    private Connection connection;

    public void setConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", DATABASE_USERNAME);
        properties.setProperty("password", DATABASE_PASSWORD);

        connection = DriverManager.getConnection(DATABASE_URL, properties);
    }

    public void accountDelete(int id) throws SQLException {

        String users = "DELETE FROM users\n" +
                "WHERE id = ?";

        PreparedStatement preparedStatementUsers = connection.prepareStatement(users);

        preparedStatementUsers.setInt(1, id);

        preparedStatementUsers.execute();


        String deleteCards = "DELETE FROM cards\n" +
                "WHERE id = ?";

        PreparedStatement preparedStatementCards = connection.prepareStatement(deleteCards);

        preparedStatementCards.setInt(1, id);

        preparedStatementCards.execute();


        String deleteMasterCards = "DELETE FROM master_cards\n" +
                "WHERE id = ?";

        PreparedStatement preparedStatementMasterCards = connection.prepareStatement(deleteMasterCards);

        preparedStatementMasterCards.setInt(1, id);

        preparedStatementMasterCards.execute();


        String deleteVisa = "DELETE FROM visa_classic\n" +
                "WHERE id = ?";

        PreparedStatement preparedStatementVisa = connection.prepareStatement(deleteVisa);

        preparedStatementVisa.setInt(1, id);

        preparedStatementVisa.execute();


        String deleteCredit = "DELETE FROM credit_cards\n" +
                "WHERE id = ?";

        PreparedStatement preparedStatementCredit = connection.prepareStatement(deleteCredit);

        preparedStatementCredit.setInt(1, id);

        preparedStatementCredit.execute();
    }
}
