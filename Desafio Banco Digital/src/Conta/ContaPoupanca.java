package Conta;
public class ContaPoupanca extends Conta {
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        imprimirInfosComuns();
    }
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }
}
