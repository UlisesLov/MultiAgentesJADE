package pck_comportamientos;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
//import jade.mtp.http.BasicFipaDateTime;

import java.awt.*;

public class CMultiReceptor extends TickerBehaviour {

    ACLMessage mensaje, respuesta;
    MessageTemplate mt1, mt2, mt3, mt4, mt5;

    public CMultiReceptor(Agent a, long period) {
        super(a, period);
        mt1 = MessageTemplate.MatchSender(new AID("Emisor", AID.ISLOCALNAME));
        mt2 = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM),
                MessageTemplate.MatchContent("Hola, soy un mensaje INFORM."));
        mt3 = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
                MessageTemplate.MatchContent("Por favor, procesa mi solicitud (REQUEST)"));
        mt4 = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.PROPOSE),
                MessageTemplate.MatchContent("Te propongo una acción (PROPOSE)."));
        mt5 = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.NOT_UNDERSTOOD),
                mt1);
    }

    @Override
    protected void onTick() {
        emisor();
        inform();
        request();
        propose();
        no_under();
//        plantillaInforme();
//        petition();
//        propuesta();
//        propuestaEmisor();

    }
    public void emisor(){
        mensaje = myAgent.receive(mt1);
        if(mensaje != null){
            System.out.println("Mensaje recibido." + mensaje.getContent());
            respuesta = mensaje.createReply();
            respuesta.setContent("Filtrado por emisor. No se descirminan Performativas");
            myAgent.send(respuesta);
        }
    }
    public void inform(){
        mensaje = myAgent.receive(mt2);
        if(mensaje != null){
            System.out.println("Mensaje recibido." + mensaje.getContent());
            respuesta = mensaje.createReply();
            respuesta.setContent("Filtrado por inform. No se descirminan Performativas");
            myAgent.send(respuesta);
        }
    }
    public void request() {
        mensaje = myAgent.receive(mt3);
        if(mensaje != null){
            System.out.println("Mensaje recibido." + mensaje.getContent());
            respuesta = mensaje.createReply();
            respuesta.setContent("Filtrado por request. No se descirminan Performativas");
            myAgent.send(respuesta);

        }
    }
    public void propose() {
        mensaje = myAgent.receive(mt4);
        if(mensaje != null){
            System.out.println("Mensaje recibido." + mensaje.getContent());
            respuesta = mensaje.createReply();
            respuesta.setContent("Filtrado por propose. No se descirminan");
            myAgent.send(respuesta);
        }
    }
    public void no_under(){
        mensaje = myAgent.receive(mt5);
        if(mensaje != null){
            System.out.println("Mensaje recibido." + mensaje.getContent());
            respuesta = mensaje.createReply();
            respuesta.setContent("Filtrado por no_under.");
            myAgent.send(respuesta);
        }
    }
//    public void plantillaInforme(){
//        MessageTemplate plantillaInforme = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
//
//        mensaje = myAgent.receive(plantillaInforme);
//
//        if (mensaje != null) {
//            System.out.println("Informe recibido de: " + mensaje.getSender().getLocalName() +
//                    " -> " + mensaje.getContent());
//
//            respuesta = mensaje.createReply();
//            respuesta.setPerformative(ACLMessage.CONFIRM);
//            respuesta.setContent("Informe recibido");
//
//            myAgent.send(respuesta);
//        }
//    }
//    public void petition() {
//        MessageTemplate mtPetition = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
//        mensaje = myAgent.receive(mtPetition);
//
//        if (mensaje != null) {
//            System.out.println("Petición recibida de: " + mensaje.getSender().getLocalName());
//            respuesta = mensaje.createReply();
//            respuesta.setContent("Receptor y petición recibidos");
//            myAgent.send(respuesta);
//        }
//    }
//    public void propuesta() {
//        MessageTemplate mtPropuesta = MessageTemplate.MatchPerformative(ACLMessage.PROPOSE);
//        mensaje = myAgent.receive(mtPropuesta);
//
//        if (mensaje != null) {
//            System.out.println("Propuesta recibida de: " + mensaje.getSender().getLocalName());
//            respuesta = mensaje.createReply();
//            respuesta.setContent("Receptor y propuesta recibidos");
//            myAgent.send(respuesta);
//        }
//    }
//    public void propuestaEmisor() {
//        ACLMessage propuesta = new ACLMessage(ACLMessage.PROPOSE);
//        propuesta.addReceiver(new AID("Receptor", AID.ISLOCALNAME));
//        propuesta.setContent("Receptor y propuesta recibidos");
//        myAgent.send(propuesta);
//    }

}

// esambles de agrupadores clustering, k-means