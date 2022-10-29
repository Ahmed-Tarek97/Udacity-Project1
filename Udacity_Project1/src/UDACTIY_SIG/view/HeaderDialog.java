package UDACTIY_SIG.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HeaderDialog extends JDialog {
    private JLabel invoiceDateLabel;
    private JTextField invoiceDateTextField;
    private JLabel customerNameLabel;
    private JTextField customerNameTextField;
    private JButton newInvoiceOkButton;
    private JButton newInvoiceCancelButton;
    
    public HeaderDialog(MainFrame frame)
    {
        invoiceDateLabel = new JLabel("Invoice Date");
        invoiceDateTextField = new JTextField(15);
        customerNameLabel = new JLabel("Customer Name");
        customerNameTextField = new JTextField(15);
        newInvoiceOkButton = new JButton("OK");
        newInvoiceCancelButton = new JButton("Cancel");
        
        newInvoiceOkButton.setActionCommand("NewInvoiceOKBTN");
        newInvoiceCancelButton.setActionCommand("NewInvoiceCancelBTN");
        
         newInvoiceOkButton.addActionListener(frame.getSalesInvoiceListener());
        newInvoiceCancelButton.addActionListener(frame.getSalesInvoiceListener());
        setLayout(new GridLayout(3, 2));
       
        add(invoiceDateLabel);
        add(invoiceDateTextField);
        add(customerNameLabel);
        add(customerNameTextField);
        add(newInvoiceOkButton);
        add(newInvoiceCancelButton);
        setModal(true);
         pack();
        
     }
    
    public JTextField getCustNameField()
    {
      return customerNameTextField;
    }
    
    public JTextField getInvDateField()
    {
      return invoiceDateTextField;
    } 
}
