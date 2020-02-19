package com.distributedsystems.helpers;

import java.util.HashMap;
import java.util.Map;


public class Helpers {

    public static Map<String, String> userStatusMap;
    static {
        userStatusMap = new HashMap() {
        };
        userStatusMap.put("ACTIVE", "Ενεργός");
        userStatusMap.put("DISABLED", "Ανενεργός");
        userStatusMap.put("Ενεργός", "ACTIVE");
        userStatusMap.put("Ανενεργός", "DISABLED");
    }


    public static Map<String, String> statusStatusMap;
    static {
        statusStatusMap = new HashMap() {
        };
        statusStatusMap.put("PENDING", "Εκκρεμεί");
        statusStatusMap.put("APPROVED", "Εγκεκριμένη");
        statusStatusMap.put("REJECTED", "Απορριφθήσα");
        statusStatusMap.put("Ενεργός", "PENDING");
        statusStatusMap.put("Εγκεκριμένη", "APPROVED");
        statusStatusMap.put("Απορριφθήσα", "REJECTED");
    }

    public static Map<Boolean, String> booleanStatusMap;
    static {
        booleanStatusMap = new HashMap() {
        };
        booleanStatusMap.put(true, "Ναι");
        booleanStatusMap.put(false, "Όχι");
    }
}
