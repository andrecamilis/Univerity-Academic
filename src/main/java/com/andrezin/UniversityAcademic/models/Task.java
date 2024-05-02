package com.andrezin.UniversityAcademic.models;

import java.util.Objects;



import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = Task.TABLE_NAME)
public class Task {
    public static final String TABLE_NAME = "task";


    @Id
    @Column(name = "id", unique = true )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
 * ManyToOne = VÃĄrias tarefas para um Ãšnico usuÃĄrio
 * JoinColumn = ReferÃŠncia a Chave primÃĄria
 */
    @ManyToOne
    @JoinColumn(name = "nomeUsuario", nullable = false, updatable = false)
    private User nomeUsuario;

    @Column(name="descricao", length = 255, nullable = false)
     private String descricao;



     public Task() {}

     public Task(Long id, User nomeUsuario, String descricao){
            this.id = id;
            this.nomeUsuario = nomeUsuario;
            this.descricao = descricao;
     }




     public Long getId(){
        return this.id;
     }
     public void setId(Long id){
        this.id = id;
     }




     public User getNomeusuario(){
        return this.nomeUsuario;
     }

     public void setNomeusuario(User nomeUsuario){
        this.nomeUsuario = nomeUsuario;
     }




     public String getDescricao(){
        return this.descricao;
     }

     public void setDescricao(String descricao){
        this.descricao = descricao;
     }


     @Override
    public boolean equals(Object obj) {

        if (obj == this)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Task))
            return false;

        Task other = (Task) obj;

        if (this.id == null)
            if (other.id != null)
                return false;
            else if (!this.id.equals(other.id))
                return false;
        return Objects.equals(this.id, other.id) && Objects.equals(this.nomeUsuario, other.nomeUsuario)
         && Objects.equals(this.descricao, other.descricao);

    }
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0: this.id.hashCode());
        return result;
    }
    





}
