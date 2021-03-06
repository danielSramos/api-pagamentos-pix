package br.com.api.pixAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.pixAPI.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where id = :id")
	public Optional<User> findById(Long id);

	@Query("select u from User u inner join PixKey p on p.user.id = u.id where p.pixKey = :pixKey")
	public Optional<User> findUserByPixKey(Long pixKey);
}
