package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService
{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Page<Contact> findAll( Pageable pageable )
    {
        return this.contactRepository.findAll( pageable );
    }

    @Override
    public Contact findById( Long id )
    {
        return this.contactRepository.findById( id )
                .orElseThrow( () -> new ResourceNotFoundException( "Contact", "id", id ) );
    }

    @Override
    public Contact findByFirstName( String firstName )
    {
        return this.contactRepository.findByFirstName( firstName );
    }

    @Override
    public Contact save( Contact contact )
    {
        return this.contactRepository.save( contact );
    }

    @Override
    public Contact update( Long id, Contact contactInformation )
    {
        Contact contact = this.contactRepository.findById( id )
                .orElseThrow( () -> new ResourceNotFoundException( "Contact", "id", id ) );

        contact.setFirstName( contactInformation.getFirstName() );
        contact.setLastName( contactInformation.getLastName() );
        contact.setPhoneNumber( contactInformation.getPhoneNumber() );
        contact.setStreetAddress1( contactInformation.getStreetAddress1() );
        contact.setStreetAddress2( contactInformation.getStreetAddress2() );
        contact.setCity( contactInformation.getCity() );
        contact.setState( contactInformation.getState() );
        contact.setZipCode( contactInformation.getZipCode() );
        Contact updatedContact = this.contactRepository.save( contact );
        return updatedContact;
    }

    @Override
    public void delete( Long id )
    {
        Contact contact = this.contactRepository.findById( id )
                .orElseThrow( () -> new ResourceNotFoundException( "Contact", "id", id ) );
        this.contactRepository.delete( contact );
    }
}
