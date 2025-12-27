package pck_comportamiento;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class CCyclicEmisor extends CyclicBehaviour {

    public CCyclicEmisor(Agent a) {
        super(a);
    }

    @Override
    public void action() {
        // Enviar mensaje al receptor
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("CCyclicReceptor", AID.ISLOCALNAME));
        msg.setContent("Emisor contacta con receptor.");
        myAgent.send(msg);
        System.out.println("Emisor: mensaje enviado.");

        // Recibir respuesta sin bloquear
        ACLMessage msgReceived = myAgent.receive();

        if (msgReceived != null) {
            System.out.println("Emisor: recibido un mensaje de ");
        } else {
            block(); // libera CPU hasta que llegue un mensaje
        }
    }
}
