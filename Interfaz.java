import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Interfaz extends Remote{
	public boolean guardar(String c, String a, String n) throws RemoteException;
	public boolean editar(String c, String a, String n,int i) throws RemoteException;
	public boolean eliminar(String c) throws RemoteException;
	public boolean verificaCedula(String c) throws RemoteException;
	public int getNumeroFilas()throws RemoteException;
	public String getEstudiante(String ci) throws RemoteException;
z