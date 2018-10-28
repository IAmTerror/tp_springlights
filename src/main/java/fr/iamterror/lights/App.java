/**
 * Illustration d'une mise en oeuvre de IoC (ou inversion de dépendance)
 * avec Spring 3, pilotée par des annotations et un fichier de configuration XML
 */

package fr.iamterror.lights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Eclairage eclairage;

    /**
     * constructeur par défaut pour les besoins d'instanciation Remarque :
     * considéré présent par défaut si aucun autre constructeur n'est défini
     */
    public App() {
//      eclairage = new Luminaire();
    }

    /**
     * Point d'injection utilisé par Spring (un setter prenant en argument un
     * objet implémentant l'interface Ampoule). "led" est le nom (qualifé) du
     * bean à injecter (voir fichier XML)
     */
    @Autowired
    @Qualifier("incand")
    public void setEclairage(Eclairage ecl) {
        eclairage = ecl;
    }

    /**
     * Cycles d'éclairage et d'extinction d'une ampoule
     */
    public void cycles() {
        int nbCycles = 0;
        do {
            eclairage.allumer();
            System.out.println(eclairage.toString());
            while (eclairage.etat() > 0) {
                eclairage.diminuer();
            }
            System.out.println(eclairage.toString());
            nbCycles++;
        } while (nbCycles < 1000 && eclairage.etat() != -1);
        System.out.println("\n" + "Nombre de cycles effectués avant la panne = " + nbCycles);
    }

    /**
     * point d'entrée de l'application
     *
     * @param args non utilisés ici
     */
    public static void main(String[] args) {

        try {
            // chargement et initialisation du framework Spring
            ApplicationContext context = new ClassPathXmlApplicationContext(
                    "spring-conf.xml");

            // demande explicite d'un bean instance de cette classe (voir fichier
            // XML)
            App app = (App) context.getBean("main");

            // appel d'un de ses services publics (ici la méthode cycles)
            app.cycles();
        } catch (RuntimeException e) {
            System.out.println("Impossible de créer un éclairage" + e.getMessage());
        }


        //        //        TESTS DE CHAQUE AMPOULE
//        // Ampoule incandescente
//        AmpouleIncandescente inc1 = new AmpouleIncandescente();
//        System.out.println(inc1.toString());
//        inc1.allumer();
//        System.out.println(inc1.toString());
//        for (int i=0; i<9; i++) {
//            inc1.diminuer();
//            System.out.println(inc1.toString());
//        }
//        for (int i=0; i<9; i++) {
//            inc1.intensifier();
//            System.out.println(inc1.toString());
//        }
//        for (int i=0; i<10; i++) {
//            inc1.diminuer();
//            System.out.println(inc1.toString());
//        }
//        // Fin ampoule incandescente
//        System.out.println("\n");
//        // Ampoule LED
//        AmpouleLed led1 = new AmpouleLed();
//        System.out.println(led1.toString());
//        led1.allumer();
//        System.out.println(led1.toString());
//        for (int i=0; i<9; i++) {
//            led1.diminuer();
//            System.out.println(led1.toString());
//        }
//        for (int i=0; i<9; i++) {
//            led1.intensifier();
//            System.out.println(led1.toString());
//        }
//        for (int i=0; i<10; i++) {
//            led1.diminuer();
//            System.out.println(led1.toString());
//        }
//        // Fin ampoule LED
//        System.out.println("\n");
//        // Ampoule tube (néon)
//        AmpouleTube tub1 = new AmpouleTube();
//        System.out.println(tub1.toString());
//        tub1.allumer();
//        System.out.println(tub1.toString());
//        tub1.intensifier();
//        System.out.println(tub1.toString());
//        tub1.diminuer();
//        System.out.println(tub1.toString());
//        tub1.allumer();
//        System.out.println(tub1.toString());
//        tub1.eteindre();
//        System.out.println(tub1.toString());
//        // Fin ampoule tube (néon)
////        FIN TESTS
    }
}