package controller;

import model.Calculateur;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controlleur {
    private static Controlleur instance;
    private Calculateur calculateur = Calculateur.getInstance();
    private static final Pattern p = Pattern.compile("^( *\\d+(?:\\.\\d+)? *)([+-/*])( *\\d+(?:\\.\\d+)? *)$");

    private Controlleur() {
    }

    public static Controlleur getInstance() {
        return instance = instance == null ? new Controlleur() : instance;
    }

    public void calculer(String saisie) {
        Matcher m = p.matcher(saisie);
        if (m.find()) {
            float nombre1 = Float.parseFloat(m.group(1).trim());
            float nombre2 = Float.parseFloat(m.group(3).trim());
            char operateur = m.group(2).charAt(0);
            String log = nombre1 + " " + operateur + " " + nombre2;
            calculateur.process(log, nombre1, nombre2, operateur);
        }
        else{
            calculateur.erreur("ERREUR");
        }
    }
}
