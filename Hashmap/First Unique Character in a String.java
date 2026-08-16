class Solution {
    public int firstUniqChar(String s) {
    Map<Character, Integer> freq = new HashMap<>();

    // Pass 1: count frequencies
    for (char c : s.toCharArray()) {
        freq.put(c, freq.getOrDefault(c, 0) + 1);
    }

    // Pass 2: find first index with freq = 1
    for (int i = 0; i < s.length(); i++) {
        if (freq.get(s.charAt(i)) == 1) {
            return i;
        }
    }

    return -1;
}

}
