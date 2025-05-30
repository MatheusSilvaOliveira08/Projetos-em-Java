import java.util.Scanner;


public class CalculadoraSimples { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira um número: ");
        double numero1 = scanner.nextDouble();

        System.out.println("Insira outro número: ");
        double numero2 = scanner.nextDouble();

        System.out.println("Escolha o tipo de operação que você deseja realizar: (+, - , * , /)");
        char operador = scanner.next().charAt(0);

        double resultado = 0;

        switch (operador) {
        case '+': 
        resultado = numero1 + numero2; 
        break;

        case '-': 
        resultado = numero1 = numero2; 
        break;

        case '*': 
        resultado = numero1 * numero2; 
        break;

        case '/': 
        if (numero2 != 0) { 
            resultado = numero1 / numero2;
        }
        else { 
            System.out.println("Não se divide por 0...");
        }
        break;
        
        default: 
        System.out.println("Operação inválida");
    }

    System.err.println("O resultado da sua operação é: " + resultado);
    scanner.close();
    }
}
