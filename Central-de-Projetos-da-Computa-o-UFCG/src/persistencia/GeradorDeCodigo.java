package persistencia;

import java.io.IOException;
import java.io.*;

public class GeradorDeCodigo {

	private static int contador;
	
	public static String geraCodigo() throws IOException {
		contador = inicio() + 1;
		salvar();
		return String.format("${cod%d}", contador);
	}
	
	
	public static void reiniciarCodigo() throws IOException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("UltimoCodigo.txt");
			out.write(0);
		} finally {
			out.close();
		}
	}
	
	
	private static int inicio() throws IOException {
		int c = 0;
		FileInputStream in = null;
		
		try {
			in = new FileInputStream("UltimoCodigo.txt");
			c = in.read();
		} catch (FileNotFoundException e) {
			c = 0;
		} finally {
			if(in != null)
				in.close();
		}
		return c;
	}

	private static void salvar() throws IOException {

		FileOutputStream out = null;
		try {
			out = new FileOutputStream("UltimoCodigo.txt");
			out.write(contador);
		} finally {
			out.close();
		}
	}
	
}
