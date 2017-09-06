package com.shareTools.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *  系统日志
 */
public class Log implements Serializable {

    /**
     * 主键
     */
    private String id;

    /**
     * 应用名称
     */
    private String appName;
    /**
     * 日志类型 0操作日志，1异常日志
     */
    private Integer logType;
    /**
     * 操作人
     */
    private String user;
    /**
     * 方法名称
     */
    private String methodName;
    /**
     * 请求参数
     */
    private String requestParams;
    /**
     * 方法描述
     */
    private String methodDescription;
    /**
     * 访问者ip
     */
    private String requestIp;
    /**
     * 请求uri
     */
    private String requestUri;
    /**
     * 请求path
     */
    private String requestPath;
    /**
     * 异常编码
     */
    private String exceptionCode;
    /**
     * 异常详情
     */
    private String exceptionDetail;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 请求响应状态
     */
    private String status;
    /**
     * 请求响应内容
     */
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    public String getMethodDescription() {
        return methodDescription;
    }

    public void setMethodDescription(String methodDescription) {
        this.methodDescription = methodDescription;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
