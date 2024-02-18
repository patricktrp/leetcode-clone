package dev.treppmann.leetcode.api.controller;

import dev.treppmann.leetcode.api.dto.ProblemDTO;
import dev.treppmann.leetcode.api.dto.ProblemListDTO;
import dev.treppmann.leetcode.api.exception.ProblemNotFoundException;
import dev.treppmann.leetcode.api.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/problems")
public class ProblemController {
    private final IProblemService problemService;

    @Autowired
    public ProblemController(IProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping
    public List<ProblemListDTO> getProblems() {
        return problemService.getProblems();
    }

    @GetMapping
    @RequestMapping("/{problemId}")
    public ProblemDTO getProblemById(@PathVariable String problemId) {
        try {
            return problemService.getProblemById(problemId);
        } catch (ProblemNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
