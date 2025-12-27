package pck_comportamientos;

import jade.core.behaviours.TickerBehaviour;
import jade.core.Agent;
import pck_agent.SemaforoAgent;


public class CambiarColorBehaviour extends TickerBehaviour {
    private String[] colores = {"verde", "amarillo", "rojo"};
    private int indiceActual = 0;

    public CambiarColorBehaviour(Agent a, long period) {
        super(a, period);
    }

    @Override
    protected void onTick() {

        SemaforoAgent semaforo = (SemaforoAgent) myAgent;
        semaforo.setColorActual(colores[indiceActual]);

        System.out.println("[SEMÁFORO] Color cambiado a: " + colores[indiceActual]);

    }
}