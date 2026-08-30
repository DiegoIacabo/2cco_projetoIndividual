package individual.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@RestController
@RequestMapping("/festivais")
public class FestivalController {

    private final JdbcTemplate jdbcTemplate;

    public FestivalController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Festival>> listarFestivais(){

        String sql = "select * from festival";

        List<Festival> festivais = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Festival.class));

        return ResponseEntity.status(200).body(festivais);
    }

    @PostMapping
    public ResponseEntity<Festival> cadastrar(@RequestBody Festival festival){

        String sql = "insert into festival values (default, ?, ?, ?, ?, ?, ?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, festival.getNome());
            ps.setInt(2, festival.getQtdAtracoes());
            ps.setObject(3, festival.getDtInicio());
            ps.setObject(4, festival.getDtFim());
            ps.setBoolean(5, festival.getEventoPublico());
            ps.setInt(6, festival.getFkLocal());

            return ps;
        }, keyHolder);

        Integer idGerado = keyHolder.getKeyAs(Integer.class);
        festival.setId(idGerado);
        return ResponseEntity.status(201).body(festival);
    }
}
