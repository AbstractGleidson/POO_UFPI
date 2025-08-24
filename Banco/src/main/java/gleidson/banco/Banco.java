package gleidson.banco;

public class Banco {

    private Conta[] contas = new Conta[50]; // Guarda a quantidade de pessoas
    private int posContas = 0; // Controla a quantidade de contas no banco
    private Pessoa[] pessoas = new Pessoa[50]; // Guarda a quantidade de pessoas
    private int posPessoas = 0; // Controla a quantidade de clientes no banco

    // Registra uma pessoa no banco
    public boolean cadastrarPessoa(Pessoa p) {
        if (p.validar() && pesquisarPessoa(p.getCpf()) == null) {
            pessoas[posPessoas++] = p;
            return true;
        } else {
            System.out.println("Pessoa inválida ou já cadastrada.");
            return false;
        }
    }

    // Verifica se a pessoa ja esta registrada no banco
    private Pessoa pesquisarPessoa(int cpf) {
        for (int i = 0; i < posPessoas; i++) {
            if (pessoas[i].getCpf() == cpf) {
                return pessoas[i];
            }
        }
        return null;
    }

    // Cadastra uma conta no banco, se a pessoa ja estiver cadastrada no banco
    public boolean cadastrarConta(Conta conta, int cpf) {
        // Verifica se a pessoa ja esta cadastrada no banco
        Pessoa pessoa = pesquisarPessoa(cpf);

        if (conta.validar() && pessoa != null && !(pessoa.temConta()) && !(contaExiste(conta))) {
            contas[posContas++] = conta;
            conta.setDono(pessoa);
            pessoa.setConta(conta);
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

    // Retorna o saldo da conta
    public double saldo(int num, String passwd) {
        Conta conta = pesquisarConta(num); // Tenta achar a conta

        if (conta != null && conta.autenticacao(passwd)) {
                return conta.getSaldo();
            }

        return -9999999;
    }

    // Deposita um valor na conta
    public boolean deposito(int numeroConta, double valor) {
        Conta conta = pesquisarConta(numeroConta); // Tenta achar a conta

        if (conta != null && valor > 0) {
            conta.credito(valor);
            return true; // Se der certo a operacao
        }
        System.out.println("Conta inexistente ou valor inválido.");
        return false; // Se der errado a operacao
    }

    public boolean saque(int numeroConta, double valor, String senhaDono) {
        Conta conta = pesquisarConta(numeroConta);

        if(conta != null && conta.autenticacao(senhaDono) && valor > 0 && conta.getSaldo() >= valor)
        {
            conta.debito(valor); // Se a opercao for legitima
            return true; // Se a operacao der certo
        }

        return false; // Se a operacao der errado
    }

    // Retorna o extrato da conta
    public String extrato(int numeroConta, String senhaConta) {
        Conta conta = pesquisarConta(numeroConta); // Tenta achar conta

        if (conta != null && conta.autenticacao(senhaConta))
            return conta.getExtrato();
        System.out.println("Conta invalida ou senha errada!");
        return null;
    }

    // Tranferencia de valores entre duas contas
    public boolean transferencia(int numeroContaSaida, String senhaContaSaida, double valor,  int numeroContaDestino) {
        Conta contaSaida = pesquisarConta(numeroContaSaida); // tenta achar conta de saida
        Conta contaDestino = pesquisarConta(numeroContaDestino); // tenta achar conta de destino

        if(contaSaida != null && contaDestino != null && valor > 0 && contaSaida.getSaldo() >= valor && contaSaida.autenticacao(senhaContaSaida))
        {
            contaSaida.debito(valor); // Retira o valor da trasferencia da conta de saida
            contaDestino.credito(valor); // Adiciona o valor da transferencia na conta de destino
            return true; // Operacao deu certo
        }
        System.out.println("Contas invalidas ou valor invalido!");
        return false; // Operacao deu errado
    }

    public boolean contaExiste(Conta conta)
    {
        return pesquisarConta(conta.getNumero()) != null;
    }
}
