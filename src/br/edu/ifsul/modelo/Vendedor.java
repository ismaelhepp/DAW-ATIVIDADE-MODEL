package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name = "vendedor")
public class Vendedor extends Pessoa implements Serializable {
    
    @Column(name = "login", length = 40, nullable = false)
    @NotNull(message = "O login não pode ser nulo")
    @NotBlank(message = "O login não pode ser em branco")
    @Length(max = 40, message = "O login não pode ter mais que {max} caracteres")    
    private String nomeUsuario;
    
    @Column(name = "senha", length = 20, nullable = false)
    @NotNull(message = "A senha não pode ser nula")
    @NotBlank(message = "A senha não pode ser em branco")
    @Length(max = 20, message = "A senha não pode ter mais que {max} caracteres")    
    private String senha;
    
    @Column(name = "ativo", nullable = false)
    @NotNull(message = "O ativo não pode ser nulo")
    private Boolean ativo;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
