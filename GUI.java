import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    private InventoryManager manager;
    private JTable productTable;
    private DefaultTableModel tableModel;

    public GUI() {
        manager = new InventoryManager();
        setTitle("Inventory Manager");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel panel = new JPanel(null);
        panel.setBounds(10, 10, 780, 350);
        add(panel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 10, 80, 25);
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(100, 10, 165, 25);
        panel.add(nameField);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(10, 40, 80, 25);
        panel.add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(100, 40, 165, 25);
        panel.add(priceField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(10, 70, 80, 25);
        panel.add(quantityLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(100, 70, 165, 25);
        panel.add(quantityField);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(10, 100, 80, 25);
        panel.add(typeLabel);

        String[] types = {"Electronics", "Clothing", "Grocery", "Toys"};
        JComboBox<String> typeCombo = new JComboBox<>(types);
        typeCombo.setBounds(100, 100, 165, 25);
        panel.add(typeCombo);

        JLabel detailLabel = new JLabel("Detail:");
        detailLabel.setBounds(10, 130, 80, 25);
        panel.add(detailLabel);

        JTextField detailField = new JTextField();
        detailField.setBounds(100, 130, 165, 25);
        panel.add(detailField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(10, 170, 80, 25);
        panel.add(addButton);

        JButton editButton = new JButton("Edit");
        editButton.setBounds(100, 170, 80, 25);
        panel.add(editButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(190, 170, 80, 25);
        panel.add(deleteButton);

        // Table
        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Price", "Qty", "Type", "Detail"}, 0);
        productTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productTable);
        scrollPane.setBounds(300, 10, 460, 300);
        panel.add(scrollPane);

        // Add product logic
        addButton.addActionListener(e -> {
            try {
                int id = (int) (Math.random() * 10000);
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                String type = (String) typeCombo.getSelectedItem();
                String detail = detailField.getText();
                Products p = switch (type) {
                    case "Electronics" -> new Electronics(id, name, price, quantity, Integer.parseInt(detail));
                    case "Clothing" -> new Clothing(id, name, price, quantity, detail);
                    case "Grocery" -> new Grocery(id, name, price, quantity, detail);
                    case "Toys" -> new Toys(id, name, price, quantity, detail);
                    default -> null;
                };
                if (p != null) {
                    manager.addProduct(p);
                    tableModel.addRow(new Object[]{p.getId(), p.getName(), price, quantity, type, detail});
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage());
            }
        });

        // Delete logic
        deleteButton.addActionListener(e -> {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow >= 0) {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                manager.removeProductById(id); // You must implement this
                tableModel.removeRow(selectedRow);
            }
        });

        // Edit logic
        editButton.addActionListener(e -> {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow >= 0) {
                try {
                    int id = (int) tableModel.getValueAt(selectedRow, 0);
                    String name = nameField.getText();
                    double price = Double.parseDouble(priceField.getText());
                    int quantity = Integer.parseInt(quantityField.getText());
                    String type = (String) typeCombo.getSelectedItem();
                    String detail = detailField.getText();

                    Products updated = switch (type) {
                        case "Electronics" -> new Electronics(id, name, price, quantity, Integer.parseInt(detail));
                        case "Clothing" -> new Clothing(id, name, price, quantity, detail);
                        case "Grocery" -> new Grocery(id, name, price, quantity, detail);
                        case "Toys" -> new Toys(id, name, price, quantity, detail);
                        default -> null;
                    };

                    if (updated != null) {
                        manager.updateProduct(id, updated); // You must implement this
                        tableModel.setValueAt(name, selectedRow, 1);
                        tableModel.setValueAt(price, selectedRow, 2);
                        tableModel.setValueAt(quantity, selectedRow, 3);
                        tableModel.setValueAt(type, selectedRow, 4);
                        tableModel.setValueAt(detail, selectedRow, 5);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
