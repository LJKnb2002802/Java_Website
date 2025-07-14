package com.tfswufe.resume.bean;


import com.tfswufe.resume.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean<T> {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;


    @Override
    public String toString() {
        return JsonUtil.obj2string(this);
    }

    public static  class ResultBeanUtil{
        public static <T> ResultBean<T> success(T data){
            return new ResultBean<>(200, "成功", data);
        }
        public static <T> ResultBean<T> success(String msg,T data){
            return new ResultBean<>(200, msg, data);
        }
        public static <T> ResultBean<T> success(){
            return new ResultBean<>(200, "成功", null);
        }
        public static <T> ResultBean<T> error(T data){
            return new ResultBean<>(400, "失败", data);
        }
        public static <T> ResultBean<T> error(String msg,T data){
            return new ResultBean<>(400, msg, data);
        }
        public static <T> ResultBean<T> error(){
            return new ResultBean<>(400, "失败", null);
        }
    }
}
