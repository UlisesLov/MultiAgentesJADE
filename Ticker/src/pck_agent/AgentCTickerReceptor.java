package pck_agent;
import jade.core.Agent;
import pck_comportamiento.CTickerReceptor;

public class AgentCTickerReceptor extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new CTickerReceptor(this, 1000)); // cada 1 segundo revisa la cola
    }
}
