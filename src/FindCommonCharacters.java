
import java.awt.desktop.PrintFilesEvent;
import java.util.ArrayList;
import java.util.List;

/*
 * Problem link https://leetcode.com/problems/find-common-characters/submissions/
 * How this works for input [bella,label,roller]
 * Lets take the 0th index as String s = "bella"
 * Then compare this with the other string iterating from 1 to n
 * if a particular character of i is present in any of the other string remove character and update the particular index
 * Ex for i = 0 and j = 1 s.charAt(i) = 'b' so "Label" contains the character 'b' at index 2 so it is changed to lael - b is removed
 * If a particular character doesn't exist then break the loop
 * If a particular character appears in every indices of string then add that character to the list
 * */

public class FindCommonCharacters {
    public static List<String> commonChars(String[] words) {

        ArrayList<String> list = new ArrayList<>();
        String s = words[0];

        int n = words.length;

        for (int i = 0; i < s.length(); i++) {

            int j;
            for (j = 1; j < n; j++) {

                int idx = words[j].indexOf(s.charAt(i));

                if (idx != -1) {
                    words[j] = words[j].substring(0, idx) + words[j].substring(idx + 1);
                } else {
                    break;
                }
            }
            if (j == n) {
                list.add(String.valueOf(s.charAt(i)));
            }

        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
    }
}