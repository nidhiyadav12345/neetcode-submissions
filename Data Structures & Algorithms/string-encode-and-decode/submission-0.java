class Solution {

    // Encode
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    // Decode
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {

            // Find '#'
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            // Length of next string
            int len = Integer.parseInt(str.substring(i, j));

            // Move after '#'
            j++;

            // Extract the string
            result.add(str.substring(j, j + len));

            // Move to next encoded string
            i = j + len;
        }

        return result;
    }
}