package dev.treppmann.leetcode.api.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document
@Data
public class Problem {
    @Id
    private String id;
    private String name;
    private List<String> description;
    private List<String> hints;
    private String sampleInput;
    private String sampleOutput;
    private String optimalComplexity;
    private Difficulty difficulty;
    private List<Category> categories;
    private Map<ProgrammingLanguage, String> placeholderCode;
}
