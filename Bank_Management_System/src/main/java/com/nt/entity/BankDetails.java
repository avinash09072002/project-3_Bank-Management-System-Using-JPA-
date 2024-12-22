package com.nt.entity;

import java.security.KeyStore.PrivateKeyEntry;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class BankDetails {
	
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "AccoNo_seq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer accNo;
	
	@Column(name = "name",length = 8)
	private String name;
	
	@Column(name = "bankBalance" , length = 7)
	private Double bankBalance;
	
	
	
	@Version
    private Integer modificationCount;
	
	@CreationTimestamp
	@Column(insertable = true,updatable = false)
	private LocalDateTime openingTime;
	
	
	@UpdateTimestamp
	@Column(insertable = true, updatable = true)
	private LocalDateTime lastOperatedOn;
	

}
