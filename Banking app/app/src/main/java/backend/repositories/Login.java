package backend.repositories;

import backend.entities.User;
import backend.entities.cards.Credit;
import backend.services.ConnectionJbdc;

import java.math.BigDecimal;
import java.sql.*;

public class Login {

    private boolean isCorrectInfo = false;
    private boolean successfulLogin = false;

    public static User user = new User();

    public boolean isSuccessfulLogin() {
        return successfulLogin;
    }

    public void setSuccessfulLogin(boolean successfulLogin) {
        this.successfulLogin = successfulLogin;
    }

    public boolean isCorrectInfo() {
        return isCorrectInfo;
    }

    public void setCorrectInfo(boolean correctInfo) {
        isCorrectInfo = correctInfo;
    }

    public User login(String username, String password) throws SQLException {

        Connection connection = ConnectionJbdc.getConnection();

        //check
        String queryForNameAndPass = "SELECT u.username, u.password FROM users AS u";

        PreparedStatement statementGetName = connection.prepareStatement(queryForNameAndPass);

        ResultSet resultSetNames = statementGetName.executeQuery();

        while (resultSetNames.next()) {
            if (resultSetNames.getString("username").equals(username)
                    && resultSetNames.getString("password").equals(password)) {
                setCorrectInfo(true);
            }
        }
        return loginUser(username, password);
    }

    public User loginUser(String username, String password) throws SQLException {

        Connection connection = ConnectionJbdc.getConnection();

        if (isCorrectInfo) {
            //user
            String queryForInfo = "SELECT * FROM users WHERE username = ?";

            PreparedStatement statementGetInfo = connection.prepareStatement(queryForInfo);

            statementGetInfo.setString(1, username);

            ResultSet resultGetInfo = statementGetInfo.executeQuery();
            int userId = 0;
            String userMail = null;
            String userCity = null;
            String userFirstName = null;
            String userLastName = null;
            while (resultGetInfo.next()) {
                userId = resultGetInfo.getInt("id");
                userMail = resultGetInfo.getString("email");
                userCity = resultGetInfo.getString("city");
                userFirstName = resultGetInfo.getString("first name");
                userLastName = resultGetInfo.getString("last name");
            }

            //master card
            String queryForMasterCard = "SELECT master_cards.*, users.id\n" +
                    "FROM master_cards\n" +
                    "INNER JOIN users ON master_cards.id = users.id\n" +
                    "WHERE master_cards.id = ?";

            PreparedStatement statementForMasterCard = connection.prepareStatement(queryForMasterCard);

            statementForMasterCard.setInt(1, userId);

            ResultSet resultForMasterCard = statementForMasterCard.executeQuery();
            BigDecimal masterCardBalance = new BigDecimal("0.00");
            BigDecimal masterCardPaymentLimit = new BigDecimal("0.00");
            BigDecimal masterCardWithdrawalLimit = new BigDecimal("0.00");

            while (resultForMasterCard.next()) {
                masterCardBalance = resultForMasterCard.getBigDecimal("balance");
                masterCardPaymentLimit = resultForMasterCard.getBigDecimal("payment_limit");
                masterCardWithdrawalLimit = resultForMasterCard.getBigDecimal("withdrawal_limit");
            }

            //visa classic
            String queryForVisaClassic = "SELECT visa_classic.*, users.id\n" +
                    "FROM visa_classic\n" +
                    "INNER JOIN users ON visa_classic.id = users.id\n" +
                    "WHERE visa_classic.id = ?";

            PreparedStatement statementForVisaClassic = connection.prepareStatement(queryForVisaClassic);

            statementForVisaClassic.setInt(1, userId);

            ResultSet resultForVisaClassic = statementForVisaClassic.executeQuery();
            BigDecimal visaClassicBalance = new BigDecimal("0.00");
            BigDecimal visaClassicPaymentLimit = new BigDecimal("0.00");
            BigDecimal visaClassicWithdrawalLimit = new BigDecimal("0.00");
            while (resultForVisaClassic.next()) {
                visaClassicBalance = resultForVisaClassic.getBigDecimal("balance");
                visaClassicPaymentLimit = resultForVisaClassic.getBigDecimal("payment_limit");
                visaClassicWithdrawalLimit = resultForVisaClassic.getBigDecimal("withdrawal_limit");

            }

            //credit card
            String queryForCreditCard = "SELECT credit_cards.*, users.id\n" +
                    "FROM credit_cards\n" +
                    "INNER JOIN users ON credit_cards.id = users.id\n" +
                    "WHERE credit_cards.id = ?";

            PreparedStatement statementForCreditCard = connection.prepareStatement(queryForCreditCard);

            statementForCreditCard.setInt(1, userId);

            ResultSet resultForCreditCard = statementForCreditCard.executeQuery();
            BigDecimal creditCardBalance = new BigDecimal("0.00");
            BigDecimal creditCardPaymentLimit = new BigDecimal("0.00");
            BigDecimal creditCardWithdrawalLimit = new BigDecimal("0.00");
            while (resultForCreditCard.next()) {
                creditCardBalance = resultForCreditCard.getBigDecimal("balance");
                creditCardPaymentLimit = resultForCreditCard.getBigDecimal("payment_limit");
                creditCardWithdrawalLimit = resultForCreditCard.getBigDecimal("withdrawal_limit");
            }

            //credit card
            String queryForCredit = "SELECT credit.*, users.id\n" +
                    "FROM credit\n" +
                    "INNER JOIN users ON credit.id = users.id\n" +
                    "WHERE credit.id = ?";

            PreparedStatement statementForCredit = connection.prepareStatement(queryForCredit);

            statementForCredit.setInt(1, userId);

            ResultSet resultForCredit = statementForCredit.executeQuery();
            Credit credit = new Credit();
            while (resultForCredit.next()) {
                credit.setAvailableCredit(resultForCredit.getBoolean("available_credit"));
                credit.setCreditNumbers(resultForCredit.getInt("credit_numbers"));
                credit.setCreditAmount(resultForCredit.getBigDecimal("credit_amount"));
                credit.setCreditTerm(resultForCredit.getInt("credit_term"));
                credit.setContributionAmount(resultForCredit.getBigDecimal("contribution_amount"));
            }

            user.logUser(userId, username, password, userMail, userCity, userFirstName, userLastName
                    , masterCardBalance, masterCardPaymentLimit, masterCardWithdrawalLimit
                    , visaClassicBalance, visaClassicPaymentLimit, visaClassicWithdrawalLimit
                    , creditCardBalance, creditCardPaymentLimit, creditCardWithdrawalLimit,credit);

            setSuccessfulLogin(true);
        }
        return user;
    }

}
