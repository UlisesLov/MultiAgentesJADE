package pck_agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;


public class AgentEmisor extends Agent {
    @Override
    protected void setup() {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("Receptor", AID.ISLOCALNAME));
        msg.setContent("Hola amigo Receptor");
        send(msg);
        System.out.println("Agente emisor envio un mensaje");
    }
    public static void main(String[] args) {
        String[] run = {
                "-agent",
                "-gui",
                "Receptor:pck_agentes.AgentReceptor;" +
                        "Emisor:pck_agentes.AgentEmisor",
        };
        jade.Boot.main(run);
    }
}
