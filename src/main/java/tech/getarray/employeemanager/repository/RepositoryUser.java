package tech.getarray.employeemanager.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tech.getarray.employeemanager.model.User;


@Repository
public interface RepositoryUser extends PagingAndSortingRepository<User, Integer>{


    public Optional<User> findByEmail(String email);
    public List<User> findByUserType(String userType);
}
