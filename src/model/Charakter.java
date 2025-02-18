package model;

import java.util.List;

public class Charakter {
    private int id;
    private String Name;
    private String herkunftsort;
    private List<Produkt> produkts;

    public Charakter(int id, String Name, String herkunftsort, List<Produkt> produkts) {
        this.id = id;
        this.Name = Name;
        this.herkunftsort = herkunftsort;
        this.produkts = produkts;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getHerkunftsort() {
        return herkunftsort;
    }

    public void setHerkunftsort(String herkunftsort) {
        this.herkunftsort = herkunftsort;
    }

    public List<Produkt> getModel1s() {
        return produkts;
    }

    public void setModel1s(List<Produkt> produkts) {
        this.produkts = produkts;
    }

    @Override
    public String toString() {
        return "model2{" +
                "atr1=" + id +
                ", atr2='" + Name + '\'' +
                ", atr3='" + herkunftsort + '\'' +
                ", model1s=" + produkts +
                '}';
    }
}
