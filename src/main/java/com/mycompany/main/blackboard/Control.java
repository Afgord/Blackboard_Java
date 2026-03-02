/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.blackboard;

import java.util.List;

/**
 *
 * @author Afgord
 */
public class Control {

    private final List<IKnowledgeSource> sources;

    public Control(List<IKnowledgeSource> sources) {
        this.sources = sources;
    }

    /**
     * En este método el Control decide que KS puede actuar, selecciona el de
     * mayor prioridad y ejecuta su acción. Este proceso se repite hasta
     * encontrar la solución al problema o determinar que no tiene solución.
     *
     * @param bb
     * @param maxSteps
     */
    public void run(Blackboard bb, int maxSteps) {
        System.out.println("=== Inicio Control Heuristico ===");

        for (int step = 1; step <= maxSteps; step++) {
            System.out.println("\n--- Paso " + step + " ---");
            IKnowledgeSource best = selectBest(bb);

            // Si se cumple esta condición, quiere decir que el problema no tiene solución con este patrón.
            if (best == null) {
                System.out.println("No hay KS aplicable. Se detiene.");
                System.out.println("Estado BB: " + bb);
                return;
            }

            System.out.println("Control: selecciono " + best.name()
                    + " (prioridad=" + best.priority(bb) + ")");
            best.action(bb);

            System.out.println("Estado BB: " + bb);

            if (bb.has("launchDecision")) {
                System.out.println("\nSolucion encontrada: " + bb.get("launchDecision", String.class));
                return;
            }
        }

        System.out.println("\nSe alcanzo maxSteps sin solucion final.");
        System.out.println("Estado BB: " + bb);
    }

    /**
     * En esta función el Control escoge al KS con mayor prioridad.
     *
     * @param bb
     * @return
     */
    private IKnowledgeSource selectBest(Blackboard bb) {
        IKnowledgeSource best = null;
        int bestScore = 0;

        for (IKnowledgeSource ks : sources) {
            if (!ks.condition(bb)) {
                continue;
            }

            int score = ks.priority(bb);
            if (best == null || score > bestScore) {
                best = ks;
                bestScore = score;
            }
        }
        return best;
    }

}
