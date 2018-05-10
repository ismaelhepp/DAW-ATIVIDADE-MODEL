package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Ismael F. Hepp <ismaelhepp.ifsul@gmail.com>
 * 
 */
@Entity
@Table(name = "adicional")
public class Adicional implements Serializable {
	
    @Id
    @SequenceGenerator(name = "seq_adicional", sequenceName = "seq_adicional_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_adicional", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(
            name = "valor",
            nullable = false
            )
    @NotNull(message = "O valor da diária não pode ser nulo")
    private Double valor;
    
    @NotNull(message = "O tipo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "tipo", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_adicional_tipo")    
    private TipoAdicional tipo;
    
    @NotNull(message = "A locacao não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "locacao_id", referencedColumnName = "id", nullable= false)
    @ForeignKey(name = "fk_adicional_locacao")
    private Locacao locacao;
	
    public Adicional() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.getId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Adicional other = (Adicional) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public TipoAdicional getTipo() {
        return tipo;
    }

    public void setTipo(TipoAdicional tipo) {
        this.tipo = tipo;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }
}
