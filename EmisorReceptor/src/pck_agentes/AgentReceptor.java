package pck_agentes;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;


public class AgentReceptor extends Agent {
    @Override
    protected void setup() {
        ACLMessage recived = blockingReceive();
        if (recived != null) {
            System.out.println("El receptor recivio es: " + recived.getContent());
        }else {
            System.out.println("El mensaje recivido no es correcto");
        }

    }
}

