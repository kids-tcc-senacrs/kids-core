package com.kids.modulofamilia.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.kids.enumeration.Parentesco;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 * 
 */
@ApiModel(description = "familiar")
public class FamiliaDTO implements Serializable {

    private static final long serialVersionUID = 5337553723112523107L;

    @ApiModelProperty(position = 0, required = true)
    private Long criancaId;

    @ApiModelProperty(position = 1, required = true)
    @NotEmpty(message = "o campo 'nome' não pode ser vazio")
    @NotNull(message = "o campo 'nome' é de preenchimento obrigatório")
    @Size(max = 60, message = "o campo 'email' deve conter no máximo '60' caracteres")
    private String nome;

    @ApiModelProperty(position = 2, required = true, example = "email@gmail.com")
    @Email(message = "o 'email' informado não é um endereço de email valido")
    @NotEmpty(message = "o campo 'email' não pode ser vazio")
    @NotNull(message = "o campo 'email' é de preenchimento obrigatório")
    @Size(max = 255, message = "o campo 'email' deve conter no máximo '255' caracteres")
    private String email;

    @ApiModelProperty(position = 3, required = true)
    @NotNull(message = "o campo 'parentesco' é de preenchimento obrigatório")
    private Parentesco parentesco;

    @ApiModelProperty(position = 4, required = true)
    @Column(name = "ativo")
    private Boolean ativo;





    public FamiliaDTO() {
	super();
    }





    public Long getCriancaId() {
	return criancaId;
    }





    public void setCriancaId(final Long criancaId) {
	this.criancaId = criancaId;
    }





    public String getNome() {
	return nome;
    }





    public void setNome(final String nome) {
	this.nome = nome;
    }





    public String getEmail() {
	return email;
    }





    public void setEmail(final String email) {
	this.email = email;
    }





    public Parentesco getParentesco() {
	return parentesco;
    }





    public void setParentesco(final Parentesco parentesco) {
	this.parentesco = parentesco;
    }





    public Boolean getAtivo() {
	return ativo;
    }





    public void setAtivo(final Boolean ativo) {
	this.ativo = ativo;
    }

}