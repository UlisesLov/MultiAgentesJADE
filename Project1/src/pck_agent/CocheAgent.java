package pck_agent;

import jade.core.Agent;
import pck_comportamientos.ConsultarInicialBehaviour;
import pck_comportamientos.EsperarVerdeBehaviour;



public class CocheAgent extends Agent {

    @Override
    protected void setup() {
        System.out.println("=================================");
        System.out.println("[COCHE] Agente iniciado: " + getLocalName());
        System.out.println("=================================");


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        addBehaviour(new ConsultarInicialBehaviour());

        addBehaviour(new EsperarVerdeBehaviour());
    }

    @Override
    protected void takeDown() {
        System.out.println("[COCHE] Agente finalizado: " + getLocalName());
    }
    public static void main(String[] args) {
        String[] run = {
                "-gui",
                "-agents",
                "semaforo:pck_agent.SemaforoAgent;coche:pck_agent.CocheAgent"
        };
        jade.Boot.main(run);
    }



}