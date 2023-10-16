package com.example.todoback.dto;

import lombok.Data;

@Data
public class Response {
    private boolean status;
    private String message;
    private Object result;

    private static Response getSuccess(Object res){
        Response response=new Response();
        response.message="";
        response.status=true;
        response.result=res;
        return response;
    }
    private static Response withError(Exception e){
        Response response=new Response();
        response.message=e.getMessage();
        response.status=false;
        response.result=null;
        return response;
    }

    public static Response response(Object any){
        if(any instanceof Exception){
            return withError((Exception) any);
        }
        return getSuccess(any);
    }
}
