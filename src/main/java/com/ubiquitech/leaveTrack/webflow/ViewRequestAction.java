package com.ubiquitech.leaveTrack.webflow;

import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

/**
 * Created by vane on 2015/01/16.
 */
public class ViewRequestAction extends MultiAction {

    public Event setupCalendar(RequestContext context){
       return  success();

    }
}
