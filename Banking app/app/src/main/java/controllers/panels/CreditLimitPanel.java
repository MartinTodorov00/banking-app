package controllers.panels;

import backend.entities.User;
import controllers.controls.FrontEndControl;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;

import static backend.repositories.Login.user;

public class CreditLimitPanel {

    private static JLabel creditCard;
    private static JLabel limitWithdraw;
    private static JLabel limitPay;
    private static JLabel limitWithdrawValue;
    private static JLabel limitPayValue;
    private static JTextField newWithdrawLimit;
    private static JTextField newPayLimit;
    private static JLabel limitWithdrawCurrency;
    private static JLabel limitPayCurrency;
    private static JButton updateLimit;

    public static Component CreditLimit() {

        Font customFontOne = new Font(Font.DIALOG, Font.BOLD, 20);
        Font customFontTwo = new Font(Font.DIALOG, Font.BOLD, 16);
        Font customFontButton = new Font(Font.DIALOG, Font.BOLD, 18);

        JPanel creditLimitPanel = new JPanel();
        creditLimitPanel.setLayout(null);
        creditLimitPanel.setBackground(new Color(24, 24, 24));

        creditCard = new JLabel("Credit Card");
        creditCard.setBounds(150, 0, 800, 50);
        creditCard.setForeground(new Color(170,170,170));
        creditCard.setFont(customFontOne);
        creditLimitPanel.add(creditCard);

        limitWithdraw = new JLabel("Лимит на теглене");
        limitWithdraw.setBounds(20, 40, 160, 30);
        limitWithdraw.setForeground(new Color(170,170,170));
        limitWithdraw.setFont(customFontTwo);
        creditLimitPanel.add(limitWithdraw);

        limitPay = new JLabel("Лимит на плащане");
        limitPay.setBounds(20, 70, 160, 30);
        limitPay.setForeground(new Color(170,170,170));
        limitPay.setFont(customFontTwo);
        creditLimitPanel.add(limitPay);

        limitWithdrawValue = new JLabel(String.valueOf(user.getCredit().getWithdrawalLimit()));
        limitWithdrawValue.setBounds(190, 40, 100, 30);
        limitWithdrawValue.setForeground(new Color(170,170,170));
        limitWithdrawValue.setFont(customFontTwo);
        creditLimitPanel.add(limitWithdrawValue);

        limitPayValue = new JLabel(String.valueOf(user.getCredit().getPaymentLimit()));
        limitPayValue.setBounds(190, 70, 100, 30);
        limitPayValue.setForeground(new Color(170,170,170));
        limitPayValue.setFont(customFontTwo);
        creditLimitPanel.add(limitPayValue);

        newWithdrawLimit = new JTextField();
        newWithdrawLimit.setBounds(240, 45, 85, 20);
        newWithdrawLimit.setBackground(new Color(61,61,61));
        newWithdrawLimit.setForeground(new Color(255,255,255));
        newWithdrawLimit.setBorder(new LineBorder(new Color(33,33,33)));
        newWithdrawLimit.setFont(customFontTwo);
        creditLimitPanel.add(newWithdrawLimit);

        newPayLimit = new JTextField();
        newPayLimit.setBounds(240, 75, 85, 20);
        newPayLimit.setBackground(new Color(61,61,61));
        newPayLimit.setForeground(new Color(255,255,255));
        newPayLimit.setBorder(new LineBorder(new Color(33,33,33)));
        newPayLimit.setFont(customFontTwo);
        creditLimitPanel.add(newPayLimit);

        limitWithdrawCurrency = new JLabel("BGN");
        limitWithdrawCurrency.setBounds(330, 42, 100, 25);
        limitWithdrawCurrency.setForeground(new Color(170,170,170));
        limitWithdrawCurrency.setFont(customFontTwo);
        creditLimitPanel.add(limitWithdrawCurrency);

        limitPayCurrency = new JLabel("BGN");
        limitPayCurrency.setBounds(330, 72, 100, 25);
        limitPayCurrency.setForeground(new Color(170,170,170));
        limitPayCurrency.setFont(customFontTwo);
        creditLimitPanel.add(limitPayCurrency);

        updateLimit = new JButton("Обнови лимита");
        updateLimit.setBounds(110, 110, 190, 25);
        updateLimit.setBackground(new Color(33, 33, 33));
        updateLimit.setForeground(new Color(170,170,170));
        updateLimit.setFont(customFontButton);
        creditLimitPanel.add(updateLimit);
        updateLimit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newWithdrawValue = newWithdrawLimit.getText();
                        String newPayValue = newPayLimit.getText();

                        boolean flagWithdraw = true;
                        boolean flagPay = true;

                        BigDecimal withdrawBigDecimal = BigDecimal.valueOf(0);
                        BigDecimal payBigDecimal = BigDecimal.valueOf(0);

                        int withdraw = 0;
                        int pay = 0;

                        if (newWithdrawValue.equals("")) {
                            flagWithdraw = false;
                        }
                        if (newPayValue.equals("")) {
                            flagPay = false;
                        }

                        if (flagWithdraw) {
                            withdrawBigDecimal = new BigDecimal((Integer.parseInt(newWithdrawValue)));
                            withdraw = Integer.parseInt(newWithdrawValue);
                        }
                        if (flagPay) {
                            payBigDecimal = new BigDecimal((Integer.parseInt(newPayValue)));
                            pay = Integer.parseInt(newPayValue);
                        }

                        if (withdraw != 0 && pay != 0) {
                            try {
                                FrontEndControl.changeWithdrawalLimits("Credit card", withdrawBigDecimal, user.getId());
                                FrontEndControl.changePaymentLimits("Credit card", payBigDecimal, user.getId());
                                limitWithdrawValue.setText(newWithdrawValue);
                                limitPayValue.setText(newPayValue);
                                newWithdrawLimit.setText("");
                                newPayLimit.setText("");
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        } else if (withdraw != 0) {
                            try {
                                FrontEndControl.changeWithdrawalLimits("Credit card", withdrawBigDecimal, user.getId());
                                limitWithdrawValue.setText(newWithdrawValue);
                                newWithdrawLimit.setText("");
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        } else if (pay != 0) {
                            try {
                                FrontEndControl.changePaymentLimits("Credit card", payBigDecimal, user.getId());
                                limitPayValue.setText(newPayValue);
                                newPayLimit.setText("");
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    }
                }
        );
        return creditLimitPanel;
    }
}