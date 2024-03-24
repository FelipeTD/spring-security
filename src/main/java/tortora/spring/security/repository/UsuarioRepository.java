package tortora.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tortora.spring.security.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT e FROM Usuario e JOIN FETCH e.roles WHERE e.username = (:username)")
    public Usuario findByUsername(@Param("username") String username);

}
