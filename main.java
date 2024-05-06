import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        int[] usuario = new int[3];
        String[] nome = new String[3];
        int[] senha = new int[3];
        int[] agencia = new int[3];
        int[] saldo = new int[3];

        usuario[1] = 1;
        nome[1] = "Fabio Souza";
        senha[1] = 123;
        agencia[1] = 1;
        saldo[1] = 200;

        usuario[0] = 0;
        nome[0] = "Júlia Maciel";
        senha[0] = 123;
        agencia[0] = 0;
        saldo[0] = 200;

        Scanner scanner = new Scanner(System.in);
        System.out.println("=======Banco 24 horas=======");
        System.out.println("Insira o numero de usuario:");
        int inputUsuario = scanner.nextInt();
        System.out.println("Insira a senha:");
        int inputSenha = scanner.nextInt();

      
        boolean authenticated = false;
        int currentUserIndex = -1; 
        for (int i = 0; i < usuario.length; i++) {
            if (usuario[i] == inputUsuario && senha[i] == inputSenha) {
                authenticated = true;
                currentUserIndex = i;
                System.out.println("Autenticado como " + nome[i]);
                System.out.println("Agência: " + agencia[i]);
                System.out.println("Saldo: " + saldo[i]);
                break;
            }
        }

        if (!authenticated) {
            System.out.println("Usuário ou senha incorretos.");
        } else {
            System.out.println("1-Sacar");
            System.out.println("2-Depositar");
            System.out.println("3-Transferencia");

            int valor = scanner.nextInt();
            switch (valor) {
                case 1:
                    System.out.println("Digite o valor que deseja sacar:");
                    int saque = scanner.nextInt();
                    if (saque > saldo[currentUserIndex]) {
                        System.out.println("Saldo insuficiente.");
                    } else {
                        saldo[currentUserIndex] -= saque;
                        System.out.println("Saque de " + saque + " realizado com sucesso.");
                        System.out.println("Saldo restante: " + saldo[currentUserIndex]);
                    }
                    break;

                case 2:
                    System.out.println("Digite o valor que deseja depositar:");
                    int deposito = scanner.nextInt();
                    saldo[currentUserIndex] += deposito;
                    System.out.println("Depósito de " + deposito + " realizado com sucesso.");
                    System.out.println("Saldo atualizado: " + saldo[currentUserIndex]);
                    break;

                    case 3:
                    System.out.println("Insira o número da conta de destino:");
                    int destino = scanner.nextInt();
                    System.out.println("Insira o valor a ser transferido:");
                    int valorTransferencia = scanner.nextInt();
                
                  
                    boolean contaEncontrada = false;
                    int contaDestinoIndex = -1;
                    for (int i = 0; i < usuario.length; i++) {
                        if (usuario[i] == destino) {
                            contaEncontrada = true;
                            contaDestinoIndex = i;
                            break;
                        }
                    }
                
                    if (!contaEncontrada) {
                        System.out.println("Conta de destino não encontrada.");
                    } else {
                        
                        if (saldo[currentUserIndex] >= valorTransferencia) {
                            saldo[currentUserIndex] -= valorTransferencia;
                            saldo[contaDestinoIndex] += valorTransferencia;
                            System.out.println("Transferência de " + valorTransferencia + " realizada com sucesso para " + nome[contaDestinoIndex]);
                            System.out.println("Saldo atual: " + saldo[currentUserIndex]);
                        } else {
                            System.out.println("Saldo insuficiente para realizar a transferência.");
                        }
                    }
                    break;
                

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
