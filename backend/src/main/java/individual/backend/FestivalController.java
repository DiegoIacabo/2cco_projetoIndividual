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

@CrossOrigin
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

        if (festival.getNome() == null || festival.getNome().isBlank()) {
            System.out.println("Nome inválido!");
            return ResponseEntity.status(400).build();
        }

        if (festival.getQtdAtracoes() < 2) {
            System.out.println("Quantidade de atrações inválida!");
            return ResponseEntity.status(400).build();
        }

        if (festival.getDtInicio() == null || festival.getDtFim() == null || festival.getDtFim().isBefore(festival.getDtInicio())){
            System.out.println("Datas inválidas!");
            return ResponseEntity.status(400).build();
        }

        if (festival.getEventoPublico() == null) {
            System.out.println("Não informado se o evento é público!");
            return ResponseEntity.status(400).build();
        }

        if (festival.getFkLocal() == null || festival.getFkLocal() == 0) {
            System.out.println("Local inválido!");
            return ResponseEntity.status(400).build();
        }

        if (festival.getIdGeneros() == null || festival.getIdGeneros().isEmpty()) {
            System.out.println("Gênero musical não escolhido!");
            return ResponseEntity.status(400).build();
        }

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

        List<Integer> generos = festival.getIdGeneros();

        for (Integer idGeneroAtual : generos) {
            String sqlAssociativo = "insert into festival_genero values (?, ?)";

            jdbcTemplate.update(sqlAssociativo, idGerado, idGeneroAtual);
        }

        return ResponseEntity.status(201).body(festival);
    }
}
