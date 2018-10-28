package fr.iamterror.lights.impl;

/**
 * Implémentation et simulation d'une "ampoule" de type tube néon dont la durée
 * de vie est est longue mais qui ne supporte pas les variations d'intensité.
 */
public class AmpouleTube extends Ampoule {

    public AmpouleTube() {
        super();
        super.probaPanneAmpoule = 5;
    }

    /**
     * Augmente l'intensité lumineuse de l'ampoule
     */
    public void intensifier() {
        allumer();
    }

    /**
     * Diminuer l'intensité lumineuse de l'ampoule
     */
    public void diminuer() {
        eteindre();
    }
}
