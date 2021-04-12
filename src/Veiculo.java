package src;

import java.util.Random;

public class Veiculo {
    Random rand = new Random();
    private int Id;
    private int distPecorrida;
    private Roda[] rodas;
    private float combustivel;
    private boolean ipva;
    
    
    // Inicia Rodas do objeto carro
    public Veiculo(){
        rodas = new Roda[4];
    }
   
    // Geters e Seters

    /*Metodo geter do distancia percorrida, usado para requisição da distancia percorrida do veiculo*/
    public int getDistPecorrida() {
        return distPecorrida;
    }

    /*Metodo seter da distancia percorrida, usado para definir a distancia percorrida do veiculo*/ 
    public void setDistPecorrida(int distPecorrida) {
        this.distPecorrida += distPecorrida;
    }

    /*Metodo seter do ID do carro, usado para definir o ID do veiculo*/ 
    public void setId(int id) {
        this.Id = id;
    }

    
    /*Metodo seter do IPVA, usado para definir o IPVA do veiculo*/ 
    public void setIpva(boolean ipva) {
        this.ipva = ipva;
    }

    /*Metodo geter do Combustivel, usado para requisição do combustivel do veiculo*/ 
    public float getCombustivel() {
        return combustivel;
    }
    /*Metodo seter do Combustivel, usado para definir o combustivel do veiculo*/ 
    public void setCombustivel(float combustivel) {

        this.combustivel = combustivel;
    }

    /*Construtor do Objetor Veiculo*/
    public void iniciarVeiculo()
    {
        /*Fazemos um sorteio para definir se o IPVA inicialmente será pago ou não
        caso o sorteio saia um numero par, o IPVA é pago, caso de impar não*/
       this.ipva = this.rand.nextInt(100) % 2 == 0? true: false;
       int i;

       /*Fazemos um sorteio tambem para saber se as rodas do veiculo estarão calibradas ou não,
       como o carro possui 4 rodas a estrutura de repetição vai de 0 ate menor que 4*/ 
       for(i=0;i<4;i++)
       {
            
            this.rodas[i] = new Roda();
            /*Aqui é realizado um novo sorteio para saber se cada roda vai estar calibrada, caso o sorteio seja par,
             calibramos a roda, caso não, permanece descalibrada como definimos a inicializar o carro*/
            if(this.rand.nextInt(100) % 2 == 0){
                
                this.rodas[i].setCalibragem(true);
            }
        }
        
        this.combustivel = 3.25f;
    }

    //Mostra o status de carro a carro
    public String toString() {
        int i = 0;
        boolean c;

        // vai retornar uma variavel s do tipo string contendo todos os dados do veículo 

        String s = "-------------------------------------------------"; 
        s += "\nStatus";
        s +=  "\nID: " + this.Id;
        s +=  "\nCombustivel: " + this.combustivel + (this.combustivel > 1? " litros" : " litro");
        s +=  "\nDistancia percorrida: " + this.distPecorrida + (this.distPecorrida > 1? " metros" : " metro");
        s += "\nIPVA: " + this.ipva;
        s += "\nPneus:\n";
        for (Roda roda : rodas) {
            c = roda.getCalibragem();
            s += (i+1) + " - " + c + "    " ;
            i++;
        }
        s += "\n-------------------------------------------------"; 
        s+= "\n\n";

        return s;
    }
   //Eavazia pneu indicado
    public void esvaziarPneu(int pneu)
    {
        //int pneu é o pneu indicado pelo usuario o qual ele deseja esvaziar
        //chamamos a a função setCalibragem passamos a posição pneu-1 pois o vetor inicia posição em 0
        //então se ele quer calibrar o pneu 3, ele estara na posição 2 do vetor rodas
        rodas[pneu-1].setCalibragem(false);
    }
    //calibra pneu indicado
    public void calibrarPneu(int pneu)
    {   
        //int pneu é o pneu indicado pelo usuario o qual ele deseja calibrar
        //chamamos a a função setCalibragem passamos a posição pneu-1 pois o vetor inicia posição em 0
        //então se ele quer calibrar o pneu 3, ele estara na posição 2 do vetor rodas
    
        rodas[pneu-1].setCalibragem(true);
    }
    //Calibra todos os pneus de um carro
    public void calibrarPneu()
    {
        int i;
        //a estrutura de repetição passa pneu a pneu do carro tornando todos calibrados
        for(i=0;i<4;i++)
        {
            rodas[i].setCalibragem(true);
        }
    }
    //Movimenta veiculo dentro da pista de corrida
    public boolean movimentarVeiculo()
    {

        int i;
        boolean aux = true;

        /*para movimentar um carro precisamos ter certeza que todas as rodas estejam calibradas
        a estrutura de repetição passa roda a roda fazendo essa verificação e em caso alguma roda esteja descalibrada
        ele para a verificação*/
        for(i=0;i<4 && aux == true;i++)
        {
            aux = this.rodas[i].getCalibragem();

        }

        /*alem das rodas precisamos ter certeza que o IPVA do carro esta pago e se o combustivel do mesmo é superior a 0.55
        assim fazemos uma verificação condicional, em caso todos os itens necessarios para movimentar o carro estejam de acordo
        movimentamos ele*/
        if(this.ipva==true && this.combustivel>=0.55 && aux)
        {
            //caso todos os fatores necessarios estejam de acordo movimentamos o veiculo e retiramos o combustivel do trajeto
            this.distPecorrida += 5;
            this.combustivel -= 0.55;
            return true;
        }
        return false;
        
    }
    /*Imprime carro a carro na pista de corrida*/
    public void carroNaPista(){
        int vezes = this.distPecorrida;
        String dist = "";
        /* usamos a estrutura while para movimentar o carro a distancia que esteja ja definida interna ao carro*/ 
        while(vezes > 0){
            dist += "\t";
            vezes--;
        }

        /*Apos a distancia que ele ja andou é printado finalmente o carro na pista*/
        System.out.println(dist + "    ___  ");
        System.out.println(dist + " __/ |_\\_");
        System.out.println(dist + "|  _     _‘‘-.");
        System.out.println(dist + "’-(_)---(_)--’");
        System.out.println(dist + "      "+this.Id+"\n");
    }
    /*Paga IPVA de um veiculo*/ 
    public void pagarIpva(){
        setIpva(true);
    }

}
