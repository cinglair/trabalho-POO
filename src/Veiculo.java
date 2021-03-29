package src;

import java.util.Random;
//salveeee
public class Veiculo {
    Random rand = new Random();
    private int Id;
    private int distPecorrida;
    private Roda[] rodas;
    private int quantRodas;
    private float combustivel;
    private boolean ipva;

    public Veiculo(){
        rodas = new Roda[4];
    }
    // geters e seters
    public int getDistPecorrida() {
        return distPecorrida;
    }
    public int getQuantRodas() {
        return quantRodas;
    }
    public void setDistPecorrida(int distPecorrida) {
        this.distPecorrida += distPecorrida;
    }
    public void setId(int id) {
        Id = id;
    }
    public void setQuantRodas(int quantRodas) {
        this.quantRodas = quantRodas;
    }
    public void setIpva(boolean ipva) {
        this.ipva = ipva;
    }
    public float getCombustivel() {
        return combustivel;
    }
    public void setCombustivel(float combustivel) {
        this.combustivel = combustivel;
    }
    public void iniciarVeiculo()
    {
       this.ipva = this.rand.nextInt(100) %2 == 0? true: false;
       int i;
       for(i=0;i<4;i++)
       {
            
            this.rodas[i] = new Roda();
            if(this.rand.nextInt(100) % 2 == 0){
                
                this.rodas[i].setCalibragem(true);
            }
        }
        
        this.combustivel = 3.25f;
    }

    

    public String toString() {
        int i = 0;
        boolean c;
        String s = "\nStatus";
        s +=  "\nID: " + this.Id;
        s +=  "\nCombustivel: " + this.combustivel + (this.combustivel > 1? " litros" : " litro");
        s +=  "\nDistancia percorrida: " + this.distPecorrida + (this.distPecorrida > 1? " metro" : " metros");
        s += "\nIPVA: " + this.ipva;
        s += "\nPneus:\n";
        for (Roda roda : rodas) {
            c = roda.getCalibragem();
            s += (i+1) + " - " + c + "\t" ;
            i++;
        }
       s+= "\n";

        return s;
    }
   
    public void esvaziarPneu(int Pneu)
    {
        rodas[Pneu-1].setCalibragem(false);
    }
    public void calibrarPneu(int Pneu)
    {
        rodas[Pneu-1].setCalibragem(true);
    }
    public void calibrarTodosPneu()
    {
        int i;
        for(i=0;i<4;i++)
        {
            rodas[i].setCalibragem(true);
        }
    }
    public void movimentarVeiculo()
    {
        int i;
        boolean aux;
        for(i=0;i<4;i++)
        {
            aux = this.rodas[i].getCalibragem();
            if(aux == false)
            {
                i = 10;
            }
        }

        
        if(this.ipva==true ||this.combustivel>0||i != 10)
        {
            this.distPecorrida += 5;
        }
        
    }
    public void carroNaPista(){
        int vezes = this.distPecorrida;
        String dist = "";
        while(vezes > 0){
            dist += "\t";
            vezes--;
        }

        System.out.println(dist + "    ___  ");
        System.out.println(dist + " __/ |_\\_");
        System.out.println(dist + "|  _     _‘‘-.");
        System.out.println(dist + "’-(_)---(_)--’");
        System.out.println(dist + "      "+this.Id+"\n");
    }

}
