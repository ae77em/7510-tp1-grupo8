package tp1_7510.grupo8;

import java.util.Hashtable;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LoaderXmlConfiguration implements LoaderConfiguration{
	org.w3c.dom.NodeList loggers;
	
	public LoaderXmlConfiguration(String pathConfig){
		org.w3c.dom.Document dom = null;
		javax.xml.parsers.DocumentBuilderFactory dbf;
		javax.xml.parsers.DocumentBuilder db;
		
		dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		
		try
		{
		  db = dbf.newDocumentBuilder();
		  dom = db.parse(pathConfig);
		}
		catch(Exception ex) {
			System.out.println("NO PUDE ABRIR CONFIG.XML");
		}
		
		org.w3c.dom.Element rootElement = dom.getDocumentElement();
		loggers = rootElement.getElementsByTagName("logger");
	}


	public int getLenghtLoggers() {
		return loggers.getLength();
	}


	public String getNameLogger(int i) {
		
		Element eElement = (Element) loggers.item(i);		
		return eElement.getElementsByTagName("name").item(0).getTextContent();
	}


	public String getTypeLogger(int i) {
		
		Element eElement = (Element) loggers.item(i);		
		return eElement.getElementsByTagName("type").item(0).getTextContent();
	}


	public String getFileNameLogger(int i) {
		
		Element eElement = (Element) loggers.item(i);		
		Element fileName = (Element) eElement.getElementsByTagName("output").item(0);		
		return fileName.getElementsByTagName("fileName").item(0).getTextContent();	
	}


	public String getLevelLogLogger(int i) {
		
		Element eElement = (Element) loggers.item(i);		
		Element fileName = (Element) eElement.getElementsByTagName("output").item(0);		
		return fileName.getElementsByTagName("levelLog").item(0).getTextContent();
	}


	public String getFormatDateLogger(int i) {
		
		Element eElement = (Element) loggers.item(i);		
		Element fileName = (Element) eElement.getElementsByTagName("output").item(0);		
		return fileName.getElementsByTagName("formatDate").item(0).getTextContent();
	}


	public String getPatternMessageLogger(int i) {
		
		Element eElement = (Element) loggers.item(i);		
		Element fileName = (Element) eElement.getElementsByTagName("output").item(0);		
		return fileName.getElementsByTagName("patternMessage").item(0).getTextContent();	
	}


	public String getSeparatorLogger(int i) {
		
		Element eElement = (Element) loggers.item(i);		
		Element fileName = (Element) eElement.getElementsByTagName("output").item(0);		
		return fileName.getElementsByTagName("separator").item(0).getTextContent();
	}


	public String getRegularExpresionLogger(int i) {
		
		Element eElement = (Element) loggers.item(i);		
		Element fileName = (Element) eElement.getElementsByTagName("output").item(0);		
		return fileName.getElementsByTagName("regularExpresion").item(0).getTextContent();
	}


	public Hashtable<String, String> getCustomFilterLogger(int i) {
		Hashtable<String, String> hashCustomsFilters = new Hashtable<String, String>();
		
		Element eElement = (Element) loggers.item(i);
		
		Element output = (Element) eElement.getElementsByTagName("output").item(0);
		
		Element customFilter = (Element) output.getElementsByTagName("customFilter").item(0);
		
		NodeList patternList =  eElement.getElementsByTagName("valPattern");
		
		for (int filter = 0; filter < patternList.getLength(); filter++){
			Element aFilter = (Element) output.getElementsByTagName("valPattern").item(filter);
			hashCustomsFilters.put(aFilter.getAttribute("pattern"),aFilter.getTextContent());
		}

		return hashCustomsFilters;
	}
}