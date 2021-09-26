package net.piggygames.spring5webapp.repositories;

import net.piggygames.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
