package cn.healthy.manage.domain;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;


@Data
public class DietReturn {

    private String type;

    private JSONArray foods;

}
