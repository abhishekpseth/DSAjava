package HashMap;

import java.util.*;

public class p9_FindCommonCharacters {
    Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> mp = new HashMap<>();

        for(Character ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        return mp;
    }

    Map<Character, Integer> getCommon(Map<Character, Integer> mp1, Map<Character,Integer> mp2) {
        Map<Character, Integer> res = new HashMap<>();

        mp1.forEach((key, value) -> {
            if(mp2.containsKey(key)) {
                res.put(key, Math.min(value, mp2.get(key)));
            }
        });

        return res;
    }

    public List<String> commonChars(String[] words) {
        Map<Character, Integer> ans = getMap(words[0]);

        for(int i=1; i<words.length; i++) {
            ans = getCommon(ans, getMap(words[i]));
        }

        List<String> res = new ArrayList<>();

        ans.forEach((key, value) -> {
            for(int i=0; i<value; i++) {
                res.add(key.toString());
            }
        });

        return res;
    }
}
