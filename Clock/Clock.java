import java.util.Scanner;

public class Clock {

    private static int[] mTimes = new String[24];
    private static int mCurrentTime;

    public static void main( String[] args ) {
        
        for ( int i = 0; i < 24; i++ ) {
            mTimes[i] = i;
        }


        Scanner sc = new Scanner( System.in );
        System.out.print( "Current time (0-24): " );
        mCurrentTime = sc.nextInt();
        
        int ffRR;
        System.out.print( "Fast foward/rewing how many hours? ");
        ffRR = sc.nextInt();
        System.out.println( "Time after " + ffRR + " hours: " + timeAfter( ffRR ) );
    }

    public int timeAfter( int nextTime ) {

    }
}