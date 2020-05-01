package by.bsu.util;

public class ServletUtil {
    public static final String PREFIX = "/WEB-INF/classes/jsp/";
    public static final String SUFFIX = ".jsp";

    private ServletUtil(){}

    public static String createViewPath(String viewName){
        return String.format("%s%s%s",PREFIX,viewName,SUFFIX);
    }
}
