import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco("Itaú");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao " + banco.getNome() + "!");
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar Conta Corrente");
            System.out.println("2. Criar Conta Poupança");
            System.out.println("3. Listar Contas");
            System.out.println("4. Excluir Conta");
            System.out.println("5. Fazer Saque");
            System.out.println("6. Fazer Depósito");
            System.out.println("7. Fazer Transferência");
            System.out.println("8. Mostrar Extrato");
            System.out.println("9. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

                if (opcao == 1) {
                    while (true) {
                        System.out.print("Nome do cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF do cliente: ");
                        int cpf = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        System.out.print("Email do cliente: ");
                        String email = scanner.nextLine();
                        System.out.println("Senha da conta: ");
                        String senha = scanner.nextLine();
                        System.out.println("Confirme a senha: ");
                        String senhaConfirmacao = scanner.nextLine();
                        if (!senha.equals(senhaConfirmacao)) {
                            System.out.println("As senhas não coincidem. Tente novamente.");
                            continue;
                        }
    
                        Cliente cliente = new Cliente(nome, cpf, email);
                        Conta conta = new ContaCorrente(cliente, senha);
                        banco.addConta(conta);
                        System.out.println("Conta Corrente criada com sucesso!");
                        break; // Sai do loop após criar a conta
                    }
                }
                else if (opcao == 2) {
                    while (true) {
                        System.out.print("Nome do cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF do cliente: ");
                        int cpf = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        System.out.print("Email do cliente: ");
                        String email = scanner.nextLine();
                        System.out.println("Senha da conta: ");
                        String senha = scanner.nextLine();
                        System.out.println("Confirme a senha: ");
                        String senhaConfirmacao = scanner.nextLine();
                        if (!senha.equals(senhaConfirmacao)) {
                            System.out.println("As senhas não coincidem. Tente novamente.");
                            continue;
                        }
    
                        Cliente cliente = new Cliente(nome, cpf, email);
                        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente, senha);
                        banco.addConta(contaPoupanca);
                        System.out.println("Conta Poupança criada com sucesso!");
                        break; // Sai do loop após criar a conta
                    }
                }
                else if (opcao == 3) {
                    for (Conta conta : banco.getContas()) {
                        conta.imprimirInfos();
                        System.out.println("--------------------------");
                    }
                }
                else if (opcao == 4) {
                    System.out.println("Digite o cpf da conta a ser excluida: ");
                    int cpf = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.println("Digite a senha da conta: ");
                    String senha = scanner.nextLine();
                    Conta conta = banco.acessarConta(cpf, senha);
                    if (conta != null) {
                        banco.removeConta(conta);
                        System.out.println("Conta excluída com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada ou senha incorreta.");
                    }
                }
                else if (opcao == 5) {
                    while (true) {
                        System.out.println("Digite o cpf da conta: ");
                        int cpf = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        System.out.println("Digite a senha da conta: ");
                        String senha = scanner.nextLine();
                        Conta conta = banco.acessarConta(cpf, senha);
                        if (conta != null) {
                            System.out.print("Valor do saque: ");
                            double valorSaque = scanner.nextDouble();
                            conta.sacar(valorSaque);
                            break; // Sai do loop após realizar o saque
                        } else {
                            System.out.println("Conta não encontrada ou senha incorreta.");
                            continue;
                        }
                    }
                }
                else if (opcao == 6) {
                    while (true) {
                        System.out.println("Digite o cpf da conta: ");
                        int cpf = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        System.out.println("Digite a senha da conta: ");
                        String senha = scanner.nextLine();
                        Conta conta = banco.acessarConta(cpf, senha);
                        if (conta != null) {
                            System.out.print("Valor do depósito: ");
                            double valorDeposito = scanner.nextDouble();
                            conta.depositar(valorDeposito);
                            System.out.println("Depósito realizado com sucesso!");
                            break; // Sai do loop após realizar o depósito
                        } else {
                            System.out.println("Conta não encontrada ou senha incorreta.");
                            continue;
                        }
                    }
                }
                else if (opcao == 7) {
                    while (true) {
                        System.out.println("Digite o cpf da conta de origem: ");
                        int cpfOrigem = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        System.out.println("Digite a senha da conta de origem: ");
                        String senhaOrigem = scanner.nextLine();
                        Conta contaOrigem = banco.acessarConta(cpfOrigem, senhaOrigem);
                        if (contaOrigem != null) {
                            System.out.println("Digite o cpf da conta de destino: ");
                            int cpfDestino = scanner.nextInt();
                            scanner.nextLine(); // Limpar o buffer
                            Conta contaDestino = banco.buscarConta(cpfDestino);
                            if (contaDestino != null || !banco.getContas().isEmpty()) {
                                System.out.print("Valor da transferência: ");
                                double valorTransferencia = scanner.nextDouble();
                                contaOrigem.transferir(valorTransferencia, contaDestino);
                                System.out.println("Transferência realizada com sucesso!");
                                break; // Sai do loop após realizar a transferência
                            } else {
                                System.out.println("Conta de destino não encontrada ,senha incorreta ou não há conta para transferir.");
                                continue;
                            }
                        } else {
                            System.out.println("Conta de origem não encontrada ou senha incorreta.");
                            continue;
                        }
                    }
                }
                else if (opcao == 8) {
                    while (true) {
                        System.out.println("Digite o cpf da conta: ");
                        int cpf = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        System.out.println("Digite a senha da conta: ");
                        String senha = scanner.nextLine();
                        Conta conta = banco.acessarConta(cpf, senha);
                        if (conta != null) {
                            conta.imprimirInfos();
                            break; // Sai do loop após mostrar o extrato
                        } else {
                            System.out.println("Conta não encontrada ou senha incorreta.");
                            continue;
                        }
                    }
                }
                else if (opcao == 9) {
                    System.out.println("Saindo...");
                    break;
                }
            
                else {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            }
            scanner.close();
        }
    }
