package pck_comportamientos;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import pck_agent.SemaforoAgent;

public class ResponderConsultasBehaviour extends CyclicBehaviour {


    @Override
    public void action() {

        ACLMessage mensaje = myAgent.receive();

        if (mensaje != null) {

            if (mensaje.getPerformative() == ACLMessage.REQUEST) {
                System.out.println("[SEMÁFORO] Consulta recibida de: " + mensaje.getSender().getLocalName());

                SemaforoAgent semaforo = (SemaforoAgent) myAgent;
                String colorActual = semaforo.getColorActual();


                ACLMessage respuesta = mensaje.createReply();
                respuesta.setPerformative(ACLMessage.INFORM);
                respuesta.setContent(colorActual);


                myAgent.send(respuesta);
                System.out.println("[SEMÁFORO] Respuesta enviada: " + colorActual);
            }
        } else {

            block();
        }
    }
}