package UDACTIY_SIG.view;

import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class InvoicesLineDialog extends JDialog{
    private JLabel itemNameLabel;
    private JLabel itemPriceLabel;
    private JLabel itemCountLabel;
    private JTextField itemNameTextField;
    private JTextField itemPriceTextField;
    private JTextField itemCountTextField;
    private JButton newLineOkButton;
    private JButton newLineCancelButton;
    
    public InvoicesLineDialog(MainFrame frame)
    {
      itemNameLabel = new JLabel("Item Name");
      itemPriceLabel =new JLabel("Item Price");
      itemCountLabel =new JLabel("Item Count");
      itemNameTextField = new JTextField(20);
      itemPriceTextField = new JTextField(20);
      itemCountTextField = new JTextField(20);
      newLineOkButton = new JButton("OK");
      newLineCancelButton = new JButton("Cancel");
      
      newLineOkButton.addActionListener(frame.getSalesInvoiceListener());
      newLineCancelButton.addActionListener(frame.getSalesInvoiceListener());
      
      newLineOkButton.setActionCommand("NewLineOKBTN");
      newLineCancelButton.setActionCommand("NewLineCancelBTN");
        setLayout(new GridLayout(5, 5));
        
        add(itemNameLabel);
        add(itemNameTextField);
        add(itemPriceLabel);
        add(itemPriceTextField);
        add(itemCountLabel);
        add(itemCountTextField);
        add(newLineOkButton);
        add(newLineCancelButton);
        setModal(true);
        pack();
        
    }

    public JTextField getItemNameTextField() {
        return itemNameTextField;
    }

    public JTextField getItemPriceTextField() {
        return itemPriceTextField;
    }

    public JTextField getItemCountTextField() {
        return itemCountTextField;
    }
    
    
}
