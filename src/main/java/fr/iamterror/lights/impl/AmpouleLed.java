package fr.iamterror.lights.impl;

/**
 * Implémentation et simulation d'une ampoule à LED dont la durée de vie est
 * très longue et donc la probabilité de panne très faible.
 */
public class AmpouleLed extends Ampoule {

    /**
     * Constructeur
     */
    public AmpouleLed() {
        super();
        super.probaPanneAmpoule = 1;
    }
}
