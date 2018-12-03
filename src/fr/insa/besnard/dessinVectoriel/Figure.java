/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import utils.Lire;

/**
 *
 * @author nbesnard01
 */
public abstract class Figure{
    
    private String nom;
    private Color couleur;

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   
    public Figure(String nom, Color couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }
     public Figure(Figure a) {
        this(a.nom,a.couleur);
     }
    
    
    public static Figure entreFigure(){
        System.out.println("\n0) Point");
        System.out.println("1) Segment");
        int choix = Lire.i();
        if(choix == 0){
            return Point.nouveauPoint();
        }
        else{
            return Segment.nouveauSegment();
        }
    }
    
    public void changerEnsemble(EnsembleFigures a, EnsembleFigures b){
        a.getTabFigures().remove(this); 
        b.ajouterFigure(this); 
    }
    public static Figure figSelection(Figure a){
        
        Figure fgTemp = a.copy();
       fgTemp.setCouleur(Color.blue);
                if(fgTemp instanceof Polygone){
                  ((Polygone) fgTemp).setRemplir(false);  
                }
                else if(fgTemp instanceof Ellipse){
                    ((Ellipse) fgTemp).setRemplir(false); 
                }
                return fgTemp;
    }
    public static Figure parse(String info){
        String[] infoTab = info.split(";");
        if("P".equals(infoTab[0])){
              double coordX = Double.parseDouble(infoTab[2]);
              double coordY = Double.parseDouble(infoTab[3]);
              String nom = infoTab[1];
              Color couleur = new Color(Integer.parseInt(infoTab[4]),Integer.parseInt(infoTab[5]),Integer.parseInt(infoTab[6])); 
              return new Point(coordX,coordY,nom,couleur);
        }
        else if("S".equals(infoTab[0])){
              double coordXDepart = Double.parseDouble(infoTab[2]);
              double coordYDepart = Double.parseDouble(infoTab[3]);
              double coordXFin = Double.parseDouble(infoTab[4]);
              double coordYFin = Double.parseDouble(infoTab[5]);
              String nom = infoTab[1];
              Color couleur = new Color(Integer.parseInt(infoTab[6]),Integer.parseInt(infoTab[7]),Integer.parseInt(infoTab[8])); 
              return new Segment(new Point(coordXDepart,coordYDepart),new Point(coordXFin,coordYFin),nom,couleur);
        }
        else if("EL".equals(infoTab[0])){
              double coordXCenter = Double.parseDouble(infoTab[3]);
              double coordYCenter = Double.parseDouble(infoTab[4]);
              double rayonX = Double.parseDouble(infoTab[5]);
              double rayonY = Double.parseDouble(infoTab[6]);
              String nom = infoTab[1];
              boolean remplir = Boolean.getBoolean(infoTab[2]);
              Color couleur = new Color(Integer.parseInt(infoTab[7]),Integer.parseInt(infoTab[8]),Integer.parseInt(infoTab[9])); 
              return new Ellipse(new Point(coordXCenter,coordYCenter),rayonX,rayonY,nom,couleur,remplir);
        }
        else if("CE".equals(infoTab[0])){
              double coordXCenter = Double.parseDouble(infoTab[3]);
              double coordYCenter = Double.parseDouble(infoTab[4]);
              double rayonX = Double.parseDouble(infoTab[5]);
              String nom = infoTab[1];
              boolean remplir = Boolean.getBoolean(infoTab[2]);
              Color couleur = new Color(Integer.parseInt(infoTab[6]),Integer.parseInt(infoTab[7]),Integer.parseInt(infoTab[8])); 
              return new Cercle(new Point(coordXCenter,coordYCenter),rayonX,nom,couleur,remplir);
        }
         else if("PG".equals(infoTab[0])){
              String nom = infoTab[1];
              boolean remplir = Boolean.getBoolean(infoTab[2]);
              ArrayList<Point> sommet = new ArrayList<>();
              for(int i=0;i<Integer.parseInt(infoTab[6]);i++){
                  double coordX = Double.parseDouble(infoTab[7+2*i]);
                  double coordY = Double.parseDouble(infoTab[8+2*i]);
                  Point p = new Point(coordX,coordY);
                  sommet.add(p);
              }
              Color couleur = new Color(Integer.parseInt(infoTab[3]),Integer.parseInt(infoTab[4]),Integer.parseInt(infoTab[5])); 
              return new Polygone(sommet,nom,couleur,remplir);
        }
          else if("PL".equals(infoTab[0])){
              String nom = infoTab[1];
              ArrayList<Point> sommet = new ArrayList<>();
              for(int i=0;i<Integer.parseInt(infoTab[5]);i++){
                  double coordX = Double.parseDouble(infoTab[6+2*i]);
                  double coordY = Double.parseDouble(infoTab[7+2*i]);
                  Point p = new Point(coordX,coordY);
                  sommet.add(p);
              }
              Color couleur = new Color(Integer.parseInt(infoTab[2]),Integer.parseInt(infoTab[3]),Integer.parseInt(infoTab[4])); 
              return new Polyligne(sommet,nom,couleur);
        }
         else if("R".equals(infoTab[0])){
              String nom = infoTab[1];
              boolean remplir = Boolean.getBoolean(infoTab[2]);
              double coordX = Double.parseDouble(infoTab[3]);
              double coordY = Double.parseDouble(infoTab[4]);
              Point ptSupGauche = new Point(coordX,coordY);
              double longueur = Double.parseDouble(infoTab[5]);
              double largeur = Double.parseDouble(infoTab[6]);
              Color couleur = new Color(Integer.parseInt(infoTab[7]),Integer.parseInt(infoTab[8]),Integer.parseInt(infoTab[9])); 
              return new Rectangle(ptSupGauche,largeur,longueur,nom,couleur,remplir);
        }
        else if("CA".equals(infoTab[0])){
              String nom = infoTab[1];
              boolean remplir = Boolean.getBoolean(infoTab[2]);
              double coordX = Double.parseDouble(infoTab[3]);
              double coordY = Double.parseDouble(infoTab[4]);
              Point ptSupGauche = new Point(coordX,coordY);
              double longueur = Double.parseDouble(infoTab[5]);
              Color couleur = new Color(Integer.parseInt(infoTab[6]),Integer.parseInt(infoTab[7]),Integer.parseInt(infoTab[8])); 
              return new Carre(ptSupGauche,longueur,nom,couleur,remplir);
        }
        else if("EF".equals(infoTab[0])){
            // A Faire
        }
        
        
      return null;
    };
    
    
    public abstract Figure copy();
    public abstract Figure symetriqueOrigine();
    public abstract void dessine(Graphics g);
    public abstract String toSave();
    public abstract double minX();
    public abstract double minY();
    public abstract double maxX();
    public abstract double maxY();
    public abstract double distancePoint(Point p); 

    
   
}



