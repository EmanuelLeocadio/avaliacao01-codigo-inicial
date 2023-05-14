package aplicativos;

import java.io.IOException;
import java.util.Scanner;
import Classes.Pessoa;
import Classes.Piloto;
import Classes.Aeronave;


public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados = 0;
        Piloto[] pilotos = new Piloto[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);
        String Cpf;
        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {

                Piloto piloto = new Piloto();

                // Se não tem mais espaço no vetor, saio do cadastro
                if (qtdCadastrados == MAX_ELEMENTOS) {
        
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);

                    continue; 

         }
               else{
                

               System.out.println("Informe o nome do piloto: ");
               piloto.setNome(in.next());
               System.out.println("Informe o CPF do piloto: ");
               piloto.setCpf(in.next());
               System.out.println("Informe o Breve do piloto: ");
               piloto.setBreve(in.next());


               pilotos [qtdCadastrados] = piloto;
               qtdCadastrados++;


                //Cadastre seu piloto aqui
                System.out.println("\nPiloto cadastrado com sucesso.");
                System.out.println("Digite alguma coisa pra voltar ao menu");

                in.next();

                voltarMenu(in);
               }

            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0 ) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }
                else{
                    for (Piloto piloto : pilotos) {
                            if(piloto != null){
                                System.out.println(piloto);
                            }
                        }
                    }
                // Exiba os pilotos aqui
              

                voltarMenu(in);
            } else if (opcao == 3) {
                
         Boolean achou = false;
                  System.out.println("Informe o CPF do piloto:");
               Cpf = in.next();
               
                for (Piloto piloto : pilotos) {
                    if(piloto!= null && Cpf.equals(piloto.getCpf())){
                        System.out.println(piloto);
                        achou = true;
                        System.out.println("Digite alguma coisa pra voltar ao menu");
                        in.next();
                    }
                    
                }
               
            } else if (opcao == 4) {
                 // Se não tem ninguém cadastrado no vetor, caio fora
                 if (qtdCadastrados == 0) {
                    System.out.println("\nSem pilotos, não há como cadastrar uma aeronave");
                    voltarMenu(in);
                    continue;
                } else {
                    System.out.println("Informe o CPF do piloto ");
                    Cpf = in.next();
                    for(Piloto piloto : pilotos){
                        if(piloto != null && Cpf.equals(piloto.getCpf())){
                            System.out.println("Informe o número de série da aeronave ");
                            Aeronave aeronave = new Aeronave();
                            aeronave.setNumeroSerie(in.next());
                            System.out.println("Informe o modelo da aeronave ");
                            aeronave.setModelo(in.next());

                            piloto.setAeronave(aeronave);

                        }

                    }
                   

                   //Solicite ao usuário o piloto
                //Crie a aeronave vinculando-a ao piloto
                System.out.println("\nAeronave cadastrada com sucesso.");
                System.out.println("Digite alguma coisa pra voltar ao menu");
                //Exiba os dados da aeronave
                voltarMenu(in);  
                }
                 
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("Digite alguma coisa pra voltar ao menu");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}