import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Files {
    public void writeFile(String filename, ArrayList<Products> list) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename));
            for (Products p : list) {
                String line = p.getType() + "," + p.toFileString();
                writer.println(line);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public ArrayList<Products> readFile(String filename) {
        ArrayList<Products> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                int id = Integer.parseInt(parts[1]);
                String name = parts[2];
                double price = Double.parseDouble(parts[3]);
                int quantity = Integer.parseInt(parts[4]);

                Products p = null;

                if (type.equals("Electronics")) {
                    int warranty = Integer.parseInt(parts[5]);
                    p = new Electronics(id, name, price, quantity, warranty);
                } else if (type.equals("Clothing")) {
                    String size = parts[5];
                    p = new Clothing(id, name, price, quantity, size);
                } else if (type.equals("Grocery")) {
                    String expiry = parts[5];
                    p = new Grocery(id, name, price, quantity, expiry);
                } else if (type.equals("Toys")) {
                    String brand = parts[5];
                    p = new Toys(id, name, price, quantity, brand);
                } else {
                    p = new Products(id, name, price, quantity);
                }

                list.add(p);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return list;
    }
}
