/**
 * 
 */
package deliverit.resttest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author mapo
 *
 */
@Entity
public class Regras {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private int diasCorte;
	private Float multa;
	private Float juros;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDiasCorte() {
		return diasCorte;
	}

	public void setDiasCorte(int diasCorte) {
		this.diasCorte = diasCorte;
	}

	public Float getMulta() {
		return multa;
	}

	public void setMulta(Float multa) {
		this.multa = multa;
	}

	public Float getJuros() {
		return juros;
	}

	public void setJuros(Float juros) {
		this.juros = juros;
	}
}
