/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.ks;

import com.mycompany.main.blackboard.Blackboard;
import com.mycompany.main.blackboard.IKnowledgeSource;

/**
 * Esta clase representa al KS experto en tomar la decisión final: FUEGO!!! Solo
 * se ejecuta cuando existe el plan de trayectoria, ya se está en posición
 * adecuada y aun no se ha tomado la decisión final.
 *
 * @author Afgord
 */
public class FC implements IKnowledgeSource {

    @Override
    public String name() {
        return "FC";
    }

    @Override
    public boolean condition(Blackboard bb) {
        Boolean inPos = bb.get("inPosition", Boolean.class);
        return bb.has("trajectoryPlan") && Boolean.TRUE.equals(inPos) && !bb.has("launchDecision");
    }

    @Override
    public void action(Blackboard bb) {
        bb.put("launchDecision", "LAUNCH");
        System.out.println("FC -> BB: launchDecision = LAUNCH");
    }

    @Override
    public int priority(Blackboard bb) {
        // Cuando ya está todo listo, FC debe ejecutarse de inmediato
        return condition(bb) ? 100 : 0;
    }

}
