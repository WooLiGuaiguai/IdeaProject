package cn.ccTengx.day0217.WaitandNotify.BaoZanli;

public class Baozi {
    private String pi;
    private String xian;
    private boolean state=false;

    public Baozi() {
    }

    public Baozi(String pi, String xian) {
        this.pi = pi;
        this.xian = xian;
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }
}
