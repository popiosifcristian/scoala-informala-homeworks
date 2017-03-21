import java.util.Scanner;
public class MaxDigit{
	public static void main(String[] args){
		Scanner s= new Scanner(System.in);
		int n,md;
		System.out.println("please type a number ");
		n=s.nextInt();
		md=n%10;
		while(n>0){
			if(n%10>md)
				md=n%10;
			n=n/10;
		}
		System.out.println("the max digit of that number is "+md);
		s.close();
	}
}