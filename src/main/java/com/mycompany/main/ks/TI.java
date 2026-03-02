/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.ks;

import com.mycompany.main.blackboard.Blackboard;
import com.mycompany.main.blackboard.IKnowledgeSource;

/**
 * Esta clase es del KS experto en identificar al objetivo a partir de datos
 * crudos.
 *
 * @author Afgord
 */
public class TI implements IKnowledgeSource {

    @Override
    public String name() {
        return "TI";
    }

    //// Si hay detección inicial (rawDetection) pero aún NO sabemos qué es
    @Override
    public boolean condition(Blackboard bb) {
        return bb.has("rawDetection") && !bb.has("targetId");
    }

    // Aquí ya "identificamos" el submarino enemigo
    @Override
    public void action(Blackboard bb) {
        bb.put("targetId", "SUB-ENEMIGO-ALFA");
        System.out.println("TI -> BB: targetId = SUB-ENEMIGO-ALFA");
    }

    // Sin identificación, casi nada avanza.
    @Override
    public int priority(Blackboard bb) {
        return condition(bb) ? 80 : 0;
    }

}
