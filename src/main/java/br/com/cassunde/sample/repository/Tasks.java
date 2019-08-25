package br.com.cassunde.sample.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.cassunde.sample.model.Book;

public class Tasks {

	@Inject
	private EntityManager em;
	
	public List<Book> listBooks(){
		return em.createQuery(" select"
								+ " b"
							+ " from "
								+ " Book b",Book.class).getResultList();
	}
}
