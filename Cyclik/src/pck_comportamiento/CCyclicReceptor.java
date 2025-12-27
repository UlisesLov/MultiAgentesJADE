package pck_comportamiento;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class CCyclicReceptor extends CyclicBehaviour {

    public CCyclicReceptor(Agent a) {
        super(a);
    }

    @Override
    public void action() {
        // Esperar mensaje del Emisor
        ACLMessage msg = myAgent.receive();

        if (msg != null) {
            System.out.println("Receptor: recibí el mensaje -> " + msg.getContent());

            // Responder al Emisor
            ACLMessage reply = msg.createReply();
            reply.setPerformative(ACLMessage.INFORM);
            reply.setContent("Receptor confirma que recibió tu mensaje.");
            myAgent.send(reply);

            System.out.println("Receptor: respondí al Emisor.");
        } else {
            block(); // esperar hasta que llegue un mensaje
        }
    }
}
