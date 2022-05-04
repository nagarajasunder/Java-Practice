import java.util.ArrayList;
import java.util.List;


class ExcelRange {

    public static void main(String[] args) {
        System.out.println(cellsInRange("K1:L2"));
    }

    public static List<String> cellsInRange(String s) {

        List<String> range = new ArrayList<>();

        char startCol = s.charAt(0);
        int startRow = Character.getNumericValue(s.charAt(1));

        char endCol = s.charAt(3);
        int endRow = Character.getNumericValue(s.charAt(4));

        while (startCol <= endCol) {

            for (int i = startRow; i <= endRow; i++) {
                String row = startCol+String.valueOf(i);
                range.add(row);
            }

            startCol++;
        }

        return range;

    }
}