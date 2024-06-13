package IMC;


import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PacienteTesteJUnit5 {
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
