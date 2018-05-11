package multithreading;

// Fig. 23.8: Consumer.java
// Consumer's run method loops ten times reading a value from buffer.
import java.util.Random;

public class Consumer implements Runnable {

    private static Random generator = new Random();
    private Buffer sharedLocation; // reference to shared object

    // constructor
    public Consumer(Buffer shared) {
        sharedLocation = shared;
    } // end Consumer constructor

    // read sharedLocation's value four times and sum the values
    public void run() {
        int sum = 0;

        for (int count = 1; count <= 10; count++) {
            // sleep 0 to 3 seconds, read value from buffer and add to sum
            try {
                Thread.sleep(generator.nextInt(3000));
                sum += sharedLocation.get();
                //System.out.printf("\t\t\t%2d\n", sum);
            } // end try
            // if sleeping thread interrupted, print stack trace
            catch (InterruptedException exception) {
                exception.printStackTrace();
            } // end catch
        } // end for

        System.out.printf("\n%s %d.\n%s\n",
                "Consumer read values totaling", sum, "Terminating Consumer.");
    } // end method run
} // end class Consumer


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/