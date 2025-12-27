package pck_agent;

import jade.core.Agent;

import pck_comportamiento.CTickerEmisor;

public class AgentCTickerEmisor extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new CTickerEmisor(this, 3000)); // cada 3 segundos envía "Hola"
    }

    public static void main(String[] args) {
        String[] run = {
                "-gui",
                "Emisor:pck_agent.AgentCTickerEmisor",
                "Receptor:pck_agent.AgentCTickerReceptor"
        };
        jade.Boot.main(run);
    }
}
