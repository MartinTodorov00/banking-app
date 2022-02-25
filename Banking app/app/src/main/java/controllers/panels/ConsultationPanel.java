package controllers.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controllers.panels.CoordinationPanel.mainFrame;

public class ConsultationPanel {

    public static Component Consultations(){

        Font customFont = new Font(Font.SERIF, Font.BOLD, 18);

        JPanel consultationsPanel = new JPanel();
        consultationsPanel.setLayout(null);
        consultationsPanel.setBackground(new Color(24, 24, 24));

        JButton creditCheckButton = new JButton("Проверка на кредит");

        creditCheckButton.setBounds(80, 150, 220, 35);
        creditCheckButton.setBackground(new Color(33, 33, 33));
        creditCheckButton.setForeground(new Color(170,170,170));
        creditCheckButton.setFont(customFont);
        consultationsPanel.add(creditCheckButton);

        creditCheckButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setVisible(false);
                        CheckCreditPanel.CheckCredit();
                    }
                }
        );

        return consultationsPanel;
    }

}
