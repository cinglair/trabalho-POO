package src;

public class Roda {
    private boolean rodaCalibrada;

    
    public Roda(){
        this.rodaCalibrada = false;
    }

    public boolean getCalibragem(){
        return this.rodaCalibrada;
    }
    public void setCalibragem(boolean rodaCalibrada){
        this.rodaCalibrada = rodaCalibrada;
    }
}
