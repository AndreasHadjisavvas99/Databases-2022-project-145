import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
public class DynamicTable
{
    //TextField
    private JTextField text1, text2, text3, text4;

    // JTable Header
    public static final String[] columns = {
            "Name", "Age", "Address"
    };
    // Create the table model
    private DefaultTableModel model = new DefaultTableModel(columns, 0);
    // Create the JTable
    private JTable table = new JTable(model);
    // Create the main panel
    private JPanel mainPanel = new JPanel(new BorderLayout());
    public DynamicTable()
    {
        //Add button
        JButton addButton = new JButton("+ Add");
        //Clear button
        JButton clearButton = new JButton("Clear");
        //Button panel
        JPanel buttonPanel = new JPanel();
        //Add buttons to panel
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);

        // This code is called when the Add button is clicked.
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add form data
                model.addRow(
                        new Object[]{
                                text1.getText(),
                                text2.getText(),
                                text3.getText()
                        }
                );
            }
        });

        // This code is called when the Clear button is clicked.
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clear the form
                text1.setText("");
                text2.setText("");
                text3.setText("");
            }
        });

        //Create the JTextFields panel
        JPanel textPanel = new JPanel(new BorderLayout());
        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        //Add JTextFields to the panel
        textPanel.add(text1, BorderLayout.NORTH);
        textPanel.add(text2, BorderLayout.CENTER);
        textPanel.add(text3, BorderLayout.SOUTH);

        //Add panels and table to the main panel
        mainPanel.add(textPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }
    //Get the main panel
    public JComponent getComponent() {
        return mainPanel;
    }
    // start the application in thread-safe
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame("Add automatically to JTable");
                f.getContentPane()
                        .add(new DynamicTable().getComponent());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(340,250);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
}