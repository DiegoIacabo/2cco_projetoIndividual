package individual.backend;

import java.time.LocalDate;

public class Festival {

    private Integer id;
    private String nome;
    private Integer qtdAtracoes;
    private LocalDate dtInicio;
    private LocalDate dtFim;
    private Boolean eventoPublico;
    private Integer fkLocal;

    public Festival() {
    }

    public Festival(Integer id, String nome, Integer qtdAtracoes, LocalDate dtInicio, LocalDate dtFim, Boolean eventoPublico, Integer fkLocal) {
        this.id = id;
        this.nome = nome;
        this.qtdAtracoes = qtdAtracoes;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.eventoPublico = eventoPublico;
        this.fkLocal = fkLocal;
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

    public Integer getQtdAtracoes() {
        return qtdAtracoes;
    }

    public void setQtdAtracoes(Integer qtdAtracoes) {
        this.qtdAtracoes = qtdAtracoes;
    }

    public LocalDate getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDate dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDate getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDate dtFim) {
        this.dtFim = dtFim;
    }

    public Boolean getEventoPublico() {
        return eventoPublico;
    }

    public void setEventoPublico(Boolean eventoPublico) {
        this.eventoPublico = eventoPublico;
    }

    public Integer getFkLocal() {
        return fkLocal;
    }

    public void setFkLocal(Integer fkLocal) {
        this.fkLocal = fkLocal;
    }
}
