import java.util.Scanner;
public class Prime{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n,d;
		boolean ok;
		System.out.println("please type a number ");
		n=s.nextInt();
		System.out.println("here are all the prime numbers lower than this number");
		while(n>2){
			n--;
			d=2;
			ok=true;
			while(d<Math.sqrt(n)&&ok){
				if(n%d==0)
					ok=false;
				d++;
			}
			if(ok)
				System.out.println(n);
		}
		s.close();
	}
}