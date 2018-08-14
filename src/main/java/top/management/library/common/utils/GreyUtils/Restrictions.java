package top.management.library.common.utils.GreyUtils;


import org.springframework.util.StringUtils;

import java.util.Collection;

public class Restrictions {

    /**
     * 等于
     */
    public static SimpleExpression eq(String fieldName,Object value){

        if (StringUtils.isEmpty(value)){ return null;}
        return new SimpleExpression(fieldName,value,Criterion.Operator.EQ);
    }

    /**
     * 不等于
     */
    public static SimpleExpression ne(String fieldName,Object value){

        if (StringUtils.isEmpty(value)){ return null;}
        return new SimpleExpression(fieldName,value,Criterion.Operator.NE);
    }

    /**
     * 模糊匹配
     */
    public static SimpleExpression like(String fieldName,Object value){

        if (StringUtils.isEmpty(value)){ return null;}
        return new SimpleExpression(fieldName,value,Criterion.Operator.LIKE);
    }

    /**
     * 大于
     */
    public static SimpleExpression gt(String fieldName,Object value){

        if (StringUtils.isEmpty(value)){ return null;}
        return new SimpleExpression(fieldName,value,Criterion.Operator.GT);
    }

    /**
     * 小于
     */
    public static SimpleExpression lt(String fieldName,Object value){

        if (StringUtils.isEmpty(value)){ return null;}
        return new SimpleExpression(fieldName,value,Criterion.Operator.LT);
    }

    /**
     * 大于等于
     */
    public static SimpleExpression gte(String fieldName,Object value){

        if (StringUtils.isEmpty(value)){ return null;}
        return new SimpleExpression(fieldName,value,Criterion.Operator.GTE);
    }

    /**
     * 小于等于
     */
    public static SimpleExpression lte(String fieldName,Object value){

        if (StringUtils.isEmpty(value)){ return null;}
        return new SimpleExpression(fieldName,value,Criterion.Operator.LTE);
    }

    /**
     * 并且
     */
    public static LogicalExpression and(Criterion... criterions){

        return new LogicalExpression(criterions,Criterion.Operator.AND);
    }

    /**
     * 或者
     */
    public static LogicalExpression or(Criterion... criterions){

        return new LogicalExpression(criterions,Criterion.Operator.OR);
    }

    /**
     * 包含于
     */
    public static LogicalExpression in(String fieldName,Collection value,boolean ignoreNull){

        if (ignoreNull&&(value==null||value.isEmpty())){return null;}
        SimpleExpression[] simpleExpressions = new SimpleExpression[value.size()];
        int i =0;
        for (Object obj:value){
            simpleExpressions[i] = new SimpleExpression(fieldName,obj,Criterion.Operator.EQ);
            i++;
        }
        return new LogicalExpression(simpleExpressions,Criterion.Operator.OR);
    }

    /**
     * 不包含
     */
    public static LogicalExpression notin(String fieldName,Collection value,boolean ignoreNull){

        if (ignoreNull&&(value==null||value.isEmpty())){return null;}
        SimpleExpression[] simpleExpressions = new SimpleExpression[value.size()];
        int i =0;
        for (Object obj:value){
            simpleExpressions[i] = new SimpleExpression(fieldName,obj,Criterion.Operator.NE);
            i++;
        }
        return new LogicalExpression(simpleExpressions,Criterion.Operator.AND);
    }

    /**
     * between
     */
    public static LogicalExpression between(String fieldName,Object object1,Object object2){

        if (object1==null||object2==null){
            return null;
        }
        SimpleExpression[] simpleExpressions = new SimpleExpression[2];
        simpleExpressions[0] = new SimpleExpression(fieldName,object1,Criterion.Operator.LTE);
        simpleExpressions[1] = new SimpleExpression(fieldName,object2,Criterion.Operator.GTE);
        return new LogicalExpression(simpleExpressions,Criterion.Operator.AND);
    }
}
