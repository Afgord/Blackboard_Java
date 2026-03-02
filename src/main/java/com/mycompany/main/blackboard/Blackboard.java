/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.blackboard;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Afgord
 */
public class Blackboard {

    private final Map<String, Object> data = new HashMap<>();

    /**
     * Este método permite a los KS escribir en el Blackboard cuando tienen
     * conocimiento útil para compartir.
     *
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        data.put(key, value);
    }

    /**
     * Este método permite a los KS obtener información del Blackboard.
     *
     * @param key
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> type) {
        Object v = data.get(key);
        return (v == null) ? null : (T) v;
    }

    /**
     * Con este método el KS pregunta si hay pieza de conocimiento nueva en el
     * Blackboard
     *
     * @param key
     * @return
     */
    public boolean has(String key) {
        return data.containsKey(key);
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
