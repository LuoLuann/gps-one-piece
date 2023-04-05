package modelo;

import java.util.Objects;

public class Vertice  implements Comparable<Vertice>{
	private String nome;
	private String descricao;
	private double longPose;
	private double distancia;
	private Vertice anterior;
	//private ArrayList<Vertice> vertices;
	
	public Vertice(String nome, String descricao, double longPose) {
		this.nome = nome;
		this.descricao = descricao;
		this.longPose = longPose;
		this.distancia = 0.;
		this.anterior = null;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Double getLongPose() {
		return longPose;
	}


	public void setLongPose(double longPose) {
		this.longPose = longPose;
	}
	
	public Vertice getAnterior() {
		return anterior;
	}

	public void setAnterior(Vertice anterior) {
		this.anterior = anterior;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, longPose, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		return Objects.equals(descricao, other.descricao)
				&& Double.doubleToLongBits(longPose) == Double.doubleToLongBits(other.longPose)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public int compareTo(Vertice o) {
		return Double.compare(distancia, o.getDistancia());
	}
}