package src;
import java.util.Scanner;


public class Corrida{ 
   
  /*array do tipo veiculo, possui todas as caracteristidas da classe veiculo*/
   private static Veiculo[] carros = new Veiculo[20];
  
   public static void main(String[] args) {
      Opcoes();
   }
   
   
   public static void Opcoes()
   {
    
    int num = 1;
    

    /*Menu incial, usado para autonomia do usuario sobre funcionalidades da corrida*/
    while(num != 12){
      System.out.print("\033[H\033[2J");
      Scanner entrada = new Scanner(System.in);
      System.out.println("\n -- Menu da corrida -- \n");
      System.out.println("[1] Para incluir veiculo; "); 
      System.out.println("[2] Para remover veiculo; "); 
      System.out.println("[3] Para abastecer veiculo;");  
      System.out.println("[4] Para movimentar veiculo;");  
      System.out.println("[5] Para movimentar todos os veiculo;");
      System.out.println("[6] Para imprimir todos veiculo;");
      System.out.println("[7] Para esvaziar pneu especifico;");
      System.out.println("[8] Para calibrar pneu especifico;"); 
      System.out.println("[9] Para calibrar todos os pneus;");  
      System.out.println("[10] Imprimir pista;");
      System.out.println("[11] Pagar IPVA do veículo;");
      System.out.println("[12] Sair da aplicação;");
      System.out.print("\nDigite a opção desejada: ");
      num = entrada.nextInt();
  
      switch (num) {
          case 1:
            incluirCarro();
            voltar();
            
            break;
          case 2:
            removerCarro();
            voltar();
            break;
          case 3:
            abastecer();
            voltar();
            break;
          case 4:
            movimentar();
            voltar();
            break;
          case 5:
            movimentarTodos();
            voltar();
            break;
          case 6:
            imprimirDados();
            voltar();
            break;
          case 7:
            esvaziarPneu();
            voltar();
            break;
          case 8:
            calibrarPneu();
            voltar();
            break;
          case 9:
            calibrarTodos();
            voltar();
            break;
          case 10:
            carrosPista();
            voltar();
            break;
          case 11:
            pagarIpva();
            voltar();
            break;
          case 12:
            System.out.println("\nVolte Sempre !!!\n");
            break;
          default:
            System.out.println("Número inválido");
            voltar();
     }
    }
   }

   /*Função auxiliar das demais, usado para requisição de algum veiculo, em caso do carro não existir, informa ao usuario*/ 
   public static int pedirID() {
    int id;
    System.out.print("\nInforme o id do carro: ");
    Scanner teclado = new Scanner(System.in);
    id = teclado.nextInt();

    /* if ternario verifica se existe um o carro com o id informado, 
    ou se o id é superior ao numero maximo de carros (20), ou se o id informado é menor que 1*/ 
    return (id < 1 || id > carros.length + 1 || carros[id-1] == null? -1 : id);
  }

  /*Metodo usado para melhor imersão do usuario, orgaziar visualmente todo o menu e deixar cada metodo 
  mais agradavel*/ 
  public static void voltar(){
    Scanner entrada = new Scanner(System.in);
    System.out.print("\n");
    System.out.print("Pressione enter para voltar ao menu");
    entrada.nextLine();
  }

  /*Usado para inserir novo veiculo*/ 
  public static void incluirCarro() { // case 1:
      int i;
      for (i = 0; i < carros.length; i++) {
        
        //Verifica-se a proximo local vazio para adcionar um novo veiculo
          if (carros[i] == null) {
              //Caso ache o novo carro é criado e inserido
              carros[i] = new Veiculo();
              carros[i].iniciarVeiculo();
              carros[i].setId(i+1);
              i = carros.length;
              System.out.println("\nVeículo adicionado com sucesso");
          }
      }
      //Caso chegue no ultimo espaço do vetor de veiculos(20) é informado que não foi possivel inserir ao usuario
      if (i == carros.length) {
          System.out.println("\nNão foi possível adicionar o veículo");
      }
  }

  /*Remove veiculo*/
  public static void removerCarro(){ //case 2:
    
    /*Solicita-se o id do veiculo a ser removido, usa o metodo auxiliar pedirID() para verificar se o 
    carro com o respectivo id existe*/
    int id = pedirID();
    
    //caso exista remove-se o carro
    if(id != -1){
        carros[id-1] = null;
        System.out.print("\nCarro removido com sucesso\n");
    }
    /*caso não encontre o id informa ao usuario*/
    else
      System.out.print(" \nCarro não encontrado \n");
  }

  /*Abastece o carro*/
  public static void abastecer() //case 3:
    {
      /*Solicita-se o id do veiculo a ser abastecido, usa o metodo auxiliar pedirID() para verificar se o 
      carro com o respectivo id existe*/
      int id = pedirID();

      //caso exista 
      if(id != -1){

        //solicita-se a quantidade de combustivel a ser adicionada
        Scanner ler = new Scanner(System.in);
        float combustivel;
        System.out.print("\nInforme a quantidade de combustivel: \n");
        combustivel = ler.nextFloat(); 

        //adiciona o combustivel no respectivo carro solicitado
        carros[id-1].setCombustivel(combustivel + carros[id-1].getCombustivel());
        System.out.print("\nVeículo abastecido com sucesso \n"); 
       
      }

      //caso não encontre o id informa ao usuario
      else
        System.out.print("\nCarro não encontrado \n");
      
    }
    /*Movimenta um carro*/
    public static void movimentar(){ //case 4:
      
      /*Solicita-se o id do veiculo a ser movimentado, usa o metodo auxiliar pedirID() para verificar se o 
      carro com o respectivo id existe*/
      int id = pedirID();

      //caso exista
      if(id != -1){

        /*é solicitado o metodo movimentar, onde alem de movimentar em caso possivel
        retorna false em caso de não ser possivel*/
        if(carros[id-1].movimentarVeiculo())
          System.out.print("Veículo movimentado com sucesso \n");
        
        /*caso movimentarVeiculo() retorne false, não é possivel movimentar e é informado ao usuario*/
        else
          System.out.println("Veículo incapaz de se locomover\n");
      }
      //caso não encontre o id informa ao usuario
      else
        System.out.print("\nCarro não encontrado \n");
      
    }

    /*Movimenta todos os veiculos*/
    public static void movimentarTodos(){ //case 5:
      boolean i = false;

      /*Estrutura sequencial passa carro a carro para movimentar um a um*/
      for (Veiculo veiculo : carros) {

        //se a posição do veiculo for != de null carro existe e pode ser movimentado
        if(veiculo != null){
          veiculo.movimentarVeiculo();
          /*i é uma variavel auxiliar incializada em false para que se em caso de 
          conseguir movimentar os veiculos possamos informar isso ao usuario*/
          i = true;
        }
      }
      //em caso de sucesso em movimentar os veiculos i tera valor true e por isso informamos sucesso ao usuario
      if (i)
        System.out.print("\nVeículos movimentados com sucesso \n");
      
      //em caso de falha em movimentar os veiculos i tera valor false e por isso informamos a falha ao usuario
      else
        System.out.print("\nNenhum veículo movimentado \n");
    }
    
    /*Imprimir dados de todos os veiculos*/ 
    public static void imprimirDados(){ //case 6:

      //percorre-se veiculo a veiculo 
      for (Veiculo veiculo : carros) {
        //em caso de veiculo != null  veiculo existe e pode ser exibido
        if(veiculo != null)
          System.out.print(veiculo);
      }
    }


    /*Esvaziar um Pneu*/
    public static void esvaziarPneu(){ //case 7:
      
      /*Solicita-se o id do veiculo a ser esvaziado um pneu, usa o metodo auxiliar pedirID() para verificar se o 
      carro com o respectivo id existe*/
      int id = pedirID();

      //caso exista
      if(id != -1){
        Scanner ler = new Scanner(System.in);
        int pneu = -1;

        //estrutura sequencial usada para que o usuario insira um valor correto entre 0 e 4, numero esse referente a roda a ser esvaziada
        while(pneu < 0 || pneu > 4){
          System.out.println("Informe o pneu a ser esvaziado: \n");
          pneu = ler.nextInt();

          //caso não esteja entre o intervalo solicita-se um novo valor ao usuario
          if(pneu < 0 || pneu > 4)
            System.out.println("Pneu incorreto, informe uma opção válida");
        }

        //caso insira um valor valido para a roda o pneu é esvaziado e informado sucesso ao usuario
        carros[id-1].esvaziarPneu(pneu);
        System.out.println("Pneu esvaziado");
      }

      //caso não encontre o id informa ao usuario
      else
        System.out.print("\nCarro não encontrado\n");
    }

    /*Calibra um pneu especifico de um veiculo especifico */
    public static void calibrarPneu(){ //case 8:
      
      /*Solicita-se o id do veiculo a ser calibrado um pneu, usa o metodo auxiliar pedirID() para verificar se o 
      carro com o respectivo id existe*/
      int id = pedirID();

      //caso exista
      if(id != -1){
        Scanner ler = new Scanner(System.in);
        
        int pneu = -1;
        //estrutura sequencial usada para que o usuario insira um valor correto entre 0 e 4, numero esse referente a roda a ser calibrada
        while(pneu < 0 || pneu > 4){
          System.out.print("\nInforme o pneu a ser calibrado: \n");
          pneu = ler.nextInt();

          //caso não esteja entre o intervalo solicita-se um novo valor ao usuario
          if(pneu < 0 || pneu > 4)
            System.out.print("\nPneu incorreto, informe uma opção válida\n");
        }

        //caso insira um valor valido para a roda o pneu é calibrado e informado sucesso ao usuario
        carros[id-1].calibrarPneu(pneu);//metodo sobrecarregado, usado mesmo nome passado parametros diferentes
        System.out.println("Pneu calibrado");
      }
      //caso não encontre o id informa ao usuario
      else
        System.out.print("\nCarro não encontrado\n");
    }

    /*Calibra todos os pneus de um Veiculo*/
    public static void calibrarTodos(){ //case 9:

      /*Solicita-se o id do veiculo a ser calibrado os pneus, usa o metodo auxiliar pedirID() para verificar se o 
      carro com o respectivo id existe*/
      int id = pedirID();

      //caso exista
      if(id != -1){

        //chama se o metodo ja usado calibrarPneu() onde calibrará todos os pneus do respectivo veiculo
        carros[id-1].calibrarPneu();//metodo sobrecarregado, usado com mesmo nome passado parametros diferentes
        System.out.println("Pneus calibrados");
      }

      //caso não encontre o id informa ao usuario
      else

        System.out.println("Carro não encontrado");
    }
    
    
    /*Desenha carros na pista*/
    public static void carrosPista(){ //case 10:

      //percorre o vetor veiculo, printando carro a carro
      for (Veiculo veiculo : carros) {

        //caso o veiculo seja diferente de null, o veiculo existe e pode ser printado
        if(veiculo!=null)

        //requisita-se o metodo carroNaPista(), para mostrar em tela o veiculo de posição diferente de nula
          veiculo.carroNaPista();
      }
    }
    
    /*Paga IPVA de um Veiculo*/
    public static void pagarIpva(){ //case 11:
      
      /*Solicita-se o id do veiculo a ser pago o IPVA, usa o metodo auxiliar pedirID() para verificar se o 
      carro com o respectivo id existe*/
      int id = pedirID();

      //caso exista
      if(id != -1){

        //requisita-se o metodo pagarIpva() do carro na posição inserida pelo usuario
        carros[id-1].pagarIpva();

        //informa usuario o sucesso na operação
        System.out.println("IPVA pago");
      }
      //caso não ache o carro informa ao usuario
      else
        System.out.println("Carro não encontrado");
    }
  
}