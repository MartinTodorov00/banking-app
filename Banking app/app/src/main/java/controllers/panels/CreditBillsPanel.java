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

public class CreditBillsPanel {

    private static JLabel totalFundsLabel;

    private static JLabel allBalanceLabel;
    private static JLabel mCBalanceLabel;
    private static JLabel allCurrencyLabel;

    private static JButton logoutButton;

    public static void CreditBillsPanel(){

        Font customFont = new Font(Font.DIALOG, Font.BOLD, 18);
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);

        JFrame mainProgramFrame = new JFrame("SmartBanking — Кредитно състояние");
        JPanel mainProgramPanel = new JPanel();
        mainProgramFrame.setIconImage(logo.getImage());
        mainProgramFrame.setSize(670, 555);
        mainProgramFrame.setBounds(500,200,670, 290);
        mainProgramFrame.add(mainProgramPanel);
        mainProgramPanel.setLayout(null);
        mainProgramPanel.setBackground(new Color(24, 24, 24));


        totalFundsLabel = new JLabel("Credit Card");
        totalFundsLabel.setBounds(70, 40, 250, 30);
        totalFundsLabel.setForeground(new Color(170,170,170));
        totalFundsLabel.setFont(customFont);
        mainProgramPanel.add(totalFundsLabel);

        totalFundsLabel = new JLabel("Вашите кредити");
        totalFundsLabel.setBounds(70, 120, 180, 30);
        totalFundsLabel.setForeground(new Color(170,170,170));
        totalFundsLabel.setFont(customFont);
        mainProgramPanel.add(totalFundsLabel);


        allBalanceLabel = new JLabel(String.valueOf(user.getCreditCard().getBalance()), SwingConstants.CENTER);
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


        mCBalanceLabel = new JLabel("Няма наличен изтеглен кредит", SwingConstants.CENTER);
        mCBalanceLabel.setBounds(290, 120, 300, 30);
        mCBalanceLabel.setBackground(new Color(61,61,61));
        mCBalanceLabel.setForeground(new Color(255,255,255));
        mCBalanceLabel.setBorder(new LineBorder(new Color(33,33,33)));
        mCBalanceLabel.setOpaque(true);
        mCBalanceLabel.setFont(customFont);
        mainProgramPanel.add(mCBalanceLabel);


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