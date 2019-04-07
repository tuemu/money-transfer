package com.tuemu.money.transfer.api;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tuemu.money.transfer.service.TransferApiService;
import com.tuemu.money.transfer.service.TransferApiServiceImpl;
import com.tuemu.money.transfer.vo.Transfers;

/**
 * 
 */
@Path("transfers")
public class TransferApi {
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postTransfers(Transfers transfers) {
    	System.out.println("START postTransfers()");
    	UUID userToken = UUID.randomUUID();
    	TransferApiService TransferService = new TransferApiServiceImpl();
    	
    	System.out.println("getFrAccountId: " + transfers.getTransfers().get(0).getFrAccountId());
    	
    	return TransferService.getTransfers(userToken);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransfers(@HeaderParam("X-Name") String name) {
    	System.out.println("START getTransfers()");
    	UUID userToken = UUID.randomUUID();
    	
    	TransferApiService TransferService = new TransferApiServiceImpl();
    	return TransferService.getTransfers(userToken);
    }

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAccountsTest() {
    	System.out.println("START getAccountsTest()");
        return "Got it233 in Accounts!";
    }
}