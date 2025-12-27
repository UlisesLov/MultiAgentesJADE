package pck_agentes;

import jade.core.Agent;
import pck_comportamiento.COneShotReceptor;

public class AgentCOSReceptor extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new COneShotReceptor(this));
    }
}
