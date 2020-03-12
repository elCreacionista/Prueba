package Cosas;

import java.awt.*;

class Variables{
    public static int DOWNLEFTx;
    public static int DOWNLEFTy;

    public static int DOWNRIGHTx;
    public static int DOWNRIGHTy;

    public static int UPLEFTx;
    public static int UPLEFTy;

    public static int UPRIGHTx;
    public static int UPRIGHTy;

    public static int SIZE;

    public static int CENTERx;
    public static int CENTERy;

    public static int setCENTERx(){
        int left = (UPLEFTx + DOWNRIGHTx) / 2;
        int right = (DOWNLEFTx + UPRIGHTx) / 2;
        return left;
    }


    public static int setCENTERy() {
        return (DOWNLEFTy + UPLEFTy) / 2;
    }

    public static void SoutVariables(){
        System.out.print("x: " + UPLEFTx + " y: " + UPLEFTy);
        System.out.print("        ");
        System.out.println("x: " + UPRIGHTx + " y: " + UPRIGHTy);
        System.out.print("x: " + DOWNLEFTx + " y: " + DOWNLEFTy);
        System.out.print("       ");
        System.out.println("x: " + DOWNRIGHTx + " y: " + DOWNRIGHTy);
        System.out.println(CENTERx + " " + CENTERy);


    }


}
public class Pantalla extends Turtle{

    public static void main(String[] args) {
        Pantalla j = new Pantalla(800,800, "hey");
        j.show();
        Variables.SoutVariables();
        System.out.println(j.getCountLine());
    }


    Tree tree;
    Floor floor;
    Island island;
    public Pantalla(int sx, int sy, String title) {
        super(sx, sy, title);
        //tree = new Tree(this,1,1,100,20,1, Color.GREEN);
        floor = new Floor(this,-600,200,2,800, Color.BLUE);
        //floor = new Floor(this,-100,100,1,200, Color.BLUE);
        island = new Island(this, -100,100, Color.ORANGE);
    }
}
class Island{

    int posx;
    int posy;
    Island(Pantalla p, int posx, int posy,Color color){
        this.posx = posx;
        this.posy = posy;
        DrawIsland(p, color);
    }
    public void DrawIsland(Pantalla p, Color color){

        boolean processing = true;
        int rand = 10;
        while (processing) {
            rand += (int)(Math.random()*5) - 2;
            p.drawRect(posx, posy, 2, rand, color);
            posx += (int)(Math.random()*5) - 2; posy -= (int)(Math.random()*5) - 2;
            if ((int)(Math.random()*5000) == 0){
                processing = false;
            }
        }
    }
}
class Floor{

    int[] size;
    int height;
    int width;
    Color color;
    Floor(Pantalla p,int x, int y, int xx, int yy, Color color){
        Variables.SIZE = yy;
        this.size = new int[]{x,y};
        this.height = xx;
        this.width = yy;
        this.color = color;
        CreateFloor(p);

        p.goTo(Variables.DOWNLEFTx,Variables.DOWNLEFTy);
        p.forward(60,Color.RED);

        p.goTo(Variables.DOWNRIGHTx,Variables.DOWNRIGHTy);
        p.forward(60,Color.RED);

        p.goTo(Variables.UPLEFTx,Variables.UPLEFTy);
        p.forward(60,Color.RED);

        p.goTo(Variables.UPRIGHTx,Variables.UPRIGHTy);
        p.forward(60,Color.RED);

        p.goTo(Variables.CENTERx,Variables.CENTERy);
        p.forward(60, Color.RED);
    }
    public void CreateFloor(Pantalla p) {
        boolean processing = true;
        int x = this.size[0], y = this.size[1];
        int xx = this.width, yy = this.height;
        Variables.DOWNLEFTx = x;
        Variables.DOWNLEFTy = -y;
        Variables.DOWNRIGHTx = x + xx;
        Variables.DOWNRIGHTy = -y;
        while (processing) {
            p.drawRect(x, y, xx, yy, this.color);
            x ++; y --;
            if (x >= y * 2){
                Variables.UPLEFTx = x;
                Variables.UPLEFTy = -y;
                Variables.UPRIGHTx = x + xx;
                Variables.UPRIGHTy = -y;
                processing = false;
            }
        }
        Variables.CENTERx = Variables.setCENTERx();
        Variables.CENTERy = Variables.setCENTERy();
    }
}
class Tree{
    int branches;
    int n_branches;
    int tree_height;
    int tree_width;
    int position;
    Color leavescolor;

    Tree(Pantalla p, int branches,int branches_per_branches, int tree_height, int tree_width, int position, Color leavescolor){
        this.branches = branches;
        this.n_branches = branches_per_branches;
        this.tree_height = tree_height;
        this.tree_width = tree_width;
        this.leavescolor = leavescolor;
        this.position = position;
        CreateTree(p);
    }

    public void CreateTree(Pantalla p){
        p.drawRect(this.position - (this.tree_width / 2),this.position + (this.tree_width / 2),
                this.tree_width, this.tree_height, Color.BLACK);
    }
    public void createBranches(Pantalla p){
        System.out.println("hola");
    }

}