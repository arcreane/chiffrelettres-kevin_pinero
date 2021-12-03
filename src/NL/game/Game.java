package NL.game;

import NL.game.logic.Letters;

import java.util.ArrayList;

import static NL.game.Dictionary.dictionaryArray;
import static NL.game.logic.Letters.*;

public class Game {
    int rounds = 0;

    UserInteraction userInteraction = new UserInteraction();
    Menu menu = new Menu();
    User[] players = new User[2];

    public void gameWelcome() {
        userInteraction.display(menu.getWelcomeMsg());
        gameMenu();
    }

    public void gameMenu() {
        userInteraction.displayMainMenu(Menu.mainOptions);
        int choice = userInteraction.getUserChoice(Menu.mainOptions.length);
        menu.manageMainChoice(choice, this);
    }

    public void start() {
        userInteraction.displaySubMenu(Menu.subOptions);
        int choice = userInteraction.getUserChoice(Menu.subOptions.length);
        menu.manageSubChoice(choice, this);


        // First loop for gameLoop
        Letters game1 = new Letters();
        do {
            new Letters();

            //-------- loop for getting 10 characters ----------
            loopForChoosingVowelOrConsonant(game1);


            // --------------------------------------------------------
            game1.loopWordsDictionary();
//            //loop on words of dictionnary
//            for (String word : dictionaryArray ){
//                if ( word.length() <= listSortedCharacters.size() ) {
//                    ArrayList<String> temp = new ArrayList<String>(listSortedCharacters) ;
//                    if (canBeWritten(temp, word))
//                        wordsCanBeWritten.add(word) ;
//                }
//            }
//            System.out.println("words can be written with these characters :  "+ wordsCanBeWritten) ;







            // ----------- getting each word from each user ------------------
            getDataWordForEachUser(game1);



            rounds++;
            System.out.println(rounds);
        } while (rounds <3);





            //game1.test(players);


//            Numbers game2 = new Numbers();
//            game2.test();

    }

    public void playerVSPlayer() {
        for(int p = 0; p <= 1; p++) {
            userInteraction.askUsername();
            String playerName = userInteraction.getUserChoice();
            players[p] = new User(playerName);
        }
    }

    public void playerVSAI() {
        userInteraction.askUsername();
        String playerName = userInteraction.getUserChoice();
        players[0] = new User(playerName);
        players[1] = new User("AI");
    }

    public void exit() {
        System.exit(0);
    }



    public void loopForChoosingVowelOrConsonant(Letters game){
        for(int turn = 1; turn <= 5; turn++) {
            userInteraction.askUserOneVowelOrKonsonant();
            game.creatingRandomCharsFromAskingEachPlayer((userInteraction.getStr()));
            userInteraction.askUserTwoVowelOrKonsonant();
            game.creatingRandomCharsFromAskingEachPlayer((userInteraction.getStr()));
        }
    }
    public void getDataWordForEachUser(Letters game){
        //game1.cloneList();
        //listSortedLetters = clonedListSortedLetters;
        System.out.println(listSortedCharacters);
        game.getCreatedWordByUserOne(userInteraction.getStr());
        //game1.cloneList();
        //listSortedLetters = clonedListSortedLetters;
        System.out.println(listSortedCharacters);
        game.getCreatedWordByUserTwo(userInteraction.getStr());
        game.checkLenghtOfWord();
        System.out.println(game.countUserOne + " user one");
        System.out.println(game.countUserTwo + " user two");




    }



}
