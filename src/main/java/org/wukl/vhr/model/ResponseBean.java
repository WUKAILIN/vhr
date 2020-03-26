package org.wukl.vhr.model;

import javax.xml.ws.Response;

public class ResponseBean {
    private Integer status;
    private String message;
    private Object obj;

    /**
     * 操作成功
     * @param message:返回消息
     * @return ResponseBean
     */
    public static ResponseBean responseSuccess(String message)
    {
        return new ResponseBean(200,message,null);
    }

    /**
     * 操作成功
     * @param message:返回消息
     * @param obj:返回对象
     * @return ResponseBean
     */
    public static ResponseBean responseSuccess(String message,Object obj)
    {
        return new ResponseBean(200,message,obj);
    }

    /**
     * 操作失败
     * @param message:返回消息
     * @return ResponseBean
     */
    public static ResponseBean responseError(String message)
    {
        return new ResponseBean(500,message,null);
    }

    /**
     * 操作失败
     * @param emssage:返回消息
     * @param obj:返回对象
     * @return ResponseBean
     */
    public static ResponseBean responseError(String message,Object obj)
    {
        return new ResponseBean(500,message,obj);
    }
    public ResponseBean() {
    }

    public ResponseBean(Integer status, String message, Object obj) {
        this.status = status;
        this.message = message;
        this.obj = obj;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
