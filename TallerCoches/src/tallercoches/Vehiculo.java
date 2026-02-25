package tallercoches;

import java.util.Arrays;

public class Vehiculo {
	
	private String matricula;
	private ESTADO estado;
	private TIPO_COCHE tipoCoche;
	private Averia[] averias=new Averia[5];
	private int indicador=0;
	
	public Vehiculo(String matricula, TIPO_COCHE tipoCoche) {
		this.matricula=matricula;
		this.tipoCoche=tipoCoche;
		estado=ESTADO.REPARACION;		
	}

	public ESTADO getEstado() {
		return estado;
	}

	public void setEstado(ESTADO estado) {
		this.estado = estado;
	}

	public String getMatricula() {
		return matricula;
	}

	public TIPO_COCHE getTipoCoche() {
		return tipoCoche;
	}
	
	
	public int costeReparacion() {
		int coste=0;
		for (int i=0;i<indicador; i++) {
			coste+=averias[i].getCoste();
		}
		
		return coste;
		
	}
	
	public void addAveria(Averia averia) {
		averias[indicador]=averia;
		indicador++;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", estado=" + estado + ", tipoCoche=" + tipoCoche + "]\n"+
				Arrays.toString(averias)+"\n";
	}
	
	
	
		
		

}
