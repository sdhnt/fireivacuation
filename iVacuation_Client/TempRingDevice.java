import java.util.*;
import java.net.*;
import java.io.*;

public class TempRingDevice {

    public static void main(String[] args) throws Exception {


        Socket incomingSocket;

        // Declare variable for the token

        while (true) {
	 
//GET TEMP
	    Process p = Runtime.getRuntime().exec("python3 /home/pi/iVacuation/fire.py");
            BufferedReader bufIn=new BufferedReader(new InputStreamReader(p.getInputStream()));
	    double currtemp = Double.parseDouble(bufIn.readLine());

//GET TEMP
            Socket nextHopSocket = new Socket("192.168.1.1", 1237);
            ObjectOutputStream out = new ObjectOutputStream(nextHopSocket.getOutputStream());
            out.writeObject(currtemp); System.out.println(currtemp);
            out.flush();

            ObjectInputStream in = new ObjectInputStream(nextHopSocket.getInputStream());

            String token = (String) in.readObject();

            if(token.equals("up"))
            {
                Process q = Runtime.getRuntime().exec("python3 /home/pi/iVacuation/print_up.py");
            }   
            else if(token.equals("down"))
            {
                    Process q = Runtime.getRuntime().exec("python3 /home/pi/iVacuation/print_down.py");
            }
            else if(token.equals("left"))
            {
                    Process q = Runtime.getRuntime().exec("python3 /home/pi/iVacuation/print_left.py");
            }            
            else if(token.equals("right"))
            {
                    Process q = Runtime.getRuntime().exec("python3 /home/pi/iVacuation/print_right.py");
            }            
            else if(token.equals("top_left"))
            {
                    Process q = Runtime.getRuntime().exec("python3 /home/pi/iVacuation/print_top_left.py");
            } 
            else if(token.equals("top_right"))
            {
                    Process q = Runtime.getRuntime().exec("python3 /home/pi/iVacuation/print_top_right.py");
            } 
            else if(token.equals("bottom_left"))
            {
                    Process q = Runtime.getRuntime().exec("python3 /home/pi/iVacuation/print_bottom_left.py");
            }
            else if(token.equals("bottom_right"))
            {
                    Process q = Runtime.getRuntime().exec("python3 /home/pi/iVacuation/print_bottom_right.py");
            }
            else if(token.equals("x"))
            {
                    Process q = Runtime.getRuntime().exec("python3 /home/pi/iVacuation/print_x.py");
            }
	     else if(token.equals("none"))
		{ Process q = Runtime.getRuntime().exec("python3 /home/pi/iVacuation/print_none.py");}            

        }

    }

}
