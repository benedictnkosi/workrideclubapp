package com.workrideshare.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;


import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
@NoArgsConstructor
public class Commuter {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	private String name;

	private String email;

	private String phoneNumber;

	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "homeAddress")
	private Address homeAddress;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workAddress")
	private Address workAddress;

	@CreatedDate
	private Date created;

}
