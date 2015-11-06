package br.com.jsbse.gspm.mvc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ordemDeServico")
public class OrdemDeServico {

	private int id;
	private Cliente cliente;
	private Funcionario funcionario;
	private Set<Servico> servicos = new HashSet<Servico>();
	private Date dataDeCadastro;
	private Date dataDeAlteracao;
	private Date dataDeAgendamento;
	private Date dataDeExecucao;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "ordemdeservico_id", nullable = false)
	@GeneratedValue(generator = "generator")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "cliente_id")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "funcionario_id")
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Column(name = "dataDeCadastro")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	@Column(name = "dataDeExecucao")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataDeExecucao() {
		return dataDeExecucao;
	}

	public void setDataDeExecucao(Date dataDeExecucao) {
		this.dataDeExecucao = dataDeExecucao;
	}

	@Column(name = "dataDeAlteracao")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataDeAlteracao() {
		return dataDeAlteracao;
	}

	public void setDataDeAlteracao(Date dataDeAlteracao) {
		this.dataDeAlteracao = dataDeAlteracao;
	}

	@Column(name = "dataDeAgendamento")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataDeAgendamento() {
		return dataDeAgendamento;
	}

	public void setDataDeAgendamento(Date dataDeAgendamento) {
		this.dataDeAgendamento = dataDeAgendamento;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,CascadeType.MERGE })
	@JoinTable(name = "ordemDeServico_servico", joinColumns = @JoinColumn(name = "ordemdeservico_id"), inverseJoinColumns = @JoinColumn(name = "servico_id"))
	public Set<Servico> getServicos() {
		if (servicos == null) {
			servicos = new HashSet<Servico>();
		}
		return servicos;
	}

	public void setServicos(Set<Servico> servicos) {
		this.servicos = servicos;
	}

}
