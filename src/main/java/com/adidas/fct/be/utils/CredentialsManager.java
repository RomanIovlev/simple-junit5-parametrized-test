package com.adidas.fct.be.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by diego.merino on 13/07/2017.
 */
public class CredentialsManager {

    private static CredentialsManager instance;
    private Map<String, String> credentials;

    private CredentialsManager() {
        credentials = new HashMap<>();
        String environment = System.getProperty("env");
        if ("SIT".equals(environment) || "SIT2".equals(environment)) {
            credentials.put("FCT_Auto1", "adipdm2");
            credentials.put("FCT_Auto2", "adipdm1");
            credentials.put("tst_sampajos", "adipdm2");
            credentials.put("tst_sampajos1", "reebok1");
            credentials.put("tst_sampajos2", "adipdm2");
            credentials.put("tst_sampajos3", "adipdm3");
            credentials.put("tst_sampajos4", "adipdm3");
            credentials.put("tst_sampajos5", "adipdm2");
            credentials.put("tst_sampajos6", "adipdm2");
            credentials.put("tst_sampajos7", "adipdm2");
            credentials.put("tst_sampajos8", "adipdm2");
            credentials.put("tst_sampajos9", "adipdm2");
            credentials.put("tst_sampajos10", "adipdm2");
            credentials.put("tst_sampajos11", "adipdm2");
            credentials.put("sampajos", "adipdm2");
        } else if ("UAT".equals(environment)) {
            credentials.put("sampajos", "adipdm2");
            credentials.put("tst_sampajos", "adipdm1");
        } else {
            credentials.put("tst_sampajos", "adipdm1");
        }
    }

    public static CredentialsManager get() {
        if (instance == null)
            instance = new CredentialsManager();
        return instance;
    }

    public String password(String username) {
        return credentials.get(username);
    }
}
