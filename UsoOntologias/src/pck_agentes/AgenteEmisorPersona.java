package pck_agentes;

import jade.core.Agent;
import pck_comportamientos.ComportamientoEmisorPersona;

public class AgenteEmisorPersona extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new ComportamientoEmisorPersona(this, 3000));
    }

    public static void main(String[] args){
        String[] run = {
                "-gui",
                "AgenteEmisorPersona:pck_agentes.AgenteEmisorPersona;AgenteReceptorPersona:pck_agentes.AgenteReceptorPersona",


        };
        jade.Boot.main(run);
    }
}
