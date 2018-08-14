package top.management.library.repository;

import org.springframework.stereotype.Repository;
import top.management.library.repository.base.AbstractRepository;
import top.management.library.entity.user.User;

@Repository
public interface UserRepository extends AbstractRepository<User,Long> {

    User findUserByLoginName(String loginName);

    User findOneById(Long id);
}
