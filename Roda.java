public class Roda {
    private boolean rodaCalibrada;

    public Roda(){
        rodaCalibrada = false;
    }

    public boolean getCalibragem(){
        return this.rodaCalibrada;
    }
    public void setCalibragem(boolean calibragem){
        rodaCalibrada = calibragem;
    }
}
