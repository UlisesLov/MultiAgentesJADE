package pck_agent;

import jade.core.Agent;
import pck_comportamiento.CWakerEmisor;

public class AgentCWakerEmisor extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new CWakerEmisor(this, 3000)); // envía mensaje a los 3 segundos
    }

    public static void main(String[] args) {
        String[] run = {
                "-gui",
                "Emisor:pck_agent.AgentCWakerEmisor",
                "Receptor:pck_agent.AgentCWakerReceptor"
        };
        jade.Boot.main(run);
    }
}
