package pck_comportamientos;

import jade.core.behaviours.CyclicBehaviour;
import jade.core.AID;
import jade.lang.acl.ACLMessage;

public class EsperarVerdeBehaviour extends CyclicBehaviour {
    private long ultimaConsulta = 0;
    private final long INTERVALO_CONSULTA = 3000; // 3 segundos
    private boolean esperandoRespuesta = false;
    private boolean debeTerminar = false;

    @Override
    public void action() {

        if (debeTerminar) {
            ACLMessage confirmacion = myAgent.receive();
            if (confirmacion != null &&
                    confirmacion.getPerformative() == ACLMessage.CONFIRM &&
                    confirmacion.getContent().equals("SEMAFORO_TERMINADO")) {
                System.out.println("[COCHE] Confirmación recibida. Terminando coche...");
                myAgent.doDelete();
            } else {
                block(100);
            }
            return;
        }

        long tiempoActual = System.currentTimeMillis();


        if (!esperandoRespuesta && (tiempoActual - ultimaConsulta >= INTERVALO_CONSULTA)) {

            ACLMessage mensaje = new ACLMessage(ACLMessage.REQUEST);
            mensaje.addReceiver(new AID("semaforo", AID.ISLOCALNAME));
            mensaje.setContent("¿Qué color tienes?");
            mensaje.setConversationId("consulta-semaforo");

            myAgent.send(mensaje);
            System.out.println("[COCHE] Consultando al semáforo...");

            ultimaConsulta = tiempoActual;
            esperandoRespuesta = true;
        }


        ACLMessage respuesta = myAgent.receive();

        if (respuesta != null && respuesta.getPerformative() == ACLMessage.INFORM) {
            String color = respuesta.getContent();
            System.out.println("[COCHE] Semáforo en: " + color);

            esperandoRespuesta = false;


            if (color.equalsIgnoreCase("verde")) {
                System.out.println("=================================");
                System.out.println("[COCHE] ¡El coche avanza!");
                System.out.println("=================================");


                ACLMessage notificacion = new ACLMessage(ACLMessage.REQUEST);
                notificacion.addReceiver(new AID("semaforo", AID.ISLOCALNAME));
                notificacion.setContent("TERMINAR");
                notificacion.setConversationId("finalizar");
                myAgent.send(notificacion);

                System.out.println("[COCHE] Notificación de término enviada al semáforo");


                debeTerminar = true;
            } else {

                System.out.println("[COCHE] Esperando... el semáforo está en " + color);
            }
        } else {

            block(100);
        }
    }
}