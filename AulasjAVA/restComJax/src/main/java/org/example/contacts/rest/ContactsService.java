package org.example.contacts.rest;

import org.example.contacts.bean.Contact;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class ContactsService {
    private static List<Contact> contacts = new ArrayList<Contact>();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/xama")
    public String rave(){
        String rave = "hahah";
        return  "hahaha";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{contactID}")
    public Contact getContact(@PathParam("contactID") int id){
        Contact result = null;

        for (Contact contact : contacts){
            if (contact.getId() == id){
                result = contact;
                break;
            }
        }
        if (result == null) {
            throw new WebApplicationException(404);
        }
        return result;
    }

    @GET
    @Path("/find/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> findByName(@PathParam("name") String name){

    List<Contact> result = new ArrayList<Contact>();
        for (Contact contact : contacts) {
            if (contact.getName() != null && contact.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(contact);

            }
        }
        return result;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Contact add(Contact contact){
        if (contact.getName() == null || contact.getName().trim().equals("")){
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("O nome do contato é obrigatorio").build());
        }
        contacts.add(contact);
        contact.setId(contacts.indexOf(contact)+1);
        return contact;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") int id, Contact contact) {
        contacts.set(id - 1, contact);
        contact.setId(contacts.indexOf(contact) + 1);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id) {
        Contact contact = contacts.get(id - 1);
        contacts.remove(contact);
    }

}
