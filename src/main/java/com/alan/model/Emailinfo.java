package com.alan.model;

import java.io.Serializable;

/**
 * emailinfo
 * @author 
 */
public class Emailinfo implements Serializable {
    private String id;

    /**
     * 事件id
     */
    private String eventid;

    /**
     * 发件人名称
     */
    private String senduser;

    /**
     * 收件人名称
     */
    private String reciveuser;

    /**
     * 发件人邮箱
     */
    private String sendemail;

    /**
     * 收件人邮箱
     */
    private String reciveemail;

    /**
     * 真言
     */
    private String content;

    /**
     * 生成代码链接
     */
    private String codeurl;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getSenduser() {
        return senduser;
    }

    public void setSenduser(String senduser) {
        this.senduser = senduser;
    }

    public String getReciveuser() {
        return reciveuser;
    }

    public void setReciveuser(String reciveuser) {
        this.reciveuser = reciveuser;
    }

    public String getSendemail() {
        return sendemail;
    }

    public void setSendemail(String sendemail) {
        this.sendemail = sendemail;
    }

    public String getReciveemail() {
        return reciveemail;
    }

    public void setReciveemail(String reciveemail) {
        this.reciveemail = reciveemail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCodeurl() {
        return codeurl;
    }

    public void setCodeurl(String codeurl) {
        this.codeurl = codeurl;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Emailinfo other = (Emailinfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEventid() == null ? other.getEventid() == null : this.getEventid().equals(other.getEventid()))
            && (this.getSenduser() == null ? other.getSenduser() == null : this.getSenduser().equals(other.getSenduser()))
            && (this.getReciveuser() == null ? other.getReciveuser() == null : this.getReciveuser().equals(other.getReciveuser()))
            && (this.getSendemail() == null ? other.getSendemail() == null : this.getSendemail().equals(other.getSendemail()))
            && (this.getReciveemail() == null ? other.getReciveemail() == null : this.getReciveemail().equals(other.getReciveemail()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCodeurl() == null ? other.getCodeurl() == null : this.getCodeurl().equals(other.getCodeurl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEventid() == null) ? 0 : getEventid().hashCode());
        result = prime * result + ((getSenduser() == null) ? 0 : getSenduser().hashCode());
        result = prime * result + ((getReciveuser() == null) ? 0 : getReciveuser().hashCode());
        result = prime * result + ((getSendemail() == null) ? 0 : getSendemail().hashCode());
        result = prime * result + ((getReciveemail() == null) ? 0 : getReciveemail().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCodeurl() == null) ? 0 : getCodeurl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", eventid=").append(eventid);
        sb.append(", senduser=").append(senduser);
        sb.append(", reciveuser=").append(reciveuser);
        sb.append(", sendemail=").append(sendemail);
        sb.append(", reciveemail=").append(reciveemail);
        sb.append(", content=").append(content);
        sb.append(", codeurl=").append(codeurl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}