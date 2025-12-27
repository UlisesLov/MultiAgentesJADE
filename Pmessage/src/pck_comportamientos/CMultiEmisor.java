package pck_comportamientos;
import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class CMultiEmisor extends TickerBehaviour {
    ACLMessage mensaje, respuesta;
    int opcion = 0;

    public CMultiEmisor(Agent a, long period) {
        super(a, period);
    }

    @Override
    protected void onTick() {
        opcion = (int)(Math.random() * 4) + 1;

        mensaje = new ACLMessage(ACLMessage.INFORM);
        mensaje.addReceiver(new AID("Receptor", AID.ISLOCALNAME));

        switch (opcion) {
            case 1 -> {
                mensaje.setPerformative(ACLMessage.INFORM);
                mensaje.setContent("Hola, soy un mensaje INFORM.");
            }
            case 2 -> {
                mensaje.setPerformative(ACLMessage.REQUEST);
                mensaje.setContent("Por favor, procesa mi solicitud (REQUEST).");
            }
            case 3 -> {
                mensaje.setPerformative(ACLMessage.PROPOSE);
                mensaje.setContent("Te propongo una acción (PROPOSE).");
            }
            case 4 -> {
                mensaje.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                mensaje.setContent("No entiendo tu mensaje anterior (NOT_UNDERSTOOD).");
            }
        }

        myAgent.send(mensaje);
        System.out.println(myAgent.getLocalName() + ": Envié -> " + mensaje.getContent());
        respuesta = myAgent.receive();

        if (respuesta != null) {
            System.out.println(myAgent.getLocalName() + ": Recibí respuesta de " +
                    respuesta.getSender().getLocalName() + " -> " + respuesta.getContent());
        } else {
            System.out.println(myAgent.getLocalName() + ": No he recibido respuesta aún.\n");
            block(500);
        }

    }
}
