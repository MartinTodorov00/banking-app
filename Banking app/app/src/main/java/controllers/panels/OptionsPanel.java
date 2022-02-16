package controllers.panels;

import backend.repositories.Login;
import controllers.controls.FrontEndControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static controllers.panels.CoordinationPanel.mainFrame;

public class OptionsPanel {

//    first button - coordinates 80, 185, 220, 35
//    second button - coordinates 80, 235, 220, 35
//    third button - coordinates 80, 285, 220, 35

    public static Component Options() {

        Font customFont = new Font(Font.SERIF, Font.BOLD, 18);

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(null);
        optionPanel.setBackground(new Color(24, 24, 24));

        JButton updateUsernameButton;
        JButton updatePasswordButton;
        JButton deleteButton;

        updateUsernameButton = new JButton("Промяна на потр. име");
        updateUsernameButton.setBounds(80, 100, 220, 35);
        updateUsernameButton.setBackground(new Color(33, 33, 33));
        updateUsernameButton.setForeground(new Color(170,170,170));
        updateUsernameButton.setFont(customFont);
        optionPanel.add(updateUsernameButton);

        updateUsernameButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setVisible(false);
                        ChangeUsernamePanel.changeUsername();
                    }
                }
        );


        updatePasswordButton = new JButton("Промяна на парола");
        updatePasswordButton.setBounds(80, 160, 220, 35);
        updatePasswordButton.setBackground(new Color(33, 33, 33));
        updatePasswordButton.setForeground(new Color(170,170,170));
        updatePasswordButton.setFont(customFont);
        optionPanel.add(updatePasswordButton);

        updatePasswordButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setVisible(false);
                        ChangePasswordPanel.changePassword();
                    }
                }
        );


        deleteButton = new JButton("Изтриване на акаунта");
        deleteButton.setBounds(80, 220, 220, 35);
        deleteButton.setBackground(new Color(33, 33, 33));
        deleteButton.setForeground(new Color(170,170,170));
        deleteButton.setFont(customFont);
        optionPanel.add(deleteButton);

        deleteButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            FrontEndControl.deleteAccount(Login.user.getId());
                            mainFrame.setVisible(false);
                            LoginPanel.loginFrame();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

        optionPanel.setVisible(true);

        return optionPanel;
    }
}