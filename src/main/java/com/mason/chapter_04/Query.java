package com.mason.chapter_04;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toMap;

/**
 * @author yongshi
 * @date 2022/11/7 22:44
 * @Description 查询的接口
 */
public class Query implements Predicate<Document> {
    private final Map<String, String> clauses;

    public Query(Map<String, String> clauses) {
        this.clauses = clauses;
    }

    static Query parse(String query) {
        return new Query(Arrays.stream(query.split(","))
                .map(str -> str.split(":"))
                .collect(toMap(x -> x[0], x -> x[1])));

    }

    @Override
    public boolean test(Document document) {
        return clauses.entrySet().stream().allMatch(entry -> {
            final String documentValue = document.getAttributes(entry.getKey());
            final String queryValue = entry.getValue();
            return document != null && documentValue.contains(queryValue);
        });
    }
}
