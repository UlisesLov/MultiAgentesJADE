package pck_comportamiento;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;

public class CWakerEmisor extends WakerBehaviour {

    public CWakerEmisor(Agent a, long timeout) {
        super(a, timeout);
    }

    @Override
    protected void onWake() {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("Receptor", AID.ISLOCALNAME)); // debe coincidir con el main
        msg.setContent("Hola");
        myAgent.send(msg);
        System.out.println("Emisor: mensaje enviado -> Hola");
    }
}
