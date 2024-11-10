package Conta;

public class Conta {
    protected static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected Cliente cliente;

    
    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    protected int agencia;
    protected int numero;
    protected double saldo;
    
    public void sacar(double valorSaque) {
        saldo -= valorSaque;
        System.out.println("Saque de " + valorSaque +"R$, realizado com sucesso");
        System.out.println("Novo saldo: " + saldo + "R$");
    };
    public void depositar(double valorDeposito) {
        saldo += valorDeposito;
        System.out.println("Deposito de " + valorDeposito +"R$, realizado com sucesso");
        System.out.println("Novo saldo: " + saldo + "R$");
    };
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    };
    public void imprimirExtrato() {
        imprimirInfosComuns();
    }
    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular, %s", cliente.getNome()));
        System.out.println(String.format("Agencia, %d", agencia));
        System.out.println(String.format("Numero, %d", numero));
        System.out.println(String.format("Saldo, %.2f", saldo));
    }

    // getter e setter
    public int getAgencia () {
        return agencia;
    }
    public int getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public static int getAgenciaPadrao() {
        return AGENCIA_PADRAO;
    }
    public static int getSEQUENCIAL() {
        return SEQUENCIAL;
    }
    public Cliente getCliente() {
        return cliente;
    }
}
