/**
 * 
 */
package deliverit.resttest;

import javax.persistence.EntityManager;

import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

/**
 * @author mapo
 *
 */
public class CriaRegras {
	private LocalEntityManagerFactoryBean factory;
	private EntityManager entityMgr;

	public CriaRegras() {
		super();
		this.init();
	}
	
	public void criaRegras() {
		Regras regra = new Regras();
		entityMgr.getTransaction().begin();

		regra.setDiasCorte(3);
		regra.setMulta(0.02f);
		regra.setJuros(0.001f);
		entityMgr.persist(regra);

		regra.setDiasCorte(5);
		regra.setMulta(0.03f);
		regra.setJuros(0.002f);
		entityMgr.persist(regra);

		regra.setDiasCorte(Integer.MAX_VALUE);
		regra.setMulta(0.05f);
		regra.setJuros(0.003f);
		entityMgr.persist(regra);

		entityMgr.getTransaction().commit();
		entityMgr.close();
	}
	
	public Regras leRegras() {
		//TODO : incompleto
		return null;
	}

	private void init() {
		//TODO : incompleto
		factory = new LocalEntityManagerFactoryBean();
		entityMgr = factory.getNativeEntityManagerFactory().createEntityManager();
	}
}
