package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class DeltagerEAO {
	
	
	@PersistenceContext(name="deltagerPU")
	private EntityManager em;
	
	public synchronized void registrerDeltager(String fNavn, String eNavn, 
			String mobil,   String passHash, String passSalt, char kjonn) {
		
		Deltager del = new Deltager(fNavn,eNavn,mobil, passHash, passSalt, kjonn);
		em.persist(del);
		System.out.println(del);
	}
	
//	public synchronized void registrerDeltager(Deltager del) {
//		em.persist(del);
//		System.out.println(del);
//	}
	
	public synchronized void slettDeltager(String mob) {
		em.remove(mob);
	}
	
	
	
	public synchronized Deltager finnDeltager(String mob) {
		return em.find(Deltager.class, mob);
		
	}
	
	public synchronized List<Deltager> hentAlleDeltagere() {
		List<Deltager> d = null;
		TypedQuery<Deltager> q = em.createQuery("SELECT d FROM Deltager d", Deltager.class);
		d = q.getResultList();
		return d;
	}

}
