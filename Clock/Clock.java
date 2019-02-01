import java.util.InputMismatchException;
import java.util.Scanner;

public class Clock {

    private static int[] mTimes = new int[24];
    private static int mCurrentTime;

    public static void main( String[] args ) {
        
        for ( int i = 0; i < 24; i++ ) {
            mTimes[i] = i;
        }

        try {
            Scanner sc = new Scanner( System.in );
            System.out.print( "Current time (0-23): " );
            mCurrentTime = sc.nextInt();
            if ( mCurrentTime > 23 || mCurrentTime < 0 ) {
                throw new InputMismatchException( "Time cannot be outside of bounds 0-23" );
            }
            
            while ( true ) {
                int ffRR;
                System.out.print( "Fast foward/rewind how many hours? ");
                ffRR = sc.nextInt();
                mCurrentTime = mTimes[ timeAfter( ffRR ) ];
                System.out.println( "Time after " + ffRR + " hours: " + mCurrentTime );
            }
        } catch ( Exception e ) {
            System.out.println( e );
        }
    }

    public static int timeAfter( int hours ) {
        hours += mCurrentTime;
        hours %= 24;
        if ( hours < 0 ) {
            hours += 24;
        }
        return hours;
    }
}