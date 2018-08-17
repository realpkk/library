package top.management.library.service.workflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.management.library.entity.workflow.AdminMessage;
import top.management.library.repository.AdminMessageRepository;

@Service
public class MessageService {

    @Autowired
    private AdminMessageRepository adminMessageRepository;

    public void createMessage(AdminMessage message) {

        adminMessageRepository.save(message);
    }

    public Page<AdminMessage> findUnReadedMessages(Pageable pageable) {

        return adminMessageRepository.findAll(pageable);
    }

    public Integer countUnReadedMessages() {

        return adminMessageRepository.countAdminMessagesByMessageStatus(0);
    }
}
