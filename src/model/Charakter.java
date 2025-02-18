package model;

import java.util.List;

public class Charakter {
    private int id;
    private String Name;
    private String herkunftdorf;
    private List<Produkt> produkts;

    public Charakter(int id, String Name, String herkunftdorf, List<Produkt> produkts) {
        this.id = id;
        this.Name = Name;
        this.herkunftdorf = herkunftdorf;
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

    public String getHerkunftdorf() {
        return herkunftdorf;
    }

    public void setHerkunftdorf(String herkunftdorf) {
        this.herkunftdorf = herkunftdorf;
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
                ", atr3='" + herkunftdorf + '\'' +
                ", model1s=" + produkts +
                '}';
    }
}
