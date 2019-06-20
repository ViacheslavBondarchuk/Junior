package DB.Resitory;

import DB.Entities.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepos extends CrudRepository<Contact,Integer> {
}
