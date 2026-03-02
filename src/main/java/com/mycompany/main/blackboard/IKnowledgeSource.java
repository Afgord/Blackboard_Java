/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.main.blackboard;

/**
 *
 * @author Afgord
 */
public interface IKnowledgeSource {

    // Nombre del KS
    String name();

    /**
     * Esta función permite al KS revisar en el Blackboard y ver si puede
     * aportar conocimiento o no. Si no se cumple la condición, entonces el KS
     * no aporta nada.
     *
     * @param bb
     * @return
     */
    boolean condition(Blackboard bb);

    /**
     * Si la condición se cumplió (método anterior), el KS ejecuta su acción.
     * Puede producir nueva información (hipótesis o resultados) y las escribe
     * en Blackboard.
     *
     * @param bb
     */
    void action(Blackboard bb);

    /**
     * Heurística simple: mayor valor es igual a mayor prioridad para ejecutarse
     * en este momento.
     *
     * @param bb
     * @return prioridad
     */
    int priority(Blackboard bb);

}
