package individual.backend;

public class Local {

    private Integer id;
    private String nome;
    private Integer capacidade;
    private Boolean ambienteAberto;

    public Local() {
    }

    public Local(Integer id, String nome, Integer capacidade, Boolean ambienteAberto) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.ambienteAberto = ambienteAberto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Boolean getAmbienteAberto() {
        return ambienteAberto;
    }

    public void setAmbienteAberto(Boolean ambienteAberto) {
        this.ambienteAberto = ambienteAberto;
    }
}
