package pck_agentes;

import jade.core.Agent;
import pck_comportamiento.AgentSemaforo;


public class Semaforo extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new AgentSemaforo(this));
    }
    public static void main(String[] args){
        String[] run = {
                "-agent",
                "-gui",
                "Semaforo:pck_agentes.Semaforo;Carro:pck_agentes.Carro",
        };
        jade.Boot.main(run);
    }
}
