package exercicios.exe3_12;

public class InvoiceTest {
    public static void main(String[] args) {
        Invoice invoice = new Invoice("1100001111010111", "Testing invoice class", 124, 12.40);
        System.out.println("Invoice Number: " + invoice.getNumber());
        System.out.println("Invoice Description: " + invoice.getDescription());
        System.out.println("Quantity Purchase: " + invoice.getQuantityPurchased() + " unities");
        System.out.printf("Price For Unity: $ %.2f\n", invoice.getPrice());
        System.out.printf("Invoice's Amount: $ %.2f\n", invoice.getInvoiceAmount());

        invoice.setQuantityPurchased(0);
        System.out.printf("Invoice's Amount (with quantity = 0): $ %.2f\n", invoice.getInvoiceAmount());
        invoice.setQuantityPurchased(50135);
        invoice.setPrice(0.00);
        System.out.printf("Invoice's Amount (with price = 0.00): $ %.2f\n", invoice.getInvoiceAmount());
        invoice.setPrice(101.24);
        System.out.printf("Invoice's Amount (normal): $ %.2f\n", invoice.getInvoiceAmount());

    }
}
