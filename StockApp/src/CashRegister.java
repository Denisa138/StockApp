import java.util.ArrayList;
import java.math.BigDecimal;

public class CashRegister {
     private int currentReceiptNo;
     private ArrayList<Receipt> receipts = new ArrayList<Receipt>();
     private String storeName;
     private String fiscalIdentifier;
     
     CashRegister(String s, String f)
     {
    	 this.storeName = s;
    	 this.fiscalIdentifier = f;
     }
     
     public void startNewSell()
     {
    	 Receipt receipt = new Receipt();
    	 receipts.add(receipt);
    	 currentReceiptNo = receipts.indexOf(receipt);	 
     }
     
     public BigDecimal registerNewProduct(String productName, String currency, int quantityDemanded,Stock stoc)
     {	 
    	 receipts.get(currentReceiptNo).add(productName, currency,quantityDemanded);
    	 return receipts.get(currentReceiptNo).getTotalForProduct(productName,stoc);
     }
     
     public BigDecimal finalizeSell(Stock stoc)
     {
    	 return receipts.get(currentReceiptNo).getTotal(stoc);
     }
     
    public int removeProductFromSell(String productName, Stock stoc)
    {
    	int quantityOfProduct = receipts.get(currentReceiptNo).getQuantity(productName);
    	receipts.get(currentReceiptNo).remove(productName);
    	
    	return quantityOfProduct;
    }
     
    public String getCurrency(int index)
    {
    	return receipts.get(index).getCurrency(index);
    }
    
    public String getFiscalIdentifier()
    {
    	return fiscalIdentifier;
    }
    
    public String getStoreName()
    {
    	return storeName;
    }
}
