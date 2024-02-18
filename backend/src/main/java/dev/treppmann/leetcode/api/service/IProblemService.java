package dev.treppmann.leetcode.api.service;

import dev.treppmann.leetcode.api.dto.ProblemDTO;
import dev.treppmann.leetcode.api.dto.ProblemListDTO;
import dev.treppmann.leetcode.api.exception.ProblemNotFoundException;

import java.util.List;

public interface IProblemService {
    List<ProblemListDTO> getProblems();
    ProblemDTO getProblemById(String problemId) throws ProblemNotFoundException;
}
