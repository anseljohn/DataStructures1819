import java.util.Scanner;

public class PersonB {
	
	public static void main(String[] args) {
		
		Scanner sc = new scanner(System.in);

		try
		{
			String name = sc.nextLine();
			StringBuilder sb = new StringBuilder(name);
			System.out.println(sb.reverse());
		}
		catch ( Exception e )
		{
			System.out.print( e );
		}
		finally
		{
			if ( sc != null )
			{
				sc.close();
			}
		}
	}
	
}
