package gleidson.banco;

public class Pessoa {

    private int cpf;
    private String nome;
    private Conta conta;
    private String senha;

    public Pessoa (int oCpf, String nm, String passwd) {
        cpf = oCpf;
        nome = nm;
        senha = passwd;
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

    public boolean validar() {
        if (cpf > 0 && nome != null && nome.length() > 0) {
            return true;
        }
        return false;
    }
}
