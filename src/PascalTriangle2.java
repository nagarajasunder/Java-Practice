import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

    public static List<Integer> getRow(int rowIndex) {

        List<Integer> pascal = new ArrayList<>(rowIndex+1);
        System.out.println(pascal);

        for(int i = 0;i<=rowIndex;i++)
        {
            pascal.add(0);
            for(int j = i;j>=0;j--)
            {
                if(j == 0 || j == i)
                {
                    pascal.set(j,1);
                }
                else
                {
                    pascal.set(j,pascal.get(j) + pascal.get(j-1));
                }
            }
            System.out.println(pascal+" for i "+i);
        }

        return pascal;
    }
}
