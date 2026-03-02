/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.main;

import com.mycompany.main.blackboard.Blackboard;
import com.mycompany.main.blackboard.Control;
import com.mycompany.main.blackboard.IKnowledgeSource;
import com.mycompany.main.ks.FC;
import com.mycompany.main.ks.MC;
import com.mycompany.main.ks.TC;
import com.mycompany.main.ks.TI;
import com.mycompany.main.ks.TP;
import java.util.List;

/**
 *
 * @author Afgord
 */
public class Main {

    public static void main(String[] args) {
        Blackboard bb = new Blackboard();

        // Entrada inicial simulada
        bb.put("rawDetection", "bearing=120 deg, range=3.2km");
        System.out.println("Sensor/Operador -> BB: rawDetection = bearing=120 deg, range=3.2km");

        List<IKnowledgeSource> kses = List.of(
                new TI(),
                new TP(),
                new TC(),
                new MC(),
                new FC()
        );

        new Control(kses).run(bb, 20);
    }
}
