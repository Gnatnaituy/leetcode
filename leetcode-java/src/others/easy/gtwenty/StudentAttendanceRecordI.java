package others.easy.gtwenty;

/**
 * 551 Student Attendance Record I
 *
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
 * or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 *
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */

public class StudentAttendanceRecordI {

    private static boolean checkRecord(String s) {
        int timeA = 0;
        int timeL = 0;

        for (int i = 0; i < s.length(); i++) {
            if (timeA > 1) return false;
            if (timeL > 2) return false;

            if (s.charAt(i) == 'A') timeA++;
            if (s.charAt(i) == 'L') timeL++;
            if (i > 0 && s.charAt(i - 1) == 'L' && s.charAt(i) != 'A') timeL = 0;
        }

        return timeL <= 2 && timeA <= 1;
    }
}
