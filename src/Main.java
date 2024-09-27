import models.Customer;
import models.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opc = -1;
        double cardBalance = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba el límite de la tarjeta $:");
        cardBalance = sc.nextDouble();
        // Consumir la nueva línea que queda en el buffer después de nextInt()
        sc.nextLine();

        Customer customer = new Customer(cardBalance);

        while (opc != 0) {
            Product product = new Product();

            System.out.println("\nEscriba la descripción de la compra:");
            product.setName(sc.nextLine());

            System.out.println("Escriba el valor de la compra $:");
            product.setPrice(sc.nextDouble());
            // Consumir la nueva línea que queda en el buffer después de nextInt()
            sc.nextLine();

            boolean verify = customer.addProduct(product);

            if (!verify) {
                System.out.println("\nSaldo insuficiente!\n");
                customer.showProducts();
                System.out.println("Saldo de la tarjeta: $" + customer.getBalance());
                return;
            }

            System.out.println("\nCompra realizada!");
            System.out.println("\nEscribra 0 para salir o 1 para continuar");
            opc = sc.nextInt();
            // Consumir la nueva línea que queda en el buffer después de nextInt()
            sc.nextLine();

            if (opc == 0) {
                customer.showProducts();
                System.out.println("\nSaldo de la tarjeta: $" + customer.getBalance() + "\n");
            }
        }


    }
}