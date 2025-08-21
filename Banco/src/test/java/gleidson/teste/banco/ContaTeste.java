package gleidson.teste.banco;
import gleidson.banco.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ContaTeste {

    @Test
    public void testarCreditoDebito() {
        Conta c1 = new Conta(1);
        c1.credito(20);
        c1.debito(10);
        assertEquals(10, c1.getSaldo(), 0.001);
    }

    @Test
    public void testarExtrato() {
        Conta c1 = new Conta(1);
        c1.credito(20);
        c1.debito(10);
        c1.credito(2);
        c1.debito(1);
        System.out.println(c1.getExtrato());
        assertEquals("Conta: 1. Credito: 20.0. Saldo: 20.0.\n"
                + "Conta: 1. Debito: 10.0. Saldo: 10.0.\n"
                + "Conta: 1. Credito: 2.0. Saldo: 12.0.\n"
                + "Conta: 1. Debito: 1.0. Saldo: 11.0.\n", c1.getExtrato());
    }

    @Test
    public void testarPessoaConta() {
        Conta c1 = new Conta(1);
        Pessoa p1 = new Pessoa(1, "Pedro", "123456");
        p1.setConta(c1);
        c1.setDono(p1);
        assertEquals("Pedro", c1.getDono().getNome());
        assertEquals(1, p1.getConta().getNumero());
        assertEquals(1, c1.getDono().getCpf());
    }
}
