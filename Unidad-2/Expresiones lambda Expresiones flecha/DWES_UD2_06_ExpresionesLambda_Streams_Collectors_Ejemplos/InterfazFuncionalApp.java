import java.util.Scanner;

@FunctionalInterface
public interface IFuncionalCalculo {
	public void calcula(int a, int b);	
}

public class InterfazFuncionalApp {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        IFuncionalCalculo suma=(a, b) -> {
            System.out.println(a + b);
        };
        IFuncionalCalculo esDivisor=(a, b) -> {
            System.out.println(a%b==0);
        };
        System.out.println("Dame el 1º número:");
        int valor1=leer.nextInt();
        System.out.println("Dame el 2º número:");
        int valor2=leer.nextInt();
        System.out.print("Suma=");
        suma.calcula( valor1, valor2);
        System.out.print("¿El 2º es divisor del 1º?");
        esDivisor.calcula(valor1, valor2);
        leer.close();
    }
}