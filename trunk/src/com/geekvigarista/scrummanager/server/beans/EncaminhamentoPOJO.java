package com.geekvigarista.scrummanager.server.beans;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.geekvigarista.scrummanager.shared.enums.StatusRequisito;
import com.geekvigarista.scrummanager.shared.vos.Encaminhamento;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;
import com.google.code.morphia.annotations.Transient;

@Entity("encaminhamentos")
public class EncaminhamentoPOJO {

	@Id ObjectId id;
	
	@Embedded
	private StakeholderPOJO stakeholder; // o stakeholder que recebeu o encaminhamento;
	@Reference
	private EncaminhamentoPOJO encaminhamentoAnterior;
	
	private Date data;
	private int tempoGasto; // em horas
	private List<String> anexos;
	private StatusRequisito status;

	@Transient
	private Encaminhamento encaminhamento;

	public EncaminhamentoPOJO() {
	}

	public EncaminhamentoPOJO(Encaminhamento encaminhamento) {
		super();

		if (encaminhamento == null) {
			this.encaminhamento = null;
			this.stakeholder = null;
			this.encaminhamentoAnterior = null;
			this.data = null;
			this.anexos = null;
			this.id = null;
			this.status = null;

		} else {
			this.encaminhamento = encaminhamento;
			this.stakeholder = new StakeholderPOJO(
					encaminhamento.getStakeholder());
			this.encaminhamentoAnterior = new EncaminhamentoPOJO(
					encaminhamento.getEncaminhamentoAnterior());
			this.data = encaminhamento.getData();
			this.tempoGasto = encaminhamento.getTempoGasto();
			this.anexos = encaminhamento.getAnexos();
			this.status = encaminhamento.getStatus();
			if (encaminhamento.getId() == null) {
				this.id = null;
			} else {
				this.id = new ObjectId(encaminhamento.getId());
			}
		}
	}

	public Encaminhamento getEncaminhamento() {
		encaminhamento = new Encaminhamento(this.id == null ? null
				: this.id.toString(),
				stakeholder != null ? stakeholder.getStakeholder() : null,
				encaminhamentoAnterior == null ? null : encaminhamentoAnterior
						.getEncaminhamento(), data, tempoGasto, anexos, status);
		return encaminhamento;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public StakeholderPOJO getStakeholder() {
		return stakeholder;
	}

	public void setStakeholder(StakeholderPOJO stakeholder) {
		this.stakeholder = stakeholder;
	}

	public EncaminhamentoPOJO getEncaminhamentoAnterior() {
		return encaminhamentoAnterior;
	}

	public void setEncaminhamentoAnterior(
			EncaminhamentoPOJO encaminhamentoAnterior) {
		this.encaminhamentoAnterior = encaminhamentoAnterior;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getTempoGasto() {
		return tempoGasto;
	}

	public void setTempoGasto(int tempoGasto) {
		this.tempoGasto = tempoGasto;
	}

	public List<String> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<String> anexos) {
		this.anexos = anexos;
	}

	public StatusRequisito getStatus() {
		return status;
	}

	public void setStatus(StatusRequisito status) {
		this.status = status;
	}

}
