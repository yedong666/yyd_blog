package com.yyd.blog_back.common;
import com.yyd.blog_back.common.util.Code;
import com.yyd.blog_back.common.util.Message;

import java.io.Serializable;
import java.util.HashMap;

public class Result extends HashMap<String, Object> implements Serializable {

    public Result() {
        put("code", 200);
        put("message", "success");
    }

    public Result(String code, String message, Object data) {
        put("code", code);
        put("message", message);
        put("data", data);
    }

    public static Result success(Object data) {
        return new Result(Code.SUCCESS_CODE, Message.SUCCESS,data);
    }

    public static Result error() {
        return new Result(Code.NOT_FOUND_RESOURSE, Message.ERROR, null);
    }

    public static Result error(String errorMessage) {
        return new Result(Code.NOT_FOUND_RESOURSE, Message.ERROR, errorMessage);
    }

    /**
     * 封装业务数据
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        //将HashMap对象本身返回
        return this;
    }
}
