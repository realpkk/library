package top.management.library.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import top.management.library.entity.menu.Menu;
import top.management.library.repository.base.AbstractRepository;

import java.util.List;

public interface MenuRepository extends AbstractRepository<Menu,Long> {

    List<Menu> findByIdIn(List<Long> idList);

    @Query("select m from Menu m order by m.parentId,m.menuSort")
    List<Menu> finAllMenus();

    @Query("select m from Role r join r.menuList m where r.id in :roleIdList")
    List<Menu> findMenusByRoleId(@Param("roleIdList") List<Long> roleList);

    List<Menu> findMenusByParentIdIs(Long parentId);
}
