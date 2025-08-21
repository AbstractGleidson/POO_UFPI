package gleidson.banco;

public class Pessoa {

    private int cpf;
    private String nome;
    private Conta conta; // Conta do user em um dado banco
    private String senha; // Senha da conta

    public Pessoa (int cpfPessoa, String nomePessoa, String senhaPessoa) {
        cpf = cpfPessoa;
        nome = nomePessoa;
        senha = senhaPessoa;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta c) {
        this.conta = c;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nm) {
        this.nome = nm;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String pass) {
        this.senha = pass;
    }

    // Valida os dados da pessoa
    public boolean validar() {
        return cpf > 0 && nome != null && !(nome.isEmpty());
    }
}
