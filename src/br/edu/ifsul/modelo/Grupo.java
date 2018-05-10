package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author Ismael F. Hepp
 * 
 */

@Entity
@Table(name = "grupo")
public class Grupo implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_grupo", sequenceName = "seq_grupo_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_grupo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(
        name = "nome", 
        length = 40, 
        nullable = false
    )
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    private String nome;
    
    @Column(
            name = "valor_diaria",
            nullable = false
            )
    @NotNull(message = "O valor da diária não pode ser nulo")
    private Double valorDiaria;
    
    @ManyToMany
    @JoinTable(name = "acessorios_grupos", 
            joinColumns = @JoinColumn(name = "grupo", 
                    referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = @JoinColumn(name = "acessorio", 
                    referencedColumnName = "id", 
                    nullable = false)
    )
    private List<Acessorios> acessorios = new ArrayList<>();

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

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.getId());
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
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Acessorios> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorios> acessorios) {
        this.acessorios = acessorios;
    }
}
