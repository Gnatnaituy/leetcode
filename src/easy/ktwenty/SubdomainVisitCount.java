package easy.ktwenty;

import java.util.*;

/**
 * 811 Subdomain Visit Count
 */

public class SubdomainVisitCount {
    
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        for (String domain : cpdomains) {
            String[] parts = domain.split(" ");
            Integer count = Integer.parseInt(parts[0]);
            map.put(parts[1], count);
            
            while (parts[1].contains(".")) {
                String subdomain = parts[1].substring(parts[1].indexOf(".") + 1);
                map.put(subdomain, map.get(subdomain) == null ? count : map.get(subdomain) + count);
                parts[1] = subdomain;
            }
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet())
            res.add(entry.getValue() + " " + entry.getKey());
        
        return res;
    }
}
