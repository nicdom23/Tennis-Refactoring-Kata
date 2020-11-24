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

        if (score_player_1==score_player_2)
        {
            switch (score_player_1)
            {
                case 0:
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                default:
                        score = "Deuce";
                    break;
                
            }
        }
        else if (score_player_1>=4 || score_player_2>=4)
        {
            int minusResult = score_player_1-score_player_2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
                switch(score_player_1)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
                switch(score_player_2)
                {
                  case 0:
                      score+="-Love";
                      break;
                  case 1:
                      score+="-Fifteen";
                      break;
                  case 2:
                      score+="-Thirty";
                      break;
                  case 3:
                      score+="-Forty";
                      break;
                }
        }

        return score;
    }
}
