class Solution {
    // Approach: Fails for 24 hour false case scenario:["14:13","22:08"]
    // ["02:40","08:08"]
    public boolean haveConflict(String[] event1, String[] event2) {
        int time1 = 0, time2 = 0;
        for (int i = 0; i < event1.length; i++) {
            if (i == 2) {
                continue;
            }

            char ch = event1[1].charAt(i);
            int digit = ch - '0';
            time1 = time1 * 10 + digit;

            ch = event2[0].charAt(i);
            digit = ch - '0';
            time2 = time2 * 10 + digit;
        }

        if (time1 < time2) {
            return false;
        } else {
            return true;
        }
    }
}