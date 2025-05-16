import java.util.Stack;

public class Palindrom {

        private String s;
        private static Stack<Character> stack = new Stack<Character>();

        public Palindrom(String s) {
            this.s = s.trim().toLowerCase(); // keine Leerzeichen
        }
        public static boolean isPalindrom(String s) {

            String st = s.toLowerCase();
            st = st.replaceAll(" ", "");
            String str = "";
            for(int i = 0; i < st.length(); i++) {
                stack.push(st.charAt(i));
            }
            for(int j = 0; j < st.length(); j++) {
                str += stack.pop();
            }
            return st.equals(str);
        }



    }

