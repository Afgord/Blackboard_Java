/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.ks;

import com.mycompany.main.blackboard.Blackboard;
import com.mycompany.main.blackboard.IKnowledgeSource;

/**
 * Esta clase representa al KS en realizar los cálculos para realizar un plan de
 * interceptación según la trayectoria del objetivo. Puede determinar que hace
 * falta reposicionarse.
 *
 * @author Afgord
 */
public class TC implements IKnowledgeSource {

    @Override
    public String name() {
        return "TC";
    }

    // Si ya hay predicción pero aún no existe plan de trayectoria
    @Override
    public boolean condition(Blackboard bb) {
        return bb.has("predictedTrack") && !bb.has("trajectoryPlan");
    }

    // Si ya hay un plan de trayectoria
    @Override
    public void action(Blackboard bb) {
        bb.put("trajectoryPlan", "interceptar_en_t+30s");
        bb.put("needReposition", true);
        System.out.println("TC -> BB: trajectoryPlan = interceptar_en_t+30s");
        System.out.println("TC -> BB: needReposition = true");
    }

    @Override
    public int priority(Blackboard bb) {
        return condition(bb) ? 60 : 0;
    }

}
