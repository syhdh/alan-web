package com.alan.common.utils;

import java.io.Serializable;

/**
 * <p>ClassName: ResponseData</p>
 * <p>Description: 接口统一返回类</p>
 */
public class ResponseData implements Serializable {
  /**
   * <p>Field serialVersionUID: 可序列化</p>
   */
  private static final long serialVersionUID = 4243835731990893219L;
  /**
   * http的状态码，200 表示ok，404 表示没有找打资源
   */
  private int httpStatus = 200;
  /**
   * 业务返回码：>=0 表示正常，负数表示异常，-1：业务异常 -100 以上 ：表示系统级的异常，比如除数是0等，空指针异常
   */
  private int code = 0;
  /**
   * 错误时候的提示信息
   */
  private String message = null; 
  /**
   * 成功时候具体的数据对象
   */
  private Object data = null;
  /**
   * <p>Description: 构造函数</p>
   */
  public ResponseData() {
  }
  /**
   * <p>Description: 构造函数</p>
   * @param code 返回码
   * @param message 提示信息
   */
  public ResponseData(int code, String message) {
    this.code = code;
    this.message = message;
  }
  /**
   * <p>Description: ResponseCode 构造函数</p>
   * @param responseCode ResponseCode
   */
  public ResponseData(ResponseCode responseCode) {
    this.code = responseCode.code();
    this.message = responseCode.getMessage();
  }
  /**
   * <p>Description: 构造函数</p>
   * @param responseCode ResponseCode
   * @param httpStatus  int
   */
  public ResponseData(ResponseCode responseCode, int httpStatus) {
    this.code = responseCode.code();
    this.message = responseCode.getMessage();
    this.httpStatus = httpStatus;
  }
  /**
   * <p>Description: 构造函数</p>
   * @param code 返回码
   * @param data 数据对象
   */
  public ResponseData(int code, Object data) {
    this.code = code;
    this.data = data;
  }
  /**
   * <p>Description: 构造函数</p>
   * @param data 数据对象
   */
  public ResponseData(Object data) {
    this.data = data;
  }
  public int getHttpStatus() {
    return httpStatus;
  }
  public void setHttpStatus(int httpStatus) {
    this.httpStatus = httpStatus;
  }
  public int getCode() {
    return code;
  }
  public void setCode(int code) {
    this.code = code;
  }
  
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public Object getData() {
    return data;
  }
  public void setData(Object data) {
    this.data = data;
  }
}
