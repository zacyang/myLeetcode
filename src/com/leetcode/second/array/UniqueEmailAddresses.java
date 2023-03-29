package com.leetcode.second.array;

import java.util.Arrays;
import java.util.HashSet;

class Email {
    String full;
    String local;
    String domain;

    public Email(String full) {
        this.full = full;
        String[] split = full.split("@");
        this.domain = split[1];
        this.local = toLocal(split[0]);
    }

    private String toLocal(String s) {
        int firstPlus = s.indexOf('+');
        String target = s;
        if(firstPlus!=-1) {
            target = s.substring(0, firstPlus);
        }

        return target.replace(".","");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;

        Email email = (Email) o;

        if (local != null ? !local.equals(email.local) : email.local != null) return false;
        return domain != null ? domain.equals(email.domain) : email.domain == null;
    }

    @Override
    public int hashCode() {
        int result = local != null ? local.hashCode() : 0;
        result = 31 * result + (domain != null ? domain.hashCode() : 0);
        return result;
    }
}

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<Email> set = new HashSet<>();
        Arrays.stream(emails).map(e -> new Email(e)).forEach((e)-> set.add(e));
        return set.size();

    }
}
