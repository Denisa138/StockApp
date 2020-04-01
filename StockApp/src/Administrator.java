
public class Administrator{
    private EmployeeInfo employeeInfo = null;
	
   Administrator(EmployeeInfo employeeInfo)
   {
	   this.employeeInfo = employeeInfo;
   }
   
   public void addProductsToStock(Product product2, int quantity2, Stock a)
    {
      a.add(product2, quantity2);
    }
   
   public void removeProductsFromStock(Product product2, Stock a)
   {
	   a.remove(product2);
   }
   
   public int checkProductsStock(Product product2, Stock a)
   {
	   return a.getProductsStock(product2);
   }
   
   String getEmployeeName()
   {
	   return employeeInfo.getName();
   }
  
}
