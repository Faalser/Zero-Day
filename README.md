
# Zero-Day
Jeu ludo-pédagogique (version terminal) — README temporaire

**Présentation**
- **Nom**: `Zero-Day` — prototype de jeu ludo-pédagogique conçu pour fonctionner dans un terminal.
- **Langage**: code en Java (utilisation possible du kernel `IJava` pour exécution dans Jupyter) — mentionné ici comme "ijava".
- **But**: proposer des activités pédagogiques interactives jouables depuis un terminal afin d'enseigner des notions via des défis et des quizz.

**Objectifs Pédagogiques**
- Favoriser l'apprentissage actif par la résolution d'énigmes et mini-jeux.
- Fournir des retours immédiats et des évaluations simples (score, progression).
- Permettre une utilisation en salle (terminals) sans dépendances graphiques lourdes.

**Fonctionnalités (temporaire)**
- Jeu entièrement textuel / console.
- Menus et navigation via saisie au clavier.
- Modules de jeu séparés (ex : quiz, mini-jeux, parcours d'énigmes).
- Sortie de score et résumé de progression (non persisté par défaut).

**Structure recommandée du dépôt**
- `src/` : sources Java (`*.java`) (ex : `src/fr/yourteam/zeroday/*.java`).
- `notebooks/` : notebooks Jupyter utilisant le kernel IJava (optionnel).
- `data/` : fichiers de contenu (questions, niveaux) en JSON/CSV si présents.
- `README.md` : ce fichier.

**Prérequis**
- Java JDK installé (version 11+ recommandée).
- Pour exécution dans Jupyter : kernel `IJava` installé (optionnel).

**Exécution rapide (option 1) — en terminal classique**
1. Compiler toutes les sources Java (depuis la racine du dépôt) :

```bash
cd /home/faalser/IUT/SAE/Zero-Day
mkdir -p out
javac -d out $(find src -name "*.java")
```

2. Lancer le jeu (remplacer `MainClass` par la classe contenant `public static void main`):

```bash
java -cp out MainClass
```

Note : adaptez le nom de la classe principale si votre package est défini (ex: `java -cp out fr.yourteam.zeroday.Main`).

**Exécution rapide (option 2) — dans Jupyter avec IJava (optionnel)**
- Si vous utilisez un notebook `notebooks/game.ipynb`, ouvrez Jupyter et sélectionnez le kernel `IJava` pour exécuter les cellules Java.
- Voir la documentation du projet `IJava` pour l'installation du kernel si nécessaire.

**Contrôles**
- Le jeu attend des entrées clavier standard (touches, chiffres, `Entrée`).
- Suivre les instructions affichées à l'écran pendant le jeu.

**Tests / Développement local**
- Pour développement rapide, créer des classes de test ou des petits notebooks IJava qui exécutent des bouts de logique.
- Exemple de commande de compilation rapide (ci‑dessus) et relancer `java` après modifications.

**Limitations (temporaire)**
- Prototype console : pas d'interface graphique.
- Pas de stockage persistant de progression (base à ajouter si besoin).

**Prochaines étapes suggérées**
- Préciser les modules pédagogiques et le format des données (JSON/CSV).
- Ajouter un script `run.sh` qui compile et lance automatiquement la bonne classe principale.
- Intégrer une option de sauvegarde simple (fichier local) pour garder les scores.

**Contribution et commit**
- Pour ajouter des fonctionnalités : éditer `src/`, tester localement puis committer.
- Message de commit proposé : `feat: ajouter <module> (jeu terminal)` ou `fix: corriger <composant>`.

---
Si vous le souhaitez, je peux :
- créer un `run.sh` qui compile et lance automatiquement le jeu,
- ajouter un exemple minimal de `src/Main.java` (squelette) pour démarrer,
- ou préparer un court guide d'installation pour `IJava` et Jupyter.


