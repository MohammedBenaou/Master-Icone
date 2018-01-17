import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestXPath {

    private static XPath compiler;
    private static Document source;
    public static ArrayList<Table> liste_table = new ArrayList<Table>();
    /**
     * Evalue une expression XPath sur le document DOM.
     *
     * @param expression expression XPath a executer
     * @return les noeuds correspondant au resultat de l'evaluation
     * @throws XPathExpressionException
     */    

    public static NodeList executeXPath(String expression)
            throws XPathExpressionException {
        // compilation de l'expression XPath
        XPathExpression exp = compiler.compile(expression);
        // evaluation de l'expression
        NodeList resultat = (NodeList) exp.evaluate(source, XPathConstants.NODESET);
        if (resultat != null) {
            for (int i = 0; i < resultat.getLength(); i++) {

                Node n = resultat.item(i);
                System.out.print(n.getNodeName() + " = ");
                System.out.println(n.getTextContent());

            }
        }
        return resultat;
    }


    public static void main(String[] args) {
        try {
            // creation de l'analyseur DOM
            DocumentBuilderFactory aDOMFactory = DocumentBuilderFactory.newInstance();
            aDOMFactory.setNamespaceAware(true);
            DocumentBuilder aDOMBuilder = aDOMFactory.newDocumentBuilder();

            // creation de la source XML a traiter
            File xmlFile = new File("content.xml");
            source = aDOMBuilder.parse(xmlFile);

            // creation de l'interpreteur XPath
            XPathFactory fabriqueXPath = XPathFactory.newInstance();
            compiler = fabriqueXPath.newXPath();
            String sourceAttExp = "/*[local-name() = 'document-content']/*[local-name() = 'body']//*[local-name() = 'table']"
                    + "/*[local-name() = 'table-row']"
                    + "//*[local-name() = 'p']";
            NodeList nodes = executeXPath(sourceAttExp); 
            Node node=nodes.item(0);
            if (node.getParentNode().getParentNode().getParentNode().getNodeName().equals("table:table")) {
                NodeList root = node.getParentNode().getParentNode().getParentNode().getParentNode().getChildNodes();
                for (int cpt = 0; cpt < root.getLength(); cpt++) {
                    //Récuperer le nom de la table
                    String NomTable = root.item(cpt).getAttributes().getNamedItem("table:name").getNodeValue();
                    //Creation d'une table avec le nom
                    Table table = new Table(NomTable);                    
                    NodeList insidetable = root.item(cpt).getChildNodes();
                    //Parcourir les noeuds de table:table
                    for (int count_insideTable = 0; count_insideTable < insidetable.getLength(); count_insideTable++) {                        
                        
                        if (insidetable.item(count_insideTable).getNodeName().equals("table:style-name")) {
                            //Récuperer l'attribut table:style-name du noeud table:style-name 
                            table.addColumnName(insidetable.item(cpt_insideTable).getAttributes().getNamedItem("table:style-name").getNodeValue());
                        }
                        if (insidetable.item(count_insideTable).getNodeName().equals("table:table-row")) {
                            ArrayList<String> cellsArray = new ArrayList<>();//Creation de la liste des cellules
                            NodeList insideRows = insidetable.item(count_insideTable).getChildNodes();
                            // parcourir les noeuds de table:table-row
                            for (int cpt_insideRows = 0; cpt_insideRows < insideRows.getLength(); cpt_insideRows++) {
                                NodeList Cellslistednode = insideRows.item(cpt_insideRows).getChildNodes();                                                                                               
                                for (int CountInsideCells = 0; CountInsideCells < Cellslistednode.getLength(); CountInsideCells++) {                                    
                                        cellsArray.add(Cellslistednode.item(CountInsideCells).getTextContent());// Ajouter le nom de la 
                                }
                            }
                            //ajout de la liste des cellules
                            table.addCellValues(cellsArray);
                        }
                    }
                    //ajout de la table dans la liste des tables
                    liste_table.add(table);
                }
            }  
            
            for (Table t : liste_table) {
                System.out.println(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
