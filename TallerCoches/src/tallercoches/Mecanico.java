package tallercoches;

public class Mecanico implements Comparable{
	private ESPECIALIDAD especialidad;
	private int codigo;
	private String nombre;
	private boolean libre;
	private static int contador=0;
	private Vehiculo vehiculo;
	
	
	public Mecanico(String nombre, ESPECIALIDAD especialidad) {
		codigo=contador++;
		this.nombre=nombre;
		this.especialidad=especialidad;
		libre=true;
		vehiculo=null;
	}


	public boolean isLibre() {
		return libre;
	}


	public void setLibre(boolean libre) {
		this.libre = libre;
	}


	public ESPECIALIDAD getEspecialidad() {
		return especialidad;
	}


	public int getCodigo() {
		return codigo;
	}


	public String getNombre() {
		return nombre;
	}
	
	public void addVehiculo(Vehiculo vehiculo) {
		this.vehiculo=vehiculo;
	}
	
	public void deleteVehiculo() {
		vehiculo=null;
		libre=true;
		this.vehiculo.setEstado(ESTADO.REPARADO);
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	@Override
	public String toString() {
		return "Mecanico [especialidad=" + especialidad + ", codigo=" + codigo + ", nombre=" + nombre + ", libre="
				+ libre + "]\n"+
				"Vehiculo: "+vehiculo;
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return nombre.compareTo(((Mecanico)o).nombre);
	}
	
	
		
	
}
