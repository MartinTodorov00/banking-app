package backend.repositories;

import backend.services.ConnectionJbdc;
import backend.services.UserModel;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeLimit {

    private static UserModel user = new UserModel();

    //master card change limits
    public void changeMasterCardPaymentLimit(BigDecimal paymentLimit, int id) throws SQLException {
        Connection connection = ConnectionJbdc.getConnection();

        String queryForChangePaymentLimit = "UPDATE master_cards\n" +
                "INNER JOIN users ON master_cards.id = users.id\n" +
                "SET payment_limit = ?\n" +
                "WHERE users.id = ?";

        PreparedStatement preparedStatementForChangePaymentLimit = connection.prepareStatement(queryForChangePaymentLimit);

        preparedStatementForChangePaymentLimit.setBigDecimal(1, paymentLimit);
        preparedStatementForChangePaymentLimit.setInt(2, id);

        preparedStatementForChangePaymentLimit.execute();
    }

    public void changeMasterCardWithdrawalLimit(BigDecimal withdrawalLimit, int id) throws SQLException {
        Connection connection = ConnectionJbdc.getConnection();

        String queryForChangeWithdrawalLimit = "UPDATE master_cards\n" +
                "INNER JOIN users ON master_cards.id = users.id\n" +
                "SET withdrawal_limit = ?\n" +
                "WHERE users.id = ?";

        PreparedStatement preparedStatementForChangeWithdrawalLimit = connection.prepareStatement(queryForChangeWithdrawalLimit);

        preparedStatementForChangeWithdrawalLimit.setBigDecimal(1, withdrawalLimit);
        preparedStatementForChangeWithdrawalLimit.setInt(2, id);

        preparedStatementForChangeWithdrawalLimit.execute();
    }

    //visa classic change limits
    public void changeVisaClassicPaymentLimit(BigDecimal paymentLimit, int id) throws SQLException {
        Connection connection = ConnectionJbdc.getConnection();

        String queryForChangePaymentLimit = "UPDATE visa_classic\n" +
                "INNER JOIN users ON visa_classic.id = users.id\n" +
                "SET payment_limit = ?\n" +
                "WHERE users.id = ?";

        PreparedStatement preparedStatementForChangePaymentLimit = connection.prepareStatement(queryForChangePaymentLimit);

        preparedStatementForChangePaymentLimit.setBigDecimal(1, paymentLimit);
        preparedStatementForChangePaymentLimit.setInt(2, id);

        preparedStatementForChangePaymentLimit.execute();
    }

    public void changeVisaClassicWithdrawalLimit(BigDecimal withdrawalLimit, int id) throws SQLException {
        Connection connection = ConnectionJbdc.getConnection();

        String queryForChangeWithdrawalLimit = "UPDATE visa_classic\n" +
                "INNER JOIN users ON visa_classic.id = users.id\n" +
                "SET withdrawal_limit = ?\n" +
                "WHERE users.id = ?";

        PreparedStatement preparedStatementForChangeWithdrawalLimit = connection.prepareStatement(queryForChangeWithdrawalLimit);

        preparedStatementForChangeWithdrawalLimit.setBigDecimal(1, withdrawalLimit);
        preparedStatementForChangeWithdrawalLimit.setInt(2, id);

        preparedStatementForChangeWithdrawalLimit.execute();
    }

    //credit card change limits
    public void changeCreditCardPaymentLimit(BigDecimal paymentLimit, int id) throws SQLException {
        Connection connection = ConnectionJbdc.getConnection();

        String queryForChangePaymentLimit = "UPDATE credit_cards\n" +
                "INNER JOIN users ON credit_cards.id = users.id\n" +
                "SET payment_limit = ?\n" +
                "WHERE users.id = ?";

        PreparedStatement preparedStatementForChangePaymentLimit = connection.prepareStatement(queryForChangePaymentLimit);

        preparedStatementForChangePaymentLimit.setBigDecimal(1, paymentLimit);
        preparedStatementForChangePaymentLimit.setInt(2, id);

        preparedStatementForChangePaymentLimit.execute();
    }

    public void changeCreditCardWithdrawalLimit(BigDecimal withdrawalLimit, int id) throws SQLException {
        Connection connection = ConnectionJbdc.getConnection();

        String queryForChangeWithdrawalLimit = "UPDATE credit_cards\n" +
                "INNER JOIN users ON credit_cards.id = users.id\n" +
                "SET withdrawal_limit = ?\n" +
                "WHERE users.id = ?";

        PreparedStatement preparedStatementForChangeWithdrawalLimit = connection.prepareStatement(queryForChangeWithdrawalLimit);

        preparedStatementForChangeWithdrawalLimit.setBigDecimal(1, withdrawalLimit);
        preparedStatementForChangeWithdrawalLimit.setInt(2, id);

        preparedStatementForChangeWithdrawalLimit.execute();
    }
}
