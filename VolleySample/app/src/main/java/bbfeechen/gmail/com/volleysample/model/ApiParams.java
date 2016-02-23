package bbfeechen.gmail.com.volleysample.model;

import java.util.HashMap;

/**
 * Author  : KAILIANG CHEN
 * Version : 0.1
 * Date    : 2/23/16
 */
public class ApiParams extends HashMap<String, String> {
    public ApiParams with(String key, String value) {
        put(key, value);
        return this;
    }
}
