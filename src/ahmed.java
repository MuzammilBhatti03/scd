import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ahmed {
    private JTextArea textArea1;

    public static void main(String[] args) {
        visible();
    }

    private static DefaultTableModel model;
    private static JTable table;
    private static JTextField nameField;
    private static JTextField priceField;
    private static JTextField quantityField;
    private static JLabel totalPriceLabel;

    private static void visible() {
        JFrame frame = new JFrame("LAB6");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Quantity");
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel inputPanel = new JPanel(new FlowLayout());


        nameField = new JTextField(20);
        priceField = new JTextField(20);
        quantityField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        totalPriceLabel = new JLabel("Total: ");
        inputPanel.add(totalPriceLabel, BorderLayout.NORTH);

        frame.setVisible(true);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ADD();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFromTable();
            }
        });


    }

    private static void ADD() {
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());
        model.addRow(new Object[]{name, price, quantity});
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
        setTotalLabel();
    }

    private static void deleteFromTable() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
            setTotalLabel();
        }
    }

    private static void setTotalLabel() {
        double totalPrice = 0.0;
        for (int row = 0; row < model.getRowCount(); row++) {
            double price = (double) model.getValueAt(row, 1);
            int quantity = (int) model.getValueAt(row, 2);
            totalPrice += price * quantity;
        }
        totalPriceLabel.setText("Total: " + totalPrice);
    }
}