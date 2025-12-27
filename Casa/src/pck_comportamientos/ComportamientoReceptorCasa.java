package pck_comportamientos;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import pck_objetos.Casa;
import pck_ontologias.Persona;
import java.util.List;

public class ComportamientoReceptorCasa extends TickerBehaviour {

    ACLMessage mensaje, respuesta;
    Casa laCasa;
    Persona personaPropietario;
    List<Persona> losHabitantes;

    public ComportamientoReceptorCasa(Agent a, long period) {
        super(a, period);
    }

    public void onTick() {
        // Recibir el mensaje
        mensaje = myAgent.blockingReceive();

        if (mensaje != null) {
            try {
                // Decodificar el mensaje
                laCasa = (Casa) mensaje.getContentObject();
                losHabitantes = laCasa.getHabitantes();

                // Imprimir datos de la casa
                System.out.println("========== CASA RECIBIDA ==========");
                System.out.println("Dirección: " + laCasa.getDireccion());
                System.out.println("Propietario: " + laCasa.getPropietario());
                System.out.println("Metros construidos: " + laCasa.getMetrosConstruidos() + " m²");

                System.out.println("\n--- Habitantes de la casa ---");
                for (int i = 0; i < losHabitantes.size(); i++) {
                    Persona p = losHabitantes.get(i);
                    System.out.println((i+1) + ". Nombre: " + p.getName() +
                            ", Edad: " + p.getOld() +
                            ", Género: " + p.getGenero());
                }
                System.out.println("Total de habitantes: " + losHabitantes.size());
                System.out.println("===================================\n");

                // Crear persona propietario con datos modificados
                personaPropietario = new Persona();
                personaPropietario.setName(laCasa.getPropietario() + " Modificado");
                personaPropietario.setOld(35);
                personaPropietario.setGenero("Masculino");

                // Enviar respuesta con el propietario modificado únicamente
                respuesta = mensaje.createReply();
                respuesta.setPerformative(ACLMessage.INFORM);

                try {
                    respuesta.setContentObject(personaPropietario);
                } catch (Exception e) {
                    System.out.println("Error al serializar propietario: " + e.getMessage());
                }

                myAgent.send(respuesta);

                System.out.println("========== PROPIETARIO ENVIADO ==========");
                System.out.println("Nombre: " + personaPropietario.getName());
                System.out.println("Edad: " + personaPropietario.getOld());
                System.out.println("Género: " + personaPropietario.getGenero());
                System.out.println("=========================================\n");

            } catch (Exception e) {
                System.out.println("Error al procesar mensaje: " + e.getMessage());
            }
        } else {
            System.out.println("No se recibió mensaje");
        }
    }
}