/**
 * 
 */
package deliverit.resttest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author mapo
 *
 */
@Entity
public class ContaPagar {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String nome;
	
	private Float valorOriginal;
	
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;

	@Transient
	private int diasAtraso;

	@Transient
	private Float valorCorrigido = new Float(0.0f);

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(Float valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public int getDiasAtraso() {
		//LocalDate vencimento = this.dataVencimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		//LocalDate hoje = LocalDate.now();
		//this.diasAtraso = (int) Math.abs(ChronoUnit.DAYS.between(hoje, vencimento) - 1);
		return this.diasAtraso;
	}

	public Float getValorCorrigido() {
		//TODO: as regras para calculo de multa e juros deveriam ser persistidas

		if(this.diasAtraso <= 0 || this.dataPagamento != null) {
			return this.valorOriginal;
		}
		Float vo = this.valorOriginal;
		Float vc = vo;
		if(this.diasAtraso <= 3) {
			vc += (vo * 0.02f) + (vo * this.diasAtraso * 0.001f);
		} else if(this.diasAtraso <= 5) {
			vc += (vo * 0.03f) + (vo * this.diasAtraso * 0.002f);			
		} else {
			vc += (vo * 0.05f) + (vo * this.diasAtraso * 0.003f);
		}
		this.valorCorrigido = vc;
		return this.valorCorrigido;
	}
}
