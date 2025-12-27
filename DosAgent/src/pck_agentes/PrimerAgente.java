package pck_agentes;

import jade.core.Agent;

public class PrimerAgente extends Agent {

    @Override
    protected void setup() {
        System.out.println("PrimerAgent.setup");
    }
    public static void main(String[] args){
        String[] run = {
                "-agent",
                "-gui",
                "PrimerAgent:pck_agentes.PrimerAgente;" +
                        "Segundo:pck_agentes.SegundoAgente",
        };
        jade.Boot.main(run);
    }

}
