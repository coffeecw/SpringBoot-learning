package cn.cwcoffee.springboot.Exception;

/**
 * created by coffeecw 2019/12/01
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
       super("用户不存在");
    }
}
