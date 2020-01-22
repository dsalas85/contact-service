package com.example.demo;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith( SpringRunner.class )
@DataJpaTest
@AutoConfigureTestDatabase( connection = EmbeddedDatabaseConnection.H2 )
public class ContactApplicationTests
{

    @Autowired
    private ContactRepository repository;

    @Test
    public void testSaveContact()
    {

        Contact contact1 = this.getContactMock();
        repository.save( contact1 );

        Contact contact2 = repository.findByFirstName( "David" );
        assertNotNull( contact1 );
        assertEquals( contact2.getFirstName(), contact1.getFirstName() );
        assertEquals( contact2.getLastName(), contact1.getLastName() );
    }

    @Test
    public void testFindByName()
    {
        Contact contact1 = this.getContactMock();
        repository.save( contact1 );
        Contact contact2 = repository.findByFirstName( "David" );
        assertNotNull( contact1 );
        assertEquals( contact2.getFirstName(), contact1.getFirstName() );
        assertEquals( contact2.getLastName(), contact1.getLastName() );
    }

    @Test
    public void testDeleteContact()
    {
        Contact contact = this.getContactMock();
        repository.save( contact );
        repository.delete( contact );
    }

    @Test
    public void findAllContacts()
    {
        Contact contact1 = this.getContactMock();
        Contact contact2 = this.getContactMock();
        repository.save( contact1 );
        repository.save( contact2 );
        assertNotNull( repository.findAll() );
    }

    @Test
    public void deleteByContactIdTest()
    {
        Contact contact = this.getContactMock();
        repository.save( contact );
        repository.deleteById( contact.getId() );
    }

    /**
     * @return
     */
    private Contact getContactMock()
    {
        Contact contact = new Contact();
        contact.setFirstName( "David" );
        contact.setLastName( "Salas" );
        contact.setZipCode( "1234" );
        contact.setCity( "San Ramon" );
        contact.setPhoneNumber( "+506 84687764" );
        contact.setStreetAddress1( "Test Address" );
        contact.setState( "Alajuela" );
        return contact;
    }

}
