package fr.iamterror.lights.impl;

import fr.iamterror.lights.Eclairage;

import java.util.Random;

public class Ampoule implements Eclairage {

    protected int etat;

    protected double probaPanneAmpoule;

    public Ampoule() {
        this.etat = etat;
        this.probaPanneAmpoule = probaPanneAmpoule;
    }

    /**
     * Calcule la probabilité qu'une ampoule tombe en panne
     *
     * @return 0 l'ampoule fonctione, -1 l'ampoule est en panne
     */
    private int probaPanne() {
        Random alea = new Random();
        if (alea.nextInt(100) < probaPanneAmpoule) {
            return -1;
        }
        return 0;
    }

    @Override
    /**
     * Allume l'ampoule à pleine puissance
     */
    public void allumer() {
        if (etat != -1 && probaPanne() != -1) {
            etat = 10;
            probaPanne();
        } else {
            etat = -1;
        }
    }

    @Override
    /**
     * Eteint l'ampoule
     */
    public void eteindre() {
        if (etat != -1) {
            etat = 0;
        }
    }

    /**
     * Augmente l'intensité lumineuse de l'ampoule
     */
    @Override
    public void intensifier() {
        if (etat != -1 && etat < 10) {
            etat++;
        }
    }

    /**
     * Diminuer l'intensité lumineuse de l'ampoule
     */
    @Override
    public void diminuer() {
        if (etat > 0) {
            etat--;
        }
    }

    @Override
    public int etat() {
        return etat;
    }

    @Override
    /**
     * @return l'état de l'objet sous la forme d'une chaîne de caractères
     */
    public String toString() {
        String nomAmpoule = this.getClass().getSimpleName();
        if (etat == 0) {
            return nomAmpoule + " est éteinte";
        }
        if (etat > 0 && etat <= 10) {
            return nomAmpoule + " est allumée. Intensité : " + etat;
        }
        return nomAmpoule + " est en panne";
    }
}
