package pck_comportamientos;


import jade.content.lang.Codec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import pck_ontologias.Fruta;
import pck_ontologias.Oferta;

public class CVendedorOferta extends OneShotBehaviour {


    private Codec code;
    private Ontology ontology;

    public CVendedorOferta(jade.core.Agent a, Codec code, Ontology ontology) {
        super(a);
        this.code = code;
        this.ontology = ontology;
    }
    public void action() {
        try {

            Fruta f = new Fruta();
            f.setName("Fresa");
            f.setPrecio(23);

            Oferta oferta = new Oferta();
            oferta.setFruta(f);

            //Creacion de ACL INFORM
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.addReceiver(new AID("Comprador", AID.ISLOCALNAME));
            msg.setLanguage(code.getName());
            msg.setOntology(ontology.getName());

            //Enviar contenido codificado

            myAgent.send(msg);

        }catch(OntologyException e){
            e.printStackTrace();
        }
    }






}
