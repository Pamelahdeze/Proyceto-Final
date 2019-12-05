import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public String ruta = getClass().getResource("/facturas/").getPath();
    public static void main(String[] args) {
    	 ServerSocket servidor;
    	 Socket conexion;
    	 Servidor miServidor = new Servidor();
    	 BufferedInputStream bufferEntrada;
    	 BufferedOutputStream bufferSalida;
    	 
    	byte[] receivedData;
    	 int in;
    	 String file;
    	 
		try {
			servidor = new ServerSocket(8000);
			while (true) {
				conexion = servidor.accept();
				receivedData = new byte[8192];
				bufferEntrada = new BufferedInputStream(conexion.getInputStream());
				DataInputStream flujoEntrada = new DataInputStream(conexion.getInputStream());
				file = flujoEntrada.readUTF();
				file = file.substring(file.indexOf('/') + 1, file.length());
				file = miServidor.ruta+file;
				bufferSalida = new BufferedOutputStream(new FileOutputStream(file));
				while ((in = bufferEntrada.read(receivedData)) != -1) {
					bufferSalida.write(receivedData, 0, in);
				}
				bufferSalida.close();
				flujoEntrada.close();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
    }
}
