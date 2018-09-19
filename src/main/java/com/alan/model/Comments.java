package com.alan.model;

import java.io.Serializable;

/**
 * comments
 * @author 
 */
public class Comments implements Serializable {
    /**
     * id
     */
    private String cId;

    /**
     * 留言
     */
    private String cParams;

    /**
     * 操作人
     */
    private String cUserId;

    /**
     * 查看人
     */
    private String vUser;

    /**
     * 相识时间
     */
    private String cTimestmap;

    private static final long serialVersionUID = 1L;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcParams() {
        return cParams;
    }

    public void setcParams(String cParams) {
        this.cParams = cParams;
    }

    public String getcUserId() {
        return cUserId;
    }

    public void setcUserId(String cUserId) {
        this.cUserId = cUserId;
    }

    public String getvUser() {
        return vUser;
    }

    public void setvUser(String vUser) {
        this.vUser = vUser;
    }

    public String getcTimestmap() {
        return cTimestmap;
    }

    public void setcTimestmap(String cTimestmap) {
        this.cTimestmap = cTimestmap;
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
        Comments other = (Comments) that;
        return (this.getcId() == null ? other.getcId() == null : this.getcId().equals(other.getcId()))
            && (this.getcParams() == null ? other.getcParams() == null : this.getcParams().equals(other.getcParams()))
            && (this.getcUserId() == null ? other.getcUserId() == null : this.getcUserId().equals(other.getcUserId()))
            && (this.getvUser() == null ? other.getvUser() == null : this.getvUser().equals(other.getvUser()))
            && (this.getcTimestmap() == null ? other.getcTimestmap() == null : this.getcTimestmap().equals(other.getcTimestmap()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getcId() == null) ? 0 : getcId().hashCode());
        result = prime * result + ((getcParams() == null) ? 0 : getcParams().hashCode());
        result = prime * result + ((getcUserId() == null) ? 0 : getcUserId().hashCode());
        result = prime * result + ((getvUser() == null) ? 0 : getvUser().hashCode());
        result = prime * result + ((getcTimestmap() == null) ? 0 : getcTimestmap().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cId=").append(cId);
        sb.append(", cParams=").append(cParams);
        sb.append(", cUserId=").append(cUserId);
        sb.append(", vUser=").append(vUser);
        sb.append(", cTimestmap=").append(cTimestmap);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}