package com.tuemu.money.transfer.api;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tuemu.money.transfer.service.AccountApiService;
import com.tuemu.money.transfer.service.AccountApiServiceImpl;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("accounts")
public class AccountApi {
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccounts(@HeaderParam(HttpHeaders.AUTHORIZATION) String authHeader) {
    	System.out.println("START getAccounts()");
    	UUID userToken = UUID.fromString(authHeader);
    	AccountApiService accountService = new AccountApiServiceImpl();
    	return accountService.getAccounts(userToken);
    }

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAccountsTest() {
    	System.out.println("START getAccountsTest()");
        return "Got it233 in Accounts!";
    }
}