import java.util.Random;

public class veiculo {
    
    private int Id;
    private int distPecorrida;
    //private Roda[];
    private int quantRodas;
    private float combustivel;
    private boolean ipva;

    // geters e seters
    public int getDistPecorrida() {
        return distPecorrida;
    }
    public int getId() {
        return Id;
    }
    public int getQuantRodas() {
        return quantRodas;
    }
    public void setDistPecorrida(int distPecorrida) {
        this.distPecorrida = distPecorrida;
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

    // metodos modulares
    public void incluirVeiculo()
    {
        Random id = new Random();
        Random pneu1 = new Random();


    }
    public void removerVeiculo(int id)
    {
        if (getId() == id) 
        {
            setId(0);
            setCombustivel(0);
            setIpva(false);
            setDistPecorrida(0);

        }
    }

    public void abastecer(int id, int combustivel)
    {
        if(getId() == id) 
        {
            setCombustivel(combustivel);
        }
    }
    public void movimentar(int id)
    {
        if(getId() == id)
        {
            
            dist = getDistPecorrida()
            setDistPecorrida();
        }
    }
    public void movimentarTodos()
    {

    }
    public void status()
    {
        System.out.println("Status");
        System.out.println("ID: " + this.Id);
        System.out.println("Combustivel: " + this.combustivel);
        System.out.println("Distancia percorrida: " + this.distPecorrida);
        System.out.println("IPVA: " + this.ipva);
    }
    public int esvaziarPneu(int id, int Pneu)
    {

    }
    public int calibrarPneu(int id, int Pneu)
    {

    }
    public void calibrarTodosPneu()
    {

    }


    
    


    

}
