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

    // les programmes suivant chiffrent les questions selon différentes méthodes

    // chiffrage en morse
    String toMorse(String questions) {
        String res = "";
        for (int i = 0; i < length(questions); i++) {
            char c = charAt(questions, i);
            if (c == 'A' || c == 'a') {
                res = res + ".-";
            } else if (c == 'B' || c == 'b') {
                res = res + "-...";
            } else if (c == 'C' || c == 'c') {
                res = res + "-.-.";
            } else if (c == 'D' || c == 'd') {
                res = res + "-..";
            } else if (c == 'E' || c == 'e') {
                res = res + ".";
            } else if (c == 'F' || c == 'f') {
                res = res + "..-.";
            } else if (c == 'G' || c == 'g') {
                res = res + "--.";
            } else if (c == 'H' || c == 'h') {
                res = res + "....";
            } else if (c == 'I' || c == 'i') {
                res = res + "..";
            } else if (c == 'J' || c == 'j') {
                res = res + ".---";
            } else if (c == 'K' || c == 'k') {
                res = res + "-.-";
            } else if (c == 'L' || c == 'l') {
                res = res + ".-..";
            } else if (c == 'M' || c == 'm') {
                res = res + "--";
            } else if (c == 'N' || c == 'n') {
                res = res + "-.";
            } else if (c == 'O' || c == 'o') {
                res = res + "---";
            } else if (c == 'P' || c == 'p') {
                res = res + ".--.";
            } else if (c == 'Q' || c == 'q') {
                res = res + "--.-";
            } else if (c == 'R' || c == 'r') {
                res = res + ".-.";
            } else if (c == 'S' || c == 's') {
                res = res + "...";
            } else if (c == 'T' || c == 't') {
                res = res + "-";
            } else if (c == 'U' || c == 'u') {
                res = res + "..-";
            } else if (c == 'V' || c == 'v') {
                res = res + "...-";
            } else if (c == 'W' || c == 'w') {
                res = res + ".--";
            } else if (c == 'X' || c == 'x') {
                res = res + "-..-";
            } else if (c == 'Y' || c == 'y') {
                res = res + "-.--";
            } else if (c == 'Z' || c == 'z') {
                res = res + "--..";
            res = res + " ";
        }
        return res;
    }

    // chiffrage par décalage de César
    String cesar(String questions) {
        String res = "";
        int decalage = randomInt(1, 25);
        for (int i = 0; i < length(questions); i++) {
            char c = charAt(questions, i);
            if (c >= 'A' && c <= 'Z') {
                res = res + char(((c - 'A' + decalage) % 26) + 'A');
            } else if (c >= 'a' && c <= 'z') {
                res = res + char(((c - 'a' + decalage) % 26) + 'a');
            } else {
                res = res + c;
            }
        }
        return res;
    }
}