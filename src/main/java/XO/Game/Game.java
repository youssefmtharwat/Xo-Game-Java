package XO.Game;

import java.util.Scanner;

public class Game {
    private Board b=new Board();
    private Player p1=new Player();
    private Player p2=new Player();
    private int count =0;
    Scanner cin=new Scanner(System.in);
    public void readPlayerData(){
        System.out.println("Enter P1 Name : ");
        String s=cin.next();
        p1.setName(s);
        System.out.println("Enter P1 Op (x,o) : ");
        char c=cin.next().charAt(0);
        p1.setOp(c);
        System.out.println("Enter P2 Name : ");
        s=cin.next();
        p2.setName(s);
        if(c=='x'){
            p2.setOp('o');
        }
        else if(c=='o'){
            p2.setOp('x');
        }
    }
    public void play(){
        readPlayerData();
        b.draw();
        Player cp=new Player();
        while(!b.isFull()){
            if(count%2==1){
                cp=p2;
            }
            else{
                cp=p1;
            }
            while(true){
            int pos;
            System.out.println("Choose 1:9");
            pos=cin.nextInt();
            if(b.replaceChar(pos,cp)){
                break;
            }
            }
            b.draw();
            if(b.isWin(cp)){
                System.out.println("Winner : "+cp.getName());
                break;
            };
            count++;
        }
        if(b.isFull()&& !b.isWin(cp)){
            System.out.println("Game is draw...");
        }
    }
}
