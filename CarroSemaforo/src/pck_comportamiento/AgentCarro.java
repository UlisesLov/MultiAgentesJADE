package pck_comportamiento;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;



public class AgentCarro extends SimpleBehaviour {
    private int mensajesR;
    private final int maxM = 3;

    public AgentCarro(Agent a) {
        myAgent = a;
    }
    @Override
    public void action() {
        ACLMessage msg = myAgent.receive();
        if (msg != null) {
            String color =  msg.getContent();
            mensajesR++;
            switch (color.toLowerCase()) {
                case "verde" -> System.out.println("El coche avanza");
                case "amarillo" -> System.out.println("El coche baja velocidad");
                case "rojo" -> System.out.println("El coche se detiene");
            }

        } else {
            block();
        }

    }
    @Override
    public boolean done() {
        return mensajesR >= maxM;

    }

}
