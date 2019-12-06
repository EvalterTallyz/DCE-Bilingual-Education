package com.dcebilingualeducation.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Turma implements Serializable {

		private static final long serialVersionUID = 1L;

		
		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		private Long codigo;
		
		@NotEmpty
		private String curso;
		
		@NotEmpty
		private String professor;
		
		@NotEmpty
		private String sala;
		
		@NotEmpty
		private String turno;
		
		@NotEmpty
		private String horario;
		
		@OneToMany
		private List<Aluno> alunos;

		
		public String getCurso() {
			return curso;
		}
		public void setCurso(String curso) {
			this.curso = curso;
		}
		public String getProfessor() {
			return professor;
		}
		public void setProfessor(String professor) {
			this.professor = professor;
		}
		public String getSala() {
			return sala;
		}
		public void setSala(String sala) {
			this.sala = sala;
		}
		public String getTurno() {
			return turno;
		}
		public void setTurno(String turno) {
			this.turno = turno;
		}
		public String getHorario() {
			return horario;
		}
		public void setHorario(String horario) {
			this.horario = horario;
		}
		public List<Aluno> getAlunos() {
			return alunos;
		}
		public void setAlunos(List<Aluno> alunos) {
			this.alunos = alunos;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public Long getCodigo() {
			return codigo;
		}
		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}
		
	
}
