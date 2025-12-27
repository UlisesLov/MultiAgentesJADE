package pck_comportamientos;


import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import pck_objetos.Casa;
import pck_ontologias.Persona;
import java.util.ArrayList;
import java.util.List;

public class ComportamientoEmisorCasa  extends TickerBehaviour {

    ACLMessage msg, respuesta;
    Casa casa;
    Persona persona1, persona2, persona3;
    Persona personaPropietario;

    public ComportamientoEmisorCasa(Agent a, long period) {
        super(a, period);
    }
    protected void onTick() {
        persona1 = new Persona();
        persona1.setName("Ulises");
        persona1.setOld(21);
        persona1.setGenero("Masculino");
        persona2 = new Persona();
        persona2.setName("Juan");
        persona2.setOld(22);
        persona2.setGenero("Masculino");
        persona3 = new Persona();
        persona3.setName("Sophia");
        persona3.setOld(18);
        persona3.setGenero("Femenino");

        List<Persona> losHabitantes = new ArrayList<Persona>();
        losHabitantes.add(persona1);
        losHabitantes.add(persona2);
        losHabitantes.add(persona3);

        casa = new Casa();
        casa.setDireccion("Alamo IMSS");
        casa.setPropietario("Ulises");
        casa.setMetrosConstruidos(1228.3);

        casa.setHabitantes(losHabitantes);

        msg =  new ACLMessage(ACLMessage.INFORM);

        try{

            msg.setContentObject(casa);

        }catch(Exception e){

            System.out.println("No hay instancia " +  e.getMessage());

        }

        msg.addReceiver(new AID("AgenteReceptorCasa", AID.ISLOCALNAME));
        myAgent.send(msg);

        respuesta = myAgent.blockingReceive();

        if (respuesta != null) {
            try {
                personaPropietario = (Persona) respuesta.getContentObject();
                System.out.println("========== PROPIETARIO ========== ");
                System.out.println("Nombre: " + personaPropietario.getName());
                System.out.println("Edad: " + personaPropietario.getOld());
                System.out.println("Género: " + personaPropietario.getGenero());
                System.out.println("======================================================\n");

            }catch(Exception e){
                System.out.println("Error al recibir propietario: " + e.getMessage());

            }
        }else {
            System.out.println("No hay propietario en el casa");
        }


    }

}
