package IMC;

import java.util.Scanner;

public class Main {
    static String nome = null;
    static Double altura = 0.0;
    static Double peso = 0.0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {;
        Paciente p1 = new Paciente(1.77, 200);
        Paciente p2 = new Paciente(1.57, 50);
        Paciente p3 = new Paciente(1.59, 55);
        p1.setNome("John");
        p2.setNome("Jane");
        p3.setNome("Doe");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());

    }

    public static void lerParametros() {
        try {
            System.out.println("Digite seu Nome: ");
            nome = sc.nextLine();
            System.out.println(nome + " agora digite sua altura: ");
            altura = Double.parseDouble(trataParametros(sc.nextLine()));
            System.out.println(nome + " agora digite seu peso: ");
            peso = Double.parseDouble(trataParametros(sc.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Por favor informe digite um número válido");
        }
    }

    public static String trataParametros(String parametro) {
        parametro = parametro.replace(',', '.');
        return parametro;
    }
}