import java.math.BigDecimal; 
public class Main {
	
	public static void main(String[] args)
	{
		BigDecimal price1 = new BigDecimal(33.25);
		BigDecimal price2 = new BigDecimal(87.25);
		Product product1 = new Product("jeans","black", "40", "casual", price1);
		Product product2 = new Product("dress","red", "xxl", "elegant", price2);
		Product product3 = new Product("shoes","green", "37", "elegant", price2);
		
		Stock stoc1 = new Stock();
		Store store1 = new Store("Etic","fashion", stoc1);
		store1.addNewAdministrator("Victor", "0733028119", "Str. Viscan");
		store1.getAdministrator(0).addProductsToStock(product1, 80, stoc1);
		store1.getAdministrator(0).addProductsToStock(product2, 74, stoc1);
		store1.getAdministrator(0).addProductsToStock(product3, 104, stoc1);
		store1.getAdministrator(0).removeProductsFromStock(product1, stoc1);
		store1.getAdministrator(0).addProductsToStock(product1, 120, stoc1);
		
		System.out.println("The stock of " + store1.getName() + " store is: ");
		System.out.println("-" + product1.getName() +": "+ stoc1.getProductsStock(product1)+" items");
		System.out.println("-" + product2.getName() +": "+ stoc1.getProductsStock(product2)+" items");
		System.out.println("-" + product3.getName() +": "+ stoc1.getProductsStock(product3)+" items");
		
		store1.addNewSeller("Bogdan", "0734243567","Str. Florilor, Slatina");
		store1.addNewCashRegister("Etic", "Bogdan");
		store1.addNewSeller("Iza", "0733253567","Str. Albinelor, Slatina");
		store1.addNewCashRegister("Etic", "Iza");
		
		System.out.println("\nNew sell: ");
		store1.getCashRegister(0).startNewSell();
		System.out.println("Price of '" + product2.getName() + "': "+  store1.getSeller(0).sell(product2, 3, "USD",stoc1, store1.getCashRegister(0)) + " " + store1.getCashRegister(0).getCurrency(0));
		System.out.println("Price of '" + product1.getName() + "': "+  store1.getSeller(0).sell(product1, 7, "USD",stoc1, store1.getCashRegister(0)) + " " + store1.getCashRegister(0).getCurrency(0));
		System.out.println("Total price: " + store1.getCashRegister(0).finalizeSell(stoc1) + " " + store1.getCashRegister(0).getCurrency(0));
		
		System.out.println("\nNew sell: ");
		store1.getCashRegister(1).startNewSell();
		System.out.println("Price of '" + product2.getName() + "': "+  store1.getSeller(1).sell(product2, 33, "JPY",stoc1, store1.getCashRegister(1)) + " " + store1.getCashRegister(1).getCurrency(0));
		System.out.println("Price of '" + product3.getName() + "': "+  store1.getSeller(1).sell(product3, 70, "JPY",stoc1, store1.getCashRegister(1)) + " " + store1.getCashRegister(1).getCurrency(0));
		System.out.println("Price of '" + product3.getName() + "': "+  store1.getSeller(1).sell(product1, 10, "JPY",stoc1, store1.getCashRegister(1)) + " " + store1.getCashRegister(1).getCurrency(0));
		System.out.println("Total price: " + store1.getCashRegister(1).finalizeSell(stoc1) + " " + store1.getCashRegister(1).getCurrency(0));
		
		//Retur produs
		System.out.print("\nThe stock of '" +product1.getName()+"' after both sells :"+ store1.getSeller(1).checkProductsStock(product1, stoc1));
		store1.getSeller(1).returnProducts(product1, stoc1, store1.getCashRegister(1));
		System.out.print("\nThe stock of '" +product1.getName()+"' after return items from the second sell :" + store1.getSeller(1).checkProductsStock(product1, stoc1));
	} 
}
