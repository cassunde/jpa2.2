package br.com.cassunde.sample.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import javax.inject.Inject;

import br.com.cassunde.sample.model.Book;
import br.com.cassunde.sample.repository.Books;

public class BookService {

	@Inject
	private Books repo;
	
	public void usingList() {
		
		System.out.println("**********************************************");
		System.out.println("Using List");
		System.out.println("**********************************************");
		
		List<Book> books = repo.listBooks();
		
		System.out.println("Total: "+books.size());
		
		for (Book book : books) {
			
			System.out.println("Book: " + book.getDescription() );
			System.out.println("Tasks size: " + book.getTasks().size() );
		}
	}
	
	/**
	 * 
	 * this method use the stream object to print
	 * 
	 * */
	public void usingStream() {

		System.out.println("**********************************************");
		System.out.println("Using stream");
		System.out.println("**********************************************");
		
		Stream<Book> books = repo.streamBooks();
		
		books.forEach( book -> {
			
			System.out.println("Book: " + book.getDescription() );
			System.out.println("Tasks size: " + book.getTasks().size() );
		} );
	}
	
	public void usingStreamAccessingSubList() {

		System.out.println("**********************************************");
		System.out.println("Using stream to print sublist");
		System.out.println("**********************************************");
		
		Stream<Book> books = repo.streamBooks();
		
		books.forEach( book -> {
			
			
			System.out.println("Book: " + book.getDescription() );
			System.out.println("Tasks size: " + book.getTasks().size() );
			

			book.getTasks().stream().forEach( b ->{
				
				System.out.println(b.toString());
			} );
			
		} );
	}
	
	public void usingStreamToPrintOverdueTask() {

		System.out.println("**********************************");
		System.out.println("Using stream to print overdue task");
		System.out.println("**********************************");
		
		LocalDate baseDate = LocalDate.of(2019, 1, 10);
		
		Stream<Book> books = repo.streamBooks();
		
		books.forEach( book -> {

			book.getTasks().stream().forEach( t ->{
				
				boolean overDueTask = t.getDate().isBefore(baseDate);
				
				if(overDueTask) {
					
					System.out.println(t);
				}
			} );
		} );
	}
}
