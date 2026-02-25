package tallercoches;

import java.util.Arrays;

public class Taller {
	
	private Mecanico[] mecanicos= {
			new Mecanico("Juan Perez",ESPECIALIDAD.COCHE),
			new Mecanico("Luis Garcia",ESPECIALIDAD.COCHE),
			new Mecanico("Rosa Gomez",ESPECIALIDAD.MOTOCICLETA)
	};
	private Averia[] averias= {
			new Averia("Rotura bujia",100),
			new Averia("Rotura luna",150),
			new Averia("Rotura motor",150),
			new Averia("Rotura frenos",150),
			new Averia("Rotura inyección",150)
	};
	
	private final int CAPACIDAD_TALLER=20;
	private Vehiculo[] vehiculos=new Vehiculo[CAPACIDAD_TALLER];
	private int indicador=0;
	
	public void recepcionarVehiculo(String matricula, String tipoCoche) {
		Vehiculo vehiculo=new Vehiculo(matricula,TIPO_COCHE.valueOf(tipoCoche));
		addVehiculo(vehiculo);
		Mecanico mecanico=buscarMecanimoLibre(TIPO_COCHE.valueOf(tipoCoche));
		if (mecanico==null) {
			vehiculo.setEstado(ESTADO.ESPERA);
		}
		else {
			vehiculo.setEstado(ESTADO.REPARACION);
			mecanico.addVehiculo(vehiculo);
			mecanico.setLibre(false);
			diagnosticoAverias(vehiculo);
		}
		
	}
	
	public void terminacionVehiculo(int codigo) {
		Mecanico mecanico=buscarMecanico(codigo);
		if (mecanico==null) {
			System.out.println("Mecanico no encontrado.");
		}
		else {
			if (mecanico.isLibre()) {
				System.out.println("Mecanico libre");
			}
			else {
				Vehiculo vehiculo=mecanico.getVehiculo();
				System.out.println("El coste de la averia: "+vehiculo.costeReparacion());
				vehiculo.setEstado(ESTADO.REPARADO);
				Vehiculo vehiculoEnEspera=buscarVehiculoEnEspera();
				if (vehiculoEnEspera==null) {
					mecanico.setLibre(true);
					mecanico.addVehiculo(null);
				}
				else {
					mecanico.addVehiculo(vehiculoEnEspera);
				}
			}
		}
		
	}
	
	public void entregaVehiculosReparados() {
		for (int i=0; i<indicador; i++) {
			if (vehiculos[i].getEstado()==ESTADO.REPARADO) {
				System.out.println(vehiculos[i]);
				vehiculos[i]=vehiculos[--indicador];
			}
		}
	}
	
	public void verTaller() {
		System.out.println("Mecanicos:");
		System.out.println(Arrays.toString(mecanicos));
		System.out.println("Vehiculos:");
		for (int i=0; i<indicador; i++) {
			System.out.println(vehiculos[i]);
		}
	}
	
	/**
	 * Añade un vehiculo al array de vehiculos
	 * @param vehiculo
	 */
	private void addVehiculo(Vehiculo vehiculo) {
		vehiculos[indicador]=vehiculo;
		indicador++;
	}
	
	/**
	 * Buscar un mecanico del tipo Coche libre
	 * @param tipoCoche
	 * @return
	 */
	private Mecanico buscarMecanimoLibre(TIPO_COCHE tipoCoche) {
		Mecanico mecanico=null;
		for (int i=0; i<mecanicos.length; i++) {
			if (mecanicos[i].isLibre() && 
					((tipoCoche==TIPO_COCHE.COCHE && mecanicos[i].getEspecialidad()==ESPECIALIDAD.COCHE) ||
					(tipoCoche==TIPO_COCHE.MOTO && mecanicos[i].getEspecialidad()==ESPECIALIDAD.MOTOCICLETA) )) {
				return mecanicos[i]; 
			}
		}
		
		return mecanico;
	}
	/**
	 * Se asigna de manera aleatoria las averias
	 * NOTA: Algoritmo mejorable
	 * @param vehiculo
	 */
	private void diagnosticoAverias(Vehiculo vehiculo) {
		int NAverias=(int)(Math.random()*averias.length)+1;
		for (int i=0; i<NAverias; i++) {
			vehiculo.addAveria(averias[i]);
		}
	}
	
	/**
	 * Busca mecanico por codigo
	 * @param codigo
	 * @return
	 */
	private Mecanico buscarMecanico(int codigo) {
		for (int i=0; i<mecanicos.length; i++) {
			if (mecanicos[i].getCodigo()==codigo)
				return mecanicos[i];
		}
		
		return null;		
	}
	
	/**
	 * Busca un vehiculo en Espera
	 * @return Vehiculo
	 */
	private Vehiculo buscarVehiculoEnEspera() {
		Vehiculo vehiculo=null;
		for (int i=0; i<indicador; i++) {
			if (vehiculos[i].getEstado()==ESTADO.ESPERA) {
				vehiculo=vehiculos[i];
				break;
			}
		}
		
		return vehiculo;
	}
	

}
