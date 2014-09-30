package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import config.RootPath;


public class XMLUtil {
	private Document doc;
	private String xmlFileName;
	public XMLUtil(String xmlFIleName){
		this.xmlFileName = xmlFIleName;
		buildXmlFile();
	}
	private void buildXmlFile(){
		DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
		String path = "src/config/";
//		path = "WEB-INF/";
		path = RootPath.getInstance().getRoot() + "/WEB-INF/";
		try {
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			this.doc = builder.parse(new File(path + xmlFileName + ".xml"));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e){
			e.printStackTrace();
		}
		
	}
	public void update(){
		buildXmlFile();
	}
	
	public ArrayList<String> getListByTag(String tagname){
		ArrayList<String> al = new ArrayList<String>();
			NodeList nl = doc.getElementsByTagName(tagname);

			for (int i = 0; i < nl.getLength(); i++){
				String node = nl.item(i).getFirstChild().getNodeValue();
				al.add(node);
				}
			return al;
	}
	public ArrayList<String> getValueListByUpperTagAndName(String upperTagName, String key, String tagToCheck){
		ArrayList<String> al = new ArrayList<String>();
		NodeList nl = doc.getElementsByTagName(upperTagName);

		for (int i = 0; i < nl.getLength(); i++){
			Element element = (Element)nl.item(i);
			NodeList keyList = element.getElementsByTagName("Name");
			
			String keyString = keyList.item(0).getFirstChild().getNodeValue();
			if (keyString.equalsIgnoreCase(key)){
				
				NodeList paramsList = element.getElementsByTagName(tagToCheck);
				for (int j = 0; j < paramsList.getLength(); j++){
					String params = paramsList.item(j).getFirstChild().getNodeValue();
					al.add(params);
					
				}
				return al;
			}
		}
		return null;
	}
	
	
	
}
