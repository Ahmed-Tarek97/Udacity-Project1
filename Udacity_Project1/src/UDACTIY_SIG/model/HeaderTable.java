package UDACTIY_SIG.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import UDACTIY_SIG.view.MainFrame;

public class HeaderTable extends AbstractTableModel{

    String[] InvoiceHeaderTableCols = {"Invoice Number" , "Invoice Date" , "Customer Name" , "Invoice Total"};
    List<Header> invoices;

    public HeaderTable(List<Header> invoices)
    {
       this.invoices = invoices;
    }
    
    @Override
    public int getRowCount() {
        return invoices.size();
       }

    @Override
    public int getColumnCount() {
      return InvoiceHeaderTableCols.length;    
    }
    
    @Override
    public String getColumnName(int columnIndex)
    {
          return InvoiceHeaderTableCols[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Header inv = invoices.get(rowIndex);
      switch(columnIndex)
      {
          case 0: return inv.getInvoiceNumber();
          case 1: return MainFrame.simpleDateFormat.format(inv.getInvoiceDate());
          case 2: return inv.getCustomerName(); 
          case 3: return  inv.getInvoiceTotal();
      }
      return "";
       }
    
}
