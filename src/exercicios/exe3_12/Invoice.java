package exercicios.exe3_12;

public class Invoice {
    private String number;
    private String description;
    private int quantityPurchased;
    private double price;

    public Invoice(String number, String description, int quantityPurchased, double price) {
        this.number = number;
        this.description = description;
        this.quantityPurchased = quantityPurchased;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(int quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getInvoiceAmount(){
        int quantity = getQuantityPurchased();
        double price = getPrice();
        if (quantity == 0 || price == 0){
            return 0;
        }
        return quantity*price;
    }
}
