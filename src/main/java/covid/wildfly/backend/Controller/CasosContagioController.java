package covid.wildfly.backend.Controller;

import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import wildfly.backend.covid.DTO.CasosNuevosComunaDTO;
import wildfly.backend.covid.service.CasosContagioService;


import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * esto es un controlador.
 *
 *
 */

@Stateful
@Path("/casos")
public class CasosContagioController {
    @EJB
    private CasosContagioService casosContagioService;

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/comuna/{idComuna}")
    public Response getComunasByRegion(@PathParam("idComuna") Long idComuna){
        if (idComuna == null) {
            return Response.serverError().entity("El valor no puede estar vacacio").build();
        }
        List<CasosNuevosComunaDTO> listaComunasQuery = casosContagioService.casosNuevosPorComuna(idComuna);
        if (listaComunasQuery == null){
            return Response.status(Response.Status.NOT_FOUND).entity("comuna no encontrada").build();
        }
        return Response.ok(listaComunasQuery).build();
    }
}
