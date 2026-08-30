package individual.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locais")
public class LocalController {

    private final JdbcTemplate jdbcTemplate;

    public LocalController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Local>> listarLocais(){
        String sql = "select * from local;";

        List<Local> locais = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Local.class));

        return ResponseEntity.status(200).body(locais);
    }

}
