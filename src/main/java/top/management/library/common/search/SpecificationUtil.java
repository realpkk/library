package top.management.library.common.search;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.jpa.domain.Specification;
import top.management.library.common.utils.DateUtil;
import top.management.library.common.search.SearchFilter.MatchType;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpecificationUtil {

    public static <T>Specification<T> getSpecification(final List<SearchFilter> searchFilterList){

        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                if (null!=searchFilterList&&!searchFilterList.isEmpty()){
                    List<Predicate> predicates = new ArrayList<>();
                    Predicate predicate = null;
                    for (SearchFilter searchFilter:searchFilterList){
                        predicate = getPredicate(searchFilter,root,criteriaBuilder);
                        if (predicate!=null){
                            predicates.add(predicate);
                        }
                    }
                    if (predicates.size()>0){
                        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                    }
                }
                return criteriaBuilder.conjunction();
            }
        };
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public static <T>Predicate getPredicate(final SearchFilter searchFilter,final Root<T> root,final CriteriaBuilder criteriaBuilder){

        Object value = searchFilter.getParamValue();
        if (null == value){
            return null;
        }
        Path path;
        path = root.get(searchFilter.getParamName());
        if (searchFilter.getDataType().equals(Date.class)){
            if (value.toString().length()==10&&(searchFilter.getMatchType()== MatchType.LT||searchFilter.getMatchType()== MatchType.LTE)){
                String time = value.toString()+"23:59:59";
                value = DateUtil.parseDate((value.toString()+" 23:59:59"));
            }
            else {
                value = DateUtil.parseDate(value.toString());
            }
        }

        switch (searchFilter.getMatchType()){
            case EQ:
                return criteriaBuilder.equal(path,value);
            case NE:
                return criteriaBuilder.notEqual(path,value);
            case LIKE:
                return criteriaBuilder.like(path,"%"+value+"%");
            case LT:
                return criteriaBuilder.lessThan(path,(Comparable) value);
            case GT:
                return criteriaBuilder.greaterThan(path,(Comparable) value);
            case LTE:
                return criteriaBuilder.lessThanOrEqualTo(path,(Comparable) value);
            case GTE:
                return criteriaBuilder.greaterThanOrEqualTo(path,(Comparable) value);
        }
        return null;
    }
}
