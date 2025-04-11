import java.io.*;
import java.util.ArrayList;

public class Files {
    public static void writeFile(String fileName, ArrayList<Products> list) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();
        } catch (Exception e) {
            System.out.println("Error writing file.");
        }
    }

    public static ArrayList<Products> readFile(String fileName) {
        ArrayList<Products> list = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            list = (ArrayList<Products>) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
        return list;
    }
}

