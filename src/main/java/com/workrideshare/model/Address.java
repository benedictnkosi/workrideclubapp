package com.workrideshare.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String streetAddress;

	private String city;

	private String state;

	private String country;

	private String latitude;
	private String longitude;

	private String type;
}
