/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Mohammed
 */
public class TestSAXParser extends DefaultHandler {
    public static ArrayList<Table> array_table=new ArrayList<>();    

    private boolean insideTable = false;
    private boolean insideRow = false;
    private boolean insideCells = false;
    private boolean insideP = false;
    private boolean TestForInstanceRow = false;
    private boolean OpendRow = false;
    public Table table = null;
    public ArrayList<String> ListeCells;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName == "table:table") {
            table = new Table(attributes.getValue("table:name"));                 
            insideTable = true;
        }
        if (insideTable == true) {
            if (qName == "table:table-column") {
                table.addColumnName(attributes.getValue("table:style-name"));
            }
        }
        if (insideTable == true) {
            if (qName == "table:table-row") {
                ListeCells=new ArrayList<>();                                                
                insideRow = true;
            }
        }
        if (insideRow == true) {
            if (qName == "table:table-cell") {
                OpendRow = true;
                if (attributes.getValue("office:value-type")!=null) {
                    insideCells = true;                    
                }
                else
                {
                    insideCells=false;
                }
            }
        }
        if (insideCells == true) {
            if (qName == "text:p") {                  
                insideP=true;
            }
        }        
    }
    @Override
    public void endDocument() throws SAXException {        
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName == "table:table-row") {
            if (OpendRow == true) {                
                table.addCellValues(ListeCells);               
            }
        }
        if (qName == "table:table") {            

            if (OpendRow == true) {
                OpendRow = false;
            }
            insideTable = false;
            insideRow = false;
            insideCells = false;
            insideP = false;
            TestSAXParser.array_table.add(table);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {        
        if (insideP == true) {
            String content = new String(ch, start, length);                       
            ListeCells.add(content);
            insideP = false;
        }
    }
}
