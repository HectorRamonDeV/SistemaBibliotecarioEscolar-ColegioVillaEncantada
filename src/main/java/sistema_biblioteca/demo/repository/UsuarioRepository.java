package sistema_biblioteca.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema_biblioteca.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}