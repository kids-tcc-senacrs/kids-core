package com.kids.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Creche implements Serializable {

	private static final long serialVersionUID = 8164369067802692420L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "creche_id_seq")
	@SequenceGenerator(name = "creche_id_seq", sequenceName = "creche_id_seq", allocationSize = 1)
	private Long id;



	public Long getId() {
		return id;
	}



	public void setId(final Long id) {
		this.id = id;
	}
}
