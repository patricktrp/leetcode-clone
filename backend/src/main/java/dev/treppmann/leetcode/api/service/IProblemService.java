package dev.treppmann.leetcode.api.service;

import dev.treppmann.leetcode.api.dto.ProblemDTO;
import dev.treppmann.leetcode.api.dto.ProblemListDTO;
import dev.treppmann.leetcode.api.entity.Problem;
import dev.treppmann.leetcode.api.exception.ProblemNotFoundException;

import java.util.List;

public interface IProblemService {
    List<Problem> getProblems();
    Problem getProblemById(String problemId) throws ProblemNotFoundException;
}
