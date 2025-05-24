package Pagination.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Pagination.pagination.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
