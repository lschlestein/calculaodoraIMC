package IMC;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PacienteTesteJUnit5 {
    Paciente paciente;
    double imc;
    double altura;
    double peso;

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Executando antes de cada teste");
        paciente = new Paciente(altura, peso);
    }

    @Test
    public void verificaErroDiagnostico() {
        paciente = new Paciente(0.0, 0.0);
        assertEquals(0.0, paciente.calculaIMC(), 0);
        assertTrue(paciente.diagnostico().equals("Erro de cálculo de IMC"));
    }

    @Test
    public void verificaErroIMC() {
        paciente = new Paciente(0.0, 0.0);
        assertEquals(0.0, paciente.calculaIMC(), 0);
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
