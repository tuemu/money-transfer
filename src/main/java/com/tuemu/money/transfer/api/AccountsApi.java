package com.tuemu.money.transfer.api;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.tuemu.money.transfer.model.Account;
import com.tuemu.money.transfer.service.AccountApiService;
import com.tuemu.money.transfer.service.AccountApiServiceImpl;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("accounts")
public class AccountsApi {
	
    @GET
    @Produces("application/json")
    public String getAccounts() {
    	Gson gson = new Gson();
    	
		UUID userToken = UUID.randomUUID();
    	System.out.println("getAccounts is called !");
    	AccountApiService accountService = new AccountApiServiceImpl();
    	List<Account> list = accountService.getAccounts(userToken);
    	//gson.toJson(list);
    	
    	//return Response.ok(accountService.getAccounts(userToken)).build();
    	
    	return gson.toJson(list);
    }

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAccountsTest() {
        return "Got it233 in Accounts!";
    }
}
