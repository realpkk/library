package top.management.library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import top.management.library.entity.workflow.AfterSale;
import top.management.library.repository.base.AbstractRepository;

@Repository
public interface AfterSaleRepository extends AbstractRepository<AfterSale,Long> {

    Page<AfterSale> findAfterSalesByApplicationLauncher(String refundLauncher, Pageable pageable);

    AfterSale findAfterSalesByApplicationCode(String applicationCode);

    void deleteAfterSaleByApplicationCode(String applicationCode);

    @Modifying
    @Query("update AfterSale a set a.approvalStatus=2 where a.applicationCode=?1")
    int passApplication(String applicationCode);

    @Modifying
    @Query("update AfterSale a set a.approvalStatus=3,a.reply=?2 where a.applicationCode=?1")
    int rejectApplication(String applicationCode,String reply);
}
