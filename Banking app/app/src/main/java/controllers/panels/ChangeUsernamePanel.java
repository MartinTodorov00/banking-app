package controllers.panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controllers.panels.CoordinationPanel.mainFrame;

public class ChangeUsernamePanel {

    private static String newUsername = "";

    public static void changeUsername(){

        Font customFont = new Font(Font.SERIF, Font.BOLD, 18);
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        JFrame frame = new JFrame("Промяна на потребителско име");
        frame.setBounds(650,200,600,400);
        JPanel usernameUpdate = new JPanel();
        usernameUpdate.setLayout(null);
        usernameUpdate.setBackground(new Color(238, 247, 255));
        usernameUpdate.setBounds(650,200,400,500);
        usernameUpdate.setVisible(true);
        frame.add(usernameUpdate);
        frame.setVisible(true);

        JTextArea usernameField = new JTextArea();
        usernameField.setBounds(300, 100,220,35);
        usernameField.setFont(customFont);
        usernameField.setBorder(blackLine);
        usernameUpdate.add(usernameField);

        JLabel label = new JLabel("Въведете новo потр. име тук:");
        label.setBounds(50,100,250,35);
        label.setFont(customFont);
        usernameUpdate.add(label);

        JButton submitButton = new JButton("Потвърди");
        submitButton.setBounds(100,220,150,35);
        submitButton.setFont(customFont);
        submitButton.setBackground(new Color(212, 212, 212));
        usernameUpdate.add(submitButton);

        submitButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newUsername = usernameField.getText();
                        frame.setVisible(false);
                        CoordinationPanel.CoordinationPanel();
                        mainFrame.setVisible(true);
                    }
                });

        JButton backButton = new JButton("Назад");
        backButton.setBounds(270,220,150,35);
        backButton.setFont(customFont);
        backButton.setBackground(new Color(212, 212, 212));
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

    public static String getNewUsername(){
        return newUsername;
    }
}
