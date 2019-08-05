package com.example.zhaop.test.controller;
public class Test {

    static{
        System.out.println("3333333333333");
    }

    public Test(){
        System.out.println("2222222222222222");
    }

    public static void main(String[] args) {
        System.out.println("1111111111111");
        Test t = new Test();

        //String str = "{\"id\":\"111\",\"openid\":\"222\",\"remark\":\"点击查看详情\",\"data\":[{\"value\":\"测试1\"},{\"value\":\"测试2\"},{\"value\":\"测试3\"},{\"value\":\"测试4\"}]}";
        //
        //JSONObject json = JSONObject.parseObject(str);
        //String id = (String) json.get("id");
        //String openid = (String) json.get("openid");
        //System.out.println(id);
        //System.out.println(openid);
        //JSONArray jsona = json.getJSONArray("data");
        //for (Object j : jsona) {
        //    JSONObject jsono = (JSONObject)j;
        //    System.out.println(jsono.get("value"));
        //}
    }
}
