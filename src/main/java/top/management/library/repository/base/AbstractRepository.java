package top.management.library.repository.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface AbstractRepository<T,ID extends Serializable> extends
        JpaRepository<T,ID>,JpaSpecificationExecutor<T> {

    @Override
    Page<T> findAll(Specification<T> specification, Pageable pageable);

    @Override
    List<T> findAll(Specification<T> specification);
}
