package com.dcebilingualeducation.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Aluno implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idAluno;

		@Id
		@NotEmpty
		private String nome;
		
		@NotEmpty
		private String rg;
		
		@NotEmpty
		private String matricula;
		
		@NotEmpty
		private String cpf;
		
		@NotEmpty
		private String dataNascimento;
		
		@NotEmpty
		private String endereco;
		
		@ManyToOne
		private Turma turma;

		public long getIdAluno() {
			return idAluno;
		}

		public void setIdAluno(long idAluno) {
			this.idAluno = idAluno;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getRg() {
			return rg;
		}

		public void setRg(String rg) {
			this.rg = rg;
		}

		public String getMatricula() {
			return matricula;
		}

		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(String dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public Turma getTurma() {
			return turma;
		}

		public void setTurma(Turma turma) {
			this.turma = turma;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	
		
}
