import java.util.Stack;

public class ValidParanthesis {

    public boolean isVaild(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.length() == 0) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            char at = s.charAt(i);

            if (at == '(' || at == '[' || at == '{') {
                stack.push(at);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char last = stack.pop();

                if (last == '(' && at != ')') return false;
                if (last == '[' && at != ']') return false;
                if (last == '{' && at != '}') return false;
            }

        }

        return stack.isEmpty();

    }

}
