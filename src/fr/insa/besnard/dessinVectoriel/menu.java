/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import utils.Lire;

/**
 *
 * @author nbesnard01
 */
public class menu {
    public static int MAXFIG = 2000;
    public static Figure[] tabFigures = new Figure[MAXFIG];
    public static void menu(){
    
    int n = 0;
    int rep;
    do{
        System.out.println("\n0) Quitter"); 
        System.out.println("1) Ajouter"); 
        System.out.println("2) Supprimer"); 
        System.out.println("3) Tout afficher"); 
        System.out.println("4) Trouver figure proche du point"); 
        rep = Lire.i();
    
    
    if(rep == 1){
        tabFigures[n] = Figure.entreFigure();
        n = n+1;
    }
    else if(rep == 2){
        for(int i =0;i<n;i++){
            System.out.println(i+" | "+tabFigures[i]);
        }
       tabFigures[Lire.i()] = tabFigures[n-1];
       tabFigures[n-1] = null;
       n=n-1;
    }
    else if(rep == 3){
        for(int i =0;i<n;i++){
            System.out.println(i+" | "+tabFigures[i]+ " | Min X : "+tabFigures[i].minX()+" | Min Y : "+tabFigures[i].minY()+" | Max X : "+tabFigures[i].maxX()+" | Max Y : "+tabFigures[i].maxY());
        }
    }
    else if(rep == 4){
      Point p = Point.nouveauPoint();
      double MinDistance = Double.MAX_VALUE;
      int idMinDistance = 0;
      for(int i =0;i<n;i++){
          double distance = tabFigures[i].distancePoint(p);
          if(distance < MinDistance){
              MinDistance = distance;
              idMinDistance = i;
          }
      }
      System.out.println(tabFigures[idMinDistance]);
    }
    
    }while(rep !=0);
}
    public static void main(String[] args) {
       menu();
    }
}
