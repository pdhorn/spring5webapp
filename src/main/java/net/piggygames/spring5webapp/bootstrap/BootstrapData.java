package net.piggygames.spring5webapp.bootstrap;

import net.piggygames.spring5webapp.domain.Author;
import net.piggygames.spring5webapp.domain.Book;
import net.piggygames.spring5webapp.domain.Publisher;
import net.piggygames.spring5webapp.repositories.AuthorRepository;
import net.piggygames.spring5webapp.repositories.BookRepository;
import net.piggygames.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrapped Data");

        Publisher wePublish = new Publisher("We publish books, Inc", "23 Main St", "Nowhere", "Tx", "12345");
        publisherRepository.save(wePublish);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(wePublish);
        wePublish.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(wePublish);


        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2EE Development without EJB", "8124824");
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);
        noEjb.setPublisher(wePublish);
        wePublish.getBooks().add(noEjb);
        authorRepository.save(rod);
        bookRepository.save(noEjb);
        publisherRepository.save(wePublish);


        System.out.println("There are this many books: " + bookRepository.count());
        System.out.println("There are this many publishers: " + publisherRepository.count());
        System.out.println("The publisher has books: " + wePublish.getBooks().size());
    }
}
