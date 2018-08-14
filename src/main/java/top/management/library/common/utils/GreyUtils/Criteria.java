package top.management.library.common.utils.GreyUtils;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义查询条件容器
 *
 * @param <T>
 */
public class Criteria<T> implements Specification<T> {

    private List<Criterion> criterions= new ArrayList<Criterion>();

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        if (!criterions.isEmpty()){
            List<Predicate> predicates = new ArrayList<Predicate>();
            for (Criterion c:criterions){
                predicates.add(c.toPredicate(root,criteriaQuery,criteriaBuilder));
            }
            if (predicates.size()>0){
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }
        return criteriaBuilder.conjunction();
    }

    /**
     *
     * 增加简单条件表达式
     */
    public Criteria<T> add(Criterion criterion){

        if (criterion!=null){
            criterions.add(criterion);
        }
        return this;
    }
}
