package controllers.panels;


import backend.entities.User;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static backend.repositories.Login.user;
import static controllers.panels.CoordinationPanel.logo;

public class MainBillsPanel {

    private static JLabel totalFundsLabel;

    private static JLabel allBalanceLabel;
    private static JLabel mCBalanceLabel;
    private static JLabel vBalanceLabel;


    private static JLabel allCurrencyLabel;
    private static JLabel mCCurrencyLabel;
    private static JLabel vCurrencyLabel;

    private static JButton logoutButton;

    public static void MainBillsPanel(){

        Font customFont = new Font(Font.DIALOG, Font.BOLD, 18);

        JFrame mainProgramFrame = new JFrame("SmartBanking — Наличност по сметка");
        JPanel mainProgramPanel = new JPanel();
        mainProgramFrame.setSize(670, 555);
        mainProgramFrame.setBounds(500,200,670, 290);
        mainProgramFrame.add(mainProgramPanel);
        mainProgramPanel.setLayout(null);
        mainProgramPanel.setBackground(new Color(24, 24, 24));
        mainProgramFrame.setIconImage(logo.getImage());


        totalFundsLabel = new JLabel("Обща разполагаемост");
        totalFundsLabel.setBounds(70, 40, 250, 30);
        totalFundsLabel.setForeground(new Color(170,170,170));
        totalFundsLabel.setFont(customFont);
        mainProgramPanel.add(totalFundsLabel);

        totalFundsLabel = new JLabel("MasterCard");
        totalFundsLabel.setBounds(70, 90, 180, 30);
        totalFundsLabel.setForeground(new Color(170,170,170));
        totalFundsLabel.setFont(customFont);
        mainProgramPanel.add(totalFundsLabel);

        totalFundsLabel = new JLabel("Visa Classic");
        totalFundsLabel.setBounds(70, 140, 180, 30);
        totalFundsLabel.setForeground(new Color(170,170,170));
        totalFundsLabel.setFont(customFont);
        mainProgramPanel.add(totalFundsLabel);

        mCBalanceLabel = new JLabel(String.valueOf(user.getMasterCard().getBalance()), SwingConstants.CENTER);
        mCBalanceLabel.setBounds(290, 90, 180, 30);
        mCBalanceLabel.setBackground(new Color(61,61,61));
        mCBalanceLabel.setForeground(new Color(255,255,255));
        mCBalanceLabel.setBorder(new LineBorder(new Color(33,33,33)));
        mCBalanceLabel.setOpaque(true);
        mCBalanceLabel.setFont(customFont);
        mainProgramPanel.add(mCBalanceLabel);

        mCCurrencyLabel = new JLabel("BGN", SwingConstants.CENTER);
        mCCurrencyLabel.setBounds(490, 90, 100, 30);
        mCCurrencyLabel.setBackground(new Color(61,61,61));
        mCCurrencyLabel.setForeground(new Color(255,255,255));
        mCCurrencyLabel.setBorder(new LineBorder(new Color(33,33,33)));
        mCCurrencyLabel.setOpaque(true);
        mCCurrencyLabel.setFont(customFont);
        mainProgramPanel.add(mCCurrencyLabel);

        vBalanceLabel = new JLabel(String.valueOf(user.getVisa().getBalance()), SwingConstants.CENTER);
        vBalanceLabel.setBounds(290, 140, 180, 30);
        vBalanceLabel.setBackground(new Color(61,61,61));
        vBalanceLabel.setForeground(new Color(255,255,255));
        vBalanceLabel.setBorder(new LineBorder(new Color(33,33,33)));
        vBalanceLabel.setOpaque(true);
        vBalanceLabel.setFont(customFont);
        mainProgramPanel.add(vBalanceLabel);

        vCurrencyLabel = new JLabel("BGN", SwingConstants.CENTER);
        vCurrencyLabel.setBounds(490, 140, 100, 30);
        vCurrencyLabel.setBackground(new Color(61,61,61));
        vCurrencyLabel.setForeground(new Color(255,255,255));
        vCurrencyLabel.setBorder(new LineBorder(new Color(33,33,33)));
        vCurrencyLabel.setOpaque(true);
        vCurrencyLabel.setFont(customFont);
        mainProgramPanel.add(vCurrencyLabel);

        String mc = mCBalanceLabel.getText();
        String visaClassic = vBalanceLabel.getText();

        int masterCardCurrency = Integer.parseInt(mc);
        int visaCurrency = Integer.parseInt(visaClassic);
        int total = masterCardCurrency + visaCurrency;

        allBalanceLabel = new JLabel(String.valueOf(total), SwingConstants.CENTER);
        allBalanceLabel.setBounds(290, 40, 180, 30);
        allBalanceLabel.setBackground(new Color(61,61,61));
        allBalanceLabel.setForeground(new Color(255,255,255));
        allBalanceLabel.setBorder(new LineBorder(new Color(33,33,33)));
        allBalanceLabel.setOpaque(true);
        allBalanceLabel.setFont(customFont);
        mainProgramPanel.add(allBalanceLabel);

        allCurrencyLabel = new JLabel("BGN", SwingConstants.CENTER);
        allCurrencyLabel.setBounds(490, 40, 100, 30);
        allCurrencyLabel.setBackground(new Color(61,61,61));
        allCurrencyLabel.setForeground(new Color(255,255,255));
        allCurrencyLabel.setBorder(new LineBorder(new Color(33,33,33)));
        allCurrencyLabel.setOpaque(true);
        allCurrencyLabel.setFont(customFont);
        mainProgramPanel.add(allCurrencyLabel);

        logoutButton = new JButton("Изход");
        logoutButton.setBounds(540, 210, 100, 30);
        logoutButton.setBackground(new Color(33, 33, 33));
        logoutButton.setForeground(new Color(170,170,170));
        logoutButton.setFont(customFont);
        mainProgramPanel.add(logoutButton);
        logoutButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainProgramFrame.setVisible(false);
                        CoordinationPanel.CoordinationPanel();
                    }
                }
        );
        mainProgramFrame.setVisible(true);
    }
}