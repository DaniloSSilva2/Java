import java.util.Scanner;

public class Lição4 {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Digite a primeira nota: ");
        double nota1 = entrada.nextDouble();
        
        System.out.print("\nDigite a segunda nota: ");
        double nota2 = entrada.nextDouble();
        
        System.out.print("\nDigite a terceira nota: ");
        double nota3 = entrada.nextDouble();
        
        double media = (nota1 + nota2 + nota3) / 3;
        
        System.out.println("\nMédia do aluno: " + media);
        
        if (media >= 7) {
            System.out.println("\nAluno aprovado!");
        } else {
            System.out.println("\nAluno reprovado!");
        }

        entrada.close();
    }
}