package fr.iamterror.lights.impl;

import fr.iamterror.lights.Eclairage;

import java.util.List;

public class Luminaire implements Eclairage {

    private List<Eclairage> ampoules;

    public List<Eclairage> getAmpoules() {
        return ampoules;
    }

    public void setAmpoules(List<Eclairage> ampoules) throws RuntimeException {
        this.ampoules = ampoules;
        if (ampoules.size() > 0) {
            String className = ampoules.get(0).getClass().getName();
            for (int i = 1; i < ampoules.size(); i++) {
                if (ampoules.get(i).getClass().getName().equals("Luminaire")) {
                    throw new RuntimeException("Echec : il est strictement interdit de brancher un luminaire sur un luminaire !");
                } else if (!ampoules.get(i).getClass().getName().equals(className)) {
                    throw new RuntimeException("Ampoules hétérogènes");
                }
            }
        } else {
            throw new RuntimeException("Luminaire vide");
        }
    }

    @Override
    public void allumer() {
        for (int i = 0; i < this.ampoules.size(); i++) {
            this.ampoules.get(i).allumer();
        }
    }

    @Override
    public void eteindre() {
        for (int i = 0; i < this.ampoules.size(); i++) {
            this.ampoules.get(i).eteindre();
        }
    }

    @Override
    public void intensifier() {
        for (int i = 0; i < this.ampoules.size(); i++) {
            this.ampoules.get(i).intensifier();
        }
    }

    @Override
    public void diminuer() {
        for (int i = 0; i < this.ampoules.size(); i++) {
            this.ampoules.get(i).diminuer();
        }
    }

    /**
     * Retourne l'état du luminaire dans l'intervalle [0..10] ou -1 si il est en
     * panne. L'état résultant est la plus grande valeur des états des 4
     * ampoules du luminaire
     *
     * @return l'état du luminaire
     */
    @Override
    public int etat() {
        int etat = -1;

        for (int i = 0; i < ampoules.size(); i++) {
            if (ampoules.get(i).etat() > etat) {
                etat = ampoules.get(i).etat();
            }
        }
        return etat;
    }

    /**
     * methode permettant de vérifier si les ampoules branchées sur le luminaire
     * sont de même type. Renvoie 1 si oui, 0 dans le cas contraire
     *
     * @return un int vérifiant l'intégrité du luminaire
     */
    public int ampoulesIdentiques() {
        int ampoulesIdentiques = 1;
        for (int i = 1; i < ampoules.size(); i++) {
            if (ampoules.get(i).getClass() != ampoules.get(i - 1).getClass()) {
                ampoulesIdentiques = 0;
                break;
            }
        }
        return ampoulesIdentiques;
    }

    public String toString() {
        String s = "\n" + "---------" + "\n\n" + "Classe : " + this.getClass().getSimpleName() + " etat : "
                + this.etat();

        for (Eclairage ecl : ampoules) {
            s += "\n" + "   " + ecl.toString();
        }

        return s;
    }
}
