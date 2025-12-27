package pck_comportamiento;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class CTickerEmisor extends TickerBehaviour {
    public CTickerEmisor(Agent a, long period) {
        super(a, period);

    }
    @Override
    protected void onTick() {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("Receptor", AID.ISLOCALNAME)); // debe coincidir con el nombre del Receptor
        msg.setContent("Hola");
        myAgent.send(msg);
        System.out.println("Emisor: mensaje enviado -> Hola");
    }

}
