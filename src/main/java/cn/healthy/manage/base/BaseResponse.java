package cn.healthy.manage.base;

public class BaseResponse {
    private Integer code;

    private String msg;

    private Object data;

    public void setCode(Integer code){
        this.code =code;
    }

    public Integer getCode(){
        return this.code;
    }

    public void setMsg(String msg){
        this.msg=msg;
    }

    public String getMsg(){
        return this.msg;
    }

    public void setData(Object data){
        this.data=data;
    }

    public Object getData(){
        return this.data;
    }
}
