package it.unibo.exceptions.fakenetwork.exceptions;

import java.io.IOException;

public class NetworkException extends IOException{

    public NetworkException(){
        new Exception("Network error: no response");
    }

    public NetworkException(String msg){
        new Exception("Network error while sending message: <" + msg + ">");
    }
}
