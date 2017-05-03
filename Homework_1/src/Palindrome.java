import java.util.Scanner;
public class Palindrome{
	public static void main(String[] args){
	Scanner s = new Scanner(System.in);
		int n,m,og=0;
		System.out.println("please type a number ");
		n=s.nextInt();
		m=n;
		while(m>0){
			og=og*10+m%10;
			m=m/10;
		}
		if(n==og)
			System.out.println("is a palindrome");
		else
			System.out.println("is not a palindrome");
		s.close();
	}
}