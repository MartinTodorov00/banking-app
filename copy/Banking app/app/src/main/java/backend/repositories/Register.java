package backend.repositories;

import backend.services.ConnectionJbdc;
import backend.services.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Register {

    public void register(String username, String password, String email, String city, String firstName, String lastName) throws SQLException {
        //master_cards

        Connection connection = ConnectionJbdc.getConnection();

        String queryForMasterCard = "INSERT INTO master_cards(balance, payment_limit, withdrawal_limit)\n" +
                "VALUES (?,?,?)";

        PreparedStatement preparedStatementForMasterCard = connection.prepareStatement(queryForMasterCard);

        preparedStatementForMasterCard.setInt(1, 4500);
        preparedStatementForMasterCard.setInt(2, 100);
        preparedStatementForMasterCard.setInt(3, 150);

        preparedStatementForMasterCard.execute();

        //visa_classic
        String queryForVisaClassic = "INSERT INTO visa_classic(balance, payment_limit, withdrawal_limit)\n" +
                "VALUES (?,?,?)";

        PreparedStatement preparedStatementForVisaClassic = connection.prepareStatement(queryForVisaClassic);

        preparedStatementForVisaClassic.setInt(1, 2000);
        preparedStatementForVisaClassic.setInt(2, 50);
        preparedStatementForVisaClassic.setInt(3, 100);

        preparedStatementForVisaClassic.execute();

        //credit_cards
        String queryForCreditCard = "INSERT INTO credit_cards(balance, payment_limit, withdrawal_limit)\n" +
                "VALUES (?,?,?)";

        PreparedStatement preparedStatementForCreditCard = connection.prepareStatement(queryForCreditCard);

        preparedStatementForCreditCard.setInt(1, 5000);
        preparedStatementForCreditCard.setInt(2, 200);
        preparedStatementForCreditCard.setInt(3, 300);

        preparedStatementForCreditCard.execute();


        //id
        int countForCards = 0;
        String queryForId = "SELECT MAX(id)\n" +
                "FROM master_cards;";

        PreparedStatement preparedStatementForId = connection.prepareStatement(queryForId);

        ResultSet resultSetId = preparedStatementForId.executeQuery();
        while (resultSetId.next()) {
            countForCards = resultSetId.getInt("MAX(id)");
        }

        //cards
        String queryForMoney = "INSERT INTO cards(master_card, visa_classic, credit_card)\n" +
                "VALUES (?,?,?)";

        PreparedStatement preparedStatementForMoney = connection.prepareStatement(queryForMoney);

        preparedStatementForMoney.setInt(1, countForCards);
        preparedStatementForMoney.setInt(2, countForCards);
        preparedStatementForMoney.setInt(3, countForCards);

        preparedStatementForMoney.execute();

        //password
        String queryForPassword = "INSERT INTO password(password)\n" +
                "VALUES (?)";

        PreparedStatement preparedStatementForPassword = connection.prepareStatement(queryForPassword);

        preparedStatementForPassword.setString(1, password);

        preparedStatementForPassword.execute();

        //user

        String s = "BGN";
        int random = Util.randomNumber(100000, 999999);
        String iban = s + random;
        String query = "INSERT INTO users (username, id_password, `email`, city, `first name`, `last name`, `id_cards`, `iban`)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, username);
        preparedStatement.setInt(2, countForCards);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, city);
        preparedStatement.setString(5, firstName);
        preparedStatement.setString(6, lastName);
        preparedStatement.setInt(7, countForCards);
        preparedStatement.setString(8, iban);

        preparedStatement.execute();
    }
}