package pck_agentes;

import jade.core.Agent;
import pck_comportamientos.ComportamientoReceptorPersona;

public class AgenteReceptorPersona extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new ComportamientoReceptorPersona(this, 3001));
    }

}
