/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author MAGNO
 */
public class Evento implements Serializable{
    
    public String evento, equipamento, sala, local;
    
    public Evento(String evento, String equipamento, String sala, String local) {
        this.evento = evento;
        this.equipamento = equipamento;
        this.sala = sala;
        this.local = local;
    }

    public Evento() {
    }


    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return  evento + "\n" + equipamento + "\n" + sala + "\n" + local + "\n";
    }
    
}
