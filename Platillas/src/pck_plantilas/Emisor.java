package pck_plantilas;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.MessageTemplate;

public class Emisor extends Agent {

    @Override
    protected void setup() {
        System.out.println(getLocalName() + ": iniciando conversacio");

        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {

                ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);
                mensaje.addReceiver(new jade.core.AID("Receptor", jade.core.AID.ISLOCALNAME));
                mensaje.setContent("Hola Mundo desde el Emisor ");
                mensaje.setConversationId("platica-hola");
                send(mensaje);
                System.out.println(getLocalName() + ": mensaje enviado a Receptor.");

                MessageTemplate plantilla = MessageTemplate.MatchConversationId("platica-hola");
                ACLMessage respuesta = blockingReceive(plantilla);
                if (respuesta != null) {
                    System.out.println(getLocalName() + " recibió respuesta: " + respuesta.getContent());
                } else {
                    System.out.println(getLocalName() + ": no se recibió respuesta.");
                }

                doDelete();
            }
        });
    }
}
