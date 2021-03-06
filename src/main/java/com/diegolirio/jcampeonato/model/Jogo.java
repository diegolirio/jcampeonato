package com.diegolirio.jcampeonato.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Jogo extends Model {

	@Id @GeneratedValue
	private long id;
	  
	@NotNull
	@ManyToOne
	private Grupo grupo;
	
	@NotNull
	@ManyToOne
	private Time timeA; 
	
	private int resultadoA = 0;
	
	@NotNull
	@ManyToOne
	private Time timeB;
	
	private int resultadoB = 0;
	
	@NotNull
	@ManyToOne
	private Local local;
	
	@NotNull
	@ManyToOne
	private Harbito harbito;
	
	@ManyToOne
	private Status status;
	
	private int rodada = 0;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
    private java.util.Date dataHora;
	
	private int sequencia;

	private char vencedor;

	public Jogo() {}
	
	public Jogo(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Time getTimeA() {
		return timeA;
	}

	public void setTimeA(Time timeA) {
		this.timeA = timeA;
	}

	public int getResultadoA() {
		return resultadoA;
	}

	public void setResultadoA(int resultadoA) {
		this.resultadoA = resultadoA;
	}

	public Time getTimeB() {
		return timeB;
	}

	public void setTimeB(Time timeB) {
		this.timeB = timeB;
	}

	public int getResultadoB() {
		return resultadoB;
	}

	public void setResultadoB(int resultadoB) {
		this.resultadoB = resultadoB;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Harbito getHarbito() {
		return harbito;
	}

	public void setHarbito(Harbito harbito) {
		this.harbito = harbito;
	}
	
	public Status getStatus() {
		return status;
	}

	public java.util.Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(java.util.Date dataHora) {
		this.dataHora = dataHora;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public int getRodada() {
		return rodada;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}
	
	public int getSequencia() {
		return sequencia;
	}

	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}

	public char getVencedor() {
		return vencedor;
	}

	public void setVencedor(char vencedor) {
		this.vencedor = vencedor;
	}

	@Override
	public String toString() {
		return "Jogo [id=" + id + ", grupo=" + grupo + ", timeA=" + timeA
				+ ", resultadoA=" + resultadoA + ", timeB=" + timeB
				+ ", resultadoB=" + resultadoB + ", local=" + local
				+ ", harbito=" + harbito + ", status=" + status + ", rodada="
				+ rodada + ", dataHora=" + dataHora + ", sequencia="
				+ sequencia + ", vencedor=" + vencedor + "]";
	}

	


	
}
