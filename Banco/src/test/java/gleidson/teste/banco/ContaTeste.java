package gleidson.teste.banco;
import gleidson.banco.*;

import org.junit.Test;

import static org.junit.Assert.*;

// Testa a classe Conta
public class ContaTeste {

    // Testa o Metodo credito
    @Test
    public void testaCreditoDebito() {
        Conta conta = new Conta(1); // Conta comeca com 0

        conta.credito(10); // Adiciona 10 ao saldo

        assertEquals(10, conta.getSaldo(), 0.001);

        conta.credito(190.5);
        assertEquals(200.5, conta.getSaldo(), 0.001);

    }

    // Testa o Metodo Debito
    @Test
    public void testaDebito() {
        Conta conta = new Conta(1); // Conta comeca com 0

        conta.credito(200); // Adiciona 200 ao saldo
        conta.debito(50); // Tira 50 do saldo
        assertEquals(150, conta.getSaldo(), 0.001);

        conta.debito(1.99999);
        assertEquals(148.00001, conta.getSaldo(), 0.001);

    }

    // Testa o extrato da conta
    @Test
    public void testaExtrato() {
        Conta conta = new Conta(1);
        conta.credito(20);
        conta.debito(10);
        conta.credito(2);
        conta.debito(1);

        assertEquals(
                "Conta: 1. Credito: 20.00. Saldo: 20.00.\n" +
                        "Conta: 1. Debito: 10.00. Saldo: 10.00.\n" +
                        "Conta: 1. Credito: 2.00. Saldo: 12.00.\n" +
                        "Conta: 1. Debito: 1.00. Saldo: 11.00.\n",
                conta.getExtrato()); // Testa o extrato
    }

    @Test
    public void testaAutenticacao()
    {
        Pessoa pessoa = new Pessoa(1, "Pateta", "Pateta123");
        Conta conta = new Conta(1);

        conta.setDono(pessoa); // Associa conta a pessoa

        assertTrue(conta.autenticacao("Pateta123")); // Valida uma senha correta
        assertFalse(conta.autenticacao("Pateta")); // Invalida uma senha incorreta
    }

    @Test
    public void testaTemDono()
    {
        Conta conta = new Conta(1);

        assertFalse(conta.temDono()); // Conta nao esta vinculada a uma pessoa

        Pessoa pessoa = new Pessoa(1, "Pateta", "Pateta123");
        conta.setDono(pessoa); // Associa conta a pessoa

        assertTrue(conta.temDono()); // Conta esta vinculada a uma pessoa
    }
}
