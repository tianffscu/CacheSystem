package cn.tianff.testing;

/**
 * A Testing object
 * Created by Tianff on 2017/10/28.
 */
public class Bear {

    private String name;

    private String info;

    public Bear() {
    }

    public Bear(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
