package org.onedatashare.endpointcredentials.model.credential;

import lombok.Data;
import lombok.SneakyThrows;
import org.onedatashare.endpointcredentials.model.error.InvalidTypeException;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Base class for storing one user credential
 */
@Data
@Document
public class EndpointCredential extends Object{
    protected String accountId;
    protected EndpointCredentialType type;

    @SneakyThrows
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof EndpointCredential)) {
            throw new InvalidTypeException(EndpointCredential.class.toString());
        }
        return accountId.toLowerCase().equals(((EndpointCredential) obj).accountId.toLowerCase());
    }
}