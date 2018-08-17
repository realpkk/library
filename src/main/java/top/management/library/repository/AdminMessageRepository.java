package top.management.library.repository;

import org.springframework.stereotype.Repository;
import top.management.library.entity.workflow.AdminMessage;
import top.management.library.repository.base.AbstractRepository;

@Repository
public interface AdminMessageRepository extends AbstractRepository<AdminMessage,Long> {

    int countAdminMessagesByMessageStatus(Integer status);
}
