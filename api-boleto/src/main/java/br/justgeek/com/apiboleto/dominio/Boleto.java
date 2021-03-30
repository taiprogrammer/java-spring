package br.justgeek.com.apiboleto.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBoleto;
    private Integer numeroBoleto;
    private LocalDate dataVencimento;

    public Integer getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Integer getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(Integer numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "idBoleto=" + idBoleto +
                ", numeroBoleto=" + numeroBoleto +
                ", dataVencimento=" + dataVencimento +
                '}';
    }
}
