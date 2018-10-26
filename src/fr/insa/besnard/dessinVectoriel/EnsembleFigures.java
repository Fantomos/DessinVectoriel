/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import utils.Lire;

/**
 *
 * @author nbesnard01
 */
public class EnsembleFigures extends Figure{
    // Attributs
    private ArrayList<Figure> tabFigures;

    // Constructeur
    public EnsembleFigures(ArrayList<Figure> tabFigures, String nom, Color couleur) {
        super(nom,couleur);
        this.tabFigures = tabFigures;
    }

    // Méthode création
    public static EnsembleFigures nouveauEnsembleFigures(){
       ArrayList<Figure> tabFigures = new ArrayList<Figure>();
       
       
       
       return new EnsembleFigures(tabFigures,"ensemble",Color.black);
    } 
     
    
    public void afficheFigure(){
        for (int i = 0; i < this.tabFigures.size(); i++) {
                    System.out.println(i + " | " + this.tabFigures.get(i) + " | Min X : " + this.tabFigures.get(i).minX() + " | Min Y : " + this.tabFigures.get(i).minY() + " | Max X : " + this.tabFigures.get(i).maxX() + " | Max Y : " + this.tabFigures.get(i).maxY() + " | Couleur : " + this.tabFigures.get(i).getCouleur());
        }
    }
    
    public Figure choisiFigure(){
        this.afficheFigure();
        System.out.println("Selectionner une figure :");
        return this.tabFigures.get(Lire.i());
    }
    
    public void supprimeFigure(){
          this.afficheFigure();
          System.out.println("Supprimer la figure :");
          this.tabFigures.remove(Lire.i());
    }
    
    public void ajouterFigure(){
          this.tabFigures.add(Figure.entreFigure());
    }
    
    
    public void gestion() {
        int n = 0;
        int rep;
        do {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("0) Quitter");
            System.out.println("1) Ajouter");
            System.out.println("2) Supprimer");
            System.out.println("3) Tout afficher");
            System.out.println("4) Afficher distance à un point");
            System.out.println("------------------------------------------------------------------------------");
            rep = Lire.i();

            if (rep == 1) {
                this.ajouterFigure();
            } else if (rep == 2) {
                this.supprimeFigure();
            } else if (rep == 3) {
                this.afficheFigure();
            } else if (rep == 4) {
                Point p = Point.nouveauPoint();
                System.out.println("Distance : "+this.distancePoint(p));
            }
        } while (rep != 0);
    }
    
    
    //Définition méthode abstract de Figure
    @Override
    public double distancePoint(Point p){
        Figure figureProche =  Collections.min(this.tabFigures, Comparator.comparing((Figure a) -> a.distancePoint(p)));
        return figureProche.distancePoint(p);
        
//        double MinDistance = Double.MAX_VALUE;
//        int idMinDistance = 0 ;
//                for (int i = 0; i < this.tabFigures.size(); i++) {
//                    double distance = tabFigures.get(i).distancePoint(p);
//                    if (distance < MinDistance) {
//                        MinDistance = distance;
//                        idMinDistance = i;
//                    }
//                }
//           return MinDistance;        
    }
    
    
  
    @Override
    public double minX(){
        Figure figureMinX =  Collections.min(this.tabFigures, Comparator.comparing((Figure a) -> a.minX()));
        return figureMinX.minX();
    };
    @Override
    public double minY(){
        Figure figureMinY =  Collections.min(this.tabFigures, Comparator.comparing((Figure a) -> a.minY()));
        return figureMinY.minY();
    };
    @Override
    public double maxX(){
        Figure figureMaxX =  Collections.max(this.tabFigures, Comparator.comparing((Figure a) -> a.maxX()));
        return figureMaxX.maxX();
    };
    @Override
    public  double maxY(){
        Figure figureMaxY =  Collections.max(this.tabFigures, Comparator.comparing((Figure a) -> a.maxY()));
        return figureMaxY.maxY();
    };
    
   

    public static void main(String[] args) {
        EnsembleFigures ensemble1 = EnsembleFigures.nouveauEnsembleFigures();
        ensemble1.tabFigures.add(new Point(6,10));
        ensemble1.tabFigures.add(new Point(0,5));
        ensemble1.tabFigures.add(new Point(8,9));
        System.out.println(ensemble1.distancePoint(new Point()));
    }
}
