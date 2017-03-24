import java.util.Scanner;
public class BazaDoi{
	public static void main (String[] args){
		int og=0,n;
		Scanner s=new Scanner(System.in);
		System.out.println("type a number ");
		n=s.nextInt();
		while(n>0){
			og=og*10+n%2;
			n=n/2;
		}
		n=0;
		while(og>0){
			n=n*10+og%10;
			og=og/10;
		}
		System.out.println(n);
	}
}