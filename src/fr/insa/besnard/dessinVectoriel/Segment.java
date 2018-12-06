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
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import utils.Lire;

/**
 *
 * @author nbesnard01
 */
public class Segment extends Figure {

    private Point depart;
    private Point fin;

    public void setDepart(Point depart) {
        this.depart = depart;
    }

    public void setFin(Point fin) {
        this.fin = fin;
    }

    public Point getDepart() {
        return depart;
    }

    public Point getFin() {
        return fin;
    }

    //Constructeur
    public Segment() {
        this(new Point(), new Point(), "Segment", Color.BLACK);
    }

    public Segment(Segment seg) {
        this(seg.depart, seg.fin, seg.getNom(), seg.getCouleur());
    }

    public Segment(Point a, Point b) {
        this(a, b, "Segment", Color.BLACK);
    }

    public Segment(Point a, Point b, String nom) {
        this(a, b, nom, Color.BLACK);
    }

    public Segment(Point a, Point b, String nom, Color couleur) {
        super(nom, couleur);
        this.depart = a;
        this.fin = b;
    }

    //Méthode création
    public static Segment nouveauSegment() {
        System.out.println("Entrez le nom du segment : ");
        String nom = Lire.S();
        return new Segment(Point.nouveauPoint(), Point.nouveauPoint(), nom, Color.black);
    }

    public double longueur() {
        return Math.sqrt(Math.pow(
                this.fin.getCoordx() - this.depart.getCoordx(), 2)
                + Math.pow(
                        this.fin.getCoordy() - this.depart.getCoordy(), 2));
    }

    public Point centre() {
        return new Point((depart.getCoordx() + fin.getCoordx()) / 2, (depart.getCoordy() + fin.getCoordy()) / 2);
    }

    public int extremiteProche(Point a) {
        if (this.depart.distancePoint(a) < this.fin.distancePoint(a)) {
            if (this.depart.distancePoint(a) < this.longueur() / 3) {
                return 0;
            } else {
                return -1;
            }

        } else {
            if (this.fin.distancePoint(a) < this.longueur() / 3) {
                return 1;
            }
            return -1;
        }

    }

    public void deplace(Point2D p) {
        double deltaX = this.centre().getCoordx() - p.getX();
        double deltaY = this.centre().getCoordy() - p.getY();
        this.setDepart(new Point(this.getDepart().getCoordx() - deltaX, this.getDepart().getCoordy() - deltaY));
        this.setFin(new Point(this.getFin().getCoordx() - deltaX, this.getFin().getCoordy() - deltaY));
    }

    //Définition méthode abstract de Figure
    @Override
    public void dessine(Graphics2D g) {
        g.setColor(this.getCouleur());
        g.draw(new Line2D.Double(this.depart.getCoordx(),this.depart.getCoordy(), this.fin.getCoordx(),this.fin.getCoordy()));
 

    }

    @Override
    public String toString() {
        return super.getNom() + " = [" + depart + "," + fin + "]";
    }

    @Override
    public double minX() {
        return Math.min(depart.getCoordx(), fin.getCoordx());
    }

    ;
    
    @Override
    public double maxX() {
        return Math.max(depart.getCoordx(), fin.getCoordx());
    }

    ;
    
    @Override
    public double minY() {
        return Math.min(depart.getCoordy(), fin.getCoordy());
    }

    ;
     
    @Override
    public double maxY() {
        return Math.max(depart.getCoordy(), fin.getCoordy());
    }

    ;
    
    @Override
    public double distancePoint(Point p) {
        double upnum = (p.getCoordx() - depart.getCoordx()) * (fin.getCoordx() - depart.getCoordx()) + (p.getCoordy() - depart.getCoordy()) * (fin.getCoordy() - depart.getCoordy());
        double updenum = Math.pow((fin.getCoordx() - depart.getCoordx()), 2) + Math.pow((fin.getCoordy() - depart.getCoordy()), 2);
        double up = upnum / updenum;
        if (up < 0) {
            return p.distancePoint(depart);
        } else if (up > 1) {
            return p.distancePoint(fin);
        } else {
            Point P4 = new Point(depart.getCoordx() + up * (fin.getCoordx() - depart.getCoordx()), depart.getCoordy() + up * (fin.getCoordy() - depart.getCoordy()));
            return p.distancePoint(P4);
        }

    }

    @Override
    public String toSave() {
        return "S;" + this.getNom() + ";"
                + this.depart.getCoordx() + ";"
                + this.depart.getCoordy() + ";"
                + this.fin.getCoordx() + ";"
                + this.fin.getCoordy() + ";"
                + this.getCouleur().getRed() + ";" + getCouleur().getBlue() + ";" + getCouleur().getGreen();
    }

    ;
    
    @Override
    public Segment symetriqueOrigine() {
        Point departSym = this.depart.symetriqueOrigine();
        Point finSym = this.fin.symetriqueOrigine();
        return new Segment(departSym, finSym, this.getNom() + "Sym");
    }

    ;
    
    
     @Override
    public Segment copy() {
        return new Segment(this);
    }

    public static void main(String[] args) {

        Segment seg1 = nouveauSegment();
        Segment seg1Sym = seg1.symetriqueOrigine();
        System.out.println(seg1Sym);
    }

}
