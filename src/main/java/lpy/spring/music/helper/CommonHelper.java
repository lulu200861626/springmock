package lpy.spring.music.helper;

/**
 */
public class CommonHelper {

    /**
     * 私有构建器，本类中的所有方法均为静态引用
     */
    private CommonHelper() {
    }

    private static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

    public static Object getThreadLocalValue() {
        return threadLocal.get();
    }

    public static <T> T getThreadLocalObject() {
        return (T) threadLocal.get();
    }

    public static void setThreadLocalValue(Object object) {
        threadLocal.set(object);
    }
}
