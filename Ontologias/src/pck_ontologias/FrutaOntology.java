package pck_ontologias;

import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.schema.ConceptSchema;
import jade.content.schema.PredicateSchema;
import jade.content.schema.PrimitiveSchema;

public class FrutaOntology extends Ontology {
    public static final String ONTOLOGY_NAME = "Fruta";
    private static Ontology instance = new FrutaOntology();

    public static Ontology getInstance() {
        return instance;
    }

    // Vocavulario

    public static final String Fruta = "Fruta";
    public static final String FrutaNombre = "Nombre";
    public static final String FrutaPrecio = "Precio";
    public static final String Oferta = "Oferta";
    public static final String OfertaFruta = "Fruta";
    public static final String Comprar = "Comprar";
    public static final String ComprarFruta = "Fruta";


    private FrutaOntology() {
        super(ONTOLOGY_NAME, BasicOntology.getInstance());

        try {
            //Concepto fruta
            ConceptSchema frutaSchema = new ConceptSchema(Fruta);
            frutaSchema.add(FrutaNombre, (PrimitiveSchema) getSchema(BasicOntology.STRING));
            frutaSchema.add(FrutaPrecio, (PrimitiveSchema) getSchema(BasicOntology.INTEGER));

            // Predicados oferta

            PredicateSchema ofertaSchema = new PredicateSchema(Oferta);
            ofertaSchema.add(OfertaFruta, frutaSchema);
            add(ofertaSchema, Oferta.class);

            //Predicados compra

            PredicateSchema comprarSchema = new PredicateSchema(Comprar);
            comprarSchema.add(ComprarFruta, frutaSchema);
            add(comprarSchema, Compra.class);


        }catch(OntologyException e){
            e.printStackTrace();
        }
    }

}
