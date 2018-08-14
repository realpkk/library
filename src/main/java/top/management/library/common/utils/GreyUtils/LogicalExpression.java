package top.management.library.common.utils.GreyUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class LogicalExpression implements Criterion {

    private Criterion[] criterion;

    private Operator operator;

    public LogicalExpression(Criterion[] criterion, Operator operator) {
        this.criterion = criterion;
        this.operator = operator;
    }

    @Override
    public Predicate toPredicate(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        for (int i=0;i<this.criterion.length;i++){
            predicates.add(this.criterion[i].toPredicate(root,criteriaQuery,criteriaBuilder));
        }
        switch (operator){
            case OR:
                return criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()]));
            case AND:
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            default:
                return null;
        }
    }
}
