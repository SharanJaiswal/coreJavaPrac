package kk.strings;

public class StringBuilderVsString {
    public static void main(String[] args) {
        String str1 = "";
        String str2 = "";
        for(int i = 0; i < 26; i++) {
            str1 += i;

            // At every iteration, new String object is created and de-referencing of old str occurs.
            char c = (char)(i + 'a');
            str2 += c; // This is so much of memory wastage. Also, there is an overhead of copying old str to new object,
                        // along with new character appending at the end. Hence, extra memory along with copying overhead.
                        // APPROACH IS LACKING PERFORMANCE: SPACE COMPLEXITY OF O(N^2)
        }
        System.out.println(str1);
        System.out.println(str2);

        /*
        If there would be data type where changes are happening in the same object instead of creating new object everytime.
        Hence, it'll be mutable, unlike Strings. It is StringBuilder class which provide many methods to its object. O(N)
         */


        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char)(i + 'a');
            strb.append(ch);
        }
        System.out.println(strb);
    }
}
