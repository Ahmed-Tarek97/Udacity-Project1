package UDACTIY_SIG.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import UDACTIY_SIG.model.Header;
import UDACTIY_SIG.model.HeaderTable;
import UDACTIY_SIG.model.InvoiceLine;
import UDACTIY_SIG.model.InvoicesLinesTable;
import UDACTIY_SIG.view.HeaderDialog;
import UDACTIY_SIG.view.InvoicesLineDialog;
import UDACTIY_SIG.view.MainFrame;

public class MainListener implements ActionListener , ListSelectionListener {

   private MainFrame sigPreviewFrame;
   private HeaderDialog headerDialog;
   private InvoicesLineDialog lineDialog;
    
    public MainListener(MainFrame frame) {
        this.sigPreviewFrame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("SalesInvoiceButtonsListener");
       
        
       switch (e.getActionCommand()) {
           case "Create New Invoice":
               createNewInvoice();
               break;
           case "Delete Invoice":
               deleteInvoice();
               break;
           case "Create Item":
               addNewLine();
               saveFiles();
               break;
           case "Delete Item":
               deleteLine();
               break;
           case "Load File":
               loadFilesIntoFrame(null , null);
               break;
           case "Save File":
               saveFiles();
               break;
           case "NewInvoiceOKBTN":
               createInvoiceFromNewInvoiceDialog();
               break;
           case "NewInvoiceCancelBTN":
               cancelNewInvoiceFromNewInvoiceDialog();
               break;
           case "NewLineOKBTN":
               createNewLineFromNewLineDialog();
               break;
           case "NewLineCancelBTN":
               cancelNewLineFromNewLineDialog();
                   break;
           default:
               break;
       }
    }
    private void createNewInvoice() {
        headerDialog = new HeaderDialog(sigPreviewFrame);
        headerDialog.setVisible(true);
    }

    private void deleteInvoice() {
        int invoicesHeaderTableRowIndex = sigPreviewFrame.getInvoicesHeadersTable().getSelectedRow();
        if (invoicesHeaderTableRowIndex == -1)
        {
            JOptionPane.showMessageDialog(sigPreviewFrame, "Please Select an invoice from Invoices table or reload files if there's no more invoices"
                    , "", JOptionPane.ERROR_MESSAGE);
        }
        else if(invoicesHeaderTableRowIndex != -1)
        {
        sigPreviewFrame.getInvoices().remove(invoicesHeaderTableRowIndex);
        ((HeaderTable) sigPreviewFrame.getInvoicesHeadersTable().getModel()).fireTableDataChanged();
     }}

    private void addNewLine() {
       int selectedInv = sigPreviewFrame.getInvoicesHeadersTable().getSelectedRow();
       if( selectedInv != -1)
       {
        lineDialog = new InvoicesLineDialog(sigPreviewFrame);
        lineDialog.setVisible(true);
     }
       else{
        JOptionPane.showMessageDialog(sigPreviewFrame, "Please select an invoice from Invoices table", "Error", JOptionPane.ERROR_MESSAGE);
       }
    }
    private void deleteLine() {
      int invoiceLinesTableSelectedRow = sigPreviewFrame.getInvoiceLinesTable().getSelectedRow();
      if(invoiceLinesTableSelectedRow != -1)
      {
        int headerRow = sigPreviewFrame.getInvoicesHeadersTable().getSelectedRow();
        InvoicesLinesTable invoiceLinesTableModel = (InvoicesLinesTable) sigPreviewFrame.getInvoiceLinesTable().getModel();
        invoiceLinesTableModel.getInvoiceLines().remove(invoiceLinesTableSelectedRow);
        invoiceLinesTableModel.fireTableDataChanged();
        ((HeaderTable) sigPreviewFrame.getInvoicesHeadersTable().getModel()).fireTableDataChanged();
        sigPreviewFrame.getInvoicesHeadersTable().setRowSelectionInterval(headerRow, headerRow);
      
      }
     }

    public void loadFilesIntoFrame(String headerPath , String linePath) {
             File InvoiceHeaderFile = null , InvoiceLinesFile = null;
             int fileChooserResult;
             
          if(headerPath == null && linePath == null)
          {
             
              JFileChooser fileChooser = new JFileChooser();
              fileChooserResult = fileChooser.showOpenDialog(sigPreviewFrame);
                if(fileChooserResult == JFileChooser.APPROVE_OPTION)
                {
                   InvoiceHeaderFile = fileChooser.getSelectedFile();
                   fileChooserResult = fileChooser.showOpenDialog(sigPreviewFrame);
                   if(fileChooserResult == JFileChooser.APPROVE_OPTION)
                     InvoiceLinesFile = fileChooser.getSelectedFile();
                }
              
          }
          else{
                InvoiceHeaderFile = new File(headerPath);
                InvoiceLinesFile = new File(linePath);
          }
          
          if(InvoiceHeaderFile != null && InvoiceLinesFile !=null)
          {
              try{
               List<String> InvoiceHeaderFileLines = Files.lines(Paths.get(InvoiceHeaderFile.getAbsolutePath()))
                      .collect(Collectors.toList());
               List<String> InvoiceLinesFileLines = Files.lines(Paths.get(InvoiceLinesFile.getAbsolutePath()))
                      .collect(Collectors.toList());
                 // ArrayList<InvoiceHeader> invoices = new ArrayList<>();
               for(String InvoiceHeaderFileLine : InvoiceHeaderFileLines)
               {
                  String[] InvoiceHeaderLineParts = InvoiceHeaderFileLine.split(",");
                  String numberASString = InvoiceHeaderLineParts[0];
                  String dateASString = InvoiceHeaderLineParts[1];
                  String custName = InvoiceHeaderLineParts[2];
                  int invNumber = Integer.parseInt(numberASString);
                  Date invDate = MainFrame.simpleDateFormat.parse(dateASString);
                  
                  Header invoice = new Header(invNumber, invDate, custName);
                  sigPreviewFrame.getInvoices().add(invoice);
               }
           
               for(String InvoiceLinesFileLine : InvoiceLinesFileLines)
                  {
                  String[] InvoiceLinesLineParts = InvoiceLinesFileLine.split(",");
                  int invoiceNumber = Integer.parseInt(InvoiceLinesLineParts[0]);
                  String itemName = InvoiceLinesLineParts[1];
                  double itemPrice = Double.parseDouble(InvoiceLinesLineParts[2]);
                  int itemCount = Integer.parseInt(InvoiceLinesLineParts[3]);
                  Header invoice = getInvoiceByInvoiceNumber(invoiceNumber);
                  InvoiceLine invoiceLine = new InvoiceLine(itemName, itemPrice, itemCount, invoice);
                  invoice.getLines().add(invoiceLine);
                  }
               sigPreviewFrame.getInvoicesHeadersTable().setModel(new HeaderTable(sigPreviewFrame.getInvoices()));
               
                       }catch(Exception e)
          {
              e.printStackTrace();
          }
          }
     }

    private void saveFiles() {
        String invoicesData="";
        String linesData="";
        for(Header inv : sigPreviewFrame.getInvoices())
        {
           invoicesData += inv.convertToCSV();
           invoicesData += "\n";
           for(InvoiceLine invLine : inv.getLines())
           {
               linesData += invLine.convertToCSV();
               linesData += "\n";
           }
        }
        JFileChooser jfc = new JFileChooser();
        if(jfc.showSaveDialog(sigPreviewFrame) == JFileChooser.APPROVE_OPTION)
        {
          File invoiceHeaderFile = jfc.getSelectedFile();
          if(jfc.showSaveDialog(sigPreviewFrame) == JFileChooser.APPROVE_OPTION)
          {
           File invoiceLineFile = jfc.getSelectedFile(); 
           try{
           FileWriter headerFW = new FileWriter(invoiceHeaderFile); 
           headerFW.write(invoicesData);
           headerFW.flush();
           headerFW.close();
           FileWriter linesFW = new FileWriter(invoiceLineFile);
           linesFW.write(linesData);
           linesFW.flush();
           linesFW.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(sigPreviewFrame, "Error while saving data", "Error", JOptionPane.ERROR_MESSAGE);
        }
          }
       }
    }     
    
    private Header getInvoiceByInvoiceNumber(int invoicenumber)
    {
        for(Header invoice : sigPreviewFrame.getInvoices())
        {
            if(invoicenumber == invoice.getInvoiceNumber())
                return invoice;
                }
        return null;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
      int rowNumber = sigPreviewFrame.getInvoicesHeadersTable().getSelectedRow();
      
      if(rowNumber > -1 && rowNumber < sigPreviewFrame.getInvoices().size())
      {
      Header invoice = sigPreviewFrame.getInvoices().get(rowNumber);
      sigPreviewFrame.getInvoiceNumLblVal().setText(String.valueOf(invoice.getInvoiceNumber()));
      sigPreviewFrame.getInvoiceDateLblVal().setText(MainFrame.simpleDateFormat.format(invoice.getInvoiceDate()));
      sigPreviewFrame.getCustNameLblVal().setText(invoice.getCustomerName());
      sigPreviewFrame.getInvoiceTotalLblVal().setText(String.valueOf(invoice.getInvoiceTotal()));
      
      List<InvoiceLine> invoiceLines = invoice.getLines();
      sigPreviewFrame.getInvoiceLinesTable().setModel(new InvoicesLinesTable(invoiceLines));
    }else{
      sigPreviewFrame.getInvoiceNumLblVal().setText("");
      sigPreviewFrame.getInvoiceDateLblVal().setText("");
      sigPreviewFrame.getCustNameLblVal().setText("");
      sigPreviewFrame.getInvoiceTotalLblVal().setText("");
      
      sigPreviewFrame.getInvoiceLinesTable().setModel(new InvoicesLinesTable(new ArrayList<InvoiceLine>()));
      }
    }

    private void createInvoiceFromNewInvoiceDialog() {
     String customerName = headerDialog.getCustNameField().getText();
     String Date = headerDialog.getInvDateField().getText();
     headerDialog.setVisible(false);
     headerDialog.dispose();
     try{
         Date invoiceDate = sigPreviewFrame.simpleDateFormat.parse(Date);
         Header invoice = new Header(getNextInvoiceNum() , invoiceDate , customerName);
         sigPreviewFrame.getInvoices().add(invoice);
         ((HeaderTable) sigPreviewFrame.getInvoicesHeadersTable().getModel()).fireTableDataChanged();
     }catch(ParseException pe)
     {
      JOptionPane.showMessageDialog(headerDialog, "Please enter valid date format", "Error date format", JOptionPane.ERROR_MESSAGE);
     }
     
    
    }

    private int getNextInvoiceNum()
    {
            int num =1;        
            List<Header> invoices = sigPreviewFrame.getInvoices();
            for(Header inv : invoices)
            {
              if(inv.getInvoiceNumber() > num)
              {
                 num = inv.getInvoiceNumber();
              }
            }
    return num + 1;
    }
    private void cancelNewInvoiceFromNewInvoiceDialog() {
     headerDialog.setVisible(false);
     headerDialog.dispose();    
    }
    private void createNewLineFromNewLineDialog() {
        int selectedInvoice = sigPreviewFrame.getInvoicesHeadersTable().getSelectedRow();
        if(selectedInvoice != -1){
         Header invoice = sigPreviewFrame.getInvoices().get(selectedInvoice);
         String itemName =  lineDialog.getItemNameTextField().getText();
         double itemPrice = Double.parseDouble(lineDialog.getItemPriceTextField().getText());
         int itemCount =  Integer.parseInt(lineDialog.getItemCountTextField().getText());
         lineDialog.setVisible(false);
         lineDialog.dispose();
         InvoiceLine invLine = new InvoiceLine(itemName, itemPrice, itemCount, invoice);
         invoice.getLines().add(invLine);
         ((InvoicesLinesTable) sigPreviewFrame.getInvoiceLinesTable().getModel()).fireTableDataChanged();
         ((HeaderTable) sigPreviewFrame.getInvoicesHeadersTable().getModel()).fireTableDataChanged();
         sigPreviewFrame.getInvoicesHeadersTable().setRowSelectionInterval(selectedInvoice, selectedInvoice);
        }
    }

    private void cancelNewLineFromNewLineDialog() {
     lineDialog.setVisible(false);
     lineDialog.dispose();      
    }

}
