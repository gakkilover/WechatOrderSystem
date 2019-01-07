package com.zwk.weibo.exception;

import com.zwk.weibo.constant.Final;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class BaseException {
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", 100);
        map.put("msg", ex.getMessage());
        return map;
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public Map myErrorHandler(MyException ex) {
        Map map = new HashMap();
        map.put("code", ex.getCode());
        map.put("msg", ex.getMsg());
        return map;
    }

    /**
     * 拦截数据库索引（数据重复异常）
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = DuplicateKeyException.class)
    public Map duplicateHandler(DuplicateKeyException ex) {
        Map map = new HashMap();
        map.put("code", Final.EXIST_ERROE_CODE);
        map.put("msg", "存在相同记录");
        return map;
    }

    /**
     * 空指针异常
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public Map nullPointerHandler(NullPointerException ex) {
        Map map = new HashMap();
        map.put("code", Final.NULL_ERROE_CODE);
        map.put("msg", "怎么回事？小老弟，空指针了！");
        return map;
    }



}
