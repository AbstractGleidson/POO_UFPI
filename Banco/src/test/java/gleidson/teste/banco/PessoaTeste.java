package gleidson.teste.banco;
import gleidson.banco.Pessoa;
import org.junit.Test;
import static org.junit.Assert.*;

public class PessoaTeste {

    // Teste do metodo get Pessoa
    @Test
    public void testGetPessoa()
    {
        Pessoa pessoa = new Pessoa(1, "Gleidson", "12345");
        assertEquals("Gleidson", pessoa.getNome());
    }
}
