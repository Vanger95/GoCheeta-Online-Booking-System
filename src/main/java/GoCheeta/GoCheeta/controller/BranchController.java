package GoCheeta.GoCheeta.controller;

import GoCheeta.GoCheeta.entity.Branch;
import GoCheeta.GoCheeta.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BranchController {

    @Autowired
    private BranchService branchService;

    // Save operation
    @PostMapping("/branches")
    public Branch saveBranch(@RequestBody Branch branch)
    {

        return branchService.saveBranch(branch);
    }

    // Read operation
    @GetMapping("/branches")
    public List<Branch> fetchBranchList()
    {

        return branchService.fetchBranchList();
    }
}
