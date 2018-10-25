/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;


import java.awt.Color;
import utils.Lire;

/**
 *
 * @author nbesnard01
 */
public class Segment extends Figure{
    private Point depart;
    private Point fin;
    
    //Constructeur
    public Segment(Point a, Point b){
        this(a,b,"Segment",Color.BLACK);
    }
    
    public Segment(Point a, Point b, String nom,Color couleur){
        super(nom,couleur);
        this.depart = a;
        this.fin = b;
    }
   
   //Méthode création
   public static Segment nouveauSegment(){
       System.out.println("Entrez le nom du segment : ");
       String nom = Lire.S();
       return new Segment(Point.nouveauPoint(),Point.nouveauPoint(),nom,Color.black);
    } 
   
   
   public double longueur(){
       return Math.sqrt(Math.pow(
                this.fin.getCoordx()-this.depart.getCoordx(),2)+ 
                Math.pow(
                this.fin.getCoordy()-this.depart.getCoordy(),2));
   }   
   
   
   //Définition méthode abstract de Figure
    @Override
    public String toString(){
        return super.getNom() + " = [" + depart + "," + fin + "]";
    }
    
    @Override
    public double minX(){
        return Math.min(depart.getCoordx(), fin.getCoordx());
    };
    
    @Override
    public double maxX(){
         return Math.max(depart.getCoordx(), fin.getCoordx());
    };
    
    @Override
     public double minY(){
        return Math.min(depart.getCoordy(), fin.getCoordy());
    };
     
    @Override
    public double maxY(){
        return Math.max(depart.getCoordy(), fin.getCoordy());
    };
    
    
    
    @Override
    public double distancePoint(Point p) {
        double upnum = (p.getCoordx()-depart.getCoordx())*(fin.getCoordx() - depart.getCoordx()) + (p.getCoordy() - depart.getCoordy())*(fin.getCoordy() - depart.getCoordy());
        double updenum = Math.pow((fin.getCoordx() - depart.getCoordx()),2) + Math.pow((fin.getCoordy() - depart.getCoordy()),2) ;
        double up = upnum/updenum;
        if(up < 0){
            return p.distancePoint(depart);
        }
        else if(up > 1){
            return p.distancePoint(fin);
        }
        else {
            Point P4 = new Point(depart.getCoordx() + up*(fin.getCoordx() - depart.getCoordx()), depart.getCoordy() + up*(fin.getCoordy() - depart.getCoordy()));
            return p.distancePoint(P4);
        }
        
 
    }
    
     public static void main(String[] args) {
       
        Segment seg1 = nouveauSegment();
        Point p1 = Point.nouveauPoint();
        System.out.println(seg1.distancePoint(p1));
    }
   
    
}
