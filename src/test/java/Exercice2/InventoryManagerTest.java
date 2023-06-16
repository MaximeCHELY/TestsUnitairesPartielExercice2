package Exercice2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InventoryManagerTest {

	public InventoryManager im = new InventoryManager();
	
	@ParameterizedTest
	@CsvSource({"pommes,20"})
	public void testStockSuffisant(String product, Integer quantity) {
		im.addToInventory(product, quantity);
		im.deleteQuantityFromInventory(product, 10);
		Integer resultat = im.getStock(product);
		Integer expected = 10;
		Assert.assertEquals(resultat, expected);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testStockInsuffisant() {
		im.addToInventory("pommes", 20);
		im.deleteQuantityFromInventory("pommes", 30);
	}
	
	@ParameterizedTest
	@CsvSource({"pommes,0"})
	public void testStockEpuise(String product, Integer quantity) {
		im.addToInventory(product, quantity);
		Integer resultat = im.getStock(product);
		Integer expected = 0;
		Assert.assertEquals(resultat, expected);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProduitInexistant() {
		im.addToInventory("pommes", 20);
		im.getStock("poires");
	}
}
