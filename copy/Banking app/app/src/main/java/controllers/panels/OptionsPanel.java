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

    public static Component Options() {

        Font customFont = new Font(Font.SERIF, Font.BOLD, 18);

        JPanel transferPanel = new JPanel();
        transferPanel.setLayout(null);
        transferPanel.setBackground(new Color(238, 247, 255));

        JButton deleteButton;

        deleteButton = new JButton("Изтриване на акаунта");
        deleteButton.setBounds(80, 185, 220, 35);
        deleteButton.setBackground(new Color(255, 255, 255));
        deleteButton.setFont(customFont);
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
        transferPanel.add(deleteButton);

        return transferPanel;
    }
}