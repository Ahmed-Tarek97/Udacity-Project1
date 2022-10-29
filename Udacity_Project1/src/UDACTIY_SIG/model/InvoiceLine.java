package UDACTIY_SIG.model;

import java.util.Date;
public class InvoiceLine {

  
    private String itemName;
    private double itemPrice;
    private int itemCount;
    private Header invoice;
    
    public InvoiceLine(String itemname , double itemprice , int itemcount , Header inv)
    {
        setItemName(itemname);
        setItemPrice(itemprice);
        setItemCount(itemcount);
        setInvoice(inv);
    }
    
    public String convertToCSV(){
        return invoice.getInvoiceNumber() + "," + itemName + "," + itemPrice + "," + itemCount;
    }
    
     


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public double getItemTotal() {
        return  getItemCount() * getItemPrice();
        
    }

    public Header getInvoice() {
        return invoice;
    }

  
    public void setInvoice(Header invoice) {
        this.invoice = invoice;
    }
    
}
