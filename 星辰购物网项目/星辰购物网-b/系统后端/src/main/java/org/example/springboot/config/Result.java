package org.example.springboot.config;

public class Result<T> {
    private int code;
    private String message;
    private T data;

    // 构造方法
    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 快捷方法：成功时返回结果
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    // 快捷方法：失败时返回结果
    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message, null);
    }

    // Getter 和 Setter
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}