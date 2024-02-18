package dev.treppmann.leetcode.api.mapper;

import dev.treppmann.leetcode.api.dto.ProblemDTO;
import dev.treppmann.leetcode.api.dto.ProblemListDTO;
import dev.treppmann.leetcode.api.entity.Problem;

public class ProblemMapper {
    public static ProblemDTO mapProblemtoDTO(Problem problem) {
        return new ProblemDTO();
    }

    public static ProblemListDTO mapProblemToListDTO(Problem problem) {
        return new ProblemListDTO();
    }
}
