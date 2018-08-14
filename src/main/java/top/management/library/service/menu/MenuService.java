package top.management.library.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.management.library.entity.menu.Menu;
import top.management.library.entity.role.Role;
import top.management.library.entity.user.User;
import top.management.library.repository.MenuRepository;
import top.management.library.repository.UserRepository;

import java.util.*;

@Service
public class MenuService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> findAllMenus() {

        List<Menu> menuList = menuRepository.finAllMenus();
        return menuList;
    }

    public List<Menu> findMenusFromUser(User currentUser) {

        List<Long> roleIdList = new ArrayList<>();
        User user = userRepository.findOneById(currentUser.getId());
        if (user.getRoleList() != null) {
            for (Role role:user.getRoleList()){
                roleIdList.add(role.getId());
            }
        }
        if (roleIdList.size() >0) {
            List<Menu> menuList = menuRepository.findMenusByRoleId(roleIdList);
            Collections.sort(menuList);
            return menuList;
        }
        return new ArrayList<Menu>();
    }

    public List<Menu> findMenuTreeFromUser(User currentUser){

        if (currentUser == null){
            return new ArrayList<Menu>();
        }
        List<Menu> sourceList = findMenusFromUser(currentUser);
        return findMenuTree(sourceList);
    }

    public List<Menu> findMenuTree(List<Menu> sourceList){

        Map<Long,Menu> menuMap = new HashMap<>();

        while (true){
            if (sourceList ==null||sourceList.isEmpty()){
                break;
            }
            for (Menu menu:sourceList){
                menuMap.put(menu.getId(),menu);
            }
            List<Long> idList = new ArrayList<>();
            for (Menu menu:sourceList){
                if (menu.getParentId()!=null&&!menuMap.keySet().contains((menu.getParentId()))&&!idList.contains(menu.getParentId())){
                    idList.add(menu.getParentId());
                }
            }
            if (idList.size()>0){
                sourceList = menuRepository.findByIdIn(idList);
                continue;
            }
            break;
        }
        List<Menu> menuList = new ArrayList<>(menuMap.values());
        Collections.sort(menuList);
        return menuList;
    }

    public List<Menu> getParentMenuListFromUser(User currentUser){

        List<Menu> allMenuList = findMenuTreeFromUser(currentUser);
        List<Menu> parentMenuList = new ArrayList<>();
        for (Menu menu:allMenuList){
            if (menu.getType()==1&&menu.getParentId()==null){
                parentMenuList.add(menu);
            }
        }
        return parentMenuList;
    }

    public List<Menu> getParentTreeMenu(List<Menu> parentList){

        for (Menu parentMenu:parentList){
            parentMenu.setMenuList(menuRepository.findMenusByParentIdIs(parentMenu.getId()));
        }
        return parentList;
    }

    public List<Menu> getCompleteMenuFromUser(User currentUser){

        List<Menu> parentList = getParentMenuListFromUser(currentUser);
        List<Menu> completeMenulist = getParentTreeMenu(parentList);
        return completeMenulist;
//        List<Menu> sourceList = findMenuTreeFromUser(curreentUser);
//        for (Menu menu:sourceList){
//            if (menu.getType()==1){
//                completeMenulist.add(menu);
//            }
//        }
//        for (Menu menu:completeMenulist){
//            if (menu.getParentId() == null){
//                menu.setMenuList(menuRepository.findMenusByParentIdIs(menu.getId()));
//            }
//        }
    }
}
