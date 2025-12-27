package pck_comportamiento;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class COneShotReceptor extends OneShotBehaviour {

    public COneShotReceptor(Agent a) {
        super(a);
    }

    @Override
    public void action() {
        // Esperar mensaje del emisor
        ACLMessage msg = myAgent.blockingReceive();
        if (msg != null) {
            System.out.println("Receptor: recibí -> " + msg.getContent());

            // Responder
            ACLMessage reply = msg.createReply();
            reply.setPerformative(ACLMessage.INFORM);
            reply.setContent("Hola Emisor, recibí tu mensaje.");
            myAgent.send(reply);

            System.out.println("Receptor: respondí al Emisor.");
        }
    }
}
