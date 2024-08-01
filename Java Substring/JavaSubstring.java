import java.util.*;

public class JavaSubstring {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String S = in.next();
            int start = in.nextInt();
            int end = in.nextInt();
            
            String[] strSplit = S.split("");
            
            ArrayList<String> strList = new ArrayList<>(
                    Arrays.asList(strSplit)
            );
            
            for(int i = start; i < end; i++){
                System.out.print(strList.get(i));
            }
        }
    }
}