package utils;

public class GlobalVariables {
    public static String apiHost;
    public static String seleniumHost;
    public static String getMethodsApiHost;
    public static String postMethodsApiHost;
    public static String registerSeleniumHost;

    public static void rebuildUrls(){
        getMethodsApiHost = apiHost + "/users/all";
        postMethodsApiHost = apiHost + "/users/add";
        registerSeleniumHost = seleniumHost + "/register.html";
    }
}
