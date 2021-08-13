import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{
    private Socket socket=null;
    private DataInputStream input=null;
    private DataOutputStream output=null;

    public Client(String ip,int port_num){
        try{
        socket=new Socket(ip,port_num);
        System.out.println("connection successful");
        input=new DataInputStream(System.in);
        output=new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException exception){
            System.out.println(exception);
        }
        catch(IOException ioexception){
            System.out.println(ioexception);
        }
        String text="";
        while(!text.equals("over"))
        {
            try
            {
            text=input.readLine();
            output.writeUTF(text);
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }
        try
        {
        input.close();
        output.close();
        socket.close();
        }
        catch(IOException except)
        {
            System.out.println(except);
        }
    }

    public static void main(String args[])
    {
        Client client=new Client("127.0.0.1",3333);
    }
}