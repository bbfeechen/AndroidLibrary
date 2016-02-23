package bbfeechen.gmail.com.volleysample.model;

/**
 * Author  : KAILIANG CHEN
 * Version : 0.1
 * Date    : 2/23/16
 */
public class ActivityInfo {
    public String title;
    public Class<?> name;

    public ActivityInfo(String title, Class<?> name) {
        this.title = title;
        this.name = name;
    }

    public String toString() {
        return title;
    }
}
