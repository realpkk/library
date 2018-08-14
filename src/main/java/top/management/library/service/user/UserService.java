package top.management.library.service.user;

;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;
import org.springframework.transaction.annotation.Transactional;
import top.management.library.entity.user.User;
import top.management.library.repository.UserRepository;


@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public void createUser(User user){

            userRepository.save(user);

    }

    public User findUserByLoginName(String loginName) {

        return userRepository.findUserByLoginName(loginName);
    }

    public boolean duplicateCheck(String loginName) {

        User user = findUserByLoginName(loginName);
        return (user != null);
    }


    public String getUsernameByUserLoginName(String loginName) {

        return userRepository.findUserByLoginName(loginName).getUsername();
    }
}
