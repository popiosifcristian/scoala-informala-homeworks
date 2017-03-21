import java.util.Scanner;
public class Smallest{
	public static void main(String[] args){
		int n,i,sn;
		Scanner s = new Scanner(System.in);
		System.out.println("please type the size of the number collection ");
		n=s.nextInt();
		int a[]=new int[n];
		System.out.println("now please fill the number collection with "+n+" numbers");
		for(i=0;i<n;i++){
			a[i]=s.nextInt();
		}
		sn=a[0];
		for(i=0;i<n;i++){
			if(a[i]<sn)
				sn=a[i];
		}
		System.out.println("the smallest number of this number collection is "+sn);
		s.close();
	}
}