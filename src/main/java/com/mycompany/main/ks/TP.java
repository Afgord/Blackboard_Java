/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.ks;

import com.mycompany.main.blackboard.Blackboard;
import com.mycompany.main.blackboard.IKnowledgeSource;

/**
 * Esta clase representa al KS en predecir los movimientos del objetivo
 *
 * @author Afgord
 */
public class TP implements IKnowledgeSource {

    @Override
    public String name() {
        return "TP";
    }

    // Si ya hay objetivo identificado pero aún no hay predicción
    @Override
    public boolean condition(Blackboard bb) {
        return bb.has("targetId") && !bb.has("predictedTrack");
    }

    // Predicción simulada
    @Override
    public void action(Blackboard bb) {
        bb.put("predictedTrack", "curso=NE, vel=constante, t+30s");
        System.out.println("TP -> BB: predictedTrack = curso=NE, vel=constante, t+30s");
    }

    @Override
    public int priority(Blackboard bb) {
        return condition(bb) ? 70 : 0;
    }
}
