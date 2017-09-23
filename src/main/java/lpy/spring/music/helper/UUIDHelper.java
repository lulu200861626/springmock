package lpy.spring.music.helper;

import java.util.UUID;

/**
 */
public class UUIDHelper {

    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
