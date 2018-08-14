package top.management.library.common.utils.GreyUtils;

import javax.persistence.criteria.*;

public class SimpleExpression implements Criterion {

    private String fieldName;

    private Object value;

    private Operator operator;

    public SimpleExpression(String fieldName, Object value, Operator operator) {
        this.fieldName = fieldName;
        this.value = value;
        this.operator = operator;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getValue() {
        return value;
    }

    public Operator getOperator() {
        return operator;
    }

    @Override
    @SuppressWarnings({"rawtypes","unchecked"})
    public Predicate toPredicate(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        Path expression = null;

        return null;
    }
}
