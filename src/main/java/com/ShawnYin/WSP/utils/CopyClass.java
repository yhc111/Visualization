package com.ShawnYin.WSP.utils;

import com.ShawnYin.WSP.entity.IssueOne;
import com.ShawnYin.WSP.entity.IssueOneReal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CopyClass {

	public static IssueOneReal copyOneToOnereal(IssueOneReal tempReal, IssueOne temp){

        try {
            tempReal.setId(temp.getId());
            tempReal.setDeviceid(temp.getDeviceid());
            tempReal.setHumidity(temp.getHumidity());
            tempReal.setPercent(temp.getPercent());
            tempReal.setPressure(temp.getPressure());
            tempReal.setTemperature(temp.getTemperature());
            tempReal.setUploadtime(temp.getUploadtime());
            tempReal.setVoltage(temp.getVoltage());
            tempReal.setShowself(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempReal;
    }


}
