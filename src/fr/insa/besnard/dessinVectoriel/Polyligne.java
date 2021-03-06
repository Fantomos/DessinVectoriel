/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import utils.Lire;

/**
 *
 * @author nbesnard01
 */
public class Polyligne extends Figure{
  private ArrayList<Point> sommet;

    public ArrayList<Point> getSommet() {
        return sommet;
    }

    public void setSommet(ArrayList<Point> sommet) {
        this.sommet = sommet;
    }
    
    //Constructeur
     public Polyligne(){
        this(new ArrayList<Point>(), "Polyligne",Color.BLACK);
    }
     public Polyligne(Polyligne poly){
        this(poly.getSommet(), poly.getNom(),poly.getCouleur());
    }
    
    public Polyligne(ArrayList<Point> sommet){
        this(sommet, "Polyligne",Color.BLACK);
    }
    
    public Polyligne(ArrayList<Point> sommet,String nom) {
        this(sommet,nom,Color.BLACK);
    }
    
    public Polyligne(ArrayList<Point> sommet,String nom, Color couleur) {
        super(nom,couleur,0);
        this.sommet = sommet;
    }
    
     public int sommetProche(Point p){
         Point pointProche =  Collections.min(this.sommet, Comparator.comparing(a -> a.distancePoint(p)));
         if(pointProche.distancePoint(p) < 5){
             return sommet.indexOf(pointProche);
         }
         else{
             return -1;
         }
    }
     
  @Override
     public void deplace(Point2D p) {
        double deltaX = this.getSommet().get(0).getCoordx() - p.getX();
        double deltaY = this.getSommet().get(0).getCoordy() - p.getY();
        for (int i = 0; i < this.getSommet().size(); i++) {
            this.getSommet().set(i, new Point(this.getSommet().get(i).getCoordx() - deltaX, this.getSommet().get(i).getCoordy() - deltaY));
        }
    }
    
    @Override
    public Polyligne symetriqueOrigine(){
        ArrayList<Point> sommetSym = new ArrayList<Point>(); 
        for(int i=0;i<sommet.size();i++){
            sommetSym.add(sommet.get(i).symetriqueOrigine());
        }
        
        return new Polyligne(sommetSym, this.getNom()+"Sym");
    }
    
    @Override
     public void dessine(Graphics2D g) {
        g.setColor(this.getCouleur());
        g.rotate(super.getTheta());
        double[] x = new double[sommet.size()];
        double[] y = new double[sommet.size()];
        for(int i=0;i<this.sommet.size();i++){
            x[i] = this.sommet.get(i).getCoordx();
            y[i] = this.sommet.get(i).getCoordy();
        }
        Path2D path = new Path2D.Double();
        path.moveTo(x[0], y[0]);
        for (int i = 1; i < x.length; ++i) {
            path.lineTo(x[i], y[i]);
        }
        
        g.draw(path);
            //g.fillPolygon(x, y, this.sommet.size());
       
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
 
         Segment segmentProche1;
         Segment segmentProche2;
         int index = this.sommet.indexOf(pointProche);
         
         if(index == 0){
             return new Segment(this.sommet.get(index),this.sommet.get(index+1)).distancePoint(p);
         }
         else if(index == this.sommet.size()-1){
          
             return new Segment(this.sommet.get(index),this.sommet.get(index-1)).distancePoint(p);
         }
         else{
             segmentProche1 = new Segment(this.sommet.get(index),this.sommet.get(index+1));
             segmentProche2 = new Segment(this.sommet.get(index),this.sommet.get(index-1));; 
             double distanceSegment1 = segmentProche1.distancePoint(p);
        double distanceSegment2 = segmentProche2.distancePoint(p);
         if(distanceSegment1 <= distanceSegment2){
            return distanceSegment1;
            
        }
        else{
            return distanceSegment2;
        }
         }
         
        
      
        
        
        
       
    }
    
    @Override
    public String toSave(){
        String texte = "PL;" + this.getNom() + ";" + getCouleur().getRed() + ";" + getCouleur().getGreen() + ";" + getCouleur().getBlue() + ";" + getCouleur().getAlpha() + ";"+ this.sommet.size();
        for(int i=0;i<this.sommet.size();i++){
            texte = texte + ";"+ this.sommet.get(i).getCoordx() + ";"
                + this.sommet.get(i).getCoordy();
        }
      
        return texte;
    };
    
     @Override
    public Polyligne copy() {
        return new Polyligne(this);
    }
    
    public static void main(String[] args) {
 
    }
}

