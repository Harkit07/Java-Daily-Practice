public class BackTracking {
    public static void printSubSet(String str, StringBuilder ans, int i) {
        if (str.length() == i) {
            System.out.println(ans);
            return;
        }
        printSubSet(str, ans.append(str.charAt(i)), i + 1);
        ans.deleteCharAt(ans.length() - 1);
        printSubSet(str, ans, i + 1);
    }

    public static void premutition(String str, StringBuilder ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String newStr = str.substring(0,i)+str.substring(i+1);
            premutition(newStr, ans.append(ch));
            ans.deleteCharAt(ans.length()-1);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        // printSubSet(str, new StringBuilder(""), 0);
        premutition(str, new StringBuilder(""));
    }
}
