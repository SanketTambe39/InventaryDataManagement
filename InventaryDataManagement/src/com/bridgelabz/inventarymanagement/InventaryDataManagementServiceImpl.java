package com.bridgelabz.inventarymanagement;

import java.util.LinkedList;

public class InventaryDataManagementServiceImpl implements InventaryDataManagementService{

	LinkedList<ItemsDetails> itemlist = new LinkedList<ItemsDetails>();
	
	@Override
	public void addItem(ItemsDetails item) {
		if (ItemAlreadyPresent(item))
		{
			System.out.println("\t\tItem already exsists you can try update option to chenge the value");
		}
		else
		{
			itemlist.add(item);
			System.out.println("\t\t"+item.getItemName().toUpperCase() +" Added sucessfully");
		}
		
	}

	private boolean ItemAlreadyPresent(ItemsDetails item) {
		for (ItemsDetails items : itemlist)
		{
			if (items.getItemName().equals(item.getItemName()))
			{			
				return true;
			}
		}
		return false;
	}

	@Override
	public void getDetails() {
		System.out.println("\t\tItems in the Inventory are ");
		int i = 1;
		for (ItemsDetails item : itemlist) 
		{
			System.out.println("\t\t"+(i++)+") "+item);
		}
	}

	@Override
	public void getDetailsByName(String itemName) {
		boolean found = false;
		for (ItemsDetails item : itemlist)
		{
			if (item.getItemName().equals(itemName))
			{			
				System.out.println("\t\tIteam found : "+item);
				found = true;
				break;
			}
		}
		if(!found)
		{
			System.out.println("\t\tItem not found");			
		}
		
	}

	@Override
	public void calculateValueOfEachItem() {
		for (ItemsDetails item : itemlist) 
		{
			System.out.println("\t\tvalue of "+item.getItemName()+" of  " +item.getWeight() +" kg is "+( item.getWeight()*item.getPricePerKg() ) );
		}
	}

	@Override
	public void getTotalValue() {
		double totalValue = 0;
		for (ItemsDetails item : itemlist) 
		{
			totalValue += item.getWeight()*item.getPricePerKg();
		}
		System.out.println("\t\tTotal values of all items are "+totalValue);		
	}

	@Override
	public void updateValue(ItemsDetails updateItem) {
		boolean checkItem = false;
		for (ItemsDetails items : itemlist)
		{
			if (items.getItemName().equals(updateItem.getItemName()))
			{	
				items.setWeight(updateItem.getWeight());
				items.setPricePerKg(updateItem.getPricePerKg());
				checkItem = true;
			}
		}
		if(checkItem)
		{
			System.out.println("\t\tUpdated successfully");			
		}
		else
		{
			System.out.println("\t\tItem not found");
		}
	}

	@Override
	public void deleteValue(String deleteItem) {
		boolean checkItemRemoved = false;
		for (ItemsDetails items : itemlist)
		{
			if (items.getItemName().equals(deleteItem))
			{
				itemlist.remove(items);
				checkItemRemoved = true;
			}
		}
		if(checkItemRemoved)
		{
			System.out.println("\t\tItem "+deleteItem +" Deleted successfully");			
		}
		else
		{
			System.out.println("\t\tItem not found");
		}	
	}
}
