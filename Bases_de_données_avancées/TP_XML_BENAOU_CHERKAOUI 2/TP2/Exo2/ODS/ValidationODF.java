
import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;


public class ValidationODF
{
    public static void main(String[] args) throws Exception
    {
        // phase de validation
        // 1. creation du schema
        // pour que cela fonctionne il est necessaire d'indiquer dans le classpath
        // ou se situe l'archive jing.jar
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.RELAXNG_NS_URI,
                "com.thaiopensource.relaxng.jaxp.XMLSyntaxSchemaFactory", null);
        Schema schema = sf.newSchema(new File("OpenDocument-v1.2-os-schema.rng"));
        // 2. validation du document
        schema.newValidator().validate(new StreamSource(args[0]));
        /*  après l'extraction du zip on applique cette commande pour verifier le fichier content.xml
                
            java -cp .:jing.jar ValidationODF content.xml
        */
        System.out.println("validation reussie...");


    }
}
