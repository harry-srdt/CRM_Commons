package in.co.srdt.utils;

import in.co.srdt.enums.Status;

public class StatusUtils {
    public static boolean isValidStatus(String status) {
        try {
            Status.valueOf(status.toUpperCase());
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }
}
