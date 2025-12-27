package pck_plantilas;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.core.behaviours.CyclicBehaviour;

public class Receptor extends Agent {

    @Override
    protected void setup() {
        System.out.println(getLocalName() + ": esperando mensajes...");

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage recibido = receive();
                if (recibido != null) {
                    System.out.println(getLocalName() + " recibio " + recibido.getContent());


                    ACLMessage respuesta = recibido.createReply();
                    respuesta.setPerformative(ACLMessage.INFORM);
                    respuesta.setContent("Hola " + recibido.getSender().getLocalName() + ", mensaje recibido");
                    send(respuesta);

                    System.out.println(getLocalName() + " respondio al Emisor.");
                } else {
                    block(); // Espera hasta que haya un mensaje
                }
            }
        });
    }

    public static void main(String[] args) {
        String[] run = {
                "-gui",
                "Receptor:pck_plantilas.Receptor;Emisor:pck_plantilas.Emisor"
        };
        jade.Boot.main(run);
    }
}
