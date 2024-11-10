package Conta;
import java.util.Scanner;
public class App {
    @SuppressWarnings({ "unused" })
    public static void main(String[] args) {
        // Desenvolvi este menu, procurando a interação com o usuário, para que ele possa digitar e realizar as funções desejadas implementadas na aula.
        Scanner escolhaNumero = new Scanner(System.in);
        Scanner escolhaPalavra = new Scanner(System.in);
        Cliente clienteUm = null;
        Conta contaCorrenteUm = null;
        Conta contaPoupancaUm = null;
        boolean continuar = true;
        
        while (continuar) {
        
        System.out.println("Olá, tudo bem? Nossa agência bancária está à sua disposição.");
        System.out.println("No que podemos te ajudar hoje?");
        System.out.println("1. Criar conta bancária");
        System.out.println("2. Saque.");
        System.out.println("3. Depósito.");
        System.out.println("4. Transferência.");
        System.out.println("5. Mensagem ao suporte.");
        System.out.println("6. Informações da conta.");
        System.out.println("7. Sair");
        System.out.println("Digite apenas o número correspondente a opção desejada.");
        
        
        int numero = escolhaNumero.nextInt();

        switch (numero) {
            case 1:
                clienteUm = new Cliente();
                System.out.println("Seu nome completo, por favor.");
                String nome = escolhaPalavra.nextLine();
                clienteUm.setNome(nome);
                    System.out.println("Qual tipo de conta bancária deseja criar?");
                    System.out.println("1. Conta Corrente.");
                    System.out.println("2. Conta Poupança.");
                    numero = escolhaNumero.nextInt();
                    if (numero == 1) {
                        contaCorrenteUm = new ContaCorrente(clienteUm);
                        System.out.println("Conta criada com sucesso");
                    } else if (numero == 2) {
                        contaPoupancaUm = new ContaPoupanca(clienteUm);
                        System.out.println("Conta criada com sucesso");
                    } else {
                        System.out.println("Valor inválido");
                        break;
                    } 
                break;
            case 2:
                    double valorSaque = 0.0;
                    if (contaCorrenteUm == null && contaPoupancaUm == null){
                    System.out.println("Você precisa criar uma conta antes de realizar o saque");
                        break;
                    } else if (contaPoupancaUm != null) {
                        System.out.println("Digite o valor solicitado para saque.");
                        valorSaque = escolhaNumero.nextDouble();   
                        contaPoupancaUm.sacar(valorSaque);
                        break;
                    } else {
                        System.out.println("Digite o valor solicitado para saque.");
                        valorSaque = escolhaNumero.nextDouble();   
                        contaCorrenteUm.sacar(valorSaque);
                        break;
                    }
            case 3: // depósito
                System.out.println("Digite o valor a ser depositado");
                double valorDeposito = escolhaNumero.nextDouble();
                System.out.println("Em qual conta deseja depositar");
                System.out.println("1. Conta Corrente.");
                System.out.println("2. Conta Poupança.");
                numero = escolhaNumero.nextInt();
                if (numero == 1 ) {
                    contaCorrenteUm.depositar(valorDeposito);
                } else if (numero ==2) {
                    contaPoupancaUm.depositar(valorDeposito);
                }
                break;
                
            case 4: // trasferir
                System.out.println("De qual conta você deseja transferir?");
                System.out.println("1. Conta Corrente.");
                System.out.println("2. Conta Poupança.");
                numero = escolhaNumero.nextInt();
                System.out.println("Digite o valor para transferência.");
                valorDeposito = escolhaNumero.nextDouble();
                if (numero == 1) {
                    contaCorrenteUm.transferir(valorDeposito, contaPoupancaUm);
                    System.out.println("Valor depositado com sucesso!");
                } else if (numero == 2) {
                    contaPoupancaUm.transferir(valorDeposito, contaPoupancaUm);
                    System.out.println("Valor depositado com sucesso!");
                } else {
                    System.out.println("Valor inválido");
                    break;
                };
                break;
            case 5:
                System.out.println("Estamos sempre trabalhando para melhorar nossos serviços!");
                System.out.println("Caso tiver qualquer sugestão, dúvida, digite abaixo");
                System.out.println("Ou entre em contato conoscos no número 33XXX-XXXX");
                System.out.println("Desde já, obrigada pela atenção.");
                String orientacao = escolhaPalavra.nextLine();
                // Essa funcionalidade pode ser implementada mais a fundo no futuro, fica como esboço para uma próxima inplementação 
                break;
            case 6: 
                System.out.println("Informe a conta à ser detalhada");
                System.out.println("1. Conta Corrente.");
                System.out.println("2. Conta Poupança.");
                numero = escolhaNumero.nextInt();
                 if(numero == 1 ) {
                    contaCorrenteUm.imprimirExtrato();
                } else if (numero == 2) {
                    contaPoupancaUm.imprimirExtrato();
                } else {
                    System.out.println("Valor inválido");
                };
                break;
            case 7:
                System.out.println("Até mais!");
                continuar = false;
                break;
            default:
                System.out.println("Valor inválido");
                break;
        }

    }
        escolhaNumero.close();
        escolhaPalavra.close();

    }
        
}
    
          
