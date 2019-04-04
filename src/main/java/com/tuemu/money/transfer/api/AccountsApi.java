package com.tuemu.money.transfer.api;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tuemu.money.transfer.service.AccountApiService;
import com.tuemu.money.transfer.service.AccountApiServiceImpl;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("accounts")
public class AccountsApi {
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccounts() {
    	UUID userToken = UUID.randomUUID();
    	System.out.println("getAccounts is called !");
    	AccountApiService accountService = new AccountApiServiceImpl();
    	return accountService.getAccounts(userToken);
    }

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAccountsTest() {
        return "Got it233 in Accounts!";
    }
}