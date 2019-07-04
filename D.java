import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n=in.nextInt();
        int[] a=new int[n];
        for (int i = 0; i <n ; i++) a[i]=in.nextInt();
        out.format("%.13f", Arrays.stream(a).average().orElse(0.0));
        out.close();
    }
}
