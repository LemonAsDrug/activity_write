package com.example.chong.activity_write.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class P extends HashMap {


    public void check(String... necessaryParameter) {
        testParameter(necessaryParameter);
    }

    /**
     * 验证必要参数是否全部存在
     *
     * @param necessaryParameters 必要参数集合
     * @return 返回不存在的参数的字符串，以逗号隔开，如全存在则返回""
     */
    private void testParameter(String[] necessaryParameters) {
        StringBuffer notField = new StringBuffer();
        StringBuffer nullField = new StringBuffer();
        for (String necessaryParameter : necessaryParameters) {
            if (!this.containsKey(necessaryParameter)) {
                    notField.append(necessaryParameter + ",");
            } else {
                if (this.get(necessaryParameter) == null) {
                    nullField.append(necessaryParameter + ",");
                }
            }
        }
        if (!"".equals(notField.toString())) {
            notField = new StringBuffer(notField.substring(0, notField.length() - 1));
            notField.append("参数不存在               ");
        }
        if (!"".equals(nullField.toString())) {
            nullField = new StringBuffer(nullField.substring(0, nullField.length() - 1));
            nullField.append("参数为NULL");
        }
        String msg = notField.toString() + nullField.toString();
        if (!"".equals(msg)) {
            throw new BaseException(msg);
        }
    }



    /**
     * 获取对象,转为json字符串
     * @param key
     * @return jsonStr
     * */
    public String getJsonVal(String key) {
       return JSONObject.toJSONString(this.get(key));
    }


    /**
     * 获取集合对象
     * @param key
     * @param toClass
     * @return
     * */
    public  <T> List<T> getArr(String key, Class<T> toClass){
        return  JSONArray.parseArray(getJsonVal(key),toClass);
    }

    /**
     *将字符串转换为Integer
     * @param key
     * @return
     */
    public Integer getInt(String key){
        if (isNull(key)) {
            return 0;
        }
        if (Utils.isEmpty(this.get(key))) {
            return 0;
        }
        return Integer.parseInt(this.get(key).toString());
    }

    /**
     * 将字符串转换为Integer,如果字符串为空，转换默认的toString方法为Integer值
     * @param key
     * @param to0
     * @return
     */
    public Integer getInt(String key,boolean to0){
        if (to0){
            return getInt(key);
        }else {
            return isNull(key) ? null:Integer.parseInt(this.get(key).toString());
        }
    }

    /**
     * 将字符串转换为 Long型的数据
     * @param key
     * @return
     */
    public Long getLong(String key){
        if (isNull(key)) {
            return 0L;
        }
        if (Utils.isEmpty(this.get(key))) {
            return 0L;
        }
        return Long.parseLong(this.get(key).toString());
    }

    /**
     * 获取字符串，如果字符串为 null 或空，返回 ”“ 空串。
     * @param key
     * @return
     */
    public String getStr(String key){
        if (isNull(key)) {
            return "";
        }
        if (Utils.isEmpty(this.get(key))) {
            return "";
        }
        return this.get(key).toString();
    }

    /**
     * 把字符串转换为高精度数字 BigDecimal
     * @param key
     * @return
     */
    public BigDecimal getDecimal(String key){
        return new BigDecimal(isNull(key)?"0":this.get(key).toString());
    }

    /**
     * 判断字符串是否为 null 或为空串
     * @param key
     * @return
     */
    private boolean isNull(String key){
        if (this.get(key)==null||"".equals(this.get(key).toString())){
            return true;
        }else{
            return false;
        }
    }
}
