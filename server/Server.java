import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.io.*;
import java.net.Socket;

public class Server{
    private ServerSocket server=null;
    private Socket socket=null;
    private DataInputStream input=null;
    public Server(int port_num)
    {
        try{
        server=new ServerSocket(port_num);
        System.out.println("Server running..");

        socket=server.accept();
        System.out.println("Client Connection Succesful..");

        input=new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        String text="";
        while(!text.equals("over"))
        {
            try
            {
            text=input.readUTF();
            System.out.println(text);
            }
            catch(IOException e)
            {
                System.out.println(e);
            }

        }
        System.out.println("Disconnecting..");
        input.close();
        socket.close();
        }
        catch(IOException exception)
        {
            System.out.println(exception);
        }
    }
    public static void main(String args[])
    {
        Server server=new Server(3333); 
    }
}