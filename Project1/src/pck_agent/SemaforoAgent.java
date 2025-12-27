package pck_agent;

import jade.core.Agent;
import pck_comportamientos.CambiarColorBehaviour;
import pck_comportamientos.ResponderConsultasBehaviour;



public class SemaforoAgent extends Agent {
    private String colorActual = "rojo";

    @Override
    protected void setup() {
        System.out.println("=================================");
        System.out.println("[SEMÁFORO] Agente iniciado: " + getLocalName());
        System.out.println("[SEMÁFORO] Color inicial: " + colorActual);
        System.out.println("=================================");


        addBehaviour(new CambiarColorBehaviour(this, 5000));


        addBehaviour(new ResponderConsultasBehaviour());


    }

    @Override
    protected void takeDown() {
        System.out.println("[SEMÁFORO] Agente finalizado: " + getLocalName());
    }


    public String getColorActual() {
        return colorActual;
    }

    public void setColorActual(String colorActual) {
        this.colorActual = colorActual;
    }
}