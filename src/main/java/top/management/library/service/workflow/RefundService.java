package top.management.library.service.workflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.management.library.entity.workflow.Refund;
import top.management.library.repository.RefundRepository;

@Service
public class RefundService {

    @Autowired
    private RefundRepository refundRepository;

    public void createRefundRecord(Refund refund) {

        refundRepository.save(refund);
    }

    public Page getAllRefunds(Pageable pageable) {

        return refundRepository.findAll(pageable);
    }

    public Page getRefundsByLauncher(String launcher, Pageable pageable) {

        return refundRepository.findRefundsByRefundLauncher(launcher,pageable);
    }
}
