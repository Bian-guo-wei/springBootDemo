package com.example.demo.website.po;

import com.dayainfo.common.util.StringUtils;
import com.example.demo.website.contast.MobilePassportUserInfoConstant;
import com.duxiu.cxds.api.client.utils.Md5Utils;

/**
 * @author gewu
 * @time$create 2017/6/2 20:12
 */
public class MobilePassportApiParam {
    private String xxtUid;//学习通用户的uid
    private String enc;//加密串
    private String industry;//机构

    public MobilePassportApiParam() {
    }

    public MobilePassportApiParam(String xxtUid) {
        this.xxtUid = xxtUid;
        this.enc = Md5Utils.md52(xxtUid + MobilePassportUserInfoConstant.MOBILE_PASSPORT_KEY);
        this.industry = Integer.toString(MobilePassportUserInfoConstant.MOBILE_PASSPORT_DEFAULT_INDUSTRY);
    }

    public MobilePassportApiParam(String xxtUid, String industry) {
        this.xxtUid = xxtUid;
        this.enc = Md5Utils.md52(xxtUid + MobilePassportUserInfoConstant.MOBILE_PASSPORT_KEY);
        this.industry = industry;
    }

    @Override
    public String toString() {
        return "MobilePassportApiParam{" +
                "xxtUid='" + xxtUid + '\'' +
                ", enc='" + enc + '\'' +
                ", industry='" + industry + '\'' +
                '}';
    }

    /**
     * 检查属性是否不为空
     *
     * @return true - 检查通过 <br> 异常 - 有值为空
     * @version v1.0.0.0.1 (feat, bug, doc, style, refactor)
     * @author gewu
     * @time$create 2017/6/5 15:23
     * @time$modify 2017年6月7日15:24:14
     * @modifer
     * @log$change 通过检查return true，不然抛出异常
     */
    public boolean check() {
        StringBuilder emptyParam = new StringBuilder();
        if (StringUtils.isBlank(xxtUid)) {
            emptyParam.append("xxtUid");
        }
        if (StringUtils.isBlank(enc)) {
            emptyParam.append("enc");
        }
        if (StringUtils.isBlank(industry)) {
            emptyParam.append("industry");
        }
        if (emptyParam.length() > 0) {
            System.err.println("参数: '" + emptyParam.toString() + "' 检查不通过");
            return false;
        }
        return true;
    }

    public String getXxtUid() {
        return xxtUid;
    }

    public void setXxtUid(String xxtUid) {
        this.xxtUid = xxtUid;
    }

    public String getEnc() {
        return enc;
    }

    public void setEnc(String enc) {
        this.enc = enc;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public static void main(String[] args) {
        MobilePassportApiParam mobilePassportApiParam = new MobilePassportApiParam(null);
        mobilePassportApiParam.check();
    }
}
