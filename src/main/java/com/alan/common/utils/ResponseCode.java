package com.alan.common.utils;

/**
 * @author shaoy
 * 错误返回编码
 */
public enum ResponseCode {
  /**
   * 成功
   */
    SUCCESS(0, "成功"), 
    /**
     * 失败
     */
    ERROR(-1, "失败"),
    /**
     * 未知异常
     */
    UNKNOWN_ERROR(-1000, "未知异常"),
    /**
     * 服务降级
     */
    SERVICE_LOW(-10000, "服务降级");
    /**
     * 错误编码
     */
    private final int code;
    /**
     * 错误消息
     */
    private final String message;
    /**
     * <p>Description: 构造函数</p>
     * @param code 错误编码
     * @param message 错误消息
     */
    ResponseCode(int code, String message) {
      this.code = code;
      this.message = message;
    }


    /**
     * <p>Description: Return the integer value of this error code.</p>
     * @return error code
     */
    public int code() {
      return this.code;
    }

    /**
     * <p>Description: Return the message phrase of this error code.</p>
     * @return 错误消息
     */
    public String getMessage() {
      return this.message;
    }



    /**
     * Return a string representation of this status code.
     */
    @Override
    public String toString() {
      return Integer.toString(this.code);
    }

    /**
     * <p>Description: 通过code 获取ResponseCode对象</p>
     * @param code 消息号
     * @return ResponseCode
     */
    public static ResponseCode valueOf(int code) {
      for (ResponseCode status : values()) {
        if (status.code == code) {
          return status;
        }
      }
      throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }
  }
