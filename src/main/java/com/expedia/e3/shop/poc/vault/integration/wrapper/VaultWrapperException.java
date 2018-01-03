package com.expedia.e3.shop.poc.vault.integration.wrapper;

public class VaultWrapperException extends RuntimeException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public VaultWrapperException(String message, Exception exception) {
        super(message, exception);
    }
    
}
