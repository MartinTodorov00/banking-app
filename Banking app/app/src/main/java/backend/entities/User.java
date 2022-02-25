package backend.entities;

import backend.entities.cards.CreditCard;
import backend.entities.cards.MasterCard;
import backend.entities.cards.Visa;

import java.math.BigDecimal;

public class User {

    private int id;
    private String username;
    private String password;
    private String email;
    private String city;
    private String firstName;
    private String lastName;
    private MasterCard masterCard;
    private Visa visa;
    private CreditCard creditCard;
    private Credit credit;

    public void logUser(int id, String username, String password, String email, String city, String firstName, String lastName
            , BigDecimal masterCardBalance, BigDecimal masterCardPaymentLimit, BigDecimal masterCardWithdrawalLimit
            , BigDecimal visaClassicBalance, BigDecimal visaClassicPaymentLimit, BigDecimal visaClassicWithdrawalLimit
            , BigDecimal creditCardBalance, BigDecimal creditCardPaymentLimit, BigDecimal creditCardWithdrawalLimit, Credit credit) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.city = city;
        this.firstName = firstName;
        this.lastName = lastName;
        this.masterCard = new MasterCard(new BigDecimal(String.valueOf(masterCardBalance))
                , new BigDecimal(String.valueOf(masterCardPaymentLimit))
                , new BigDecimal(String.valueOf(masterCardWithdrawalLimit)));
        this.visa = new Visa(new BigDecimal(String.valueOf(visaClassicBalance))
                , new BigDecimal(String.valueOf(visaClassicPaymentLimit))
                , new BigDecimal(String.valueOf(visaClassicWithdrawalLimit)));
        this.creditCard = new CreditCard(new BigDecimal(String.valueOf(creditCardBalance))
                , new BigDecimal(String.valueOf(creditCardPaymentLimit))
                , new BigDecimal(String.valueOf(creditCardWithdrawalLimit)));
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MasterCard getMasterCard() {
        return masterCard;
    }

    public void setMasterCard(MasterCard masterCard) {
        this.masterCard = masterCard;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public void logOut() {
        setUsername(null);
        setPassword(null);
        setEmail(null);
        setCity(null);
        setFirstName(null);
        setLastName(null);
        setMasterCard(null);
        setVisa(null);
        setCreditCard(null);
        setCredit(null);
    }
}
