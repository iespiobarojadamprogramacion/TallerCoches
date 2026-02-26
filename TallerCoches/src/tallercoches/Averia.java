package tallercoches;

public class Averia implements Comparable<Averia>{
	
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

	@Override
	public int compareTo(Averia o) {
		// TODO Auto-generated method stub
		if (descripcion.compareTo(o.descripcion)==0) {
			return coste-o.coste;
		}
		return descripcion.compareTo(o.descripcion); 
	}
	
	

}
