package modelo;

import java.util.Objects;

public class Aresta  implements Comparable<Aresta>{
	private Vertice v1;
	private Vertice v2;
	private double distancia;
	//private double distanciaMinima = Double.POSITIVE_INFINITY;
	
	public Aresta() {
		this(null, null, 0);
	}
	
	public Aresta(Vertice v1, Vertice v2, double distancia) {
		this.v1 = v1;
		this.v2 = v2;
		this.distancia = distancia;
	}
	
	public Vertice adjacencia(Vertice v) {
		return (v.equals(v1)) ? v2: v1;
	}
	
	public Vertice getV1() {
		return v1;
	}

	public void setV1(Vertice v1) {
		this.v1 = v1;
	}

	public Vertice getV2() {
		return v2;
	}

	public void setV2(Vertice v2) {
		this.v2 = v2;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	public int compareTo(Aresta a) {
		return Double.compare(this.distancia + v1.getLongPose(), a.getDistancia() + a.getV1().getLongPose());
	}
	@Override
	public int hashCode() {
		return Objects.hash(distancia, v1, v2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aresta other = (Aresta) obj;
		return Double.doubleToLongBits(distancia) == Double.doubleToLongBits(other.distancia)
				&& ( Objects.equals(v1, other.v1) && Objects.equals(v2, other.v2)  || Objects.equals(v1, other.v2) && Objects.equals(v2, other.v1) );
	}
}