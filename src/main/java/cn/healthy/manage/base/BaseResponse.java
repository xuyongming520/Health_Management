package cn.healthy.manage.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

    private enum CODE {

        SUCCESS(0,"成功"),
        FAILED(1,"失败");

        private Integer code;

        private String msg;

        CODE(Integer code,String msg){
            this.code  = code;
            this.msg = msg;
        }
    }

    private Integer code;

    private String msg;

    private Object data;

    public BaseResponse(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public static BaseResponse createSuccessResponse(){ return new BaseResponse(CODE.SUCCESS.code,CODE.SUCCESS.msg); }

    public static BaseResponse createSuccessResponse(String msg){ return new BaseResponse(CODE.SUCCESS.code,msg); }

    public static BaseResponse createSuccessResponse(Object object){ return new BaseResponse(CODE.SUCCESS.code,CODE.SUCCESS.msg,object); }

    public static BaseResponse createSuccessResponse(Integer code,String msg){ return new BaseResponse(code,msg); }

    public static BaseResponse createFailedResponse(){ return new BaseResponse(CODE.FAILED.code,CODE.FAILED.msg); }

    public static BaseResponse createFailedResponse(String msg){ return new BaseResponse(CODE.FAILED.code,msg); }

    public static BaseResponse createFailedResponse(Integer code,String msg){ return new BaseResponse(code,msg); }
}
