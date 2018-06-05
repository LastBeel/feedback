package hello;

import org.springframework.data.repository.CrudRepository;

import hello.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface Client_info_tableRepository extends CrudRepository<Client_info_table, Long> {

}
