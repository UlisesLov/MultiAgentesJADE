package pck_comportamiento;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.core.AID;
import java.util.Random;

public class AgentSemaforo extends SimpleBehaviour {
    private int vecesEnviadas;
    private final int maxCiclos = 3;
    private Random rand = new Random();
    public AgentSemaforo(Agent a) {
        myAgent = a;
    }
    @Override

    public void action() {
        if (vecesEnviadas <= maxCiclos){
            String[] colors = {"Verde", "Amarrillo", "Rojo"};
            String color = colors[rand.nextInt(colors.length)];

            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.addReceiver(new AID("Carro", AID.ISLOCALNAME));
            msg.setContent(color);
            myAgent.send(msg);
            System.out.println(myAgent.getLocalName()+" envia "+color);
            block(1000);
            vecesEnviadas++;


        }


    }

    @Override
    public boolean done() {
        return  vecesEnviadas == maxCiclos;
    }
}
