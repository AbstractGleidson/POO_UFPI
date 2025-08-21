package gleidson.banco;

public class Conta {

    private int numero;
    private double saldo;
    private String extrato = "";
    private Pessoa dono;

    public Conta(int n) {
        numero = n;
    }

    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }

    public void credito(double valor) {
        saldo = saldo + valor;
        extrato = extrato + "Conta: " + numero + ". Credito: " + valor + ". Saldo: "  + saldo + ".\n";
    }

    public void debito(double valor) {
        saldo = saldo - valor;
        extrato = extrato + "Conta: " + numero + ". Debito: " + valor + ". Saldo: "  + saldo + ".\n";
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

    public boolean validar() {
        if (numero > 0) {
            return true;
        }
        return false;
    }

}
