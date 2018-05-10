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
@Table(name = "carro")
public class Carro implements Serializable {
	
    @Id
    @SequenceGenerator(name = "seq_carro", sequenceName = "seq_carro_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_carro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "placa", length = 10, nullable = false)
    @NotNull(message = "A placa não pode ser nula")
    @NotBlank(message = "A placa não pode ser em branco")
    @Length(max = 10, message = "A placa não pode ter mais que {max} caracteres")
    private String placa;
        
    @Column(name = "ano_fabricacao", nullable = false)
    @NotNull(message = "O ano de fabricação não pode ser nulo")
    private Integer anoFabricacao;
    
    @Column(name = "ano_modelo", nullable = false)
    @NotNull(message = "O ano do modelo não pode ser nulo")
    private Integer anoModelo;
    
    @Column(name = "versao", length = 40, nullable = false)
    @NotNull(message = "A versão não pode ser nula")
    @NotBlank(message = "A versão não pode ser em branco")
    @Length(max = 40, message = "A versão não pode ter mais que {max} caracteres")
    private String versao;
    
    @ManyToOne
    @JoinColumn(name = "modelo", referencedColumnName = "id", nullable = false)
    @NotNull(message = "O modelo deve ser informado")
    private Modelo modelo;
    
	
    public Carro() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }    

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}
