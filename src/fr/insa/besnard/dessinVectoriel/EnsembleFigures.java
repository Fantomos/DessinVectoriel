/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.util.ArrayList;
import utils.Lire;

/**
 *
 * @author nbesnard01
 */
public class EnsembleFigures extends Figure{

    public ArrayList<Figure> tabFigures;

    public EnsembleFigures(String nom, Color couleur) {
        super(nom,couleur);
        this.tabFigures = new ArrayList<Figure>();
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
            System.out.println("4) Trouver figure proche du point");
            System.out.println("5) Afficher distance à un point");
            System.out.println("------------------------------------------------------------------------------");
            rep = Lire.i();

            if (rep == 1) {
                tabFigures[n] = Figure.entreFigure();
                n = n + 1;
            } else if (rep == 2) {
                for (int i = 0; i < n; i++) {
                    System.out.println(i + " | " + tabFigures[i]);
                }
                tabFigures[Lire.i()] = tabFigures[n - 1];
                tabFigures[n - 1] = null;
                n = n - 1;
            } else if (rep == 3) {
                for (int i = 0; i < n; i++) {
                    System.out.println(i + " | " + tabFigures[i] + " | Min X : " + tabFigures[i].minX() + " | Min Y : " + tabFigures[i].minY() + " | Max X : " + tabFigures[i].maxX() + " | Max Y : " + tabFigures[i].maxY() + " | Couleur : " + tabFigures[i].getCouleur());
                }
            } else if (rep == 4) {
                Point p = Point.nouveauPoint();
                double MinDistance = Double.MAX_VALUE;
                int idMinDistance = 0;
                for (int i = 0; i < n; i++) {
                    double distance = tabFigures[i].distancePoint(p);
                    if (distance < MinDistance) {
                        MinDistance = distance;
                        idMinDistance = i;
                    }
                }
                System.out.println(tabFigures[idMinDistance]);
            } else if (rep == 5) {
                Point p = Point.nouveauPoint();
                System.out.println("Selectionner une figure : ");
                for (int i = 0; i < n; i++) {
                    System.out.println(i + " | " + tabFigures[i]);
                }
                System.out.println("Distance : " + tabFigures[Lire.i()].distancePoint(p));

            }

        } while (rep != 0);
    }

    public static void main(String[] args) {
        EnsembleFigures menu1 = new EnsembleFigures();
        menu1.gestion();
    }
}
