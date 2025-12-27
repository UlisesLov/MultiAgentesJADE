package pck_comportamiento;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class COneShotEmisor extends OneShotBehaviour {
    public COneShotEmisor(Agent a) {
        super(a);
    }
    @Override
    public void action() {
        // Crear y enviar mensaje
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("OneShotReceptor", AID.ISLOCALNAME));
        msg.setContent("Hola Receptor, soy el Emisor.");
        myAgent.send(msg);
        System.out.println("Emisor: mensaje enviado.");

        // Esperar respuesta
        ACLMessage reply = myAgent.blockingReceive();
        if (reply != null) {
            System.out.println("Emisor: recibí respuesta -> " + reply.getContent());
        }
    }
}
