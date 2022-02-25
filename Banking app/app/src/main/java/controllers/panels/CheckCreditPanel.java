package controllers.panels;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controllers.panels.CoordinationPanel.logo;
import static controllers.panels.CoordinationPanel.mainFrame;

public class CheckCreditPanel {

    public static void CheckCredit(){

        Font customFont = new Font(Font.DIALOG, Font.BOLD, 18);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(24, 24, 24));
        panel.setLayout(null);
        JFrame frame = new JFrame("Кредитно състояние");
        frame.add(panel);
        frame.setIconImage(logo.getImage());
        frame.setVisible(true);
        frame.setBounds(500,200,670, 290);
        frame.setSize(750,350);

        JLabel numberOfCreditsLabel = new JLabel("Налични кредити");
        numberOfCreditsLabel.setBounds(70, 40, 250, 30);
        numberOfCreditsLabel.setForeground(new Color(170,170,170));
        numberOfCreditsLabel.setFont(customFont);
        panel.add(numberOfCreditsLabel);

        JLabel sizeOfCreditLabel = new JLabel("Размер на кредита");
        sizeOfCreditLabel.setBounds(70, 90, 180, 30);
        sizeOfCreditLabel.setForeground(new Color(170,170,170));
        sizeOfCreditLabel.setFont(customFont);
        panel.add(sizeOfCreditLabel);

        JLabel creditTermLabel = new JLabel("Срок на кредита");
        creditTermLabel.setBounds(70, 140, 180, 30);
        creditTermLabel.setForeground(new Color(170,170,170));
        creditTermLabel.setFont(customFont);
        panel.add(creditTermLabel);

        JLabel paymentSizeLabel = new JLabel("Размер на вноската");
        paymentSizeLabel.setBounds(70, 190, 180, 30);
        paymentSizeLabel.setForeground(new Color(170,170,170));
        paymentSizeLabel.setFont(customFont);
        panel.add(paymentSizeLabel);

        JLabel numberOfCreditsValue = new JLabel("1",SwingConstants.CENTER);
        numberOfCreditsValue.setBounds(290, 40, 180, 30);
        numberOfCreditsValue.setBackground(new Color(61,61,61));
        numberOfCreditsValue.setForeground(new Color(255,255,255));
        numberOfCreditsValue.setBorder(new LineBorder(new Color(33,33,33)));
        numberOfCreditsValue.setOpaque(true);
        numberOfCreditsValue.setFont(customFont);
        panel.add(numberOfCreditsValue);

        JLabel sizeOfCreditValue = new JLabel("5000",SwingConstants.CENTER);
        sizeOfCreditValue.setBounds(290, 90, 180, 30);
        sizeOfCreditValue.setBackground(new Color(61,61,61));
        sizeOfCreditValue.setForeground(new Color(255,255,255));
        sizeOfCreditValue.setBorder(new LineBorder(new Color(33,33,33)));
        sizeOfCreditValue.setOpaque(true);
        sizeOfCreditValue.setFont(customFont);
        panel.add(sizeOfCreditValue);

        JLabel creditTermValue = new JLabel("6",SwingConstants.CENTER);
        creditTermValue.setBounds(290, 140, 180, 30);
        creditTermValue.setBackground(new Color(61,61,61));
        creditTermValue.setForeground(new Color(255,255,255));
        creditTermValue.setBorder(new LineBorder(new Color(33,33,33)));
        creditTermValue.setOpaque(true);
        creditTermValue.setFont(customFont);
        panel.add(creditTermValue);

        JLabel paymentSizeValue = new JLabel("1000",SwingConstants.CENTER);
        paymentSizeValue.setBounds(290, 190, 180, 30);
        paymentSizeValue.setBackground(new Color(61,61,61));
        paymentSizeValue.setForeground(new Color(255,255,255));
        paymentSizeValue.setBorder(new LineBorder(new Color(33,33,33)));
        paymentSizeValue.setOpaque(true);
        paymentSizeValue.setFont(customFont);
        panel.add(paymentSizeValue);

        JLabel number = new JLabel("брой",SwingConstants.CENTER);
        number.setBounds(490, 40, 180, 30);
        number.setBackground(new Color(61,61,61));
        number.setForeground(new Color(255,255,255));
        number.setBorder(new LineBorder(new Color(33,33,33)));
        number.setOpaque(true);
        number.setFont(customFont);
        panel.add(number);

        JLabel currency1 = new JLabel("BGN",SwingConstants.CENTER);
        currency1.setBounds(490, 90, 180, 30);
        currency1.setBackground(new Color(61,61,61));
        currency1.setForeground(new Color(255,255,255));
        currency1.setBorder(new LineBorder(new Color(33,33,33)));
        currency1.setOpaque(true);
        currency1.setFont(customFont);
        panel.add(currency1);

        JLabel months = new JLabel("месеца",SwingConstants.CENTER);
        months.setBounds(490, 140, 180, 30);
        months.setBackground(new Color(61,61,61));
        months.setForeground(new Color(255,255,255));
        months.setBorder(new LineBorder(new Color(33,33,33)));
        months.setOpaque(true);
        months.setFont(customFont);
        panel.add(months);

        JLabel currency2 = new JLabel("BGN",SwingConstants.CENTER);
        currency2.setBounds(490, 190, 180, 30);
        currency2.setBackground(new Color(61,61,61));
        currency2.setForeground(new Color(255,255,255));
        currency2.setBorder(new LineBorder(new Color(33,33,33)));
        currency2.setOpaque(true);
        currency2.setFont(customFont);
        panel.add(currency2);

        JButton exitButton = new JButton("Изход");
        exitButton.setBounds(630, 270, 100, 30);
        exitButton.setBackground(new Color(33, 33, 33));
        exitButton.setForeground(new Color(170,170,170));
        exitButton.setFont(customFont);
        panel.add(exitButton);


        exitButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                        mainFrame.setVisible(true);
                    }
                }
        );

    }

}
