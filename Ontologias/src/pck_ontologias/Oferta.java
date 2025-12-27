package pck_ontologias;

import java.util.function.Predicate;

public class Oferta implements Predicate {

    private Fruta fruta;

    public Fruta getFruta() {return fruta;}

    public void setFruta(Fruta fruta) {this.fruta = fruta;}
}
