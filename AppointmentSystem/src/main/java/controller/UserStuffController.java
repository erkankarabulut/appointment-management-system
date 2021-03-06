package controller;

import org.json.JSONObject;
import provider.UserInformationProvider;
import provider.UserRegitrationProvider;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserStuffController {

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(@Context HttpServletRequest request) throws Exception {
        JSONObject data = UserInformationProvider.getUserInformation(request);

        return Response.ok().entity(data.toString()).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization, auth-user")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Max-Age", "9999999").build();
    }

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUSer(@Context HttpServletRequest request) throws Exception {
        JSONObject data = UserRegitrationProvider.registerUser(request);

        return Response.ok().entity(data.toString()).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization, auth-user")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Max-Age", "9999999").build();
    }


}
