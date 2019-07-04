import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n=in.nextInt();
        int ans=0;
        Solver solver=new Solver();
        for (int i = 0; i < n; i++) {
            String testString=in.nextLine();
            ans+=solver.solve(testString) ? 1 : 0;
        }
        out.println(ans);
        out.close();
    }
}

class Solver {
    public boolean validator(String testString) {
        Pattern pattern=Pattern.compile("^([1-7](TAX|TBX|TEX) \\d{4})|([1-6](TAX|TBX) \\d{4})$");
        Matcher matcher=pattern.matcher(testString);
        return matcher.matches();
    }

    public boolean solve(String testString) {
        return validator(testString) && !testString.contains("0000");
    }
}
