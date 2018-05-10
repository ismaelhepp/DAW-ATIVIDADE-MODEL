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
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ismael F. Hepp <ismaelhepp.ifsul@gmail.com>
 * 
 */

@Entity
@Table(name = "modelo")
public class Modelo implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_modelo", sequenceName = "seq_modelo_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_modelo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome", length = 40, nullable = false)
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "grupo", referencedColumnName = "id", nullable = false)
    @NotNull(message = "O grupo deve ser informado")
    private Grupo grupo;
    
    @ManyToOne
    @JoinColumn(name = "fabricante", referencedColumnName = "id", nullable = false)
    @NotNull(message = "O fabricante deve ser informado")
    private Fabricante fabricante;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.getId());
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
        final Modelo other = (Modelo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
