package gleidson.banco;

public class Banco {

    private Conta[] contas = new Conta[50];
    private int posContas = 0;
    private Pessoa[] pessoas = new Pessoa[50];
    private int posPessoas = 0;

    public boolean cadastrarPessoa(Pessoa p) {
        if (p.validar() && pesquisarPessoa(p.getCpf()) == null) {
            pessoas[posPessoas++] = p;
            return true;
        } else {
            System.out.println("Pessoa inválida ou já cadastrada.");
            return false;
        }
    }

    private Pessoa pesquisarPessoa(int cpf) {
        for (int i = 0; i < posPessoas; i++) {
            if (pessoas[i].getCpf() == cpf) {
                return pessoas[i];
            }
        }
        return null;
    }

    public boolean cadastrarConta(Conta c, int cpf) {
        Pessoa p = pesquisarPessoa(cpf);
        if (c.validar() && p != null && pesquisarConta(c.getNumero()) == null) {
            contas[posContas++] = c;
            c.setDono(p);
            p.setConta(c);
            return true;
        } else {
            System.out.println("Conta inválida ou já cadastrada.");
            return false;
        }
    }

    private Conta pesquisarConta(int num) {
        for (int i = 0; i < posContas; i++) {
            if (contas[i].getNumero() == num) {
                return contas[i];
            }
        }
        return null;
    }

    public double saldo(int num, String passwd) {
        Conta c = pesquisarConta(num);
        if (c != null) {
            if (c.getDono().getSenha() == passwd) {
                return c.getSaldo();
            }
        }
        return -9999999;
    }

    public void deposito(int num, double v) {
        Conta c = pesquisarConta(num);
        if (c != null && v > 0) {
            c.credito(v);
        } else {
            System.out.println("Conta inexistente ou valor inválido.");
        }
    }

    public void saque() {

    }

    public String extrato() {
        return "";
    }

    public void transfere() {

    }
}
