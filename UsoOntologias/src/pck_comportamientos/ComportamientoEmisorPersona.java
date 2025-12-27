package pck_comportamientos;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import pck_ontologias.Persona;

public class ComportamientoEmisorPersona extends TickerBehaviour {
    ACLMessage msg, respuesta;
    Persona p;

    public ComportamientoEmisorPersona(Agent a, long period) {
        super(a, period);
    }

    @Override
    protected void onTick() {
        msg = new ACLMessage(ACLMessage.INFORM);
        p = new Persona();
        p.setName("Maria");
        p.setOld(10);
        p.setGenero("Femenino");

        try{
            msg.setContentObject(p);

        }catch(Exception e){
            System.out.println("No hay instancia: " + e.getMessage());
        }
        msg.addReceiver(new AID("AgenteReceptorPersona", AID.ISLOCALNAME));
        myAgent.send(msg);

        respuesta = myAgent.blockingReceive();

        if (respuesta != null) {
            try {
                p = (Persona) respuesta.getContentObject();
                System.out.println("--------------------------");
                System.out.println("Nombre: " + p.getName());
                System.out.println("Edad: " + p.getOld());
                System.out.println("Genero: " + p.getGenero());
            } catch (Exception e) {
                System.out.println("Error al leer la respuesta: " + e.getMessage());
            }
        } else {
            System.out.println("No se recibió una respuesta");
        }
    }
}
