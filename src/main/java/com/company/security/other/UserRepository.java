package com.company.security.other;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
     User findByName(String name);
}
