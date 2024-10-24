import java.util.Scanner;

public class Lição5 {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("\nDigite sua altura (em metros): ");
        double altura = entrada.nextDouble();
        
        System.out.print("\nDigite seu peso (em kg): ");
        double peso = entrada.nextDouble();
        
        double imc = peso / (altura * altura);
        
        System.out.printf("\nSeu IMC é: %.2f%n", imc);

        entrada.close();
    }
}