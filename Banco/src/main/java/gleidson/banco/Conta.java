package gleidson.banco;

public class Conta {

    private int numero; // Numero da conta
    private double saldo; // Saldo da conta
    private String extrato = ""; // Extrato da conta
    private Pessoa dono; // Pessoa associada a essa conta

    public Conta(int numeroConta) {
        numero = numeroConta;
    }

    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }

    // Deposita um valor passado como parametro na conta
    public void credito(double valor) {
        saldo = saldo + valor;

        // Registra a operacao no extrato
        extrato += String.format(
                "Conta: %d. Credito: %.2f. Saldo: %.2f.\n",
                numero,
                valor,
                saldo
        );
    }

    // Saca um valor passado como parametro da conta
    public void debito(double valor) {
        saldo = saldo - valor;

        // Registra a operacao no extrato
        extrato += String.format(
                "Conta: %d. Debito: %.2f. Saldo: %.2f.\n",
                numero,
                valor,
                saldo
        );
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getExtrato() {
        return extrato;
    }

    // Valida o numero da conta
    public boolean validar() {
        return numero > 0;
    }

    // Autentica a senha para alguma operacao que tenha uma protecao
    public boolean autenticacao(String senhaDono)
    {
        return dono.getSenha().equals(senhaDono);
    }

    // Verifica se essa conta tem um dono
    public boolean temDono(){
        return dono != null && dono.validar();
    }
}
