package testsocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    
    public static void main(String[] args) throws IOException {
        
        Scanner scan = new Scanner(System.in);
        try {
            Socket cliente = new Socket("localhost", 5000);
            
            ObjectOutputStream output = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(cliente.getInputStream());
            DataOutputStream stream = new DataOutputStream(cliente.getOutputStream());
            output.writeObject("Hola desde cliente");
            System.out.print("mensaje: ");
            String saludo = scan.nextLine();
            stream.writeBytes(saludo);
            
            
            
            input.close();
            System.out.println("se cerro el input");
            output.close();
            System.out.println("se cerro el output");
            cliente.close();
            System.out.println("se cerro el cliente");
        } catch (IOException iOException) {
        }
        
    }
    
}
