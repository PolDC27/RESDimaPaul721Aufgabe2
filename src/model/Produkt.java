package model;

import java.util.Date;

public class Produkt implements Comparable<Produkt> {
    String Name;
    double preis;
    String Herkunftsregion;


    public Produkt(String Name, double preis, String Herkunftsregion) {
        this.Name = Name;
        this.preis = preis;
        this.Herkunftsregion = Herkunftsregion;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getHerkunftsregion() {
        return Herkunftsregion;
    }

    public void setHerkunftsregion(String herkunftsregion) {
        this.Herkunftsregion = herkunftsregion;
    }

    @Override
    public String toString() {
        return "model1{" +
                "atr1='" + Name + '\'' +
                ", atr2=" + preis +
                ", atr3=" + Herkunftsregion +
                '}';
    }

    @Override
    public int compareTo(Produkt o) {
        return Double.compare(this.preis, o.preis);
    }
}
