/* Implemente no Eclipse uma classe chamada Paciente que possui um construtor que recebe o seu peso em quilos
e sua altura em metros, ambos utilizando o tipo double. Crie um método chamado calcularIMC() que calcula o índice de
Massa Corporal de acordo com a fórmula IMC = peso (quilos) / (altura * altura (metros)). Crie também um método chamado
diagnostico() que utiliza o método calcularIMC() e retorna uma String de acordo com as seguintes faixas de valor: */

package IMC;

public class Paciente {
    private String nome;
    private double peso;
    private double altura;

    public  Paciente(double altura, double peso) {
        this.peso = peso;
        this.altura = altura;
    }

    public Paciente (String nome, double altura, double peso) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
    }

    public double calculaIMC() {
        if (altura != 0 && peso != 0) {
           return peso / (Math.pow(altura, 2));
        }
        else
            System.out.println("Verifique os dados do IMC");
        return 0;
    }

    /*Baixo peso muito grave = IMC abaixo de 16 kg/m²
    Baixo peso grave = IMC entre 16 e 16,99 kg/m²
    Baixo peso = IMC entre 17 e 18,49 kg/m²
    Peso normal = IMC entre 18,50 e 24,99 kg/m²
    Sobrepeso = IMC entre 25 e 29,99 kg/m²
    Obesidade grau I = IMC entre 30 e 34,99 kg/m²
    Obesidade grau II = IMC entre 35 e 39,99 kg/m²
    Obesidade grau III (obesidade mórbida) = IMC igual ou maior que 40 kg/m²*/

    public String diagnostico() {
        double IMC = calculaIMC();
        if (IMC == 0) return "Erro de cálculo de IMC";
        else if (IMC < 16) return "Baixo peso muito grave = IMC abaixo de 16 kg/m²";
        else if (IMC <= 16.99) return "Baixo peso grave = IMC entre 16 e 16,99 kg/m²";
        else if (IMC <= 18.49) return "Baixo peso = IMC entre 17 e 18,49 kg/m²";
        else if (IMC <= 24.99) return "Peso normal = IMC entre 18,50 e 24,99 kg/m²";
        else if (IMC <= 29.99) return "Sobrepeso = IMC entre 25 e 29,99 kg/m²";
        else if (IMC <= 34.99) return "Obesidade grau I = IMC entre 30 e 34,99 kg/m²";
        else if (IMC <= 39.99) return "Obesidade grau II = IMC entre 35 e 39,99 kg/m²";
        else return "Obesidade grau III (obesidade mórbida) = IMC igual ou maior que 40 kg/m²";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        String IMC = String.format("%.2f",this.calculaIMC());
        return "O pac. "+nome+" tem IMC: "+IMC+" e seu diag. é "+diagnostico();
    }
}
