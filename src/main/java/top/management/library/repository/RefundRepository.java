package top.management.library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import top.management.library.entity.workflow.Refund;
import top.management.library.repository.base.AbstractRepository;

@Repository
public interface RefundRepository extends AbstractRepository<Refund,Long> {

    Page<Refund> findRefundsByRefundLauncher(String refundLauncher, Pageable pageable);
}
