package cn.ccTengx.day0215;

public class RegisterExceptionDemo extends RuntimeException{
    public RegisterExceptionDemo() {
    }

    public RegisterExceptionDemo(String message) {
        super(message);
    }
}
