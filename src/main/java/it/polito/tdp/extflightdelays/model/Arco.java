package it.polito.tdp.extflightdelays.model;

public class Arco {
	
	private int originAirId;
	private int destinationAirId;
	private int peso;
	
	public Arco(int originAirId, int destinationAirId, int media) {
		this.originAirId = originAirId;
		this.destinationAirId = destinationAirId;
		this.peso = media;
	}

	public int getOriginAirId() {
		return originAirId;
	}

	public int getDestinationAirId() {
		return destinationAirId;
	}

	public int getPeso() {
		return peso;
	}

	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + destinationAirId;
		result = prime * result + originAirId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arco other = (Arco) obj;
		if (destinationAirId != other.destinationAirId)
			return false;
		if (originAirId != other.originAirId)
			return false;
		return true;
	}
	
	public String toString() {
		return this.originAirId+"-"+this.destinationAirId+": "+this.peso;
	}
	
	
	

}
