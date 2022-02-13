package controllers.controls;

import backend.repositories.*;
import controllers.panels.LoginPanel;

import java.math.BigDecimal;
import java.sql.SQLException;

public class FrontEndControl {

    public static void run() {
        LoginPanel.loginFrame();
    }

    public static void RegisterDataBaseControl(String username, String password, String email, String city, String firstName, String lastName) throws SQLException {
        System.out.println("YES");
        Register register = new Register();
        register.register(username, password, email, city, firstName, lastName);
        LoginPanel.loginFrame();
    }

    public static boolean loginDataBaseControl(String username, String password) throws SQLException {
        Login login = new Login();
        login.login(username, password);
        boolean correctLogin = login.isCorrectInfo();

        return correctLogin;
    }

    public static void changePaymentLimits(String cardName, BigDecimal paymentLimit, int id) throws SQLException {
        ChangeLimit changeLimit = new ChangeLimit();
        if (cardName.equals("Master card")) {
            changeLimit.changeMasterCardPaymentLimit(paymentLimit, id);
        } else if (cardName.equals("Visa classic")) {
            changeLimit.changeVisaClassicPaymentLimit(paymentLimit, id);
        } else if (cardName.equals("Credit card")) {
            changeLimit.changeCreditCardPaymentLimit(paymentLimit, id);
        }
    }

    public static void changeWithdrawalLimits(String cardName, BigDecimal withdrawalLimit, int id) throws SQLException {
        ChangeLimit changeLimit = new ChangeLimit();
        if (cardName.equals("Master card")) {
            changeLimit.changeMasterCardWithdrawalLimit(withdrawalLimit, id);
        } else if (cardName.equals("Visa classic")) {
            changeLimit.changeVisaClassicWithdrawalLimit(withdrawalLimit, id);
        } else if (cardName.equals("Credit card")) {
            changeLimit.changeCreditCardWithdrawalLimit(withdrawalLimit, id);
        }
    }

    public static boolean transferMoney(String iban, int currentUserId, String fromCard, BigDecimal money) throws SQLException {
        TransferMoney transferMoney = new TransferMoney();
        transferMoney.transferMoney(iban, currentUserId, fromCard, money);
        boolean isCorrectIban = transferMoney.isCorrectIban();
        boolean isHaveMoney = transferMoney.isHaveMoney();
        boolean isOtherUser = transferMoney.isOtherUser();

        return isCorrectIban && isHaveMoney && isOtherUser;
    }

    public static void deleteAccount(int id) throws SQLException {
        AccountDelete accountDelete = new AccountDelete();
        accountDelete.accountDelete(id);
    }

    public static void changeUsername(String username, int id) throws SQLException {
        ChangeUsername changeUsername = new ChangeUsername();
        changeUsername.changeUsername(username, id);
    }

    public static void changePassword(String password, int id) throws SQLException {
        ChangePassword changePassword = new ChangePassword();
        changePassword.changePassword(password, id);
    }
}