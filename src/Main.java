import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean playerturn1 = true;
    static boolean playflag;
    static int winning_player = 0;
    static String[][] Board = {{" "," "," "},{" "," "," "},{" "," "," "}};
    static int choice[] = {0,0};
    private static boolean iswinner(){
        for(int i=0;i<3;i++){
            if(Board[i][0]==Board[i][1] && Board[i][1] == Board[i][2] && Board[i][1] != " "){
                if(!playerturn1)
                    winning_player = 1;
                else
                    winning_player = 2;
                return true;
            }
        }
        for(int j=0;j<3;j++){
            if(Board[0][j]==Board[1][j] && Board[1][j] == Board[2][j] && Board[1][j] != " "){
                if(!playerturn1)
                    winning_player = 1;
                else
                    winning_player = 2;
                return true;
            }
        }
        if(Board[0][0]==Board[1][1] && Board[1][1] == Board[2][2] && Board[1][1] != " "){
            if(!playerturn1)
                winning_player = 1;
            else
                winning_player = 2;
            return true;
        }
        if(Board[0][2]==Board[1][1] && Board[1][1] == Board[2][0] && Board[1][1] != " "){
            if(!playerturn1)
                winning_player = 1;
            else
                winning_player = 2;
            return true;
        }
        return false;
    }
    private static boolean toend(){
        if(iswinner())
            return true;
        if(!playflag)
            return true;
        return false;
    }
    private static void mark(){
        if(playerturn1){
            while(true){
                System.out.println("Play Player 1 :");
                choice[0] = sc.nextInt();
                choice[1] = sc.nextInt();
                if(Board[choice[0]][choice[1]]==" "){
                    Board[choice[0]][choice[1]] = "O";
                    break;
                }
                else
                    System.out.println("Box aldready filled!!!");
            }
        }
        if(!playerturn1){
            while(true){
                System.out.println("Play Player 2 :");
                choice[0] = sc.nextInt();
                choice[1] = sc.nextInt();
                if(Board[choice[0]][choice[1]]==" "){
                    Board[choice[0]][choice[1]] = "X";
                    break;
                }
                else
                    System.out.println("Box aldready filled!!!");
            }
        }
        playerturn1 = !playerturn1;
    }
    private static void reset(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
            Board[i][j] = " ";
            }
        }
        playerturn1 = true;
    }

    public static void main(String[] args) {

        boolean Flag = true;
        int toexit = 0;
        while (Flag)
        {
            playflag = false;
            System.out.println("Tic Tac Toe");
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print(Board[i][j]);
                    if(Board[i][j] == " ")
                        playflag = true;
                    if(j<2)
                        System.out.print("|");
                }
                System.out.print("\n");
                if(i<2){
                    for(int j=0;j<3;j++){
                        System.out.print("-");
                        if(j<2)
                            System.out.print("+");
                    }
                }
                System.out.print("\n");
            }
            if(playflag)
                mark();
            if(toend()) {
                if(winning_player==1)
                    System.out.println("Player 1 Wins!!!");
                else if(winning_player==2)
                    System.out.println("Player 2 Wins!!!");
                else
                    System.out.println("DRAW!!!");
                System.out.println("-->Enter 1 to play again\n-->Enter 0 to quit");
                toexit = sc.nextInt();
                if (toexit == 1){
                    reset();
                    Flag = true;
                }
                else if (toexit == 0)
                    Flag = false;
                else {
                    System.out.println("Invalid Input Quiting Game");
                    Flag = false;
                }
            }

        }
    }
}
