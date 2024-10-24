import java.util.Scanner;

public class Lição2 {
    
    public static void main(String[] args) {
        
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("\nDigite o primeiro número: ");
        double num1 = entrada.nextDouble();
        
        System.out.print("\nDigite o segundo número: ");
        double num2 = entrada.nextDouble();
        
        double soma = num1 + num2;
        double subtracao = num1 - num2;
        double multiplicacao = num1 * num2;
        
        if (num2 != 0) {
            double divisao = num1 / num2;
            System.out.println("\nDivisão: " + divisao);
        } else {
            System.out.println("\nErro: Divisão por zero não é permitida.");
        }

        System.out.println("\nSoma: " + soma);
        System.out.println("\nSubtração: " + subtracao);
        System.out.println("\nMultiplicação: " + multiplicacao);

        entrada.close();
    }
}