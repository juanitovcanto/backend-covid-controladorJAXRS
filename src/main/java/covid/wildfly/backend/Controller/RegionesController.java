package covid.wildfly.backend.Controller;

import java.util.List;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ejb.EJB;


import wildfly.backend.covid.service.RegionesService;
import wildfly.backend.covid.DTO.RegionesDTO;

@Path("/regiones")
public class RegionesController {
    @EJB
    RegionesService regionesService;
    
    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(APPLICATION_JSON)
    public Response getAllRegiones(){
        List<RegionesDTO>  regiones = regionesService.findAll();
        System.out.println("hola");
        return Response.ok(regiones).build();
        
    }

}
