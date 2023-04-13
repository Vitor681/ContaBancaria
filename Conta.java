import java.sql.SQLOutput;
import java.util.Scanner;

public class Conta {
    public static void main(String[] args) {
        //variaveis
        String nome = "Vitor";
        String tipoDeConta = "Corrente";
        double saldo = 1000.00;
        int opcao = 0;
        int opcaoTransferencia = 0;
        Scanner leitura = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        String menu = """
           1 - Saldo da conta:
           2 - transferências:
           3 - realizar saque:
           4 - depositar:
           5 - encerrar sessão: \n""";

        String menuTransferencia = """
                Escolha o tipo de transfêrencia que deseje:
                1 - pix
                2 - mesmo banco
                3 - outros bancos\n""";

        String menuPix = """
                1 - para celular
                2 - para email
                3 - cpf ou cnpj\n""";

        String menuValor = "digite o valor";

        String tipoDaConta = """
                digite 1 para Conta-Corrente
                digite 2 para Conta-Poupança""";

        String declaraSaldo = "seu saldo é de: " +saldo;

        //menu inicial
        System.out.println("-----------------------------");
        System.out.println("Nome do cliente: " + nome);
        System.out.println("tipo da conta: " + tipoDeConta);
        System.out.println("saldo da conta:" + saldo);
        System.out.println("-----------------------------\n");

        //laço de repetição
        while (opcao != 5){
            System.out.println(menu);
            opcao = leitura.nextInt();
            //switch case de seleção
            switch (opcao) {
                //case do saldo
                case 1:
                    System.out.println(saldo);
                    break;
                //case de transferencias
                case 2:
                    System.out.println(menuTransferencia);
                    opcaoTransferencia = leitura.nextInt();
                    //switch dentro de transferencia para identificar o tipo de transferencia que o usuario deseja
                    switch (opcaoTransferencia) {
                        case 1:
                            int opcaoPix = 0;
                            System.out.println("como quer transferir?");
                            System.out.println(menuPix);
                            opcaoPix = leitura.nextInt();
                            //swirch para identificar qual tipo de chave o usuario deseja transferir
                            switch (opcaoPix) {
                                //celular
                                case 1:
                                    System.out.println("digite o celular");
                                    long  nCelular = leitura.nextLong();
                                    System.out.println(menuValor);
                                    double valor = leitura.nextDouble();

                                    if (valor > saldo){
                                        System.out.println("saldo insuficiente!");
                                    }else {
                                        saldo -= valor;
                                        System.out.println(saldo);
                                    }
                                    break;
                                //email
                                case 2:
                                    System.out.println("digite o email");
                                    String email = input.next();
                                    System.out.println(menuValor);
                                    double valor1 = leitura.nextDouble();

                                    if (valor1 > saldo){
                                        System.out.println("saldo insuficiente!");
                                    }else {
                                        saldo -= valor1;
                                        System.out.println(saldo);
                                    }
                                    break;
                                //cpf ou cnpj
                                case 3:
                                    System.out.println("digite o cpf ou cnpj");
                                    long cpfCnpj = leitura.nextLong();
                                    System.out.println(menuValor);
                                    double valor2 = leitura.nextDouble();

                                    if (valor2 > saldo){
                                        System.out.println("saldo insuficiente!");
                                    }else {
                                        saldo -= valor2;
                                        System.out.println(saldo);
                                    }
                                    break;
                                default:
                                    System.out.println("opção invalida! digite um numero de 1 a 3\n");
                            }
                            break;
                        //mesmo banco
                        case 2:
                            System.out.println("digite a agência sem digito");
                            int agencia = leitura.nextInt();
                            System.out.println("digite o numero da conta com digito");
                            long nConta = leitura.nextLong();
                            System.out.println(tipoDaConta);
                            int tConta = leitura.nextInt();
                            System.out.println(menuValor);
                            double valor3 = leitura.nextDouble();

                            if (valor3 > saldo){
                                System.out.println("saldo insuficiente!");
                                return;
                            }else {
                                saldo -= valor3;
                                System.out.println(saldo);
                            }
                            break;
                        //outros bancos
                        case 3:
                            System.out.println("digite o codigo do banco");
                            int codBanco = leitura.nextInt();
                            System.out.println("digite a agência sem digito");
                            int agencia2 = leitura.nextInt();
                            System.out.println("digite o numero da conta com digito");
                            long nConta2 = leitura.nextLong();
                            System.out.println(tipoDaConta);
                            int tConta2 = leitura.nextInt();
                            if (tConta2 < 3){
                                System.out.println(menuValor);
                                double valor4 = leitura.nextDouble();

                                if (valor4 > saldo){
                                    System.out.println("saldo insuficiente!");
                                    return;
                                }else {
                                    saldo -= valor4;
                                    System.out.println(saldo);
                                }
                            } else{
                                System.out.println("opção invalida");
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println(menuValor);
                    double valor5 = leitura.nextDouble();

                    if (valor5 > saldo) {
                        System.out.println("saldo insuficiente!");
                    }else  {
                        saldo -= valor5;
                        System.out.println(saldo);
                    }
                    break;
                case 4:
                    System.out.println(menuValor + " que deseje depositar");
                    double valor6 = leitura.nextDouble();

                    saldo += valor6;
                    System.out.println(saldo);
                    break;
                default:
                    System.out.println("opção invalida! digite um numero de 1 a 5\n");
            }
        }
    }
}