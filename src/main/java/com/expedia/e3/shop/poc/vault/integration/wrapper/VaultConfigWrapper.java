package com.expedia.e3.shop.poc.vault.integration.wrapper;

import com.bettercloud.vault.SslConfig;
import com.bettercloud.vault.VaultConfig;
import com.bettercloud.vault.VaultException;

public class VaultConfigWrapper {

    private String pemResourse;
    private String address;
    private VaultConfig vaultConfig;
    
    public VaultConfigWrapper(String address, String pemResource) {
        this.address = address;
        this.pemResourse = pemResource;
    }

    public VaultConfig build() {
        if (vaultConfig == null) {
            try {
                SslConfig sslConfig = new SslConfig().pemResource(pemResourse).build();
                vaultConfig = new VaultConfig().sslConfig(sslConfig).address(address).build();
            }
            catch(NullPointerException | VaultException e) {
                throw new VaultWrapperException("Error while building configuration",e);
            }
        }
        return vaultConfig;
    }

}
