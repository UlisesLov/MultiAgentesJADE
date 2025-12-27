package pck_agent;
import jade.core.Agent;
import pck_comportamiento.CCyclicReceptor;

public class AgentCyclicReceptor extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new CCyclicReceptor(this));

    }
}
