/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.shengdong.recuperacionaedfinal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author shengdong
 */
public class RecuperacionAEDFinal {

    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        var f = new File("users.xml");
        var dbf = DocumentBuilderFactory.newInstance();
        var db = dbf.newDocumentBuilder();
        
       
        
        Document doc = db.parse(f);
        
        //removeRecursively(doc, Node.ELEMENT_NODE, "user");
            
        Node raiz = doc.getFirstChild();
        NodeList empleados = raiz.getChildNodes();
        for(var i = 0; i < empleados.getLength(); i++){
            Node empleado = empleados.item(i);
            if(empleado.getNodeType() == Node.ELEMENT_NODE){
                // Se seguro que empleado es una etiqueta XML
                Element eEmpleado = (Element)empleado;
                
                NodeList datosEmpleado = eEmpleado.getChildNodes();
                
                for(int j = 0; j < datosEmpleado.getLength(); j++){
                    Node datos = datosEmpleado.item(j);
                    if(datos.getNodeType() == Node.ELEMENT_NODE){
                        Element eDato = (Element)datos;
                        
                           deletePerson(doc, "John");
 

                           /*List<String> aux = new ArrayList<String>();
                             removeDuplicate(doc.getDocumentElement(), aux);*/
                        System.out.println(eDato.getNodeName() +": " + eDato.getTextContent());
                    }
                        
                }
            }
        }
    }
    
    
    public static void deletePerson(Document doc, String personName) {
    // <person>
    NodeList nodes = doc.getElementsByTagName("user");

    for (int i = 0; i < nodes.getLength(); i++) {
      Element person = (Element)nodes.item(i);
      // <name>
      Element name = (Element)person.getElementsByTagName("name").item(0);
      String pName = name.getTextContent();
      if (pName.equals(personName)) {
         person.getParentNode().removeChild(person);
      }
    }
  }
    
    

    

}    
