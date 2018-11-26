/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Nicolas
 */
public class DetailPanel extends JPanel implements ActionListener{

    ScenePrincipal main;
    private Figure figureDetail;
    private JLabel titre;
    private JLabel formeLabel;
    private JLabel forme;
    private Container formeC;
    private JLabel nomLabel;
    private JTextField nom;
    private Container nomC;
    private JLabel colorLabel;
    private JButton jbColor;
    private Container colorC;
    private JLabel remplirLabel;
    private JCheckBox jcRemplir;
    private Container remplirC;


    public DetailPanel(ScenePrincipal main) {
        this.setVisible(false);
          this.setBackground(Color.GRAY);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.figureDetail = null;
        this.main = main;
        this.titre = new JLabel("Paramètre :");
        this.titre.setAlignmentX(CENTER_ALIGNMENT);
        
        // Type de figure
        this.formeLabel = new JLabel("Forme :");
        this.forme = new JLabel("Indisponible");
        forme.setPreferredSize(new Dimension(80, 20));
        this.formeC = new Container();
        formeC.add(formeLabel);
        formeC.add(forme);
        formeC.setLayout(new FlowLayout());
        formeC.setSize(this.getSize().width,HEIGHT);
        formeC.setMaximumSize(formeC.getPreferredSize());
        
         // Affichage/Edition du nom
        this.nomLabel = new JLabel("Nom :");
        this.nom = new JTextField("Indisponible");
        nom.setPreferredSize(new Dimension(80, 20));
        nom.addActionListener(this);   
        this.nomC = new Container();
        nomC.add(nomLabel);
        nomC.add(nom);
        nomC.setLayout(new FlowLayout());
        nomC.setSize(this.getSize().width,HEIGHT);
        nomC.setMaximumSize(nomC.getPreferredSize());
       
         // Affichage/Edition de la couleur
        this.colorLabel = new JLabel("Couleur : ");
        this.jbColor = new JButton("Color");
        jbColor.addActionListener(this);
        this.colorC = new Container();
        colorC.add(colorLabel);
        colorC.add(jbColor);
        colorC.setLayout(new FlowLayout());
        colorC.setSize(this.getSize().width,HEIGHT);
        colorC.setMaximumSize(colorC.getPreferredSize());
       
        // Affichage/Edition du remplissage
        this.jcRemplir = new JCheckBox("Remplir : ");
        jcRemplir.setHorizontalTextPosition(SwingConstants.LEFT);
        jcRemplir.addActionListener(this);
        this.remplirC = new Container();
        remplirC.add(jcRemplir);
        remplirC.setLayout(new FlowLayout());
        jcRemplir.setBackground(this.getBackground());
        remplirC.setSize(this.getSize().width,HEIGHT);
        remplirC.setMaximumSize(remplirC.getPreferredSize());           
       
       
      
       
        this.add(titre);
        this.add(Box.createGlue());
        this.add(formeC);
        this.add(nomC);
        this.add(colorC);
        this.add(remplirC);
        this.add(Box.createGlue());
   
      

    }

    public void setFigureDetail(Figure figureDetail) {
        this.figureDetail = figureDetail;
    }

    public Figure getFigureDetail() {
        return figureDetail;
    }
    
    public void afficherDetail(Figure a){
        figureDetail = a;
        forme.setText(a.getClass().getSimpleName());
        nom.setText(a.getNom());
        jbColor.setBackground(a.getCouleur());
        if(figureDetail instanceof Polygone){
                
                  Polygone figureDetailPoly = (Polygone) a;
                  jcRemplir.setSelected(figureDetailPoly.isRemplir());
                    jcRemplir.setVisible(true);
        }
        else if(figureDetail instanceof Ellipse){
               Ellipse figureDetailEll = (Ellipse) a;
               jcRemplir.setSelected(figureDetailEll.isRemplir());
                jcRemplir.setVisible(true);

        }
        else{
            jcRemplir.setVisible(false);
        }
        
        this.setVisible(true);
        main.repaint();
    }
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
      if(e.getSource() == jbColor){
          Color newColor = JColorChooser.showDialog(
                     this,
                     "Couleur de la figure",
                     figureDetail.getCouleur());
          figureDetail.setCouleur(newColor);
        

      }
      else if(e.getSource() == nom){
          figureDetail.setNom(nom.getText());
          
      }
      else if(e.getSource() == jcRemplir){
          if(jcRemplir.isSelected()){
              if(figureDetail instanceof Polygone){
                  Polygone figureDetailPoly = (Polygone) figureDetail;
                  figureDetailPoly.setRemplir(true);
              }
              else if(figureDetail instanceof Ellipse){
                  Ellipse figureDetailElli = (Ellipse) figureDetail;
                  figureDetailElli.setRemplir(true);
              }
          }
           else{
              if(figureDetail instanceof Polygone){
                  Polygone figureDetailPoly = (Polygone) figureDetail;
                  figureDetailPoly.setRemplir(false);
              }
              else if(figureDetail instanceof Ellipse){
                  Ellipse figureDetailElli = (Ellipse) figureDetail;
                  figureDetailElli.setRemplir(false);
              }
          }
      }
      afficherDetail(figureDetail);
    }

}
