package controllers.panels;

import backend.entities.User;
import controllers.controls.FrontEndControl;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import static controllers.panels.CoordinationPanel.logo;

public class LoginPanel{

    private static JLabel usernameLabel;
    private static JLabel passwordLabel;
    private static JTextField usernameField;
    private static JTextField passwordField;
    private static JButton loginButton;
    private static JButton registerButton;

    public static void loginFrame(){
        Font customFont = new Font(Font.SERIF, Font.BOLD, 18);
        Font textCustomFont = new Font("Arial", Font.BOLD, 16);

        JFrame loginFrame = new JFrame("SmartBanking — Вход");
        JPanel loginPanel = new JPanel();
        loginFrame.setBounds(600,300,400, 250);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.add(loginPanel);
        loginFrame.setIconImage(logo.getImage());
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(24, 24, 24));

        usernameLabel = new JLabel("Потребителско име");
        usernameLabel.setBounds(20, 25, 165, 50);
        usernameLabel.setFont(customFont);
        usernameLabel.setForeground(new Color(170,170,170));
        loginPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(textCustomFont);
        usernameField.setBounds(200, 40, 165, 30);
        usernameField.setBackground(new Color(61,61,61));
        usernameField.setForeground(new Color(255,255,255));
        usernameField.setBorder(new LineBorder(new Color(33,33,33)));
        loginPanel.add(usernameField);

        passwordLabel = new JLabel("Парола");
        passwordLabel.setBounds(20, 65, 120, 50);
        passwordLabel.setFont(customFont);
        passwordLabel.setForeground(new Color(170,170,170));
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(textCustomFont);
        passwordField.setBounds(200, 80, 165, 30);
        passwordField.setBackground(new Color(61,61,61));
        passwordField.setForeground(new Color(255,255,255));
        passwordField.setBorder(new LineBorder(new Color(33,33,33)));
        loginPanel.add(passwordField);

        loginButton = new JButton("Вход");
        loginButton.setBounds(260, 140, 100, 30);
        loginButton.setBackground(new Color(33, 33, 33));
        loginButton.setForeground(new Color(170,170,170));
        loginButton.setFont(customFont);
        loginButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = usernameField.getText();
                        String password = passwordField.getText();
                        try {
                            boolean correct = FrontEndControl.loginDataBaseControl(username, password);
                            if(correct){
                                loginFrame.setVisible(false);
                                CoordinationPanel.CoordinationPanel();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Въвели сте грешно потребителско име или парола!","Грешка",JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
        );
        loginPanel.add(loginButton);

        registerButton = new JButton("Нова Регистрация");
        registerButton.setBounds(40, 140, 190, 30);
        registerButton.setBackground(new Color(33, 33, 33));
        registerButton.setForeground(new Color(170,170,170));
        registerButton.setFont(customFont);
        registerButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        loginFrame.setVisible(false);
                        RegisterPanel.RegisterButtonControl();
                    }
                });
        loginPanel.add(registerButton);

        loginFrame.setVisible(true);
    }
}