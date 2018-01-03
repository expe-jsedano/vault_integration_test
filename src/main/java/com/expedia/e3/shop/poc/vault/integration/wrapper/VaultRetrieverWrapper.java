package com.expedia.e3.shop.poc.vault.integration.wrapper;
import java.util.Collections;
import java.util.Map;

import com.expedia.www.platform.ensconce.KeyPath;
import com.expedia.www.platform.ensconce.vault.AuthenticationException;
import com.expedia.www.platform.ensconce.vault.ReadException;
import com.expedia.www.platform.ensconce.vault.VaultRetriever;
import com.expedia.www.platform.ensconce.vault.authenticator.Authenticator;
import com.expedia.www.platform.ensconce.vault.wrapper.VaultWrapper;

public class VaultRetrieverWrapper {
    
    private VaultRetriever retriever;
    private final boolean isVaultEnabled;
   
    
    public VaultRetrieverWrapper(Authenticator authenticator, VaultWrapper vaultWrapper, boolean isVaultEnabled) {
        this.isVaultEnabled = isVaultEnabled;
        if (isVaultEnabled) {
            try {
                retriever = new VaultRetriever(authenticator,vaultWrapper);
            } catch(NullPointerException e) {
                throw new VaultWrapperException("VaultRetriever initialization exception",e);
            }
        }
    }
    
    
    public Map<String, String> get(String keyPath) {
        if (isVaultEnabled) {
            try {
                return retriever.get(new KeyPath(keyPath));
            } 
            catch(NullPointerException | IllegalArgumentException | AuthenticationException | ReadException e) {
                throw new VaultWrapperException("Could not get map from keypath", e);
            }
        } else {
            return Collections.emptyMap();
        }
    }
    
}
