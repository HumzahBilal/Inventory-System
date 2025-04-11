import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI {
    InventoryManager manager = new InventoryManager();

    public GUI() {
        JFrame frame = new JFrame("Inventory System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        place(panel);
        frame.setVisible(true);
    }

    public void place(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField();
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        JButton addBtn = new JButton("Add Item");
        addBtn.setBounds(10, 60, 120, 25);
        panel.add(addBtn);

        JTextArea area = new JTextArea();
        area.setBounds(10, 100, 350, 150);
        panel.add(area);

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                Products p = new Electronics((int)(Math.random() * 1000), name, 10.99, 5, 1);
                manager.addProduct(p);
                area.setText("Item Added:\n");
                ArrayList<Products> items = manager.getInventory();
                for (Products prod : items) {
                    area.append(prod.getName() + "\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        new GUI();
    }
}
