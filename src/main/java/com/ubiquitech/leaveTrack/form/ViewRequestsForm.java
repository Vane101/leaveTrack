package com.ubiquitech.leaveTrack.form;

import com.ubiquitech.leaveTrack.domain.Request;

import java.io.Serializable;

/**
 * Created by vane on 2015/01/16.
 */
public class ViewRequestsForm implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Request request = new Request();

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

}