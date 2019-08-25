package br.com.cassunde.sample.repository;

import java.util.List;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.cassunde.sample.model.Book;

public class Books {

	@Inject
	private EntityManager em;
	
	public List<Book> listBooks(){
		return em.createQuery(" select"
								+ " b"
							+ " from "
								+ " Book b",Book.class).getResultList();
	}
	
	/**
	 * 
	 * TODO {@link Stream} is new data type supported by JPA
	 * 
	 * */
	public Stream<Book> streamBooks(){
		return em.createQuery(" select"
								+ " b"
							+ " from "
								+ " Book b",Book.class).getResultStream();
	}
}
