package controllers.panels;

import controllers.controls.FrontEndControl;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static backend.repositories.Login.user;
import static controllers.panels.CoordinationPanel.logo;
import static controllers.panels.CoordinationPanel.mainFrame;

public class ChangePasswordPanel {

    private static JTextArea passwordField;
    private static JLabel label;
    private static JButton submitButton;
    private static JButton backButton;
    private static JPanel passwordUpdate;

    public static void changePassword() {

        Font customFont = new Font(Font.DIALOG, Font.BOLD, 18);
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        JFrame frame = new JFrame("Промяна на парола");
        frame.setIconImage(logo.getImage());
        frame.setBounds(650, 200, 600, 400);
        passwordUpdate = new JPanel();
        passwordUpdate.setLayout(null);
        passwordUpdate.setBackground(new Color(24, 24, 24));
        passwordUpdate.setBounds(650, 200, 400, 500);
        passwordUpdate.setVisible(true);
        frame.add(passwordUpdate);
        frame.setVisible(true);

        passwordField = new JTextArea();
        passwordField.setBounds(300, 100, 220, 35);
        passwordField.setBackground(new Color(61,61,61));
        passwordField.setForeground(new Color(255,255,255));
        passwordField.setBorder(new LineBorder(new Color(33,33,33)));
        passwordField.setFont(customFont);
        passwordUpdate.add(passwordField);

        label = new JLabel("Въведете новата парола тук:");
        label.setBounds(50, 100, 250, 35);
        label.setForeground(new Color(170,170,170));
        label.setFont(customFont);
        passwordUpdate.add(label);

        submitButton = new JButton("Потвърди");
        submitButton.setBounds(370, 220, 150, 35);
        submitButton.setBackground(new Color(33, 33, 33));
        submitButton.setForeground(new Color(170,170,170));
        submitButton.setFont(customFont);
        passwordUpdate.add(submitButton);

        submitButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newPassword = "";
                        newPassword = passwordField.getText();
                        try {
                            FrontEndControl.changePassword(newPassword, user.getId());
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        frame.setVisible(false);
                        CoordinationPanel.CoordinationPanel();
                        mainFrame.setVisible(true);
                    }
                });

        backButton = new JButton("Назад");
        backButton.setBounds(50, 220, 150, 35);
        backButton.setFont(customFont);
        backButton.setBackground(new Color(33, 33, 33));
        backButton.setForeground(new Color(170,170,170));
        passwordUpdate.add(backButton);

        backButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                        CoordinationPanel.CoordinationPanel();
                        mainFrame.setVisible(true);
                    }
                });
    }
}
