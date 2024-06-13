# calculaodoraIMC
Exemplo básico de programação orientada a objetos onde é implementada uma calculadora para cálculo do IMC de uma pessoa.
Também nesse mesmo código foi criando um DockerFile, para criação de uma imagem, sendo possível rodar essa aplicação via container Docker.
## Testes

PacienteTesteJunit5.class
Os testes, são uma etapa muito importante do desenvolvilmento de nossas aplicações. Podemos com eles, dada uma certa entrada, garantir que a saída de um determinado método seja testada.
Uma classe de teste, é uma classe Java qualquer, com algumas anotações, que fazer com que o compilador reconheça, por exemplo os métodos anotados com *@Test*, como um teste a ser executado.
A anotação *@BeforeEach* é executada antes de cada teste contido na classe, podendo ser utilizada para organizar as instâncias necessárias que antecedem os testes em si.
As anotações que começa com *Assert*, são afirmações (assertEquals, assertTrue), que uma determinada condição está sendo atendida.
``` Java
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
```

Mais informações:
[JUnit5](https://junit.org/junit5/)
