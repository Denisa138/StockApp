import java.math.BigDecimal;

public class StockItem {
   private Product product = null;
   private int quantity;
   
   StockItem(Product product, int q)
   {
	   this.product = product;
	   this.quantity = q;
   }
   
   int getQuantity()
   {
	   return quantity;
   }
   
   void setQuantity(int q)
   {
	   quantity = q;
   }
   
   @Override
   public String toString() {
       return  product.getName();
   }
    
   public void setProductPrice(BigDecimal newPrice)
   {
	   product.setPrice(newPrice);
   }
   
   public BigDecimal getProductPrice()
   {
	   return product.getPrice();
   }
}
