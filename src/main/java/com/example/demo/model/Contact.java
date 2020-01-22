package com.example.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = "contact" )
@SequenceGenerator( name = "id", sequenceName = "CONTACT_ID_SEQ", allocationSize = 1 )
@Data
public class Contact extends AuditModel
{

    @Id
    @GeneratedValue( generator = "ID", strategy = GenerationType.SEQUENCE )
    @Column( nullable = false )
    @ApiModelProperty( hidden = true )
    private Long id;

    @NotNull
    @Size( max = 100 )
    @Column( name = "first_name" )
    private String firstName;

    @NotNull
    @Size( max = 100 )
    @Column( name = "last_name" )
    private String lastName;

    @NotNull
    @Size( max = 100 )
    @Column( name = "phone_number" )
    private String phoneNumber;

    @NotNull
    @Size( max = 250 )
    @Column( name = "street_address1" )
    private String streetAddress1;

    @Size( max = 250 )
    @Column( name = "street_address2" )
    private String streetAddress2;

    @NotNull
    @Size( max = 100 )
    private String city;

    @NotNull
    @Size( max = 100 )
    private String state;

    @NotNull
    @Size( max = 100 )
    @Column( name = "zip_code" )
    private String zipCode;

}
