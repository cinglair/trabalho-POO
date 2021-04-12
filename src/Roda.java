package src;

public class Roda {
    /*classe roda usado para gerar as rodas de cada veiculo*/ 
    private boolean rodaCalibrada;

    /*optamos por sempre ao iniciar um veiculo iniciar a calibragem como falso e em meio a sorteio mudar a calibragem */
    public Roda(){
        this.rodaCalibrada = false;
    }
    /*metodo geter da calibragem usado para requisição da calibragem de uma roda especifica*/
    public boolean getCalibragem(){
        return this.rodaCalibrada;
    }
    /*metodo seter da calibragem usado para mudar o estado da roda apos o sorteio para saber
    se o pneu vai ser calibrada ou não*/
    public void setCalibragem(boolean rodaCalibrada){
        this.rodaCalibrada = rodaCalibrada;
    }
}
