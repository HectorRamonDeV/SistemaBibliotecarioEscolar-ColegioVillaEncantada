package sistema_biblioteca.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sistema_biblioteca.demo.model.Usuario;
import sistema_biblioteca.demo.repository.UsuarioRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.findByCodigo("A12345678").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setNombre("Administrador Principal");
            admin.setCodigo("A12345678");

            admin.setPassword(passwordEncoder.encode("1234"));
            admin.setRol("ADMINISTRADOR");

            usuarioRepository.save(admin);
            System.out.println("Usuario administrador creado por defecto: A12345678 / 1234");
        }
    }
}
