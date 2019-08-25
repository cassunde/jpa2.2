package br.com.cassunde.sample.jpa;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import br.com.cassunde.sample.service.BookService;

public class Main {

	public static void main(String[] args) {
		
		try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {

			BookService service = container.select(BookService.class).get();
			
			service.usingList();
			service.usingStream();
			service.usingStreamAccessingSubList();
			service.usingStreamToPrintOverdueTask();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
