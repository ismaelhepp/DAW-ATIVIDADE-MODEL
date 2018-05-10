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
 * @author Ismael F. Hepp <ismaelhepp.ifsul@gmail.com>
 * 
 */
@Entity
@Table(name = "acessorios")
public class Acessorios implements Serializable {
	
    @Id
    @SequenceGenerator(name = "seq_acessorios", sequenceName = "seq_acessorios_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_acessorios", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome", length = 40, nullable = false)
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")    
    private String nome;
    
    @ManyToMany
    @JoinTable(name = "acessorios_grupos", 
            joinColumns = @JoinColumn(name = "acessorio", 
                    referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = @JoinColumn(name = "grupo", 
                    referencedColumnName = "id", 
                    nullable = false)
    )
    private List<Grupo> grupos = new ArrayList<>(); 
	
    public Acessorios() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        final Acessorios other = (Acessorios) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
}
