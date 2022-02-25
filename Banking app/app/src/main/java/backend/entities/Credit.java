package backend.entities;

import java.math.BigDecimal;

public class Credit {

    private Boolean availableCredit;
    private int creditNumbers;
    private BigDecimal creditAmount;
    private int creditTerm;
    private BigDecimal contributionAmount;

    public Credit() {
    }

    public Credit(Boolean availableCredit, int creditNumbers, BigDecimal creditAmount, int creditTerm, BigDecimal contributionAmount) {
        this.availableCredit = availableCredit;
        this.creditNumbers = creditNumbers;
        this.creditAmount = creditAmount;
        this.creditTerm = creditTerm;
        this.contributionAmount = contributionAmount;
    }

    public Boolean getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(Boolean availableCredit) {
        this.availableCredit = availableCredit;
    }

    public int getCreditNumbers() {
        return creditNumbers;
    }

    public void setCreditNumbers(int creditNumbers) {
        this.creditNumbers = creditNumbers;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public int getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

    public BigDecimal getContributionAmount() {
        return contributionAmount;
    }

    public void setContributionAmount(BigDecimal contributionAmount) {
        this.contributionAmount = contributionAmount;
    }
}
