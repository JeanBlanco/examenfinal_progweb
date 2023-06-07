package punta_java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Binario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese un número en base 8: ");
            int baseOcho = scanner.nextInt();

            if (baseOcho < 0) {
                System.out.println("El número debe ser un valor positivo.");
                return;
            }

            String binaryString = convertOctalToBinary(baseOcho);

            System.out.println("Correspondiente en binario: " + binaryString);
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número válido en base 8.");
        } finally {
            scanner.close();
        }
    }

    public static String convertOctalToBinary(int octalNumber) {
        int decimalNumber = 0;
        int power = 0;

        while (octalNumber != 0) {
            int digit = octalNumber % 10;
            decimalNumber += digit * Math.pow(8, power);
            power++;
            octalNumber /= 10;
        }

        return Integer.toBinaryString(decimalNumber);
    }
}
