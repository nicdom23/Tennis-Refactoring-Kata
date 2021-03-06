package TennisGame_implementations;
import TennisGame_inteface.TennisGame;

public class TennisGame1 implements TennisGame {
    
    private int score_player_1 = 0;
    private int score_player_2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)//error "player1" instead of player1Name
            score_player_1 += 1;
        else
            score_player_2 += 1;
    }

    public String getScore() {
        String score = "";
        score = Set_player_1_score();
        if (is_tie())
        {
            score = set_tie_case(score);
        }
        else if (player_has_advantage())
        {
            score = Set_advantage_or_victory();
        }
        else
        {
            score = set_player_2_score(score);
        }

        return score;
    }

    private boolean player_has_advantage() {
        return score_player_1>=4 || score_player_2>=4;
    }

    private boolean is_tie() {
        return score_player_1==score_player_2;
    }

    private String set_player_2_score(String score) {
        switch(score_player_2)
        {
          case 0:
              score +="-Love";
              break;
          case 1:
              score +="-Fifteen";
              break;
          case 2:
              score +="-Thirty";
              break;
          case 3:
              score +="-Forty";
              break;
        }
        return score;
    }


    private String set_tie_case(String score) {
        if(is_score_Deuce())
            score = "Deuce";
        else score += "-All";
        return score;
    }

    private boolean is_score_Deuce() {
        return score_player_1 == 3  || score_player_1 == 4;
    }


    private String Set_player_1_score() {
        String score;
        switch(score_player_1)
        {
            case 0:
                score="Love";
                break;
            case 1:
                score="Fifteen";
                break;
            case 2:
                score="Thirty";
                break;
            case 3:
                score="Forty";
                break;
            default:
                    score = "";
        }
        return score;
    }

    private String Set_advantage_or_victory() {

        String score;
        int score_difference = score_player_1-score_player_2;
        if (score_difference==1) score ="Advantage player1";
        else if (score_difference ==-1) score ="Advantage player2";
        else if (score_difference>=2) score = "Win for player1";
        else score ="Win for player2";

        return score;
    }
}
