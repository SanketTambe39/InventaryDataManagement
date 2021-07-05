package com.bridgelabz.inventarymanagement;

public interface InventaryDataManagementService {
	
		public  void addItem(ItemsDetails item);
		public void getDetails();
		public void getDetailsByName(String itemName);
		public void calculateValueOfEachItem();
		public void getTotalValue();
		public void updateValue(ItemsDetails updateItem);
		public void deleteValue(String  deleteItem);
}
