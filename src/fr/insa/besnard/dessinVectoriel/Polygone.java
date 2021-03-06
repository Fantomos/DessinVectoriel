/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
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
    private boolean remplir;

    public boolean isRemplir() {
        return remplir;
    }

    public boolean getRemplir() {
        return remplir;
    }

    public void setRemplir(boolean remplir) {
        this.remplir = remplir;
    }

    public ArrayList<Point> getSommet() {
        return sommet;
    }

    public void setSommet(ArrayList<Point> sommet) {
        this.sommet = sommet;
    }

    //Constructeur
    public Polygone() {
        this(new ArrayList<Point>(), "Polygone", Color.BLACK, false);
    }

    public Polygone(Polygone poly) {
        this(poly.getSommet(), poly.getNom(), poly.getCouleur(), poly.getRemplir());
    }

    public Polygone(ArrayList<Point> sommet) {
        this(sommet, "Polygone", Color.BLACK, false);
    }

    public Polygone(ArrayList<Point> sommet, String nom) {
        this(sommet, nom, Color.BLACK, false);
    }

    public Polygone(ArrayList<Point> sommet, String nom, Color couleur) {
        this(sommet, nom, couleur, false);
    }

    public Polygone(ArrayList<Point> sommet, String nom, Color couleur, Boolean remplir) {
        super(nom, couleur,0);
        this.remplir = remplir;
        this.sommet = sommet;
    }

    // Méthode Création
    public static Polygone nouveauPolygone() {
        ArrayList<Point> sommet = new ArrayList<Point>();
        System.out.println("Entrez le nom du polygone : ");
        String nom = Lire.S();
        System.out.println("Entrez le nombre de sommet : ");
        int nombreSommet = Lire.i();
        for (int i = 0; i < nombreSommet; i++) {
            sommet.add(Point.nouveauPoint());
        }
        return new Polygone(sommet, nom, Color.BLACK);
    }

    public int sommetProche(Point p) {
        Point pointProche = Collections.min(this.sommet, Comparator.comparing(a -> a.distancePoint(p)));
        if (pointProche.distancePoint(p) < 5) {
            return sommet.indexOf(pointProche);
        } else {
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
    public Polygone symetriqueOrigine() {
        ArrayList<Point> sommetSym = new ArrayList<Point>();
        for (int i = 0; i < sommet.size(); i++) {
            sommetSym.add(sommet.get(i).symetriqueOrigine());
        }

        return new Polygone(sommetSym, this.getNom() + "Sym");
    }

    @Override
    public void dessine(Graphics2D g) {
        g.setColor(this.getCouleur());
        g.rotate(super.getTheta());
        double[] x = new double[sommet.size()];
        double[] y = new double[sommet.size()];
        for (int i = 0; i < this.sommet.size(); i++) {
            x[i] = this.sommet.get(i).getCoordx();
            y[i] = this.sommet.get(i).getCoordy();
        }
        Path2D path = new Path2D.Double();
        path.moveTo(x[0], y[0]);
        for (int i = 1; i < x.length; ++i) {
            path.lineTo(x[i], y[i]);
        }
        path.closePath();
        if (this.remplir) {
            g.fill(path);
            //g.fillPolygon(x, y, this.sommet.size());
        } else {
             g.draw(path);
            //g.drawPolygon(x, y, this.sommet.size());
        }

    }

    @Override
    public String toString() {
        String texte = super.getNom() + " = [";
        for (int i = 0; i < this.sommet.size(); i++) {
            texte = texte + sommet.get(i) + "; ";
        }
        texte = texte + "]";
        return texte;
    }

    @Override
    public double minX() {
        Point pointMinX = Collections.min(this.sommet, Comparator.comparing(a -> a.minX()));
        return pointMinX.minX();
    }

    ;
    @Override
    public double minY() {
        Figure pointMinY = Collections.min(this.sommet, Comparator.comparing(a -> a.minY()));
        return pointMinY.minY();
    }

    ;
    @Override
    public double maxX() {
        Figure pointMaxX = Collections.max(this.sommet, Comparator.comparing(a -> a.maxX()));
        return pointMaxX.maxX();
    }

    ;
    @Override
    public double maxY() {
        Figure pointMaxY = Collections.max(this.sommet, Comparator.comparing(a -> a.maxY()));
        return pointMaxY.maxY();
    }

    ;

    @Override
    public double distancePoint(Point p) {
        Point pointProche = Collections.min(this.sommet, Comparator.comparing(a -> a.distancePoint(p)));

        Segment segmentProche1;
        Segment segmentProche2;
        int index = this.sommet.indexOf(pointProche);

        if (index == 0) {
            segmentProche1 = new Segment(this.sommet.get(index), this.sommet.get(index + 1));
            segmentProche2 = new Segment(this.sommet.get(index), this.sommet.get(this.sommet.size() - 1));
        } else if (index == this.sommet.size() - 1) {
            segmentProche1 = new Segment(this.sommet.get(index), this.sommet.get(0));
            segmentProche2 = new Segment(this.sommet.get(index), this.sommet.get(index - 1));
        } else {
            segmentProche1 = new Segment(this.sommet.get(index), this.sommet.get(index + 1));
            segmentProche2 = new Segment(this.sommet.get(index), this.sommet.get(index - 1));;
        }

        double distanceSegment1 = segmentProche1.distancePoint(p);
        double distanceSegment2 = segmentProche2.distancePoint(p);

        if (distanceSegment1 <= distanceSegment2) {
            return distanceSegment1;

        } else {
            return distanceSegment2;
        }

    }

    @Override
    public String toSave() {
        String texte = "PG;" + this.getNom() + ";" + this.remplir + ";" + getCouleur().getRed() + ";" + getCouleur().getGreen() + ";" + getCouleur().getBlue() + ";"  + getCouleur().getAlpha()+ ";" +this.sommet.size();
        for (int i = 0; i < this.sommet.size(); i++) {
            texte = texte + ";" + this.sommet.get(i).getCoordx() + ";"
                    + this.sommet.get(i).getCoordy();
        }

        return texte;
    }

    ;
    
     @Override
    public Polygone copy() {
        return new Polygone(this);
    }

    public static void main(String[] args) {
        Polygone pol = Polygone.nouveauPolygone();
        System.out.println(pol);
    }
}
