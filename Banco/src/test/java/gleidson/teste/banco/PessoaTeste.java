package gleidson.teste.banco;
import gleidson.banco.Pessoa;
import org.junit.Test;
import static org.junit.Assert.*;

// Testes dos metodos da classe Pessoa
public class PessoaTeste {

    // Testa o metodo validar do classe Pessoa
    @Test
    public void testValidar()
    {

        Pessoa pessoaValida = new Pessoa(1, "Gleidson", "12345");
        assertTrue(pessoaValida.validar()); // Teste com valores validos

        Pessoa pessoaInvalida = new Pessoa(2, "Pateta", "12345");

        pessoaInvalida.setNome("");
        assertFalse(pessoaInvalida.validar()); // Teste com nome invalido

        pessoaInvalida.setNome("Pateta");
        pessoaInvalida.setCpf(0);
        assertFalse(pessoaInvalida.validar()); // Teste com CPF invalido

        pessoaInvalida.setCpf(2);
        pessoaInvalida.setNome(null);
        assertFalse(pessoaInvalida.validar()); // Teste com nome null
    }
}
