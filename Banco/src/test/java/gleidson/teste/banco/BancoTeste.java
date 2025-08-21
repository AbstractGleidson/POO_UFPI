package gleidson.teste.banco;
import gleidson.banco.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class BancoTeste {

    @Test
    public void testarCadastroDePessoa() {
        Pessoa p = new Pessoa(1, "Pedro", "123456");
        Banco b = new Banco();

        assertTrue(b.cadastrarPessoa(p));
        assertFalse(b.cadastrarPessoa(p));
    }

    @Test
    public void testarCadastroDeConta() {
        Pessoa p = new Pessoa(1, "Pedro", "123456");
        Conta c = new Conta(1);
        Banco b = new Banco();

        assertTrue(b.cadastrarPessoa(p));

        assertTrue(b.cadastrarConta(c, 1));
        assertFalse(b.cadastrarConta(c, 1));
    }

    @Test
    public void testarDeposito() {
        Pessoa p = new Pessoa(1, "Pedro", "123456");
        Conta c = new Conta(1);
        Banco b = new Banco();

        assertTrue(b.cadastrarPessoa(p));

        assertTrue(b.cadastrarConta(c, 1));
        b.deposito(1, 1500);
        assertEquals(1500, b.saldo(1, "123456"), 0.0001);
    }
}
