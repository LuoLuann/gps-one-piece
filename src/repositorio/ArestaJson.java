package repositorio;

/**
 *
 * @author luann
 */
public class ArestaJson {
    private int idOrigem;
    private int idDestino;
    private double distancia;

    public ArestaJson() {
    }
    
    public int getIdOrigem() {
        return idOrigem;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setIdOrigem(int idOrigem) {
        this.idOrigem = idOrigem;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
   
}
