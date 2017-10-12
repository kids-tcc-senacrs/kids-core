package com.kids.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 * 
 */
@Entity
@Table(name = "CARDAPIO_ALIMENTO")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CardapioAlimento implements Serializable {

    private static final long serialVersionUID = 2538766643131672135L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cardapio_alimento")
    @SequenceGenerator(name = "seq_cardapio_alimento", sequenceName = "seq_cardapio_alimento", allocationSize = 100, initialValue = 100)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cardapio")
    private Cardapio cardapio;

    @Column(name = "nome", nullable = false, length = 80)
    private String nome;





    public CardapioAlimento(final Cardapio cardapio, final String nome) {
	super();
	this.cardapio = cardapio;
	this.nome = nome;
    }





    public CardapioAlimento() {
	super();
    }





    public Long getId() {
	return id;
    }





    public void setId(Long id) {
	this.id = id;
    }





    public Cardapio getCardapio() {
	return cardapio;
    }





    public void setCardapio(Cardapio cardapio) {
	this.cardapio = cardapio;
    }





    public String getNome() {
	return nome;
    }





    public void setNome(String nome) {
	this.nome = nome;
    }

}
