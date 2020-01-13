/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cuentapalabras;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author CDMFP
 */
public class ClasePrincipal {
    public static void main(String[] args) {
        String texto=AccesoFichero.devolverTexto();
        String texto_limpio=tratarTexto(texto);
        Map<String, Integer> mapa_palabras=rellenarMapa(texto_limpio);
        Iterator it=mapa_palabras.keySet().iterator();
        while(it.hasNext())
        {
            String palabra=(String)it.next();
            int n_veces=mapa_palabras.get(palabra);
            System.out.println(palabra+" "+n_veces);
        }
    }

    private static String tratarTexto(String texto) {
        char[] caracteres_eliminables={'"', '.', ',', ';', '?', '¿', '!','¡', ':'};
        for(char x: caracteres_eliminables)
        {
            texto=texto.replace(String.valueOf(x),"" );
        }
        //
        return texto.toLowerCase();
    }

    private static Map<String, Integer> rellenarMapa(String texto_limpio) {
        Map<String, Integer> mapa_palabras=new HashMap();
        String[] lista_palabras=texto_limpio.split(" ");
        for (String p:lista_palabras)
        {
            if(mapa_palabras.containsKey(p))
            {
                Integer n =mapa_palabras.get(p);
                n++;
                mapa_palabras.replace(p, n);
            }
            else
            {
                mapa_palabras.put(p, 1);
            }
        }
        return mapa_palabras;
    }
}
