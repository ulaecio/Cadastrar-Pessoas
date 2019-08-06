/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author ulaecio
 */
public class Pessoas {
   private int Id;
    private int Idade;
    private String Nome;


    /**
     * @return the IdPessoa
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the IdPessoa to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Idade
     */
    public int getIdade() {
        return Idade;
    }

    /**
     * @param Idade the Idade to set
     */
    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }
 
}

