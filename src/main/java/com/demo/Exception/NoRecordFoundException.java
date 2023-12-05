package com.demo.Exception;

public class NoRecordFoundException extends  RuntimeException{

    private static  final long serialVersionUID=1L;
    public  static String ErrorCodes;
    public static  String ErrorMessages;


    public NoRecordFoundException(String ErrorCodes,String ErrorMessages) {
        super(String.format(" %s : %s",ErrorCodes,ErrorMessages));
        this.ErrorCodes=ErrorCodes;
        this.ErrorMessages=ErrorMessages;
    }
}
