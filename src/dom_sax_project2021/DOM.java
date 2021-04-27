
package dom_sax_project2021;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DOM
{
    Document dom;
    ArrayList<Slam> slams = new ArrayList<Slam>();
    String s = "";
    String p = "";
    
    
    public String run(){
        loadXMLFileIntoDOM();
        parseTheDOM();
        s = outputData();
        return s;
    }
    
    private void loadXMLFileIntoDOM(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder db = dbf.newDocumentBuilder();

            dom = db.parse("project.xml");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void parseTheDOM(){
        Element docEle = dom.getDocumentElement();

        NodeList nl = docEle.getElementsByTagName("Slam");
        if(nl != null && nl.getLength() > 0){
            for(int i = 0; i < nl.getLength(); i++){
                Element el = (Element)nl.item(i);
                Slam e = getSlam(el);

                slams.add(e);
            }
        }
    }
    
    private Slam getSlam(Element slamEl){
        String name = slamEl.getAttribute("name");
        String year = slamEl.getAttribute("year");
        String winner = getTextValue(slamEl, "winner");
        String runnerUp = getTextValue(slamEl, "runnerUp");
        String surface = getTextValue(slamEl, "surface");
        String semiFinalist = getTextValue(slamEl, "semiFinalist");
        String score = getTextValue(slamEl, "score");
        String semiFinalist2 = "";
        NodeList nl = slamEl.getElementsByTagName("semiFinalist");
        if(nl != null && nl.getLength() > 0){
            Element el = (Element)nl.item(1); 
            semiFinalist2 = el.getFirstChild().getNodeValue();
        }
        
        Slam s = new Slam(name, year, winner, runnerUp, score, surface, semiFinalist, semiFinalist2);

        return s;
    }

    
    private String getTextValue(Element ele, String tagName){
        String textVal = null;
        NodeList nl = ele.getElementsByTagName(tagName);
        if(nl != null && nl.getLength() > 0){
            Element el = (Element)nl.item(0);
            textVal = el.getFirstChild().getNodeValue();
        }
        return textVal;
    }
    
    private String outputData(){
        p += "No. of Slams ' " + slams.size() + "'.\n\n";
       
        for(Slam slam : slams){
            p += slam + "\n";
        }
        return p;
    }
}

