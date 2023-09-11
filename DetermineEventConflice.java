class Solution {
    // Approach: Fails for 24 hour false case scenario:["14:13","22:08"]
    // ["02:40","08:08"]
    // public boolean haveConflict(String[] event1, String[] event2) {
    // int time1 = 0, time2 = 0;
    // for (int i = 0; i < event1.length; i++) {
    // if (i == 2) {
    // continue;
    // }

    // char ch = event1[1].charAt(i);
    // int digit = ch - '0';
    // time1 = time1 * 10 + digit;

    // ch = event2[0].charAt(i);
    // digit = ch - '0';
    // time2 = time2 * 10 + digit;
    // }

    // if (time1 < time2) {
    // return false;
    // } else {
    // return true;
    // }
    // }

    // Alternate approach: passes all test cases
    public boolean haveConflict(String[] event1, String[] event2) {
        // Bring all times to same unit by converting each into minutes
        int event1_start = Integer.parseInt(event1[0].substring(0, 2)) * 60 + Integer.parseInt(event1[0].substring(3));
        int event1_end = Integer.parseInt(event1[1].substring(0, 2)) * 60 + Integer.parseInt(event1[1].substring(3));
        int event2_start = Integer.parseInt(event2[0].substring(0, 2)) * 60 + Integer.parseInt(event2[0].substring(3));
        int event2_end = Integer.parseInt(event2[1].substring(0, 2)) * 60 + Integer.parseInt(event2[1].substring(3));

        // The only 2 ways to avoid conflict: i.e. returning false:
        // 1. event1_start <= event1_end < event2_start <= event2_end i.e. event1_end <
        // event2_start
        // 2. event2_start <= event2_end < event1_start <= event1_end i.e. event2_end <
        // event1_start
        if ((event1_end < event2_start) || (event2_end < event1_start)) {
            return false;
        }
        return true;
        // Edge Case: ["14:13","22:08"] ["02:40","08:08"]

        // if (((event2_start <= event1_end) && (event1_end <= event2_end))
        // || ((event2_end >= event1_start) && (event2_end <= event1_end))) {
        // return true;
        // }
        // return false;
    }

}