package src;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.graalvm.compiler.asm.sparc.SPARCAssembler.Br;


public class Corrida{ 
   
   private static Veiculo[] carros = new Veiculo[20];
  
   public static void main(String[] args) {
      Opcoes();
   }
   
   
   public static void Opcoes()
   {
    
    int num = 1;
    while(num != 11){

      Scanner entrada = new Scanner(System.in);
      
      System.out.println("\n1- Para incluir veiculo:\n "); // ta feito
      System.out.println("2- Para remover veiculo:\n "); // cinglair
      System.out.println("3- Para abastecer veiculo:\n");  // cris
      System.out.println("5- Para movimentar veiculo:\n");  // cinglair
      System.out.println("6- Para movimentar todos os veiculo:\n");// cris
      System.out.println("7- Para imprimir todos veiculo:\n");// cinglair
      System.out.println("8- Para esvaziar pneu especifico:\n");//cris
      System.out.println("9- Para calibrar pneu especifico:\n"); // cinglair
      System.out.println("10- Para calibrar todos os pneus:\n");  // cris
      System.out.println("11- Imprimir pista:\n");//cris
      System.out.println("12- Sair da aplicação:\n");
      num = entrada.nextInt();
  
      switch (num) {
          case 1:
           incluirCarro();
           break;
          case 2:
           removerCarro();
           break;
          case 3:
            abastecer();
            break;
          case 4:
            System.out.println("Você escolheu 4");
            break;
          case 5:
            System.out.println("Você escolheu 1");
            break;
          case 6:
            System.out.println("Você escolheu 2");
            break;
          case 7:
            imprimirDados();
            break;
          case 8:
            System.out.println("Você escolheu 4");
            break;
          case 9:
            System.out.println("Você escolheu 1");
            break;
          case 10:
            System.out.println("Você escolheu 2");
            break;
          case 11:
            break;
          default:
            System.out.println("Número inválido");
     }
    }
   }
   public static int pedirID() {
    int id;
    System.out.print("\nInforme o id do carro: ");
    Scanner teclado = new Scanner(System.in);
    id = teclado.nextInt();
    return id;
}
  
  public static void incluirCarro() {
      int i;
      for (i = 0; i < carros.length; i++) {
          if (carros[i] == null) {
              carros[i] = new Veiculo();
              carros[i].iniciarVeiculo();
              carros[i].setId(i+1);
              i = carros.length;
              System.out.println("\nVeículo adicionado com sucesso");
          }
      }
      if (i < carros.length) {
          System.out.println("\nNão foi possível adicionar o veículo");
      }
  }
  public static void removerCarro(){
    int id = pedirID();
    if (id > 0 && id <= carros.length && carros[id-1] != null){
      carros[id-1] = null;
      System.out.print("\nCarro removido com sucesso\n");
    }
    else{
      System.out.print("\nCarro não encontrado\n");
    }
  }
  public static void abastecer()
    {
      int id = pedirID();
      
      Scanner ler = new Scanner(System.in);
      float combustivel;
      System.out.printf("Informe a quantidade de combustivel: \n");
      combustivel = ler.nextFloat(); 
      System.out.print( combustivel);
      carros[id-1].setCombustivel(combustivel + carros[id-1].getCombustivel()); 
      
    }

    public static void imprimirDados(){

      for (Veiculo veiculo : carros) {
        if(veiculo != null)
          System.out.print(veiculo);
      }
    }
}