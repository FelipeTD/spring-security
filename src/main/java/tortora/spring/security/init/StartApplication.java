package tortora.spring.security.init;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tortora.spring.security.config.Encoder;
import tortora.spring.security.model.Usuario;
import tortora.spring.security.repository.UsuarioRepository;

@Component
public class StartApplication implements CommandLineRunner {

    private final UsuarioRepository repository;

    private final Encoder encoder;

    public StartApplication(UsuarioRepository repository, Encoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Usuario usuario = repository.findByUsername("admin");

        if (usuario == null) {
            usuario = new Usuario();
            usuario.setName("ADMIN");
            usuario.setUsername("admin");
            usuario.setPassword(encoder.encoder().encode("master123"));
            usuario.getRoles().add("MANAGERS");
            repository.save(usuario);
        }

        usuario = repository.findByUsername("user");

        if (usuario == null) {
            usuario = new Usuario();
            usuario.setName("USER");
            usuario.setUsername("user");
            usuario.setPassword(encoder.encoder().encode("user123"));
            usuario.getRoles().add("USERS");
            repository.save(usuario);
        }

    }
}
