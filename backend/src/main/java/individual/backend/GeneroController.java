package individual.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    private final JdbcTemplate jdbcTemplate;

    public GeneroController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Genero>> listarGeneros(){

        String sql = "select * from genero";

        List<Genero> generos =  jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Genero.class));

        return ResponseEntity.status(200).body(generos);
    }
}
