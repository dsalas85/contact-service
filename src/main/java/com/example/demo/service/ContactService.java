package com.example.demo.service;

import com.example.demo.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ContactService
{

	/**
	 * @param pageable
	 * @return
	 */
	 Page<Contact> findAll( Pageable pageable );

	/**
	 * @param id
	 * @return
	 */
	 Contact findById( Long id );

	/**
	 * @param firstName
	 * @return
	 */
	 Contact findByFirstName( String firstName );

	/**
	 * @param contact
	 * @return
	 */
	 Contact save( Contact contact );

	/**
	 * @param id
	 * @return
	 */
	 Contact update( Long id, Contact contactInformation );

	/**
	 *
	 * @param id
	 */
	void delete( Long id );

}
