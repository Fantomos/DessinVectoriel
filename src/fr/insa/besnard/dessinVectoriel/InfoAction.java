/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author nbesnard01
 */
public class InfoAction extends JPanel {
    private JLabel infoText;

    
    
    public InfoAction(){
        this.infoText = new JLabel("Ajouter des figures");
        this.infoText.setHorizontalAlignment(SwingConstants.LEFT);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(infoText);
    }
    
    
    public JLabel getInfoText() {
        return infoText;
    }
}
