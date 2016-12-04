import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
public class Cliente{
	public Cliente(){
		try{
			System.out.println("Estamos en el Cliente");
			Interfaz objeto = (Interfaz)Naming.lookup("rmi://localhost/estudiante");
			int opcion=0;
			do{
			opcion=Integer.parseInt(JOptionPane.showInputDialog(null, "Seleciona la operacion:\n"+
														"1. Ingresar\n"+
														"2. Modificar\n"+
														"3.	Eliminar\n"+
														"4. Contar\n"+
														"5. Salir\n"));
			switch(opcion){
				case 1:
						String ci=JOptionPane.showInputDialog(null,"Ingrese la cedula");
						if(objeto.verificaCedula(ci)){
							JOptionPane.showMessageDialog(null,"La cédula ya existe");
						}else{
							String n=JOptionPane.showInputDialog(null,"Ingrese los dos nombres:");
							String a=JOptionPane.showInputDialog(null,"Ingrese los dos apellidos");
							if(objeto.guardar(ci,a,n)){
								JOptionPane.showMessageDialog(null, "Se grabo correctamente");
								System.out.println("Tamño de lista: "+objeto.getNumeroFilas());	
							}else{
								JOptionPane.showMessageDialog(null, "Error al grabar");
							}
						}
						
				break;
				case 2:
					String cic=JOptionPane.showInputDialog(null,"Ingrese la cedula del Estudiante a modificar");
					String datos=objeto.getEstudiante(cic);
					if(datos!=null){
						String[] parts = datos.split("\n");
						int i=Integer.parseInt(parts[3]);
						
							String nn=JOptionPane.showInputDialog("Ingrese los nuevos apellidos:",parts[1]);
							String an=JOptionPane.showInputDialog("Ingrese los nuevos nombres",parts[2]);
							if(objeto.editar(parts[0],an,nn,i)){
								JOptionPane.showMessageDialog(null, "Se grabo correctamente");
								System.out.println("Tamño de lista: "+objeto.getNumeroFilas());	
							}else{
								JOptionPane.showMessageDialog(null, "Error al grabar");
							}
						
					}else{
						JOptionPane.showMessageDialog(null, "La cedula no se encuentra registrada");
					}



					
				break;
				case 3:
				cic=JOptionPane.showInputDialog(null,"Ingrese la cedula del Estudiante a eliminar");
				if(objeto.eliminar(cic)){
					JOptionPane.showMessageDialog(null,"Se eliminó Correctamente");
				}
				else{
					JOptionPane.showMessageDialog(null, "No se pudo eliminar");
				}
				System.out.println("Tamño de lista: "+objeto.getNumeroFilas());	
					
				break;
				case 4: 
				JOptionPane.showMessageDialog(null,"Tamaño de lista: "+objeto.getNumeroFilas());
				break;
				case 5: 
				break;
				


        default:
        	System.out.println("opcion incorrecta");
        break;
			}}while(opcion!=5);
					
		} catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	public static void main(String [] args){
		new Cliente();
	}
}