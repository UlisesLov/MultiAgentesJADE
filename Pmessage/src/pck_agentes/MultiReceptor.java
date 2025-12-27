package pck_agentes;

import jade.core.Agent;
import pck_comportamientos.CMultiEmisor;
import pck_comportamientos.CMultiReceptor;

public class MultiReceptor extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new CMultiReceptor(this, 2001));
    }
}
