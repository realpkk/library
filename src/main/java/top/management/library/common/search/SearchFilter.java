package top.management.library.common.search;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SearchFilter {

    public enum MatchType{
        EQ, NE, LIKE, GT, LT, GTE, LTE;
    }

    public enum DataType{
        S(String.class),I(Integer.class),D(Date.class);

        private Class<?> clazz;

        DataType(Class<?> clazz){this.clazz = clazz;}

        public Class<?> getClazz() {
            return clazz;
        }
    }

    private String paramName = null;

    private MatchType matchType = null;

    private Class<?> dataType = null;

    private Object paramValue = null;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public Class<?> getDataType() {
        return dataType;
    }

    public void setDataType(Class<?> dataType) {
        this.dataType = dataType;
    }

    public Object getParamValue() {
        return paramValue;
    }

    public void setParamValue(Object paramValue) {
        this.paramValue = paramValue;
    }

    public SearchFilter(String paramName, MatchType matchType, Class<?> dataType, Object paramValue) {
        this.paramName = paramName;
        this.matchType = matchType;
        this.dataType = dataType;
        this.paramValue = paramValue;
    }

    public SearchFilter(final String param,final String value){

        paramName = StringUtils.substringBefore(param,"__").trim();

        String matchTypeStr = StringUtils.substringAfter(param,"__");
        String matchTypeCode = StringUtils.substringAfter(matchTypeStr,"_");
        String dataTypeCode = StringUtils.substringBefore(matchTypeStr,"_");

        matchType = Enum.valueOf(MatchType.class,matchTypeCode);
        dataType = Enum.valueOf(DataType.class,dataTypeCode).getClazz();

        if (value==null){ this.paramValue = "";}
        else {this.paramValue = value.trim();}
        if (value!=null&&StringUtils.isEmpty(this.paramValue.toString())&&"I".equals(dataTypeCode)){
            Integer.valueOf(this.paramValue.toString());
        }

    }

    public static List<SearchFilter> getSearchFilterList(final Map<String,String> paramMap){

        List<SearchFilter> searchFilterList = new ArrayList<>();
        for (String param : paramMap.keySet()){
            if (param.indexOf("@")>-1){
                continue;
            }
            String value = paramMap.get(param);
            if (StringUtils.isEmpty(value)){
                continue;
            }
            searchFilterList.add(new SearchFilter(param,value));
        }
        return searchFilterList;
    }
}
