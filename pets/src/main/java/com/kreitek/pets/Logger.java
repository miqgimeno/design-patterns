package com.kreitek.pets;

public class Logger {

    private static int contador = 0;
        public String debug(String log) {
            contador = contador + 1;
            return "[debug]["+ contador +"] - " + log;
        }

}
