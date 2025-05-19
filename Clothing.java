public class Clothing extends Products {
    private String size;

    public Clothing(int id, String name, double price, int quantity, String size) {
        super(id, name, price, quantity);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Size: " + size);
    }

    @Override
    public String getType() {
        return "Clothing";
    }

    @Override
    public String toFileString() {
        return super.toFileString() + "," + size;
    }
}



