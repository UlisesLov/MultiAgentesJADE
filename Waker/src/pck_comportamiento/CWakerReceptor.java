package pck_comportamiento;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;

public class CWakerReceptor extends WakerBehaviour {

    public CWakerReceptor(Agent a, long timeout) {
        super(a, timeout);
    }

    @Override
    protected void onWake() {
        ACLMessage msg = myAgent.blockingReceive();
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
