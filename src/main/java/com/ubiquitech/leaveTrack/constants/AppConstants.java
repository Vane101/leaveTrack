package com.ubiquitech.leaveTrack.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * vane created on 2015/01/29.
 */
public class AppConstants {

    public enum requestStateEnum{LOGGED,APPROVED,REJECTED} /* should this not be an enum i.e it can only have certain values? */
    public enum leaveTypeEnum{ANNUAL,SICK,MATERNITY,FAMILY}

    protected Map<String, Object> map = new HashMap<String, Object>();


    public Map<String, Object> getMap() {


        List<String> stateList = new ArrayList<String>();
        stateList.add(requestStateEnum.LOGGED.toString());
        stateList.add(requestStateEnum.APPROVED.toString());
        stateList.add(requestStateEnum.REJECTED.toString());

        List<String> leaveTypeList = new ArrayList<String>();
        leaveTypeList.add(leaveTypeEnum.ANNUAL.toString());
        leaveTypeList.add(leaveTypeEnum.SICK.toString());
        leaveTypeList.add(leaveTypeEnum.MATERNITY.toString());
        leaveTypeList.add(leaveTypeEnum.FAMILY.toString());

        map = new HashMap<String, Object>();
        map.put("stateList", stateList);
        map.put("leaveTypeList", leaveTypeList);
        return map;
    }

}
