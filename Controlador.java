import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
class Controlador extends UnicastRemoteObject implements Interfaz{
	List<Estudiante> lista;
	public Controlador() throws RemoteException{
		super();
		lista = new ArrayList<Estudiante>();
	}
	public boolean guardar(String c, String a, String n){
		Estudiante p = new Estudiante(c,a,n);
		lista.add(p);
		return true;
	}
	public int getNumeroFilas(){
		return lista.size();
	}
	public boolean verificaCedula(String c){
		for(int i=0; i<lista.size();i++){
			Estudiante est = (Estudiante)lista.get(i);
			if((""+est.cedula).equals(c)){
				return true;
			}
		}
		return false;
	}
	public String getEstudiante(String ci){
		for(int i=0; i<lista.size();i++){
			Estudiante est = (Estudiante)lista.get(i);
			if((""+est.cedula).equals(ci)){
				return ""+est.cedula+"\n"+est.nombres+"\n"+est.apellidos+"\n"+i;
			}
		}
		return null;
	}
	public boolean editar(String c, String a, String n,int i){
		Estudiante p = new Estudiante(c,a,n);
		lista.set(i,p);
		return true;
	}
	public boolean eliminar(String c){
		for(int i=0; i<lista.size();i++){
			Estudiante est = (Estudiante)lista.get(i)
			if((""+est.cedula).equals(c)){
				lista.remove(i);
				return true;
			}
		}
		return false;
	}
}