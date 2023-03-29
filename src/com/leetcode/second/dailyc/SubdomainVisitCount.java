package com.leetcode.second.dailyc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> register = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String cpdomain : cpdomains) {
            String[] s = cpdomain.split(" ");
            Integer count = Integer.valueOf(s[0]);
            String domain = s[1];
            String[] splitDomains = domain.split("\\.");
            register.compute(domain, (s1, integer) ->

            {
                Integer integer1 = register.get(s1);
                if(integer1==null) {
                    return count;
                } else {
                    return integer1+count;
                }
            });

            for (int i = 0; i < splitDomains.length-1; i++) {
                String splitDomain = splitDomains[i];
                domain = domain.substring(splitDomain.length()+1);
                register.compute(domain, (s1, integer) ->

                {
                    Integer integer1 = register.get(s1);
                    if(integer1==null) {
                        return count;
                    } else {
                        return integer1+count;
                    }
                });
            }

        }
        for (String key : register.keySet()) {
            result.add(register.get(key) + " "+ key);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = new SubdomainVisitCount().subdomainVisits(new String[]{
                "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
        });
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
