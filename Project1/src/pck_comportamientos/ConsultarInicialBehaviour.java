package pck_comportamientos;

import jade.core.behaviours.SimpleBehaviour;
import jade.core.AID;
import jade.lang.acl.ACLMessage;



public class ConsultarInicialBehaviour extends SimpleBehaviour {
    private boolean finalizado = false;

    @Override
    public void action() {
        System.out.println("[COCHE] Realizando consulta inicial al semáforo...");


        ACLMessage mensaje = new ACLMessage(ACLMessage.REQUEST);
        mensaje.addReceiver(new AID("semaforo", AID.ISLOCALNAME));
        mensaje.setContent("¿Qué color tienes?");
        mensaje.setConversationId("consulta-semaforo");


        myAgent.send(mensaje);
        System.out.println("[COCHE] Consulta inicial enviada");


        finalizado = true;
    }

    @Override
    public boolean done() {
        return finalizado;
    }
}