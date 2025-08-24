package gleidson.teste.banco;
import gleidson.banco.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class BancoTeste {

    // Testa o metodo de cadastraPessoa
    @Test
    public void testaCadastroPessoa() {
        Pessoa pessoa = new Pessoa(1, "Pedro", "123456");
        Banco banco = new Banco();

        assertTrue(banco.cadastrarPessoa(pessoa));
        assertFalse(banco.cadastrarPessoa(pessoa));
    }

    // Testa o metodo casdastrarConta
    @Test
    public void testarCadastroConta() {
        Pessoa pessoa1 = new Pessoa(1, "Pedro", "123456");
        Pessoa pessoa2 = new Pessoa(2, "Jose", "1234");
        Conta conta1 = new Conta(1);
        Conta conta2 = new Conta(2);

        Banco banco = new Banco();

        assertTrue(banco.cadastrarPessoa(pessoa1));
        assertTrue(banco.cadastrarPessoa(pessoa2));

        assertTrue(banco.cadastrarConta(conta1, 1));
        assertFalse(banco.cadastrarConta(conta1, 2)); // Tenta cadastrar uma pessoa a uma conta que ja tem dono

        assertFalse(banco.cadastrarConta(conta2, 1)); // Tenta cadastrar uma conta com uma pessoa que ja tem conta
        assertTrue(banco.cadastrarConta(conta2, 2));
    }

    // Testa o metodo de deposito
    @Test
    public void testarDeposito() {
        Pessoa pessoa = new Pessoa(1, "Pedro", "123456");
        Conta conta = new Conta(1);
        Banco banco = new Banco();

        assertTrue(banco.cadastrarPessoa(pessoa));

        assertTrue(banco.cadastrarConta(conta, 1));
        banco.deposito(1, 1500);
        assertEquals(1500, banco.saldo(1, "123456"), 0.0001);
    }

    // Testa o metodo de saque
    // Testa o metodo de deposito
    @Test
    public void testaSaque() {
        Pessoa pessoa = new Pessoa(1, "Pedro", "123456");
        Conta conta = new Conta(1);
        Banco banco = new Banco();

        assertTrue(banco.cadastrarPessoa(pessoa));

        assertTrue(banco.cadastrarConta(conta, 1));
        banco.deposito(1, 1500);
        banco.saque(1, 300, "123456");
        assertEquals(1200, banco.saldo(1, "123456"), 0.0001); // Testa o valor

        assertFalse(banco.saque(1,3000, "123456")); // Testa por valor invalido

        assertFalse(banco.saque(1, 200, "123")); // Testa por senha invalida
    }

    // Testa o metodo transferencia
    @Test
    public void testeTransferencia()
    {
        Pessoa pessoa1 = new Pessoa(1, "Pedro", "123456");
        Pessoa pessoa2 = new Pessoa(2, "Paulo", "12345");
        Conta contaPessoa1 = new Conta(1);
        Conta contaPessoa2 = new Conta(2);

        Banco banco = new Banco();

        banco.cadastrarPessoa(pessoa1);
        banco.cadastrarPessoa(pessoa2);

        banco.cadastrarConta(contaPessoa1, 1);
        banco.cadastrarConta(contaPessoa2, 2);

        banco.deposito(1, 1000); // Deposita 1000 na conta 1

        banco.transferencia(1, "123456", 200, 2);

        assertEquals(800, contaPessoa1.getSaldo(), 000.1); // Verifica o saldo da conta 1
        assertEquals(200, contaPessoa2.getSaldo(), 000.1); // Verifica o saldo da conta 2
    }
}
