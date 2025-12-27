package pck_comportamientos;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import pck_ontologias.Persona;

public class ComportamientoReceptorPersona extends TickerBehaviour {

    ACLMessage msg, respuesta;
    Persona p;

    public ComportamientoReceptorPersona(Agent a, long period) {
            super(a, period);
    }
    public void onTick() {
        msg = myAgent.blockingReceive();
        if( msg != null){
            try {

                p = (Persona) msg.getContentObject();
                System.out.println("Nombre del persona: " + p.getName());
                System.out.println("Edad: " + p.getOld());
                System.out.println("Genero: " + p.getGenero());

                p.setName("Emilia");
                p.setOld(30);



                respuesta = msg.createReply();
                respuesta.setContentObject(p);
                myAgent.send(respuesta);

            }catch(Exception e){
                System.out.println("No se recivo una respuesta");
            }
        }

    }

}
