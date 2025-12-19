import extensions.File;

class mainSacha extends Program {

    String[] SAVES = getAllFilesFromDirectory("./saves");

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

    boolean saveExist(String joueur) {
        boolean result = false;
        for (int i = 0; i < length(SAVES); i++) {
            if (equals(SAVES[i],(joueur + ".txt"))) {
                result = true;
            }
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

    void newGame() {
        print("Nouvelle partie en cours...");
    }

    void menuPrincipal(String joueur) {
        resetScreen();
        showText("./ASCII/logo.txt");
        int choix = 0;
        boolean error = false;
        do {
            write("Sélectionnez une option : ", 25);
            choix = readInt();
            if (choix >= 1 && choix <= 3) {
                error = false;
            } else {
                writeln("Option invalide, vous devez saisir une valeur entre 1 et 3.", 25);
                error = true;
            }
        } while (error);
        if (choix == 1) {
            if (saveExist(joueur)) {
                writeln("Vous êtes sur le point de supprimer votre ancienne sauvegarde.", 25);
                write("Continuer ? [O/N] ", 25);
                String supprSave = removeMaj(readString());
                if (equals(supprSave, "o") || equals(supprSave, "oui")) {
                    newGame();
                } else {
                    menuPrincipal(joueur);
                }
            }
        } else if (choix == 2) {
            if (saveExist(joueur)) {
                print("En cours de développement...");
            } else {
                writeln("Aucune sauvegarde n'a été trouvée pour le joueur " + joueur, 25);
                menuPrincipal(joueur);
            }
        } else {
            write("Nous nous reverrons...", 25);
            resetScreen();
        }
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