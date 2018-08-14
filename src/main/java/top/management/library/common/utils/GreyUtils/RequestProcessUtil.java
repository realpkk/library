package top.management.library.common.utils.GreyUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RequestProcessUtil {

    private static final String CURRENT_PAGE = "currentPage";
    private static final String OPERATION = "operation";
    private static final String TOTAL_PAGES = "totalPages";
    private static final String PAGE_SIZE = "pageSize";

    public static int getCurrentPage(HttpServletRequest request){

        return Integer.parseInt(request.getParameter(CURRENT_PAGE));
    }

    public static String getOperation(HttpServletRequest request){

        return request.getParameter(OPERATION);
    }

    public static int getTotalPages(HttpServletRequest request){

        return Integer.parseInt(request.getParameter(TOTAL_PAGES));
    }

    public static int getPageSize(HttpServletRequest request){

        return Integer.parseInt(request.getParameter(PAGE_SIZE));
    }



//        public static Map<String, Object> getParameterMap(HttpServletRequest request) {
//            Map<String, String[]> properties = request.getParameterMap();//把请求参数封装到Map<String, String[]>中
//            Map<String, Object> returnMap = new HashMap<String, Object>();
//            Iterator<Map.Entry<String, String[]>> iter = properties.entrySet().iterator();
//            String name = "";
//            String value = "";
//            while (iter.hasNext()) {
//                Map.Entry<String, String[]> entry = iter.next();
//                name = entry.getKey();
//                Object valueObj = entry.getValue();
//                if (null == valueObj) {
//                    value = "";
//                } else if (valueObj instanceof String[]) {
//                    String[] values = (String[]) valueObj;
//                    for (int i = 0; i < values.length; i++) { //用于请求参数中有多个相同名称
//                        value = values[i] + ",";
//                    }
//                    value = value.substring(0, value.length() - 1);
//                } else {
//                    value = valueObj.toString();//用于请求参数中请求参数名唯一
//                }
//                returnMap.put(name, value);
//            }
//            return returnMap;
//        }
//
//        public static Map<String, String> getParameterStringMap(HttpServletRequest request) {
//            Map<String, String[]> properties = request.getParameterMap();//把请求参数封装到Map<String, String[]>中
//            Map<String, String> returnMap = new HashMap<String, String>();
//            String name = "";
//            String value = "";
//            for (Map.Entry<String, String[]> entry : properties.entrySet()) {
//                name = entry.getKey();
//                String[] values = entry.getValue();
//                if (null == values) {
//                    value = "";
//                } else if (values.length>1) {
//                    for (int i = 0; i < values.length; i++) { //用于请求参数中有多个相同名称
//                        value = values[i] + ",";
//                    }
//                    value = value.substring(0, value.length() - 1);
//                } else {
//                    value = values[0];//用于请求参数中请求参数名唯一
//                }
//                returnMap.put(name, value);
//
//            }
//            return returnMap;
//        }

    }


