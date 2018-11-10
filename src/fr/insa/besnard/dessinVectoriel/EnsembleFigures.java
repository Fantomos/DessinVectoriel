/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    public EnsembleFigures(ArrayList<Figure> tabFigures, String nom) {
       this(tabFigures, nom,Color.BLACK);
    }
      public EnsembleFigures(ArrayList<Figure> tabFigures) {
       this(tabFigures, "Ensemble",Color.BLACK);
    }

    // Méthode création
    public static EnsembleFigures nouveauEnsembleFigures(ArrayList<Figure> figure){
       EnsembleFigures nouvelEnsemble = new EnsembleFigures(figure,"Ensemble",Color.black);
       
       return nouvelEnsemble;
      
    } 
     
    
    public void afficheFigure(){
        System.out.println(this.getNom() + " :");
        for (int i = 0; i < this.tabFigures.size(); i++) {
                    System.out.println(i + " | " + this.tabFigures.get(i) + " | Min X : " + this.tabFigures.get(i).minX() + " | Min Y : " + this.tabFigures.get(i).minY() + " | Max X : " + this.tabFigures.get(i).maxX() + " | Max Y : " + this.tabFigures.get(i).maxY() + " | Couleur : " + this.tabFigures.get(i).getCouleur());
        }
    }
    
    public Figure choisiFigure(){
        this.afficheFigure();
        System.out.println("Selectionner une figure :");
        return this.tabFigures.get(Lire.i());
    }
    
    public void supprimeFigure(int i){
          this.tabFigures.remove(i);
    }
    
    public void ajouterFigure(Figure fig){
          this.tabFigures.add(fig);
    }
    
   public int trouverFigure(Figure fig){
       int indice = -1;
       for (int i = 0; i < this.tabFigures.size(); i++) {
            if(tabFigures.get(i).equals(fig)){
                indice = i;
            }
       }
       if(indice == -1){
           throw new Error("Figure non existante");
       }
       else{
        return indice;
       }
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
                this.ajouterFigure(Figure.entreFigure());
            } else if (rep == 2) {
                this.afficheFigure();
                System.out.println("Supprimer la figure :");
                this.supprimeFigure(Lire.i());
            } else if (rep == 3) {
                this.afficheFigure();
            } else if (rep == 4) {
                Point p = Point.nouveauPoint();
                System.out.println("Distance : "+this.distancePoint(p));
            }
        } while (rep != 0);
    }
    
   
    
    public void save(File f) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(f))) {
        
            bf.append((this.toSave()));

        } catch (IOException ex) {
            throw new Error(ex);
          
        }
        
 
  
    }
    
   
    
    // Ici la méthode "symetriques" de l'énoncé est en faite la spécialisation de "symetriqueOrigine" dans EnsembleFigure  
    @Override
    public EnsembleFigures symetriqueOrigine(){
        ArrayList<Figure> tabFiguresSym = new ArrayList<Figure>(); 
        for(int i=0;i<tabFigures.size();i++){
            tabFiguresSym.add(tabFigures.get(i).symetriqueOrigine());
        }
        
        return new EnsembleFigures(tabFiguresSym, "Symetrique");
    }
    
    
    //Définition méthode abstract de Figure
    
    @Override
     public String toSave(){
        String texte = "EF;" + this.getNom() + ";" + this.tabFigures.size() + ";\n";
        for(int i=0;i<this.tabFigures.size();i++){
            texte = texte + this.tabFigures.get(i).toSave(); 
        }
        texte = texte + this.getCouleur() + ";";
        return texte;
    }
     
    
     
    @Override
      public void dessine(Graphics g) {
        g.setColor(this.getCouleur());
        for(int i=0;i<this.tabFigures.size();i++){
            this.tabFigures.get(i).dessine(g);
        }
    }
    
     
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
    
   
    
   

    // TP 3 : 3)
    public static void main(String[] args) {
   
        
      
      EnsembleFigures original = new EnsembleFigures(new ArrayList<Figure>(),"Original");
      Point p1 = new Point(0,3,"P1");
      Point p2 = new Point(-2,0, "P2");
      Point p3 = new Point(4,0,"P3");
      original.tabFigures.add(p1);
      original.tabFigures.add(p2);
      original.tabFigures.add(p3);
      original.tabFigures.add(new Segment(p1,p2,"s1"));
      original.tabFigures.add(new Segment(p2,p3,"s2"));
      original.tabFigures.add(new Segment(p3,p1,"s3"));
      
      EnsembleFigures sym = original.symetriqueOrigine();
      
      original.afficheFigure();
      sym.afficheFigure();
      
    }
}
