public class ReplaceCharWithCount {
    public static void main(String[] args) {
        String input = "OPENTEXT";
        char target = 'T'; // Note: The image shows uppercase 'T'
        
        String result = replaceWithOccurrence(input, target);
        System.out.println("Output: " + result); // Outputs: OPEN1EX2
    }

    public static String replaceWithOccurrence(String str, char target) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (currentChar == target) {
                cnt++;
                sb.append(cnt); // Automatically converts the integer to a string digit
            } else {
                sb.append(currentChar); // Keep the original character
            }
        }

        return sb.toString();
    }
}