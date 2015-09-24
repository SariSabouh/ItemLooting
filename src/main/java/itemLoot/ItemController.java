package itemLoot;

import java.util.ArrayList;

public class ItemController {

	ArrayList<Item> itemList;
	
	public void loadItems(){
		XMLParser xml = new XMLParser();
		itemList = xml.getItemsList();
		System.out.println(itemList.get(0).getName());
	}	
}
