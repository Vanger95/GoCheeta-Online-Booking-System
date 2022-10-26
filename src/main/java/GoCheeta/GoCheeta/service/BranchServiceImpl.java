package GoCheeta.GoCheeta.service;

import GoCheeta.GoCheeta.entity.Branch;
import GoCheeta.GoCheeta.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BranchServiceImpl implements BranchService{

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public Branch saveBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public List<Branch> fetchBranchList() {
        return (List<Branch>)
                branchRepository.findAll();
    }

    @Override
    public Branch getBranchbyId(Integer branchId) {
        return branchRepository.findById(branchId).get();
    }

    @Override
    public Branch updateBranch(Branch branch, Integer branchId) {
        Branch depDB = branchRepository.findById(branchId).get();

        if (Objects.nonNull(branch.getBranchName())
                && !"".equalsIgnoreCase(branch.getBranchName())) {
            depDB.setBranchName(
                    branch.getBranchName());
        }
        return branchRepository.save(depDB);
    }

    @Override
    public void deleteBranchById(Integer branchId) {
        branchRepository.deleteById(branchId);
    }
}
