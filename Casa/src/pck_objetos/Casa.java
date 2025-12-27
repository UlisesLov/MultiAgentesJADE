package pck_objetos;
import pck_ontologias.Persona;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Casa implements Serializable {

    private String  direccion;
    private String propietario;
    private double metrosConstruidos;
    private List<Persona> habitantes = new ArrayList<>();


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public double getMetrosConstruidos() {
        return metrosConstruidos;
    }

    public void setMetrosConstruidos(double metrosConstruidos) {
        this.metrosConstruidos = metrosConstruidos;
    }

    public List<Persona> getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(List<Persona> habitantes) {
        this.habitantes = habitantes;
    }
}
