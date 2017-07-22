package com.kids.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Entity
@Table(name = "CONTATO")
public class Contato implements Serializable {

    private static final long serialVersionUID = 6705004934597445605L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "sequenceContato", strategy = GenerationType.TABLE)
    @TableGenerator(name = "sequenceContato", allocationSize = 1)
    private Long id;

    @Column(name = "responsavel", nullable = false, length = 60)
    private String responsavel;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "fone_principal", nullable = false, length = 20)
    private String fonePrincipal;

    @Column(name = "fone_outro", length = 20)
    private String foneOutro;





    public Contato() {
	super();
    }





    public Long getId() {
	return id;
    }





    public void setId(final Long id) {
	this.id = id;
    }





    public String getResponsavel() {
	return responsavel;
    }





    public void setResponsavel(final String responsavel) {
	this.responsavel = responsavel;
    }





    public String getEmail() {
	return email;
    }





    public void setEmail(final String email) {
	this.email = email;
    }





    public String getFonePrincipal() {
	return fonePrincipal;
    }





    public void setFonePrincipal(final String fonePrincipal) {
	this.fonePrincipal = fonePrincipal;
    }





    public String getFoneOutro() {
	return foneOutro;
    }





    public void setFoneOutro(final String foneOutro) {
	this.foneOutro = foneOutro;
    }
}