package fr.iamterror.lights.impl;

public class AmpouleTriState extends Ampoule {
    /**
     * Constructeur
     */
    public AmpouleTriState() {
        super();
        super.probaPanneAmpoule = 0.5;
    }

    /**
     * Augmente l'intensité lumineuse de l'ampoule
     */

    public void intensifier() {
        if (etat != -1 && etat < 10) {
            etat += 5;
        }
    }

    /**
     * Diminuer l'intensité lumineuse de l'ampoule
     */

    public void diminuer() {
        if (etat > 0) {
            etat -= 5;
        }
    }
}
