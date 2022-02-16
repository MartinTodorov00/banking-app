package controllers.panels;

import javax.swing.*;
import java.awt.*;

public class CardsPanel {

    public static Component CardsPanel(){

        JPanel allCardsPanel = new JPanel();
        allCardsPanel.setLayout(new GridLayout(3,1));
        allCardsPanel.setBackground(new Color(24, 24, 24));

        allCardsPanel.add(MasterCardLimitPanel.MasterCardLimit());
        allCardsPanel.add(VisaLimitPanel.VisaLimit());
        allCardsPanel.add(CreditLimitPanel.CreditLimit());

        return allCardsPanel;
    }
}
