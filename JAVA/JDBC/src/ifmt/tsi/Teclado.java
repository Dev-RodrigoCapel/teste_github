package ifmt.tsi;

import java.util.Scanner;

public class Teclado {

    public static String leString(String rotulo) {
        System.out.println(rotulo);
        Scanner scann = new Scanner(System.in);
        return scann.nextLine();
    }

    public static int leInt(String rotulo) {
        System.out.println(rotulo);
        Scanner scann = new Scanner(System.in);
        return scann.nextInt();
    }

    public static double leDouble(String rotulo) {
        System.out.println(rotulo);
        Scanner scann = new Scanner(System.in);
        return scann.nextDouble();
    }

}
