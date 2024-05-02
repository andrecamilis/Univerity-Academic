package com.andrezin.UniversityAcademic.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = User.TABLE_NAME)
public class User {
    public static final String TABLE_NAME = "usuario";
    

    public interface CreateUser {
    }

    public interface UpdateUser {
    }

     /*
     * Ao definir os atributos não usar o INT no id recomendado usar o Integer ou
     * Long, ao usar tipo primitivos tem o risco de haver erros na execução ou
     * problemas no códigos entre o Java e o SQL
     * 
     * If want do definite the atributes do not use a INT in "id" it's
     * recommendation to use a Integer or Long because if you use a types primitives
     * have a risc for error in execution in code Java to SQL
     * 
     * 
     * GeneratedValues é estratégia para gerar numeros para o banco de dados
     * semelhante ao AUTO_INCREMENT
     */


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomeUsuario", length = 100, nullable = false, unique = true)
    private String nomeUsuario;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "senha", length = 60, nullable = false)
    private String senhaUser;


    /*
     * OneToMany = "Um usuário" várias tasks: por onde ele é mapeado 
     */
   
    

    
    public User(){}

    public User(Long id, String nomeUsuario, String senhaUser){
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.senhaUser = senhaUser;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUser() {
        return this.senhaUser;
    }

    public void setSenhaUser(String senhaUser) {
        this.senhaUser = senhaUser;
    }    
}
