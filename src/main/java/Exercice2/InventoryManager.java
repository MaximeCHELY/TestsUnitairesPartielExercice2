package Exercice2;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
	/**
	 * source des produits 
	 */
	private Map<String, Integer> inventory;
	
	public InventoryManager() {
		this.inventory = new HashMap<>();
	}
	
	public void addToInventory(String product, Integer quantity) {
		inventory.put(product, quantity);
	}
	
	public void deleteQuantityFromInventory(String product, Integer quantity) {
		if((inventory.get(product) < quantity)||(inventory.containsKey(product) == false)) {
			throw new IllegalArgumentException("Erreur, quantité à retirer trop grande");
		}
		Integer newQuantity = inventory.get(product) - quantity; 
		inventory.replace(product, newQuantity);
	}
	
	public void deleteProductFromInventory(String product) {
		if(inventory.containsKey(product) == false) {
			throw new IllegalArgumentException("Erreur, quantité à retirer trop grande");
		}
		inventory.remove(product);
	}
	
	public Integer getStock(String product) {
		if(inventory.containsKey(product) == false) {
			throw new IllegalArgumentException("Erreur, le produit n'existe pas");
		}
		return inventory.getOrDefault(product, 0);
	}
}
