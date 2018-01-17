/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author Mohammed
 */
public class APP{

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Table> array_table=new ArrayList<>();    
    public static void main(String[] args) throws Exception{        
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser parser = factory.newSAXParser();         
         parser.parse("content.xml", new TestSAXParser());          
         for(Table table: TestSAXParser.array_table){
             System.out.println(table);
         }         
    }

}
