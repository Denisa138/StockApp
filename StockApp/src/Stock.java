import java.util.*;
import java.math.BigDecimal;
public class Stock {
 private ArrayList<StockItem> stockItems = new ArrayList<StockItem>();
   
public void add(Product product2, int quantity2)
   {  
	Iterator<StockItem> itr = stockItems.iterator();
    while (itr.hasNext()) {
        StockItem nextItem = itr.next();
        if (nextItem.toString() == product2.getName()) {
        	int finalQuantity = nextItem.getQuantity() + quantity2;
            nextItem.setQuantity(finalQuantity);
            return;
        }
    }	     
     stockItems.add(new StockItem(product2, quantity2));
   }
  
  public void remove(Product product1)
   {  
	  Iterator<StockItem> itr = stockItems.iterator();
      while (itr.hasNext()) {
          StockItem nextItem = itr.next();
          if (nextItem.toString()== product1.getName()) {
              itr.remove();
          }
      }
   }
  
  public void updateProductPrice(Product product1, BigDecimal price)
  {
	  StockItem found = null;
	  Iterator<StockItem> itr = stockItems.iterator();
      while (itr.hasNext()) {
          StockItem nextItem = itr.next();
          if (nextItem.toString()== product1.getName()) {
        	  found = nextItem;
          }
      }
     found.setProductPrice(price);
  }
  
  //Functie utilizata in cadrul clasei..
  public BigDecimal getProductPrice(String name)
  {
	  StockItem found = null;
	  Iterator<StockItem> itr = stockItems.iterator();
      while (itr.hasNext()) {
          StockItem nextItem = itr.next();
          if (nextItem.toString()== name) {
        	  found = nextItem;
          }
      }
      
      return found.getProductPrice();
  }
  
  public int getProductsStock(Product product1)
  {
	  StockItem found = null;
	  Iterator<StockItem> itr = stockItems.iterator();
      while (itr.hasNext()) {
          StockItem nextItem = itr.next();
          if (nextItem.toString()== product1.getName()) {
              found = nextItem;
          }
      }
      
	return found.getQuantity();
  }
  
  public void setProductsStock(Product product1, int quantity)
  {
	  StockItem found = null;
	  Iterator<StockItem> itr = stockItems.iterator();
      while (itr.hasNext()) {
          StockItem nextItem = itr.next();
          if (nextItem.toString()== product1.getName()) {
              found = nextItem;
          }
      }
	 found.setQuantity(quantity);
  }
}
