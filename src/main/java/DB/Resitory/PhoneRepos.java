package DB.Resitory;

import DB.Entities.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepos extends CrudRepository<Phone, Integer> {
}
