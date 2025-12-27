package pck_agentes;

import jade.core.Agent;
import jade.core.behaviours.CompositeBehaviour;
import pck_comportamiento.AgentCarro;

public class Carro extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new AgentCarro(this));
    }
}
