import java.util.*;
import java.net.*;
import java.io.*;

public class TempRingMain {

    public static void main(String args[]) throws Exception {
        // Generate an Integer token
        Double tn = new Double(0.0);
        Double ts = new Double(0.0);
        Double te = new Double(0.0);
        Double tw = new Double(0.0);

        ServerSocket waitFornorthTokenSocket = new ServerSocket(1234); Socket incomingnorthSocket;
        ServerSocket waitForsouthTokenSocket = new ServerSocket(1235); Socket incomingsouthSocket;
        ServerSocket waitForeastTokenSocket = new ServerSocket(1236); Socket incomingeastSocket;
        ServerSocket waitForwestTokenSocket = new ServerSocket(1237); Socket incomingwestSocket;



        while (true) {
        incomingnorthSocket = waitFornorthTokenSocket.accept();
            ObjectInputStream inn = new ObjectInputStream(incomingnorthSocket.getInputStream());
            tn = (Double) inn.readObject();
			System.out.println(tn);



            incomingsouthSocket = waitForsouthTokenSocket.accept();
            ObjectInputStream ins = new ObjectInputStream(incomingsouthSocket.getInputStream());
            ts = (Double) ins.readObject();
            System.out.println(ts);




            incomingeastSocket = waitForeastTokenSocket.accept();
            ObjectInputStream ine = new ObjectInputStream(incomingeastSocket.getInputStream());
            te = (Double) ine.readObject();
System.out.println(te);
            



            incomingwestSocket = waitForwestTokenSocket.accept();
            ObjectInputStream inw = new ObjectInputStream(incomingwestSocket.getInputStream());
            tw = (Double) inw.readObject();
System.out.println(tw);

System.out.println("Full Set ofValues Recieved");

        ObjectOutputStream northout = new ObjectOutputStream(incomingnorthSocket.getOutputStream());
        ObjectOutputStream southout = new ObjectOutputStream(incomingsouthSocket.getOutputStream());
        ObjectOutputStream eastout = new ObjectOutputStream(incomingeastSocket.getOutputStream());
        ObjectOutputStream westout = new ObjectOutputStream(incomingwestSocket.getOutputStream());

         if(  tn>=ts && tn>=te && tn>=tw  && tn>=40.0)//IF NORTH HAS HIGHEST TEMP and is FIRE
    {
            Process p = Runtime.getRuntime().exec("python3 /home/pi/soundalarm.py");
            northout.writeObject("x");
            eastout.writeObject("left");
            southout.writeObject("up");
            if(ts<tw)
                westout.writeObject("right");
            
            else
                westout.writeObject("top_right");
System.out.println("North Highest");
    }

    else if(  te>=ts && te>=tn && te>=tw  && te>=40.0)//IF East HAS HIGHEST TEMP and is FIRE
    {
            Process p = Runtime.getRuntime().exec("python3 /home/pi/soundalarm.py");

            northout.writeObject("right");
            eastout.writeObject("x");
            westout.writeObject("up");
            if(tw<ts)
                southout.writeObject("left");
            else
                southout.writeObject("top_left");
System.out.println("East Highest");
    }
   else if(  tw>=ts && tw>=tn && tw>=te  && tw>=40.0)//IF West HAS HIGHEST TEMP and is FIRE
    {
            Process p = Runtime.getRuntime().exec("python3 /home/pi/soundalarm.py");

            
            westout.writeObject("x");
            if(tn<te){
                southout.writeObject("top_left");
		eastout.writeObject("bottom_left");
                northout.writeObject("right");}
            else{
                southout.writeObject("up");
		eastout.writeObject("left");
                northout.writeObject("bottom_right");}
System.out.println("West Highest");
    }
    else if(  ts>=tw && ts>=tn && ts>=te  && ts>=40.0)//IF South HAS HIGHEST TEMP and is FIRE
    {
            Process p = Runtime.getRuntime().exec("python3 /home/pi/soundalarm.py");

            
       
            southout.writeObject("x");
            
            if(tn<te){
		northout.writeObject("right");
                eastout.writeObject("bottom_left");
                westout.writeObject("up");}
                
            else{
		northout.writeObject("bottom_right");
                eastout.writeObject("left");
                westout.writeObject("top_right");
                 }
System.out.println("South Highest");
    }
	else{
		northout.writeObject("none");
eastout.writeObject("none");
westout.writeObject("none");
southout.writeObject("none");
}
        Thread.sleep(5000);




            
            
        }
	

    }

}


