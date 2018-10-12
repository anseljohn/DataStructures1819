import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerPractice {
	
    private static String favFood = "nothing yet";
    private static int amount = 0;
    private static double liking = 0.0;
    private static int total = 0;

    static Scanner sc = null;
    public static void main(String[] args) {
        try {
            System.out.print( "Your favorite food is " + getFavFood() + ".\nYou eat " + getFavFood() + " %" + ( amount/( double )total ) * 100+ " of the time." );
        }
        catch ( Exception e ) {
            System.out.println( e );
        }
        finally {
            if ( sc != null ) {
                sc.close();
            }
        }
    }
    
    public static String getFavFood() {
        File f = new File( "./src/foods.txt" );
        try {
            sc = new Scanner( f );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }        
        while ( sc.hasNext() ) {
        	favFood = sc.nextLine();
        	amount = sc.nextInt();
        	total += amount;
        	liking = sc.nextDouble();
        	sc.nextLine();
        	
        }
        return favFood;
    }
}
