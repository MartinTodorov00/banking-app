package backend.repositories;

import backend.services.ConnectionJbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDelete {

    public void accountDelete(int id) throws SQLException {
        Connection connection = ConnectionJbdc.getConnection();

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
