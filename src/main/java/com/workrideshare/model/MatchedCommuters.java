package com.workrideshare.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
@NoArgsConstructor
public class MatchedCommuters {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "passenger")
	private Commuter passenger;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "driver")
	private Commuter driver;

	private int totalTrip;
	private int driverHomeToPassengerHome;
	private int passengerHomeToPassengerWork;
	private int passengerWorkToDriverWork;

	private int distanceHome;
	private int distanceOffice;

	private String status;

}
