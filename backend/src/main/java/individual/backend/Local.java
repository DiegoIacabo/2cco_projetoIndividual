package individual.backend;

public class Local {

    private String nome;
    private Integer capacidade;
    private Boolean ambienteAberto;

    public Local() {
    }

    public Local(String nome, Integer capacidade, Boolean ambienteAberto) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.ambienteAberto = ambienteAberto;
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
