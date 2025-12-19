import extensions.File;

class mainSacha extends Program {

    final String[] SAVES = getAllFilesFromDirectory("./saves");

    void resetScreen() {
        println();
        print("\033[H\033[2J");
        System.out.flush();
    }

    void write(String text, int ms) {
        for (int i = 0; i < length(text); i++) {
            print(charAt(text, i));
            sleep(ms);
        }
    }

    void writeln(String text, int ms) {
        for (int i = 0; i < length(text); i++) {
            print(charAt(text, i));
            sleep(ms);
        }
        println();
    }

    void writeAndDisappear(String text, int ms, int duree) {
        for (int i = 0; i < length(text); i++) {
            print(charAt(text, i));
            sleep(ms);
        }
        sleep(duree);
        for (int i = length(text) - 1; i >= 0; i--) {
            print("\b");
            print(" ");
            print("\b");
            sleep(ms);
        }
    }

    void showText(String path) {
        File text = newFile(path);
        while (ready(text)) {
            print(readLine(text));
            println();
            sleep(25);
        }
        println();
    }

    void writeText(String path) {
        File text = newFile(path);
        while (ready(text)) {
            write(readLine(text),25);
            println();
            sleep(25);
        }
        println();
    }

    String removeMaj(String text) {
        String result = "";
        for (int i = 0; i < length(text); i++) {
            char c = charAt(text, i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32);
            }
            result = result + c;
        }
        return result;
    }

    String demanderPseudo() {
        resetScreen();
        writeln("Bonjour, agent... quel est votre nom ?", 25);
        println();
        write("Rentrez votre nom d'utilisateur : ", 25);
        String joueur = readString();
        return removeMaj(joueur);
    }

    boolean saveExist(String joueur) {
        boolean result = false;
        for (int i = 0; i < length(SAVES); i++) {
            if (equals(SAVES[i],(joueur + ".txt"))) {
                result = true;
            }
        }
        return result;
    }

    Player createPlayer(String joueur, int argent, int jour) {
        Player player = new Player();
        player.nom = joueur;
        player.argent = argent;
        player.jour = jour;
        return player;
    }


    void jour1() {
        writeText("./dialogues/jour1-intro.txt");
    }

/*
    void initStats(String joueur) {
        PAS DE METHODE QUI PERMET DE CREER OU D'ECRIRE DANS UN FICHIER EN IJAVA.
    }
*/

    void newGame(String joueur) {
        resetScreen();
        Player player = createPlayer(joueur, 100, 1);
        jour1();
    }

    void menuPrincipal(String joueur) {
        resetScreen();
        showText("./ASCII/logo.txt");
        String choix = "";
        boolean repeat = false;
        do {
            write("Sélectionnez une option : ", 25);
            choix = readString();
            if (equals(choix, "1")) {
                repeat = false;

                if (saveExist(joueur)) {
                    writeln("Vous êtes sur le point de supprimer votre ancienne sauvegarde.", 25);
                    println();
                    write("Continuer ? [O/N] ", 25);
                    String supprSave = removeMaj(readString());
                    if (equals(supprSave, "o") || equals(supprSave, "oui")) {
                        newGame(joueur);
                        repeat = false;
                    } else {
                        repeat = true;
                    }
                } else {
                    newGame(joueur);
                    repeat = false;
                }
            } else if (equals(choix, "2")) {
                if (saveExist(joueur)) {
                    print("En cours de développement...");
                    repeat = false;
                } else {
                    writeln("Aucune sauvegarde n'a été trouvée pour le joueur " + joueur + "...", 25);
                    repeat = true;
                }
            } else if (equals(choix, "3")) {
                writeln("Nous nous reverrons...", 25);
                repeat = false;
            } else {
                writeln("Option invalide, vous devez saisir une valeur entre 1 et 3.", 25);
                repeat = true;
            }
        } while (repeat);
    }

    void algorithm() {
        resetScreen();
        writeAndDisappear("Ce jeu a été conçu pour être joué en plein écran ;)", 25, 2500);
        sleep(1000);
        String joueur = demanderPseudo();
        resetScreen();
        sleep(1000);
        menuPrincipal(joueur);
    }
}