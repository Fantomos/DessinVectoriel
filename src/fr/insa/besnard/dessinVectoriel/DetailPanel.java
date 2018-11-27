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
    private Box formeC;
    private JLabel nomLabel;
    private JTextField nom;
    private Box nomC;
    private JLabel colorLabel;
    private JButton jbColor;
    private Box colorC;
    
     private Box RemplirC;
    private JCheckBox jcRemplir;
  
    private JLabel coordXLabel;
    private JTextField coordX;
    private Box coordXC;
    private JLabel coordYLabel;
    private JTextField coordY;
    private Box coordYC;

    public DetailPanel(ScenePrincipal main) {
        this.setVisible(false);
        this.setBackground(Color.GRAY);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.figureDetail = null;
        this.main = main;
        this.titre = new JLabel("Paramètre :");
        this.titre.setAlignmentX(CENTER_ALIGNMENT);
        
        // Type de figure
        this.formeLabel = new JLabel("Forme : ");
        this.forme = new JLabel("Indisponible");
        forme.setPreferredSize(new Dimension(80, 20));
        this.formeC = new Box(BoxLayout.X_AXIS);
        formeC.add(formeLabel);
        formeC.add(forme);
       
        
        formeC.setMaximumSize(formeC.getPreferredSize());
        
         // Affichage/Edition du nom
        this.nomLabel = new JLabel("Nom : ");
        this.nom = new JTextField("Indisponible");
        nom.setPreferredSize(new Dimension(80, 20));
        nom.addActionListener(this);   
        this.nomC =  new Box(BoxLayout.X_AXIS);
        nomC.add(nomLabel);
        nomC.add(nom);
 
        
        nomC.setMaximumSize(nomC.getPreferredSize());
       
         // Affichage/Edition de la couleur
        this.colorLabel = new JLabel("Couleur : ");
        this.jbColor = new JButton(" ");
        
        jbColor.addActionListener(this);
        this.colorC = new Box(BoxLayout.X_AXIS);
        colorC.add(colorLabel);
        colorC.add(jbColor);
     
       
        colorC.setMaximumSize(colorC.getPreferredSize());
       
        // Affichage/Edition du remplissage
        this.jcRemplir = new JCheckBox("Remplir : ");
        jcRemplir.setHorizontalTextPosition(SwingConstants.LEFT);
        jcRemplir.addActionListener(this);
        this.RemplirC = new Box(BoxLayout.X_AXIS);
        jcRemplir.setBackground(this.getBackground());
        jcRemplir.setMaximumSize(jcRemplir.getPreferredSize());    
        RemplirC.add(jcRemplir);
        jcRemplir.setAlignmentX(SwingConstants.WEST);
        
       
        
       
               
       
        //
        this.coordXLabel = new JLabel("X : ");
        this.coordX = new JTextField();
        coordX.addActionListener(this); 
        coordX.setPreferredSize(new Dimension(50, 20));
        this.coordXC = new Box(BoxLayout.X_AXIS);
        coordXC.add(coordXLabel);
        coordXC.add(coordX);
        coordXC.setMaximumSize(coordXC.getPreferredSize());
        
        this.coordYLabel = new JLabel("Y : ");
        this.coordY = new JTextField();
         coordY.addActionListener(this); 
        coordY.setPreferredSize(new Dimension(50, 20));
        this.coordYC = new Box(BoxLayout.X_AXIS);
        coordYC.add(coordYLabel);
        coordYC.add(coordY);
        coordYC.setMaximumSize(coordYC.getPreferredSize());
       
        this.add(titre);
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(formeC);
         this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(nomC);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(colorC);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(RemplirC);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(coordXC);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(coordYC);
     
   
      

    }

    public void setFigureDetail(Figure figureDetail) {
        this.figureDetail = figureDetail;
    }

    public Figure getFigureDetail() {
        return figureDetail;
    }
    
    public void afficherDetail(Figure a){
        if(main.getSceneDessin().isEnSelection()){
            main.getSceneDessin().setFgContourBleu(Figure.figSelection(a));
        }
        figureDetail = a;
        forme.setText(a.getClass().getSimpleName());
        nom.setText(a.getNom());
        jbColor.setBackground(a.getCouleur());
        
        
         RemplirC.setVisible(false);
         coordXC.setVisible(false);
         coordYC.setVisible(false);
        if(figureDetail instanceof Polygone){
                Polygone figureDetailPoly = (Polygone) a;
                jcRemplir.setSelected(figureDetailPoly.isRemplir());
                RemplirC.setVisible(true);
                
               if(figureDetail instanceof Rectangle){
               Rectangle figureDetailRec = (Rectangle) a;
               coordX.setText(Double.toString(figureDetailRec.centre().getCoordx()));
               coordXC.setVisible(true);
                coordY.setText(Double.toString(figureDetailRec.centre().getCoordy()));
               coordYC.setVisible(true);
        }
        }
        else if(figureDetail instanceof Ellipse){
               Ellipse figureDetailEll = (Ellipse) a;
               jcRemplir.setSelected(figureDetailEll.isRemplir());
               RemplirC.setVisible(true);
               coordX.setText(Double.toString(figureDetailEll.getPtSupGauche().getCoordx() + figureDetailEll.getRayonX()));
               coordXC.setVisible(true);
                coordY.setText(Double.toString(figureDetailEll.getPtSupGauche().getCoordy() + figureDetailEll.getRayonY()));
               coordYC.setVisible(true);
        }
        
         else if(figureDetail instanceof Point){
               Point figureDetailPt = (Point) a;
               coordX.setText(Double.toString(figureDetailPt.getCoordx()));
               coordXC.setVisible(true);
               coordY.setText(Double.toString(figureDetailPt.getCoordy()));
               coordYC.setVisible(true);
               
        }
        else if(figureDetail instanceof Segment){
               Segment figureDetailSeg = (Segment) a;
               
               
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
      else if(e.getSource() == coordX){
       
              if(figureDetail instanceof Point){
                  Point figureDetailPt = (Point) figureDetail;
                  figureDetailPt.setCoordx(Double.valueOf(coordX.getText()));
               
                  
              }
              else if(figureDetail instanceof Ellipse){
                  Ellipse figureDetailElli = (Ellipse) figureDetail;
                 figureDetailElli.getPtSupGauche().setCoordx(Double.valueOf(coordX.getText())); 
              }
              else if(figureDetail instanceof Rectangle){
                  Rectangle figureDetailRec = (Rectangle) figureDetail;
                 figureDetailRec.update(new Point(Double.valueOf(coordX.getText())-figureDetailRec.longueur()/2,figureDetailRec.getSommet().get(0).getCoordy())); 
              }
          
           
      }
      else if(e.getSource() == coordY){
       
              if(figureDetail instanceof Point){
                  Point figureDetailPt = (Point) figureDetail;
                  figureDetailPt.setCoordy(Double.valueOf(coordY.getText()));  
              }
              else if(figureDetail instanceof Ellipse){
                  Ellipse figureDetailElli = (Ellipse) figureDetail;
                  figureDetailElli.getPtSupGauche().setCoordy(Double.valueOf(coordY.getText())); 
              }
               else if(figureDetail instanceof Rectangle){
                  Rectangle figureDetailRec = (Rectangle) figureDetail;
                 figureDetailRec.update(new Point(figureDetailRec.getSommet().get(0).getCoordx(),Double.valueOf(coordY.getText())-figureDetailRec.largeur()/2)); 
              }
          
           
      }
      afficherDetail(figureDetail);
    }

}
