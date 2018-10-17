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
    public static void menu(){
    Figure[] lesFigs = new Figure[MAXFIG];
    int n = 0;
    int rep;
    do{
        System.out.println("0) Quitter"); 
        System.out.println("1) Ajouter"); 
        System.out.println("2) Supprimer"); 
        System.out.println("3) Tout afficher"); 
        System.out.println("4) Trouver figure proche"); 
        rep = Lire.i();
    }while(rep !=0);
    
    if(rep == 1){
        lesFigs[n] = Figure.entreeFig();
        n = n+1;
    }
    else if(rep == 2){
        for(int i =0;i<n;i++){
            System.out.println(i+":"+lesFigs[i]);
        }
       int choix = Lire.i();
       lesFigs[choix] = lesFigs[n-1];
       lesFigs[n-1] = null;
       n=n-1;
    }
}
