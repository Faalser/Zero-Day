import extensions.File;

class main extends Program {

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

    void showText(String path) {
        File text = newFile(path);
        resetScreen();
        while (ready(text)) {
            print(readLine(text));
            println();
        }
        println();
    }

    void algorithm() {
        resetScreen();
        writeln("Qui êtes-vous ?", 25);
        print("Je suis ");
        String pseudoJoueur = readString();
        showText("./menus/logo.txt");
        write("Sélectionnez une option : ", 25);
        int choix = readInt();
        if (choix == 1) {
            write("Bonjour, agent...", 25);
        } else if (choix == 2) {
            write("Salut !", 25);
        }
    }
}