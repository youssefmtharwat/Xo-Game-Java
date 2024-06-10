package XO.Game;

public class Board implements BoardInterface{
    char[][] arr;

    public Board() {
        this.arr=new char[][]{{'1','2','3'},{'4','5','6'},{'7','8','9'}};
    }
    public int getRow(int ind){
        return (ind-1)/3;
    }
    public int getCol(int ind){
        return (ind-1)%3;
    }
    public boolean isEmpty(int ind){
        if(ind <1 || ind >9){
            return false;
        }
        int row =getRow(ind);
        int col =getCol(ind);
        if(arr[row][col]=='x'||arr[row][col]=='o'){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean replaceChar(int ind,Player p){
        if(isEmpty(ind)){
            int row=getRow(ind);
            int col=getCol(ind);
            arr[row][col]=p.getOp();
            return true;
        }
        else{
            return false;
        }
    }
    public void draw(){
        System.out.println("-------");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print("|"+arr[i][j]);
            }
            System.out.println("|");
            System.out.println("-------");
        }
    }
    public boolean isFull(){
        int count =0;
        for(int i=1;i<10;i++){
            if(isEmpty(i)){
                count++;
            };
        }
        if(count==0){
            return true;
        }
        else{
            return false;
        }
    }

@Override
    public boolean isWin(Player p){
        if(arr[0][0]==arr[0][1]&&arr[0][1]==arr[0][2]){
            return true;
        }
        if(arr[1][0]==arr[1][1]&&arr[0][1]==arr[1][2]){
            return true;
        }
        if(arr[2][0]==arr[2][1]&&arr[0][1]==arr[2][2]){
            return true;
        }
        if(arr[0][0]==arr[1][0]&&arr[1][0]==arr[2][0]){
            return true;
        }
        if(arr[0][1]==arr[1][1]&&arr[1][1]==arr[2][1]){
            return true;
        }
        if(arr[0][2]==arr[1][2]&&arr[1][2]==arr[2][2]){
            return true;
        }
        if(arr[0][0]==arr[1][1]&&arr[1][1]==arr[2][2]){
            return true;
        }
        if(arr[2][0]==arr[1][1]&&arr[1][1]==arr[0][2]){
            return true;
        }
        else{
            return false;
        }
    }
}
