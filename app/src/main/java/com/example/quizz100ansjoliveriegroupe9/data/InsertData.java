package com.example.quizz100ansjoliveriegroupe9.data;

import com.example.quizz100ansjoliveriegroupe9.BDAdapter;
import com.example.quizz100ansjoliveriegroupe9.MainActivity;
import com.example.quizz100ansjoliveriegroupe9.Question;
import com.example.quizz100ansjoliveriegroupe9.Reponse;
import com.example.quizz100ansjoliveriegroupe9.Theme;

public class InsertData {

    private static BDAdapter adapter;
    //commit
    public static void insertData(MainActivity context) {
        adapter = new BDAdapter(context);
        adapter.open();
        //InsertData.insertTheme();
        //InsertData.insertQuestion();
        //InsertData.insertReponse();
    }

    private static void insertTheme() {
        Theme unTheme = new Theme (1, "Nantes");
        Theme unTheme2 = new Theme (2, "Paris");
        Theme unTheme3 = new Theme (3, "Nice");
        adapter.insererTheme(unTheme);
        adapter.insererTheme(unTheme2);
        adapter.insererTheme(unTheme3);
    }

    private static void insertQuestion() {
        Question question1_1 = new Question(1, "quel était le nom du BTS SIO avant 2004 ?", 1, 1);
        Question question2_1 = new Question(2, "Où se trouvait le service de reprographie avant sa situation actuelle dans le bâtiment St-Pierre (bâtiment H) ?", 5, 1);
        Question question1_2 = new Question(3, "Quel  banque est  partenaires de la joliverie ?", 9, 2);
        Question question2_2 = new Question(4, "Quelle est l'année de construction de la chapelle actuelle ?", 13, 2);
        adapter.insererQuestion(question1_1);
        adapter.insererQuestion(question2_1);
        adapter.insererQuestion(question1_2);
        adapter.insererQuestion(question2_2);

    }

    private static void insertReponse() {

        //Réponses à la question 1 du thème 1
        Reponse reponse1_1_1 = new Reponse(1, "BTS Informatique de Gestion", 1);
        Reponse reponse1_1_2 = new Reponse(2, "BTS maintenance des PC", 1);
        Reponse reponse1_1_3 = new Reponse(3, "BTS développeur", 1);
        Reponse reponse1_1_4 = new Reponse(4, "BTS réseaux", 1);
        adapter.insererReponse(reponse1_1_1);
        adapter.insererReponse(reponse1_1_2);
        adapter.insererReponse(reponse1_1_3);
        adapter.insererReponse(reponse1_1_4);

        //Réponses à la question 2 du thème 1
        Reponse reponse1_2_1 = new Reponse(5, "Bureau de la vie étudiante St-Pierre (couloir F200)", 2);
        Reponse reponse1_2_2 = new Reponse(6, "CDI Saint-Pierre", 2);
        Reponse reponse1_2_3 = new Reponse(7, "Salle du service de comptabilité - Direction générale", 2);
        Reponse reponse1_2_4 = new Reponse(8, "Salle des professeurs Saint-Joseph bâtiment D", 2);
        adapter.insererReponse(reponse1_2_1);
        adapter.insererReponse(reponse1_2_2);
        adapter.insererReponse(reponse1_2_3);
        adapter.insererReponse(reponse1_2_4);

        //Réponses à la question 1 du thème 2
        Reponse reponse2_1_1 = new Reponse(9, "Crédit mutuel", 3);
        Reponse reponse2_1_2 = new Reponse(10, "CA", 3);
        Reponse reponse2_1_3 = new Reponse(11, "Banque populaire", 3);
        Reponse reponse2_1_4 = new Reponse(12, "La banque postale", 3);
        adapter.insererReponse(reponse2_1_1);
        adapter.insererReponse(reponse2_1_2);
        adapter.insererReponse(reponse2_1_3);
        adapter.insererReponse(reponse2_1_4);

        //Réponses à la question 2 du thème 2
        Reponse reponse2_2_1 = new Reponse(13, "1962", 4);
        Reponse reponse2_2_2 = new Reponse(14, "1927", 4);
        Reponse reponse2_2_3 = new Reponse(15, "1951", 4);
        Reponse reponse2_2_4 = new Reponse(16, "1970", 4);
        adapter.insererReponse(reponse2_2_1);
        adapter.insererReponse(reponse2_2_2);
        adapter.insererReponse(reponse2_2_3);
        adapter.insererReponse(reponse2_2_4);

    }

}
