package com.arun.eventmanagementapi.exceptions;


public class AlreadyCheckedInException extends RuntimeException {
    public AlreadyCheckedInException(String msg)  {
        super(msg);
    }
}
