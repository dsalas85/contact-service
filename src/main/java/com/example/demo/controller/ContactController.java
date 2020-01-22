package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/contacts")
@Api( value = "Contact Service", description = "Operations pertaining to Contact Service" )
public class ContactController
{

    @Autowired
    private ContactService contactService;

    @ApiOperation( value = "Creates new contacts", response = Contact.class )
    @ApiResponses( value = { @ApiResponse( code = 200, message = "Contact created successfully" ),
            @ApiResponse( code = 401, message = "You are not authorized to view the resource" ),
            @ApiResponse( code = 403, message = "Accessing the resource you were trying to reach is forbidden" ),
            @ApiResponse( code = 404, message = "The resource you were trying to reach is not found" ) } )
    @PostMapping
    public Contact createContact( @Valid @RequestBody Contact contact )
    {
        return this.contactService.save( contact );
    }

    @ApiOperation( value = "Gets all contacts", response = Contact.class )
    @ApiResponses( value = { @ApiResponse( code = 200, message = "Contacts returned successfully" ),
            @ApiResponse( code = 401, message = "You are not authorized to view the resource" ),
            @ApiResponse( code = 403, message = "Accessing the resource you were trying to reach is forbidden" ),
            @ApiResponse( code = 404, message = "The resource you were trying to reach is not found" ) } )
    @GetMapping
    public Page<Contact> getContacts( Pageable pageable )
    {
        return this.contactService.findAll( pageable );
    }


    @ApiOperation( value = "Gets a contact by id", response = Contact.class )
    @ApiResponses( value = { @ApiResponse( code = 200, message = "Contact returned successfully" ),
            @ApiResponse( code = 401, message = "You are not authorized to view the resource" ),
            @ApiResponse( code = 403, message = "Accessing the resource you were trying to reach is forbidden" ),
            @ApiResponse( code = 404, message = "The resource you were trying to reach is not found" ) } )
    @GetMapping( "/{id}" )
    public Contact getContactById( @PathVariable( value = "id" ) Long id )
    {
        return this.contactService.findById( id );
    }

    @ApiOperation( value = "Update a contact by id", response = Contact.class )
    @ApiResponses( value = { @ApiResponse( code = 200, message = "Contact updated successfully" ),
            @ApiResponse( code = 401, message = "You are not authorized to view the resource" ),
            @ApiResponse( code = 403, message = "Accessing the resource you were trying to reach is forbidden" ),
            @ApiResponse( code = 404, message = "The resource you were trying to reach is not found" ) } )
    @PutMapping( "/{id}" )
    public Contact updateContact( @PathVariable( value = "id" ) Long id, @Valid @RequestBody Contact contactInformation )
    {
        return this.contactService.update( id, contactInformation );
    }

    @ApiOperation( value = "Delete a contact by id", response = Map.class )
    @ApiResponses( value = { @ApiResponse( code = 200, message = "Contact deleted successfully" ),
            @ApiResponse( code = 401, message = "You are not authorized to view the resource" ),
            @ApiResponse( code = 403, message = "Accessing the resource you were trying to reach is forbidden" ),
            @ApiResponse( code = 404, message = "The resource you were trying to reach is not found" ) } )
    @DeleteMapping( "/{id}" )
    public Map<String, Object> deleteContact( @PathVariable( value = "id" ) Long id )
    {
        this.contactService.delete( id );
        Map<String, Object> result = new HashMap<String, Object>();
        result.put( "deleted", Boolean.TRUE );
        return result;
    }

}
