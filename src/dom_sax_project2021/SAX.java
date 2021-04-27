package dom_sax_project2021;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;

import org.xml.sax.helpers.DefaultHandler;

public class SAX extends DefaultHandler {
    private ArrayList<Slam> slamList = new ArrayList<Slam>();
    private Slam tempSlam;
    private String tempVal;
    private String s = "";
    private String p = "";
    
    private boolean semiF = true;
    private boolean semiS = true;
    
    public String run(){   
        loadFileIntoSax();
        s = outputList();
        return s;
    }
    
    private void loadFileIntoSax(){
        SAXParserFactory spf = SAXParserFactory.newInstance();
        
        try{
            SAXParser sp = spf.newSAXParser();
            sp.parse("project.xml", this);
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private String outputList(){
        p += "No. of Slams ' " + slamList.size() + "'.\n\n";
       
        for(Slam slam : slamList){
            p += slam + "\n";
        }
        return p;
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{ 
            tempVal = "";
        
        if(qName.equalsIgnoreCase("Slam")){
            tempSlam = new Slam();     
            tempSlam.setName(attributes.getValue("name"));
            tempSlam.setYear(attributes.getValue("year"));
        }   
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        
        if(qName.equalsIgnoreCase("slam")){   
            slamList.add(tempSlam);
        }
        else if(qName.equalsIgnoreCase("winner")){
            tempSlam.setWinner(tempVal);
            
        }
        else if(qName.equalsIgnoreCase("runnerUp")){
            tempSlam.setRunnerUp(tempVal);
           
        }
        else if(qName.equalsIgnoreCase("surface")){
            tempSlam.setSurface(tempVal);
           
        }
        else if(qName.equalsIgnoreCase("semiFinalist")){
            if(semiF){
            tempSlam.setSemiFinalist(tempVal);  
            semiF = false;
            semiS = true;
            }
            else{
            tempSlam.setSemiFinalist2(tempVal);       
            semiF = true;
            semiS = false;
            }
        }
        else if(qName.equalsIgnoreCase("score")){
            tempSlam.setScore(tempVal);       
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }
    
   
}

