package pck_comportamiento;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class CTickerReceptor extends TickerBehaviour {
    public CTickerReceptor(Agent a, long period) {
        super(a, period);
    }

    @Override
    protected void onTick() {
        ACLMessage msg = myAgent.receive();
        if (msg != null) {
            System.out.println("Receptor: recibí -> " + msg.getContent());

            ACLMessage reply = msg.createReply();
            reply.setPerformative(ACLMessage.INFORM);
            reply.setContent("Ghola Emisor");
            myAgent.send(reply);

            System.out.println("Receptor: respondí -> Ghola Emisor");
        }
    }
}
