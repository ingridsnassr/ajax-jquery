package br.com.cast.ajaxjquery.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cast.ajaxjquery.entidade.Pessoa;


public class PessoaDAO {
	private EntityManager em;
	
	public PessoaDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ajax");
		em = emf.createEntityManager();
	}
	
	public void inserir(Pessoa pessoa) {
		em.getTransaction().begin();
		try {
			em.persist(pessoa);
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.getTransaction().commit();
	}


}


