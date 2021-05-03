
package ultetes;

import annotation.getterFunctionName;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Funkciok<Osztaly> {
    public Boolean mentes(Osztaly peldany){
        String osztalynev = peldany.getClass().getSimpleName();
        String fajlnev = osztalynev + ".xml";
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            TransformerFactory tf = TransformerFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Transformer t = tf.newTransformer();
            File file = new File(fajlnev);
            if(!(file.exists() && file.isFile())){
                //fájl létrehozása
                file.createNewFile();
                Document xml = db.newDocument();
                t.setOutputProperty(OutputKeys.ENCODING, "utf-8");
                String foelemNev = peldany.getClass().getName();
                Element foelem = xml.createElement(foelemNev);
                xml.appendChild(foelem);
                DOMSource source = new DOMSource(xml);
                StreamResult result = new StreamResult(file);
                t.transform(source, result);
            }
            //mentés folyamata
            Field[] tulajdonsagok = peldany.getClass().getDeclaredFields();
            HashMap<String, HashMap<String,String>> adatok = new HashMap<String,HashMap<String,String>>();
            for(Field tul : tulajdonsagok){
                String getterFunctionName = tul.getAnnotation(getterFunctionName.class).value();
                String tulTipus = tul.getAnnotation(getterFunctionName.class).type().getSimpleName();
                Method getterFuggveny = peldany.getClass().getMethod(getterFunctionName);
                String tulajdonsagErtek = getterFuggveny.invoke(peldany).toString();
                HashMap<String,String> ertekAdatok = new HashMap<String,String>();
                ertekAdatok.put(tulajdonsagErtek, tulTipus);
                adatok.put(tul.getName(), ertekAdatok);
                
            }
            tulajdonsagok = peldany.getClass().getSuperclass().getDeclaredFields();
            for(Field tul : tulajdonsagok){
                String getterFunctionName = tul.getAnnotation(getterFunctionName.class).value();
                String tulTipus = tul.getAnnotation(getterFunctionName.class).type().getSimpleName();
                Method getterFuggveny = peldany.getClass().getSuperclass().getMethod(getterFunctionName);
                String tulajdonsagErtek = getterFuggveny.invoke(peldany).toString();
                HashMap<String,String> ertekAdatok = new HashMap<String,String>();
                ertekAdatok.put(tulajdonsagErtek, tulTipus);
                adatok.put(tul.getName(), ertekAdatok);
            }
            Document xml = db.parse(file);
            xml.normalize();
            Element foelem = (Element)xml.getFirstChild();
            Element ujElem = xml.createElement(peldany.getClass().getSimpleName());
            foelem.appendChild(ujElem);
            for(Map.Entry<String, HashMap<String, String>> adat : adatok.entrySet()){
                String tulNev = adat.getKey();
                HashMap<String, String> ertekAdatok = adat.getValue();
                String veglegesErtek = "";
                String veglegesTipus = "";
                for(Map.Entry<String, String> ertekAdat : ertekAdatok.entrySet()){
                    veglegesErtek = ertekAdat.getKey();
                    veglegesTipus = ertekAdat.getValue();
                }
                Element tulajdonsag = xml.createElement(tulNev);
                tulajdonsag.setTextContent(veglegesErtek);
                tulajdonsag.setAttribute("type", veglegesTipus);
                ujElem.appendChild(tulajdonsag);
            }
            DOMSource source = new DOMSource(xml);
            StreamResult result = new StreamResult(file);
            t.transform(source, result);
            return Boolean.TRUE;
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
        return Boolean.FALSE;
    }
}
