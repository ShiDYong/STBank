package com.mason.chapter_05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yongshi
 * @date 2022/11/13 17:24
 * @Description TODO
 */
public class Facts {
    private final Map<String, String> facts = new HashMap<>();

    public String getFact(String name) {

        return this.facts.get(name);
    }

    public void addFact(String name, String value) {
        this.facts.put(name, value);
    }


}
