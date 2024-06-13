package IMC;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/*
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
 */

public class PacienteTesteJunit4 {
    Paciente paciente;
    double imc;
    double altura;
    double peso;

    @Before
    public void setUp() throws Exception {
        altura = 0;
        peso = 0;
        imc = 0;
        paciente = new Paciente(altura, peso);
    }

    @Test
    public void verificaDiagnostico() {
        paciente = new Paciente(0.0, 0.0);
        assertTrue(paciente.diagnostico().equals("Erro de cálculo de IMC"));
        paciente = new Paciente(1.7, 70);
    }

    @Test
    public void verificaIMCNormal() {
        paciente = new Paciente(1.7, 70);
        double imc = paciente.calculaIMC();
        assertEquals(imc, 22, 3.5);
        assertTrue(paciente.diagnostico().equals("Peso normal = IMC entre 18,50 e 24,99 kg/m²"));
    }

    @Test
    public void verificaIMCSobrepeso() {
        paciente = new Paciente(1.6, 70);
        double imc = paciente.calculaIMC();
        assertEquals(imc, 27.35, 0.1);
        assertTrue(paciente.diagnostico().equals("Sobrepeso = IMC entre 25 e 29,99 kg/m²"));
    }
}