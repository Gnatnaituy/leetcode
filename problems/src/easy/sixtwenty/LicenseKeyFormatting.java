package easy.sixtwenty;

/**
 * 482 License Key Formatting
 *
 * You are given a license key represented as a string S which consists only alphanumeric character and dashes.
 * The string is separated into N+1 groups by N dashes.
 *
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters,
 * except for the first group which could be shorter than K, but still must contain at least one character.
 * Furthermore,
 * there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
 *
 * Given a non-empty string S and a number K, format the string according to the rules described above.
 *
 * Example 1:
 * Input: S = "5F3Z-2e-9-w", K = 4
 *
 * Output: "5F3Z-2E9W"
 *
 * Explanation: The string S has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 *
 * Example 2:
 * Input: S = "2-5g-3-J", K = 2
 *
 * Output: "2-5G-3J"
 *
 * Explanation: The string S has been split into three parts,
 * each part has 2 characters except the first part as it could be shorter as mentioned above.
 */

public class LicenseKeyFormatting {

    private static String licenseKeyFormatting(String S, int K) {
        StringBuilder res = new StringBuilder();
        char[] sUpper = S.toUpperCase().toCharArray();
        int count = 0;
        for (int i = sUpper.length - 1; i >= 0; i--) {
            if (sUpper[i] != '-') {
                res.append(sUpper[i]);
                count++;
            }
            if (count == 4) {
                res.append('-');
                count = 0;
            }
        }

        if (res.length() != 0 && res.charAt(res.length() - 1) == '-')
            res.deleteCharAt(res.length() - 1);

        return res.reverse().toString();
    }
}
