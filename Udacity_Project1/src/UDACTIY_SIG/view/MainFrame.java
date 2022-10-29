package UDACTIY_SIG.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import UDACTIY_SIG.controller.MainListener;
import UDACTIY_SIG.model.Header;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        initComponents2();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceHeaderTable = new javax.swing.JTable();
        createNewInvoiceBtn = new javax.swing.JButton();
        deleteInvoiceBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        createNewLineBtn = new javax.swing.JButton();
        deleteLineBtn = new javax.swing.JButton();
        invoiceNumLbl = new javax.swing.JLabel();
        invoiceDateLbl = new javax.swing.JLabel();
        custNameLbl = new javax.swing.JLabel();
        invoiceTotalLbl = new javax.swing.JLabel();
        invoiceNumLblVal = new javax.swing.JLabel();
        invoiceDateLblVal = new javax.swing.JLabel();
        custNameLblVal = new javax.swing.JLabel();
        invoiceTotalLblVal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoiceLinesTable = new javax.swing.JTable();
        salesInvoiceFrameMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadFileMenuItem = new javax.swing.JMenuItem();
        saveFileMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoiceHeaderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(invoiceHeaderTable);

        createNewInvoiceBtn.setText("Create New Invoice");

        deleteInvoiceBtn.setText("Delete Invoice");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createNewInvoiceBtn)
                .addGap(18, 18, 18)
                .addComponent(deleteInvoiceBtn)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(423, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createNewInvoiceBtn)
                    .addComponent(deleteInvoiceBtn))
                .addGap(52, 52, 52))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(353, Short.MAX_VALUE)))
        );

        createNewLineBtn.setText("Create Item");

        deleteLineBtn.setText("Delete Item");

        invoiceNumLbl.setText("Invoice Number");

        invoiceDateLbl.setText("Invoice Date");

        custNameLbl.setText("Customer Name");

        invoiceTotalLbl.setText("Invoice Total");

        invoiceNumLblVal.setText("Invoice Num Value");

        invoiceDateLblVal.setText("Invoice Date Value");

        custNameLblVal.setText("Customer Name Value");

        invoiceTotalLblVal.setText("Invoice Total Value");

        jScrollPane2.setViewportView(invoiceLinesTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(createNewLineBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(deleteLineBtn)
                .addGap(39, 39, 39))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(invoiceNumLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 77, Short.MAX_VALUE)
                                    .addComponent(invoiceDateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(custNameLbl)
                                .addComponent(invoiceTotalLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(invoiceDateLblVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(custNameLblVal, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                .addComponent(invoiceTotalLblVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(invoiceNumLblVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(434, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createNewLineBtn)
                    .addComponent(deleteLineBtn))
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(invoiceNumLbl)
                        .addComponent(invoiceNumLblVal))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(invoiceDateLbl)
                        .addComponent(invoiceDateLblVal))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(custNameLbl)
                        .addComponent(custNameLblVal))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(invoiceTotalLbl)
                        .addComponent(invoiceTotalLblVal))
                    .addGap(28, 28, 28)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(198, Short.MAX_VALUE)))
        );

        fileMenu.setText("File");

        loadFileMenuItem.setText("Load File");
        fileMenu.add(loadFileMenuItem);

        saveFileMenuItem.setText("Save File");
        fileMenu.add(saveFileMenuItem);

        salesInvoiceFrameMenuBar.add(fileMenu);

        setJMenuBar(salesInvoiceFrameMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initComponents2()
   {
        SIListener = new MainListener(this);
        createNewInvoiceBtn.addActionListener(SIListener);
        deleteInvoiceBtn.addActionListener(SIListener);
        createNewLineBtn.addActionListener(SIListener);
        deleteLineBtn.addActionListener(SIListener);
        loadFileMenuItem.addActionListener(SIListener);
        saveFileMenuItem.addActionListener(SIListener);
        invoiceHeaderTable.getSelectionModel().addListSelectionListener(SIListener);
        
   }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame SIFrame = new MainFrame();
                SIFrame.setVisible(true);
                SIFrame.SIListener.loadFilesIntoFrame("InvoiceHeader.csv" , "InvoiceLine.csv");
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createNewInvoiceBtn;
    private javax.swing.JButton createNewLineBtn;
    private javax.swing.JLabel custNameLbl;
    private javax.swing.JLabel custNameLblVal;
    private javax.swing.JButton deleteInvoiceBtn;
    private javax.swing.JButton deleteLineBtn;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel invoiceDateLbl;
    private javax.swing.JLabel invoiceDateLblVal;
    private javax.swing.JTable invoiceHeaderTable;
    private javax.swing.JTable invoiceLinesTable;
    private javax.swing.JLabel invoiceNumLbl;
    private javax.swing.JLabel invoiceNumLblVal;
    private javax.swing.JLabel invoiceTotalLbl;
    private javax.swing.JLabel invoiceTotalLblVal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadFileMenuItem;
    private javax.swing.JMenuBar salesInvoiceFrameMenuBar;
    private javax.swing.JMenuItem saveFileMenuItem;
    // End of variables declaration//GEN-END:variables
    private MainListener SIListener;
    public static DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private ArrayList<Header> invoices;
    
    public ArrayList<Header> getInvoices()
    {
        if(invoices == null)
        {
            invoices = new ArrayList<>();
    }
        return invoices;
    }

    public JTable getInvoicesHeadersTable() {
        return invoiceHeaderTable;
       }

    public JTable getInvoiceLinesTable() {
    return invoiceLinesTable;    
    }

    public JLabel getCustNameLblVal() {
        return custNameLblVal;
    }

    public JLabel getInvoiceDateLblVal() {
        return invoiceDateLblVal;
    }

    public JLabel getInvoiceNumLblVal() {
        return invoiceNumLblVal;
    }

    public JLabel getInvoiceTotalLblVal() {
        return invoiceTotalLblVal;
    }
    
    public MainListener getSalesInvoiceListener() {
        return SIListener;
    }
    
    

}
