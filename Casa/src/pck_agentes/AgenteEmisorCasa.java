package pck_agentes;

import jade.core.Agent;
import pck_comportamientos.ComportamientoEmisorCasa;

public class AgenteEmisorCasa extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new ComportamientoEmisorCasa(this, 3000));
    }
    public static void main (String[] args) {
        String[] run = {
                "-agents",
                "AgenteEmisorCasa:pck_agentes.AgenteEmisorCasa;AgenteReceptorCasa:pck_agentes.AgenteReceptorCasa",
                "-gui"
        };
        jade.Boot.main(run);
    }
}
