package com.kids.modulocrianca.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@ApiModel(description = "crianca")
public class CriancaVO implements Serializable {

    private static final long serialVersionUID = 8182810973491330809L;

    @Valid
    @ApiModelProperty(position = 0, required = true)
    private GeralVO geral;

    @Valid
    @ApiModelProperty(position = 1, required = true)
    private EnderecoVO endereco;

    @Valid
    @ApiModelProperty(position = 2, required = true)
    private ContatoVO contato;

    @Valid
    @ApiModelProperty(position = 3)
    private Set<MedicamentoVO> medicamentos;

    @Valid
    @ApiModelProperty(position = 4)
    private Set<AlergiaVO> alergias;





    public CriancaVO() {
	super();
	this.alergias = new HashSet<>();
    }





    public GeralVO getGeral() {
	return geral;
    }





    public EnderecoVO getEndereco() {
	return endereco;
    }





    public ContatoVO getContato() {
	return contato;
    }





    public Set<MedicamentoVO> getMedicamentos() {
	return medicamentos;
    }





    public Set<AlergiaVO> getAlergias() {
	return alergias;
    }
}