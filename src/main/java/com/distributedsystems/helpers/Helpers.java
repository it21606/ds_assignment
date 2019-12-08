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
}
