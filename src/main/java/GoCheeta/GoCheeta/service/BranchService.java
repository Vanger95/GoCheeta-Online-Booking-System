package GoCheeta.GoCheeta.service;

import GoCheeta.GoCheeta.entity.Branch;

import java.util.List;

public interface BranchService {

    Branch saveBranch(Branch branch);

    // Read operation
    List<Branch> fetchBranchList();

    // Read operation
    Branch getBranchbyId (Integer branchId);

    // Update operation
    Branch updateBranch(Branch branch,
                            Integer branchId);

    // Delete operation
    void deleteBranchById(Integer branchId);
}
