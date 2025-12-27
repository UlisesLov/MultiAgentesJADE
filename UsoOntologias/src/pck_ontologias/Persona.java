package pck_ontologias;

import java.io.Serializable;

public class Persona implements Serializable {

    private String name;
    private int old;
    private String genero;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }



}

