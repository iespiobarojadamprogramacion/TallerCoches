package tallercoches;

public class Averia {
	
	private int codigo;
	private static int contador=0;
	private String descripcion;
	private int coste;
	
	public Averia(String descripcion, int coste) {
		codigo=contador++;
		this.descripcion=descripcion;
		this.coste=coste;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Averia [codigo=" + codigo + ", descripcion=" + descripcion + ", coste=" + coste + "]";
	}
	
	

}
