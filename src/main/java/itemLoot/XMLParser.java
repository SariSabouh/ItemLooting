package itemLoot;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import itemLoot.Item.ItemType;
import itemLoot.Item.ItemUsage;

public class XMLParser extends DefaultHandler {
	private Item item;
	private String tmpValue;
	private ArrayList<Item> itemList;

	public XMLParser() {
		itemList = new ArrayList<Item>();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse("./src/main/resources/itemList.xml", this);
		} catch (ParserConfigurationException e) {
			System.out.println("ParserConfig error");
		} catch (SAXException e) {
			System.out.println("SAXException : xml not well formed");
		} catch (IOException e) {
			System.out.println("IO error");
		}
	}
	
	public ArrayList<Item> getItemsList(){
		return itemList;
	}

	public void startElement(String s, String s1, String elementName, Attributes attributes) throws SAXException {
		if(item != null){
			itemList.add(item);
		}
		// WE CAN USE THAT IN CASE WE USE THE XML FOR ITEMS TO BUY AND SOMETHING
		// ELSE
	}

	@Override
	public void endElement(String s, String s1, String element)
			throws SAXException {
		if (element.equals("name")) {
			item = new Item(tmpValue);
		}

		else if (element.equals("cost")) {
			item.setCost(Float.parseFloat(tmpValue));
		}

		else if (element.equals("rarity")) {
			item.setRarity(Float.parseFloat(tmpValue));
		}

		else if (element.equals("amount")) {
			item.setAmount(Float.parseFloat(tmpValue));
		}

		else if (element.equals("type")) {
			item.setType(ItemType.valueOf(tmpValue));
		}

		else if (element.equals("usage")) {
			item.setUsage(ItemUsage.valueOf(tmpValue));
		}
	}

	@Override
	public void characters(char[] ac, int i, int j) throws SAXException {
		tmpValue = new String(ac, i, j);
	}
}