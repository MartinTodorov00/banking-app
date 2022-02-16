package controllers.panels;

import controllers.controls.FrontEndControl;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static controllers.panels.CoordinationPanel.logo;

public class RegisterPanel{

    public static void RegisterButtonControl(){
        JLabel newUsernameLabel;
        JLabel newPasswordLabel;
        JLabel emailTextLabel;
        JLabel cityTextLabel;
        JLabel firstNameLabel;
        JLabel lastNameLabel;

        JTextField newUsernameField;
        JPasswordField newPasswordField;
        JTextField emailField;
        JTextField firstNameField;
        JTextField lastNameField;

        JButton completeRegisterButton;

        Font customFont = new Font(Font.DIALOG, Font.BOLD, 18);
        Font textCustomFont = new Font(Font.DIALOG, Font.PLAIN, 16);

        JFrame registerFrame = new JFrame("SmartBanking — Нова регистрация");
        JPanel registerPanel = new JPanel();
        registerFrame.setIconImage(logo.getImage());
        registerFrame.setBounds(600,300,390, 350);
        registerFrame.add(registerPanel);
        registerPanel.setLayout(null);
        registerPanel.setBackground(new Color(24, 24, 24));

        newUsernameLabel = new JLabel("Потребителско име");
        newUsernameLabel.setBounds(20, 20,165,50);
        newUsernameLabel.setFont(customFont);
        newUsernameLabel.setForeground(new Color(170,170,170));
        registerPanel.add(newUsernameLabel);

        newPasswordLabel = new JLabel("Парола");
        newPasswordLabel.setBounds(20, 55,120,50);
        newPasswordLabel.setFont(customFont);
        newPasswordLabel.setForeground(new Color(170,170,170));
        registerPanel.add(newPasswordLabel);

        emailTextLabel = new JLabel("E-mail");
        emailTextLabel.setBounds(20, 90, 120, 50);
        emailTextLabel.setFont(customFont);
        emailTextLabel.setForeground(new Color(170,170,170));
        registerPanel.add(emailTextLabel);

        cityTextLabel = new JLabel("Град");
        cityTextLabel.setBounds(20, 125, 120, 50);
        cityTextLabel.setFont(customFont);
        cityTextLabel.setForeground(new Color(170,170,170));
        registerPanel.add(cityTextLabel);

        firstNameLabel = new JLabel("Име");
        firstNameLabel.setBounds(20, 160, 120, 50);
        firstNameLabel.setFont(customFont);
        firstNameLabel.setForeground(new Color(170,170,170));
        registerPanel.add(firstNameLabel);

        lastNameLabel = new JLabel("Фамилия");
        lastNameLabel.setBounds(20, 195, 120, 50);
        lastNameLabel.setFont(customFont);
        lastNameLabel.setForeground(new Color(170,170,170));
        registerPanel.add(lastNameLabel);

        newUsernameField = new JTextField();
        newUsernameField.setFont(textCustomFont);
        newUsernameField.setBounds(200, 35, 165, 25);
        newUsernameField.setBackground(new Color(61,61,61));
        newUsernameField.setForeground(new Color(255,255,255));
        newUsernameField.setBorder(new LineBorder(new Color(33,33,33)));
        registerPanel.add(newUsernameField);

        newPasswordField = new JPasswordField();
        newPasswordField.setFont(textCustomFont);
        newPasswordField.setBounds(200, 70, 165, 25);
        newPasswordField.setBackground(new Color(61,61,61));
        newPasswordField.setForeground(new Color(255,255,255));
        newPasswordField.setBorder(new LineBorder(new Color(33,33,33)));
        registerPanel.add(newPasswordField);

        emailField = new JTextField();
        emailField.setFont(textCustomFont);
        emailField.setBounds(200, 105, 165, 25);
        emailField.setBackground(new Color(61,61,61));
        emailField.setForeground(new Color(255,255,255));
        emailField.setBorder(new LineBorder(new Color(33,33,33)));
        registerPanel.add(emailField);

        String[] city = { "","София", "Пловдив", "Варна", "Бургас", "Плевен", "Ловеч", "Стара Загора", "Видин",
                "Сандански", "Пазарджик", "Русе"};
        JComboBox cityBox = new JComboBox(city);
        cityBox.setFont(textCustomFont);
        cityBox.setBounds(200, 140, 165, 25);
        cityBox.setBackground(new Color(61,61,61));
        cityBox.setForeground(new Color(255,255,255));
        cityBox.setBorder(new LineBorder(new Color(33,33,33)));
        registerPanel.add(cityBox);

        firstNameField = new JTextField();
        firstNameField.setFont(textCustomFont);
        firstNameField.setBounds(200, 175, 165, 25);
        firstNameField.setBackground(new Color(61,61,61));
        firstNameField.setForeground(new Color(255,255,255));
        firstNameField.setBorder(new LineBorder(new Color(33,33,33)));
        registerPanel.add(firstNameField);

        lastNameField = new JTextField();
        lastNameField.setFont(textCustomFont);
        lastNameField.setBounds(200, 210, 165,25);
        lastNameField.setBackground(new Color(61,61,61));
        lastNameField.setForeground(new Color(255,255,255));
        lastNameField.setBorder(new LineBorder(new Color(33,33,33)));
        registerPanel.add(lastNameField);

        completeRegisterButton = new JButton("Регистрация");
        completeRegisterButton.setBounds(100, 260, 150, 30);
        completeRegisterButton.setBackground(new Color(33, 33, 33));
        completeRegisterButton.setForeground(new Color(170,170,170));
        completeRegisterButton.setFont(customFont);
        completeRegisterButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = newUsernameField.getText();
                        String password = String.valueOf(newPasswordField.getPassword());
                        String email = emailField.getText();
                        String city = cityBox.getSelectedItem().toString();
                        String firstName = firstNameField.getText();
                        String lastName = lastNameField.getText();

                        if(username.equals("") || password.equals("") || email.equals("") || city.equals("") || firstName.equals("") || lastName.equals("")){
                            JOptionPane.showMessageDialog(null, "Имате непопълнени полета!","Внимание",JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            try {
                                FrontEndControl.RegisterDataBaseControl(username, password, email, city, firstName, lastName);
                                registerFrame.setVisible(false);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    }
                });
        registerPanel.add(completeRegisterButton);

        registerFrame.setVisible(true);

    }
}