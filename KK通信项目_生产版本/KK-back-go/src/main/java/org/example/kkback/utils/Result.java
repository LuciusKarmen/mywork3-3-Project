package org.example.kkback.utils;

import lombok.Data;


import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;
    private String message;
    private T data;

    public Result() {}

    private Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //
    public static <T> Result<T> ok(T data) {
        return new Result<>(200, "操作成功", data);
    }


    public static <T> Result<T> ok() {
        return new Result<>(200, "操作成功", null);
    }


//      错误,没有的时候

    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message, null);
    }

}