
package controllers.panels;

import backend.entities.User;
import controllers.controls.FrontEndControl;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;

import static backend.repositories.Login.user;

public class TransferPanel {

    public static Component Transfer() {

        JLabel titleLabel;
        JLabel ibanLabel;
        JLabel fromCardLabel;
        JLabel transferSum;
        JTextField ibanField;
        JTextField transferSumField;
        JButton commenceTransferButton;
        JComboBox cardsBox;

        Font customFont = new Font(Font.DIALOG, Font.BOLD, 18);

        JPanel transferPanel = new JPanel();
        transferPanel.setLayout(null);
        transferPanel.setBackground(new Color(24, 24, 24));

        titleLabel = new JLabel("Паричен превод");
        titleLabel.setBounds(130, 10, 800, 50);
        titleLabel.setForeground(new Color(170,170,170));
        titleLabel.setFont(customFont);
        transferPanel.add(titleLabel);

        ibanLabel = new JLabel("IBAN на получател:");
        ibanLabel.setBounds(115, 80, 190, 30);
        ibanLabel.setForeground(new Color(170,170,170));
        ibanLabel.setFont(customFont);
        transferPanel.add(ibanLabel);

        fromCardLabel = new JLabel("От сметка");
        fromCardLabel.setBounds(150, 150, 190, 30);
        fromCardLabel.setForeground(new Color(170,170,170));
        fromCardLabel.setFont(customFont);
        transferPanel.add(fromCardLabel);

        transferSum = new JLabel("Сума за изпращане:");
        transferSum.setBounds(110, 230, 190, 30);
        transferSum.setForeground(new Color(170,170,170));
        transferSum.setFont(customFont);
        transferPanel.add(transferSum);

        ibanField = new JTextField();
        ibanField.setBounds(110, 110, 175, 30);
        ibanField.setBackground(new Color(61,61,61));
        ibanField.setForeground(new Color(255,255,255));
        ibanField.setBorder(new LineBorder(new Color(33,33,33)));
        ibanField.setFont(customFont);
        transferPanel.add(ibanField);

        String cards[] = {" ", "MasterCard", "VisaClassic", "CreditCard"};
        cardsBox = new JComboBox(cards);
        cardsBox.setBackground(new Color(61,61,61));
        cardsBox.setForeground(new Color(170,170,170));
        cardsBox.setBorder(new LineBorder(new Color(33,33,33)));
        cardsBox.setBounds(110, 180, 175, 30);
        cardsBox.setFont(customFont);
        transferPanel.add(cardsBox);

        transferSumField = new JTextField();
        transferSumField.setBounds(110, 260, 175, 30);
        transferSumField.setBackground(new Color(61,61,61));
        transferSumField.setForeground(new Color(255,255,255));
        transferSumField.setBorder(new LineBorder(new Color(33,33,33)));
        transferSumField.setFont(customFont);
        transferPanel.add(transferSumField);

        commenceTransferButton = new JButton("Преведи");
        commenceTransferButton.setBounds(100, 350, 200, 40);
        commenceTransferButton.setBackground(new Color(33, 33, 33));
        commenceTransferButton.setForeground(new Color(170,170,170));
        commenceTransferButton.setFont(customFont);
        transferPanel.add(commenceTransferButton);
        commenceTransferButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String ibanNumber = ibanField.getText();
                        String sumNumber = transferSumField.getText();
                        String card = cardsBox.getSelectedItem().toString();

                        try {
                            if(ibanNumber.equals("") || sumNumber.equals("") || card.equals("")){
                                commenceTransferButton.setBackground(new Color(220, 20, 60));
                                JOptionPane.showMessageDialog(null, "Неуспешен паричен трансфер", "Грешка", JOptionPane.ERROR_MESSAGE);
                            }else{
                                BigDecimal sumNumberBigDecimal = new BigDecimal((Integer.parseInt(sumNumber)));
                                boolean correct = FrontEndControl.transferMoney(ibanNumber, user.getId(), card, sumNumberBigDecimal);
                                if (correct) {
                                    if (card.equals("MasterCard")) {
                                        user.getMasterCard().setBalance(user.getMasterCard().getBalance().subtract(sumNumberBigDecimal));
                                    }else if (card.equals("VisaClassic")) {
                                        user.getVisa().setBalance(user.getVisa().getBalance().subtract(sumNumberBigDecimal));
                                    }else if (card.equals("CreditCard")) {
                                        user.getCreditCard().setBalance(user.getCreditCard().getBalance().subtract(sumNumberBigDecimal));
                                    }

                                    commenceTransferButton.setBackground(new Color(124, 252, 0));
                                    JOptionPane.showMessageDialog(null, "Успешен паричен трансфер", "Успешно", JOptionPane.INFORMATION_MESSAGE);
                                    ibanField.setText("");
                                    transferSumField.setText("");
                                    cardsBox.setSelectedIndex(0);
                                } else {
                                    commenceTransferButton.setBackground(new Color(220, 20, 60));
                                    JOptionPane.showMessageDialog(null, "Неуспешен паричен трансфер", "Грешка", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
        );
        return transferPanel;
    }
}