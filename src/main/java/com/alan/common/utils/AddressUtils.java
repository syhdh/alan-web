package com.alan.common.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

@Component
public class AddressUtils {
    /**
     *
     * @param content
     *            请求的参数 格式为：name=xxx&pwd=xxx
     * @param encodingString
     *            服务器端请求编码。如GBK,UTF-8等
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getAddresses(String content, String encodingString){
        //调用淘宝API
        String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
        String returnStr = getResult(urlStr, content,encodingString);
        if(returnStr != null){
            System.out.println(returnStr);
            return  returnStr;
        }
        return null;
    }

    /**
     * @param urlStr
     *            请求的地址
     * @param content
     *            请求的参数 格式为：name=xxx&pwd=xxx
     * @param encodingString
     *            服务器端请求编码。如GBK,UTF-8等
     * @return
     */
    private static String getResult(String urlStr, String content, String encodingString) {
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(urlStr);
            // 新建连接实例
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接超时时间，单位毫秒
            //connection.setConnectTimeout(20000);
            // 设置读取数据超时时间，单位毫秒
            //connection.setReadTimeout(20000);
            //是否打开输出流
            connection.setDoOutput(true);
            //是否打开输入流
            connection.setDoInput(true);
            //提交方法 POST|GET
            connection.setRequestMethod("POST");
            //是否缓存
            connection.setUseCaches(false);
            //打开连接端口
            connection.connect();
            //打开输出流往对端服务器写数据
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            //写数据，即提交表单 name=xxx&pwd=xxx
            out.writeBytes(content);
            //刷新
            out.flush();
            //关闭输出流
            out.close();
            // 往对端写完数据对端服务器返回数据 ,以BufferedReader流来读取
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encodingString));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }
            reader.close();
            return buffer.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.disconnect();
            }
        }
        return null;
    }
    
    
    
    
    public String getAddress(String ip) {
    	// 参数ip  
        // json_result用于接收返回的json数据  
        String json_result = null;  
        try {  
            json_result = AddressUtils.getAddresses("ip=" + ip, "utf-8");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        JSONObject json = JSONObject.fromObject(json_result);  
        System.out.println("json数据： " + json);  
        String country = JSONObject.fromObject(json.get("data")).get("country").toString();  
        String region = JSONObject.fromObject(json.get("data")).get("region").toString();  
        String city = JSONObject.fromObject(json.get("data")).get("city").toString();  
        String county = JSONObject.fromObject(json.get("data")).get("county").toString();  
        String isp = JSONObject.fromObject(json.get("data")).get("isp").toString();  
        String area = JSONObject.fromObject(json.get("data")).get("area").toString();  
        /*System.out.println("国家： " + country);  
        System.out.println("地区： " + area);  
        System.out.println("省份: " + region);  
        System.out.println("城市： " + city);  
        System.out.println("区/县： " + county);  
        System.out.println("互联网服务提供商： " + isp);  */
        String address = "ip地址："+ip+";/n国家： " + country+"/n";  
        address = address+"地区： " + area+"/n";  
        address = address+"省份: " + region+"/n";  
        address = address + "城市： " + city+"/n";  
        address = address + "区/县： " + county+"/n";  
        address = address + "互联网服务提供商： " + isp;  
        return address;
	}
}