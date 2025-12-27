package pck_agentes;

import jade.core.Agent;
import pck_comportamiento.COneShotEmisor;

public class AgentCOSEmisor extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new COneShotEmisor(this));
    }
    public static void main(String[] args){
        String[] run = {
                "-agent",
                "-gui",
                "Emisor:pck_agentes.AgentCOSEmisor;Receptor:pck_agentes.AgentCOSReceptor"
        };
        jade.Boot.main(run);
    }
}
