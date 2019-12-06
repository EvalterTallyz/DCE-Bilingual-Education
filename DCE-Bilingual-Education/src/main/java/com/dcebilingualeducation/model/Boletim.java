package com.dcebilingualeducation.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Boletim implements Serializable{
		
		private static final long serialVersionUID = 1L;

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idBoletim;

		private String nome;
		private String primeiroBimestre;
		private String segundoBimestre;
		private String terceiroBimestre;
		private String quartoBimestre;
		private String condicaoFinal;
		
		public long getIdBoletim() {
			return idBoletim;
		}
		public void setIdBoletim(long idBoletim) {
			this.idBoletim = idBoletim;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getPrimeiroBimestre() {
			return primeiroBimestre;
		}
		public void setPrimeiroBimestre(String primeiroBimestre) {
			this.primeiroBimestre = primeiroBimestre;
		}
		public String getSegundoBimestre() {
			return segundoBimestre;
		}
		public void setSegundoBimestre(String segundoBimestre) {
			this.segundoBimestre = segundoBimestre;
		}
		public String getTerceiroBimestre() {
			return terceiroBimestre;
		}
		public void setTerceiroBimestre(String terceiroBimestre) {
			this.terceiroBimestre = terceiroBimestre;
		}
		public String getQuartoBimestre() {
			return quartoBimestre;
		}
		public void setQuartoBimestre(String quartoBimestre) {
			this.quartoBimestre = quartoBimestre;
		}
		public String getCondicaoFinal() {
			return condicaoFinal;
		}
		public void setCondicaoFinal(String condicaoFinal) {
			this.condicaoFinal = condicaoFinal;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
			
}
	
