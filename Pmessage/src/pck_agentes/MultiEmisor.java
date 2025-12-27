package pck_agentes;
import jade.core.Agent;
import pck_comportamientos.CMultiEmisor;

public class MultiEmisor extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new CMultiEmisor(this, 2000));
    }

    public static void main(String[] args) {
        String[] run = {
                "-gui",
                "Emisor:pck_agentes.MultiEmisor;Receptor:pck_agentes.MultiReceptor"
        };
        jade.Boot.main(run);
    }
}
