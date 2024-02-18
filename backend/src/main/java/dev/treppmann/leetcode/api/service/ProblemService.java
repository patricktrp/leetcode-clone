package dev.treppmann.leetcode.api.service;

import dev.treppmann.leetcode.api.dto.ProblemDTO;
import dev.treppmann.leetcode.api.dto.ProblemListDTO;
import dev.treppmann.leetcode.api.entity.Problem;
import dev.treppmann.leetcode.api.exception.ProblemNotFoundException;
import dev.treppmann.leetcode.api.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemService implements IProblemService {
    private final ProblemRepository problemRepository;

    @Autowired
    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @Override
    public List<Problem> getProblems() {
        List<Problem> problems = problemRepository.findAll();
        return problems;
    }

    @Override
    public Problem getProblemById(String problemId) throws ProblemNotFoundException {
        Problem problem = problemRepository.findById(problemId).orElseThrow(ProblemNotFoundException::new);
        return problem;
    }
}
