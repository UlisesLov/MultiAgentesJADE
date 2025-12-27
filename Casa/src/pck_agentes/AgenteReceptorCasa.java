package pck_agentes;

import jade.core.Agent;
import pck_comportamientos.ComportamientoReceptorCasa;

public class AgenteReceptorCasa extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new ComportamientoReceptorCasa(this, 3001));
    }
}
