/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.ks;

import com.mycompany.main.blackboard.Blackboard;
import com.mycompany.main.blackboard.IKnowledgeSource;

/**
 * Esta clase representa al KS experto en mover la plataforma (reposicionar). Se
 * activa si se detectó que se requiere reposicionar (needReposition = true).
 *
 * @author Afgord
 */
public class MC implements IKnowledgeSource {

    @Override
    public String name() {
        return "MC";
    }

    @Override
    public boolean condition(Blackboard bb) {
        Boolean need = bb.get("needReposition", Boolean.class);
        Boolean inPos = bb.get("inPosition", Boolean.class);
        return Boolean.TRUE.equals(need) && !Boolean.TRUE.equals(inPos);
    }

    @Override
    public void action(Blackboard bb) {
        bb.put("inPosition", true);
        System.out.println("MC -> BB: inPosition = true");
    }

    @Override
    public int priority(Blackboard bb) {
        // Si hay que reposicionarse, esto se vuelve urgente
        return condition(bb) ? 90 : 0;
    }

}
