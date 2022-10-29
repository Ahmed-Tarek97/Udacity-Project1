package UDACTIY_SIG.model;

import java.util.ArrayList;
import java.util.Date;
import UDACTIY_SIG.view.MainFrame;

public class Header {

   
   private int invoiceNumber;
   private String customerName;
   private Date invoiceDate;
   private ArrayList<InvoiceLine> lines=null;
    
    public Header(int invoiceNumber, Date invoiceDate, String customerName) {
          setInvoiceNumber(invoiceNumber);
          setCustomerName(customerName);
          setInvoiceDate(invoiceDate);
    }
    
    public String convertToCSV(){
     return invoiceNumber + "," + MainFrame.simpleDateFormat.format(invoiceDate)  + "," + customerName;
    }
    

     public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    
    public ArrayList<InvoiceLine> getLines() {
        if(lines == null)
        {
            lines = new ArrayList<InvoiceLine>();
        }
        return lines;
    
    }

    public double getInvoiceTotal()
    {
        double invoiceTotal= 0.0;
        for(int i=0 ; i < getLines().size() ;i++)
        {
            invoiceTotal += getLines().get(i).getItemTotal();
        }
        return invoiceTotal;
    }
    
    

   

    
    
}
