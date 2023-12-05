package com.demo.Exception;

public class GeneralMessageException  extends  RuntimeException{

    private static final long serialVersionUID = 1L;
    private String errorCodes;
    private String errorMessages;

    public GeneralMessageException(String errorCodes,String errorMessages) {
        super(String.format("%s : %s",errorCodes,errorMessages));
        this.errorMessages=errorMessages;
        this.errorCodes=errorCodes;
    }
}
