package controllers.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controllers.panels.CoordinationPanel.logo;

public class ContactsPanel {

    public static void Contacts(){

        JLabel contacts;
        JLabel timeShift;
        JLabel shiftHours;
        JLabel contactNumber;
        JLabel contactNumA1;
        JLabel cNumDataA1;
        JLabel contactNumTelenor;
        JLabel cNumDataTelenor;
        JLabel contactNumViva;
        JLabel cNumDataViva;
        JLabel contactNumRoaming;
        JLabel cNumDataRoaming;
        JLabel contactEmailLabel;
        JLabel contactEmail;
        JLabel centralOfficeLabel;
        JLabel centralOfficeAddress;
        JButton logoutButton;

        Font customFont = new Font(Font.DIALOG, Font.BOLD, 18);
        Font mainCustomFont = new Font(Font.DIALOG, Font.BOLD, 20);

        JFrame contactsFrame = new JFrame("SmartBanking — Контакти");
        JPanel contactsPanel = new JPanel();
        contactsFrame.setIconImage(logo.getImage());
        contactsFrame.setBounds(650,200,580, 400);
        contactsFrame.add(contactsPanel);
        contactsPanel.setLayout(null);
        contactsPanel.setBackground(new Color(24, 24, 24));

        contacts = new JLabel("Контакти");
        contacts.setBounds(245, 10 , 800, 50);
        contacts.setForeground(new Color(170,170,170));
        contacts.setFont(mainCustomFont);
        contactsPanel.add(contacts);

        timeShift = new JLabel("Работно Време:");
        timeShift.setBounds(40, 50, 250, 50);
        timeShift.setForeground(new Color(170,170,170));
        timeShift.setFont(customFont);
        contactsPanel.add(timeShift);

        contactEmailLabel = new JLabel("E-mail:");
        contactEmailLabel.setBounds(40, 80, 250, 50);
        contactEmailLabel.setForeground(new Color(170,170,170));
        contactEmailLabel.setFont(customFont);
        contactsPanel.add(contactEmailLabel);

        centralOfficeLabel = new JLabel("Адрес на централен офис:");
        centralOfficeLabel.setForeground(new Color(170,170,170));
        centralOfficeLabel.setBounds(40, 110, 250, 50);
        centralOfficeLabel.setFont(customFont);
        contactsPanel.add(centralOfficeLabel);

        contactNumber = new JLabel("Номера за контакт");
        contactNumber.setBounds(200, 160, 250, 50);
        contactNumber.setForeground(new Color(170,170,170));
        contactNumber.setFont(mainCustomFont);
        contactsPanel.add(contactNumber);

        contactNumA1 = new JLabel("През оператор на А1:");
        contactNumA1.setBounds(40, 200, 250, 50);
        contactNumA1.setForeground(new Color(170,170,170));
        contactNumA1.setFont(customFont);
        contactsPanel.add(contactNumA1);

        contactNumTelenor = new JLabel("През оператор на Теленор:");
        contactNumTelenor.setBounds(40, 230, 250, 50);
        contactNumTelenor.setForeground(new Color(170,170,170));
        contactNumTelenor.setFont(customFont);
        contactsPanel.add(contactNumTelenor);

        contactNumViva = new JLabel("През оператор на Виваком:");
        contactNumViva.setBounds(40, 260, 250, 50);
        contactNumViva.setForeground(new Color(170,170,170));
        contactNumViva.setFont(customFont);
        contactsPanel.add(contactNumViva);

        contactNumRoaming = new JLabel("Международен номер:");
        contactNumRoaming.setBounds(40, 290, 250, 50);
        contactNumRoaming.setForeground(new Color(170,170,170));
        contactNumRoaming.setFont(customFont);
        contactsPanel.add(contactNumRoaming);

        shiftHours = new JLabel("9:00 - 18:30");
        shiftHours.setBounds(320, 50, 250, 50);
        shiftHours.setForeground(new Color(170,170,170));
        shiftHours.setFont(customFont);
        contactsPanel.add(shiftHours);

        contactEmail = new JLabel("smartbankers@smb.com");
        contactEmail.setBounds(320, 80, 250, 50);
        contactEmail.setForeground(new Color(170,170,170));
        contactEmail.setFont(customFont);
        contactsPanel.add(contactEmail);

        centralOfficeAddress = new JLabel("гр. София, ул. Раковска 63");
        centralOfficeAddress.setBounds(320, 110, 250, 50);
        centralOfficeAddress.setForeground(new Color(170,170,170));
        centralOfficeAddress.setFont(customFont);
        contactsPanel.add(centralOfficeAddress);

        cNumDataA1 = new JLabel("+359882465882");
        cNumDataA1.setBounds(320, 200, 250, 50);
        cNumDataA1.setForeground(new Color(170,170,170));
        cNumDataA1.setFont(customFont);
        contactsPanel.add(cNumDataA1);

        cNumDataTelenor = new JLabel("+359892465882");
        cNumDataTelenor.setBounds(320, 230, 250, 50);
        cNumDataTelenor.setForeground(new Color(170,170,170));
        cNumDataTelenor.setFont(customFont);
        contactsPanel.add(cNumDataTelenor);

        cNumDataViva = new JLabel("+359872465882");
        cNumDataViva.setBounds(320, 260, 250, 50);
        cNumDataViva.setForeground(new Color(170,170,170));
        cNumDataViva.setFont(customFont);
        contactsPanel.add(cNumDataViva);

        cNumDataRoaming = new JLabel("+02666042");
        cNumDataRoaming.setBounds(320, 290, 250, 50);
        cNumDataRoaming.setForeground(new Color(170,170,170));
        cNumDataRoaming.setFont(customFont);
        contactsPanel.add(cNumDataRoaming);

        logoutButton = new JButton("Изход");
        logoutButton.setBounds(450, 320, 100, 30);
        logoutButton.setBackground(new Color(33, 33, 33));
        logoutButton.setForeground(new Color(170,170,170));
        logoutButton.setFont(customFont);
        contactsPanel.add(logoutButton);
        logoutButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        contactsFrame.setVisible(false);
                        CoordinationPanel.CoordinationPanel();
                    }
                }
        );
        contactsFrame.setVisible(true);
    }
}