import java.util.Scanner;

public class Lição3 {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Digite um número: ");
        int numero = entrada.nextInt();
        
        if (numero % 2 == 0) {
            System.out.println("\nO número " + numero + " é par.");
        } else {
            System.out.println("\nO número " + numero + " é ímpar.");
        }

        entrada.close();
    }
}