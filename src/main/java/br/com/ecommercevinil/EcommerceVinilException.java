package br.com.ecommercevinil;

public class EcommerceVinilException extends RuntimeException {

    public EcommerceVinilException(String mensagem){
        super(mensagem);
    }

    public EcommerceVinilException(Throwable throwable){
        super(throwable);
    }

    public EcommerceVinilException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }

}
