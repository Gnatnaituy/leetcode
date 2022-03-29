package classify.hash;

public class RansomNote {

    /**
     * 4ms      30.25%
     * 41.1MB   65.12%
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            if (i < ransomNote.length()) {
                counter[ransomNote.charAt(i) - 'a']++;
            }
            counter[magazine.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count > 0) {
                return false;
            }
        }

        return true;
    }
}
