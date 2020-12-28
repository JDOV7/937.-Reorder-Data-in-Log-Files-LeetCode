package leetcode;

import java.util.Vector;
import java.util.Collections;

public class ReorderDatainLogFiles937 {

    public void ReorderDatainLogFiles937() {
        String[] logs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        Vector<DataUsers> vListUsersNumbers = new Vector();
        Vector<DataUsers> vListUsersLetters = new Vector();
        String sArrSortUsers[] = new String[logs.length];
        for (String log : logs) {
            if (log.charAt(log.indexOf(' ') + 1) >= '0' && log.charAt(log.indexOf(' ') + 1) <= '9') {
                vListUsersNumbers.add(new DataUsers(log.substring(0, log.indexOf(' ')), log.substring(log.indexOf(' ') + 1)));
            } else {
                vListUsersLetters.add(new DataUsers(log.substring(0, log.indexOf(' ')), log.substring(log.indexOf(' ') + 1)));
            }
        }
        Collections.sort(vListUsersLetters);
        vListUsersLetters.addAll(vListUsersNumbers);
        for (int i = 0; i < vListUsersLetters.size(); i++) {
            System.out.println(vListUsersLetters.get(i).toString());
            sArrSortUsers[i] = vListUsersLetters.get(i).toString();
        }
    }

    public class DataUsers implements Comparable<DataUsers> {

        String sIdentifier;
        String sPassword;

        public DataUsers(String sId, String sPass) {
            sIdentifier = sId;
            sPassword = sPass;
        }

        public String getsIdentifier() {
            return sIdentifier;
        }

        public String getsPassword() {
            return sPassword;
        }

        public String toString() {
            return getsIdentifier() + " " + getsPassword();
        }

        public int compareTo(DataUsers dUser) {
            if (dUser.getsPassword().compareTo(getsPassword()) < 0) {
                return 1;
            }
            if (dUser.getsPassword().compareTo(getsPassword()) > 0) {
                return -1;
            }
            if (dUser.getsIdentifier().compareTo(getsIdentifier()) < 0) {
                return 1;
            }
            if (dUser.getsIdentifier().compareTo(getsIdentifier()) > 0) {
                return -1;
            }
            return 0;
        }
    }
}
