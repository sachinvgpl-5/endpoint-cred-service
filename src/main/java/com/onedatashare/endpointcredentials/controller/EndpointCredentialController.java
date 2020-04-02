package com.onedatashare.endpointcredentials.controller;

import com.onedatashare.endpointcredentials.model.credential.EndpointCredential;
import com.onedatashare.endpointcredentials.model.request.SaveNewAccountCredRequest;
import com.onedatashare.endpointcredentials.model.request.SaveNewOAuthCredRequest;
import com.onedatashare.endpointcredentials.repository.CredListResponse;
import com.onedatashare.endpointcredentials.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/endpoint-cred")
public class EndpointCredentialController {

    @Autowired
    private UserCredentialService userCredentialService;

    @GetMapping("/list")
    public Mono<CredListResponse> getCredential(@RequestParam String type){
        return userCredentialService.fetchCredentialList("aashish_jain@live!com" ,type);
    }

    @GetMapping("/get-cred")
    public Mono<EndpointCredential> getCredential(@RequestParam String type, @RequestParam String id){
        id.replace(".","!");
        return userCredentialService.getCredential("aashish_jain@live!com" ,type, id);
    }



    @PostMapping("/save/account-cred")
    public void addCredential(@RequestBody SaveNewAccountCredRequest request){
        userCredentialService.saveCredential(request.getEmail(), request.getType(), request.getCredential());
    }

    @PostMapping("/save/oauth-cred")
    public void addCredential(@RequestBody SaveNewOAuthCredRequest request){
        userCredentialService.saveCredential(request.getEmail(), request.getType(), request.getCredential());
    }

    @DeleteMapping("/delete")
    public void deleteCredential(@RequestParam String type, @RequestParam String id){
        userCredentialService.deleteCredential("", type, id);
    }
}