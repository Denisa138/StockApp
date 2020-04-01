import java.math.BigDecimal;
public class Seller {
	private EmployeeInfo employeeInfo = null;
	
	   Seller(EmployeeInfo employeeInfo)
	   {
		   this.employeeInfo = employeeInfo;
	   }
	   
	   public int checkProductsStock(Product product2, Stock a)
	   {
		   return a.getProductsStock(product2);
	   }
	   
	   public BigDecimal sell(Product product2, int quantity, String currency,Stock stoc, CashRegister a)
	   {
		   BigDecimal price = BigDecimal.ZERO;
		   if(checkProductsStock(product2, stoc) != 0)
		   {
			   int finalQuantity = checkProductsStock(product2, stoc) - quantity;
			   stoc.setProductsStock(product2, finalQuantity);
			   price = a.registerNewProduct(product2.getName(),currency,quantity,stoc);
		   }
		   return price;
	   }
	   
	  /* public void printCostOfProduct(Product product2, int quantity,String currency,Stock stoc,CashRegister a)
		{
			BigDecimal price = a.registerNewProduct(product2.getName(),currency,quantity,stoc);
			System.out.println("Price of '" + product2.getName() + "':"+ price);
		}*/
		
		public BigDecimal TotalCost(Stock stoc,CashRegister a)
		{
			BigDecimal price = a.finalizeSell(stoc);
			return price;
		}
		
		public void returnProducts(Product product,Stock stoc,CashRegister a)
		{
			int quantityRemoved = a.removeProductFromSell(product.getName(), stoc);
			quantityRemoved = stoc.getProductsStock(product) + quantityRemoved;
			stoc.setProductsStock(product,quantityRemoved);
		}
		
		String getName()
		{
			return employeeInfo.getName();
		}
}
