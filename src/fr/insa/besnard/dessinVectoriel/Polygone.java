/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import utils.Lire;

/**
 *
 * @author Nicolas
 */
public class Polygone extends Figure {
    private ArrayList<Point> sommet;

    public ArrayList<Point> getSommet() {
        return sommet;
    }

    public void setSommet(ArrayList<Point> sommet) {
        this.sommet = sommet;
    }
    
    //Constructeur
    public Polygone(ArrayList<Point> sommet){
        this(sommet, "Polygone",Color.BLACK);
    }
    
    public Polygone(ArrayList<Point> sommet,String nom) {
        this(sommet,nom,Color.BLACK);
    }
    
    public Polygone(ArrayList<Point> sommet,String nom, Color couleur) {
        super(nom,couleur);
        this.sommet = sommet;
    }
    
    
    // Méthode Création
    public static Polygone nouveauPolygone(){
       ArrayList<Point> sommet = new ArrayList<Point>();
       System.out.println("Entrez le nom du polygone : ");
       String nom = Lire.S();
       System.out.println("Entrez le nombre de sommet : ");
       int nombreSommet = Lire.i();
       for(int i=0;i<nombreSommet;i++){
         sommet.add(Point.nouveauPoint());
       }
       return new Polygone(sommet,nom,Color.BLACK);
    } 
    
    @Override
    public Polygone symetriqueOrigine(){
        ArrayList<Point> sommetSym = new ArrayList<Point>(); 
        for(int i=0;i<sommet.size();i++){
            sommetSym.add(sommet.get(i).symetriqueOrigine());
        }
        
        return new Polygone(sommetSym, this.getNom()+"Sym");
    }
    
    @Override
     public void dessine(Graphics g) {
        g.setColor(this.getCouleur());
        int[] x = new int[sommet.size()];
        int[] y = new int[sommet.size()];
        for(int i=0;i<this.sommet.size();i++){
            x[i] = (int) this.sommet.get(i).getCoordx();
            y[i] = (int) this.sommet.get(i).getCoordy();
        }
        g.fillPolygon(x,y,this.sommet.size());
       
    }
    
     @Override
    public String toString(){
        String texte = super.getNom() + " = [";
        for(int i=0;i<this.sommet.size();i++){
            texte = texte + sommet.get(i) + "; ";
        }
        texte = texte + "]";
        return texte;
    }
    
    @Override
  public double minX(){
        Point pointMinX =  Collections.min(this.sommet, Comparator.comparing(a -> a.minX()));
        return pointMinX.minX();
    };
    @Override
    public double minY(){
        Figure pointMinY =  Collections.min(this.sommet, Comparator.comparing(a -> a.minY()));
        return pointMinY.minY();
    };
    @Override
    public double maxX(){
        Figure pointMaxX =  Collections.max(this.sommet, Comparator.comparing(a -> a.maxX()));
        return pointMaxX.maxX();
    };
    @Override
    public  double maxY(){
        Figure pointMaxY =  Collections.max(this.sommet, Comparator.comparing(a -> a.maxY()));
        return pointMaxY.maxY();
    };

    @Override
    public double distancePoint(Point p) {
        Point pointProche =  Collections.min(this.sommet, Comparator.comparing(a -> a.distancePoint(p)));
        return pointProche.distancePoint(p);
    }
    
    @Override
    public String toSave(){
        String texte = "PG;" + this.getNom() + ";" + this.sommet.size() + ";";
        for(int i=0;i<this.sommet.size();i++){
            texte = texte +  + this.sommet.get(i).getCoordx() + ";"
                + this.sommet.get(i).getCoordy()  + ";";
        }
        texte = texte + getCouleur() +";\n";
        return texte;
    };
    
    
    
    public static void main(String[] args) {
        Polygone pol = Polygone.nouveauPolygone();
        System.out.println(pol);
    }
}
