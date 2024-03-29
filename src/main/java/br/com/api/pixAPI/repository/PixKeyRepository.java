package br.com.api.pixAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.pixAPI.model.PixKey;

@Repository
public interface PixKeyRepository extends JpaRepository<PixKey, Long> {
	
	@Query("select p.pixKey from PixKey p where id = :id")
	public Optional<PixKey> findPixKeyById(Long id);

	@Query("select p from PixKey p where pixKey = :pixKey")
	public Optional<PixKey> findByPixKey(Long pixKey);
	
	@Query("select count(p.pixKey) from PixKey p where p.user.id = :id")
	public Integer pixKeyCount(Long id);

}
