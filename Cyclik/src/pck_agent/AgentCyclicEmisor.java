package pck_agent;

import jade.core.Agent;
import pck_comportamiento.CCyclicEmisor;


public class AgentCyclicEmisor extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new CCyclicEmisor(this));

    }

    public static void main(String[] args){
        String[] run ={
                "-agent",
                "-gui",
                "Emisor:pck_agent.AgentCyclicEmisor;Receptor:pck_agent.AgentCyclicReceptor;",
        };
        jade.Boot.main(run);

    }

}
