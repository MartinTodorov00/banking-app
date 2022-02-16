package controllers.panels;

import backend.entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static backend.repositories.Login.user;

public class CoordinationPanel{

    public static ImageIcon logo = new ImageIcon("src/main/resources/logo.png");
    public static JFrame mainFrame = new JFrame("SmartBanking — " + user.getFirstName()+ " " + user.getLastName());

    public static Component CoordinationPanel(){

        JButton billButton;
        JButton creditButton;
        JButton contactsButton;
        JButton exitButton;

        //run.Main JFrame
        Font customFont = new Font(Font.SERIF, Font.BOLD, 18);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(650,200,400, 500);
        mainFrame.setIconImage(logo.getImage());

        //Coordination Panel
        JPanel coordinationPanel = new JPanel();
        coordinationPanel.setLayout(null);
        coordinationPanel.setBackground(new Color(238, 247, 255));

        //TabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Начало", coordinationPanel);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_0);

        tabbedPane.addTab("Нов превод",TransferPanel.Transfer());
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        tabbedPane.addTab("Карти", CardsPanel.CardsPanel());
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        tabbedPane.addTab("Настройки", OptionsPanel.Options());
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

        mainFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);


        billButton = new JButton("Сметки");
        billButton.setBounds(80, 75, 220, 35);
        billButton.setBackground(new Color(255, 255, 255));
        billButton.setFont(customFont);
        billButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setVisible(false);
                        MainBillsPanel.MainBillsPanel();
                    }
                });
        coordinationPanel.add(billButton);

        creditButton = new JButton("Кредитно състояние");
        creditButton.setBounds(80, 130, 220, 35);
        creditButton.setBackground(new Color(255, 255, 255));
        creditButton.setFont(customFont);
        creditButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setVisible(false);
                        CreditBillsPanel.CreditBillsPanel();

                    }
                });
        coordinationPanel.add(creditButton);

        contactsButton = new JButton("Контакти");
        contactsButton.setBounds(80, 185, 220, 35);
        contactsButton.setBackground(new Color(255, 255, 255));
        contactsButton.setFont(customFont);
        contactsButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setVisible(false);
                        ContactsPanel.Contacts();
                    }
                });
        coordinationPanel.add(contactsButton);


        exitButton = new JButton("Изход");
        exitButton.setBounds(260, 390, 100, 30);
        exitButton.setBackground(new Color(212, 212, 212));
        exitButton.setFont(customFont);
        exitButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setVisible(false);
                        user.logOut();
                        LoginPanel.loginFrame();
                    }
                });
        coordinationPanel.add(exitButton);

        mainFrame.setVisible(true);
        return coordinationPanel;
    }
}
