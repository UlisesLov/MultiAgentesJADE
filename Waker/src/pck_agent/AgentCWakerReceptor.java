package pck_agent;

import jade.core.Agent;
import pck_comportamiento.CWakerReceptor;

public class AgentCWakerReceptor extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new CWakerReceptor(this, 4000));

    }
}

