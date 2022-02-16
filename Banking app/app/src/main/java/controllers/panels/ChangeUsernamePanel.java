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
import static controllers.panels.CoordinationPanel.mainFrame;
import static controllers.panels.CoordinationPanel.logo;

public class ChangeUsernamePanel {

    public static void changeUsername() {


        Font customFont = new Font(Font.DIALOG, Font.BOLD, 18);
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        JFrame frame = new JFrame("Промяна на потребителско име");
        frame.setIconImage(logo.getImage());
        frame.setBounds(650, 200, 600, 400);
        JPanel usernameUpdate = new JPanel();
        usernameUpdate.setLayout(null);
        usernameUpdate.setBackground(new Color(24, 24, 24));
        usernameUpdate.setBounds(650, 200, 400, 500);
        usernameUpdate.setVisible(true);
        frame.add(usernameUpdate);
        frame.setVisible(true);

        JTextArea usernameField = new JTextArea();
        usernameField.setBounds(300, 100, 220, 35);
        usernameField.setBackground(new Color(61,61,61));
        usernameField.setForeground(new Color(255,255,255));
        usernameField.setBorder(new LineBorder(new Color(33,33,33)));
        usernameField.setFont(customFont);
        usernameUpdate.add(usernameField);

        JLabel label = new JLabel("Въведете новo потр. име тук:");
        label.setBounds(50, 100, 250, 35);
        label.setForeground(new Color(170,170,170));
        label.setFont(customFont);
        usernameUpdate.add(label);

        JButton submitButton = new JButton("Потвърди");
        submitButton.setBounds(370, 220, 150, 35);
        submitButton.setFont(customFont);
        submitButton.setBackground(new Color(33, 33, 33));
        submitButton.setForeground(new Color(170,170,170));
        usernameUpdate.add(submitButton);

        submitButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newUsername = "";
                        newUsername = usernameField.getText();
                        try {
                            FrontEndControl.changeUsername(newUsername, user.getId());
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        frame.setVisible(false);
                        CoordinationPanel.CoordinationPanel();
                        mainFrame.setVisible(true);
                    }
                });

        JButton backButton = new JButton("Назад");
        backButton.setBounds(50, 220, 150, 35);
        backButton.setFont(customFont);
        backButton.setBackground(new Color(33, 33, 33));
        backButton.setForeground(new Color(170,170,170));
        usernameUpdate.add(backButton);

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
