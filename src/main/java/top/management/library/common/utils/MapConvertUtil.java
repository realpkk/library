package top.management.library.common.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapConvertUtil {

//    private static final String BOOK_NAME_PARAM = "bookName";
//    private static final String SEARCH_TYPE_PARAM = "searchType";
//
//    private static final String EQ_PARAM = "bookName__S_EQ";
//    private static final String LIKE_PARAM = "bookName__S_LIKE";
//
//    private static final String PAGE_NUMBER_PARAM = "pageNumber";
//    private static final String PAGE_SIZE_PARAM = "pageSize";

    public static Map<String,String> getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

//    public static Object toObject(Map<String,String[]> map,Class<?> clazz){
//        if (map == null) {
//            return null;
//        }
//        Object obj = null;
//        try {
//            obj = clazz.newInstance();
//
//            Field[] fields = obj.getClass().getDeclaredFields();
//            for (Field field : fields) {
//                int mod = field.getModifiers();
//                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
//                    continue;
//                }
//                field.setAccessible(true);
//                field.set(obj, map.get(field.getName()));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return obj;
//    }

//    public static Map<String,String> searchMapProcess(Map<String,String> paramMap){
//
//        if ("1".equals(paramMap.get(SEARCH_TYPE_PARAM))){
//            paramMap.put(LIKE_PARAM,paramMap.get(BOOK_NAME_PARAM));
//        }else {
//            paramMap.put(EQ_PARAM,paramMap.get(BOOK_NAME_PARAM));
//        }
//        paramMap.remove(SEARCH_TYPE_PARAM);paramMap.remove(BOOK_NAME_PARAM);
//        return paramMap;
//    }
//
//    public static Map<String,String> pageMapProcess(HttpServletRequest request){
//
//        Map<String,String> map = getParameterMap(request);
//        map.remove(PAGE_NUMBER_PARAM);map.remove(PAGE_SIZE_PARAM);
//        return searchMapProcess(map);
//
//    }

}
