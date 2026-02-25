package tallercoches;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String menu="1-Recepcion Vehiculo\n"+
				"2-Terminación de una recepción\n"+
				"3-Entrega de vehiculo repadados\n"+
				"4-Ver taller\n"+
				"-1-Salir\n";
		Scanner sc=new Scanner(System.in);
		Taller taller=new Taller();
		int opcion=0;
		String matricula="";
		String tipoCoche="";
		int codigo=0;
		do {
			System.out.println(menu);
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Dame una matricula:");
				matricula=sc.next();
				System.out.println("Dame el tipo coche:");
				tipoCoche=sc.next();
				taller.recepcionarVehiculo(matricula, tipoCoche);
				break;
			case 2:
				System.out.println("Introduce el codigo del mecanico:");
				codigo=sc.nextInt();
				taller.terminacionVehiculo(codigo);
				break;
			case 3:
				taller.entregaVehiculosReparados();
				break;
			case 4:
				taller.verTaller();
				break;
			case -1:
				System.out.println("Hasta luego.!");
				break;
			default:
				System.out.println("Opcion incorrecta.");
			}
		}while (opcion!=-1);
		
		sc.close();

	}

}
