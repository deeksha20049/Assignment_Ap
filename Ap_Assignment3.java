package ap_assignment;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ap_Assignment3 {
    public static void main(String[] args) {
        int playerscore = 0;
        ArrayList<floor> arrayofsteps = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the player name and hit enter");
        String name = sc.nextLine();
        System.out.println(name);
        int leader = 0;
        while(true){
            if(leader==0){
                System.out.println("The game setup is ready");
                System.out.println("Hit enter to roll the dice");
                Dice dice = new Dice(2);
                String str = sc.nextLine();
                int store = 0;
                if(str.equals("")){
                    store = dice.getFaceValue();
                }
                if(store==1){
                    System.out.println("Dice gave "+store);
                    emptystepfloor emfloor = new emptystepfloor(name,leader);
                    arrayofsteps.add(emfloor);
                    System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                    System.out.println(emfloor.show());
                    playerscore+=emfloor.gettotal();
                    System.out.println("Total points "+playerscore);
                    System.out.println("Hit enter to roll the dice");
                    Dice dic = new Dice(2);
                    String st = sc.nextLine();
                    int stor = 0;
                    if(st.equals("")){
                        stor = dic.getFaceValue();
                    }
                    if(stor==1){
                        leader=1;
                    }else if(stor==2){
                        leader=2;
                    }
                    System.out.println("Dice gave "+stor);
                }
                else{
                    while (true){
                        if(store==1){
                            emptystepfloor emfloor = new emptystepfloor(name,leader);
                            arrayofsteps.add(emfloor);
                            System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                            System.out.println(emfloor.show());
                            playerscore+=emfloor.gettotal();
                            System.out.println("Total points "+playerscore);
                            System.out.println("Hit enter to roll the dice");
                            Dice dic = new Dice(2);
                            String st = sc.nextLine();
                            int stor = 0;
                            if(st.equals("")){
                                stor = dic.getFaceValue();
                            }
                            if(stor==1){
                                leader=1;
                            }else if(stor==2){
                                leader=2;
                            }
                            System.out.println("Dice gave "+stor);
                            break;
                        }else {
                            System.out.println("Game cannot start until you get 1");
                            System.out.println("Hit enter to roll the dice");
                            Dice dic = new Dice(2);
                            String stri = sc.nextLine();
                            store = dic.getFaceValue();
                            if(stri.equals("")){
                                store = dic.getFaceValue();
                                System.out.println("Dice gave "+store);
                            }
                        }
                    }
                }
            }
            if(leader==1){
                emptystepfloor emfloor = new emptystepfloor(name,leader);
                arrayofsteps.add(emfloor);
                System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                System.out.println(emfloor.show());
                playerscore+=emfloor.gettotal();
                System.out.println("Total points "+playerscore);
                System.out.println("Hit enter to roll the dice");
                Dice dic = new Dice(2);
                String st = sc.nextLine();
                int stor = 0;
                if(st.equals("")){
                    stor = dic.getFaceValue();
                }
                if(stor==1){
                    leader=2;
                }else if(stor==2){
                    leader=3;
                }
                System.out.println("Dice gave "+stor);
            }if(leader==2){
                elevator e = new elevator(name,leader);
                arrayofsteps.add(e);
                System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                e.show();
                playerscore+=e.gettotal();
                System.out.println("Total points "+playerscore);
                if(e.getnewposition()==10){
                    leader = 10;
                }
            }if(leader==3) {
                emptystepfloor emfloor = new emptystepfloor(name,leader);
                arrayofsteps.add(emfloor);
                System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                System.out.println(emfloor.show());
                playerscore+=emfloor.gettotal();
                System.out.println("Total points "+playerscore);
                System.out.println("Hit enter to roll the dice");
                Dice dic = new Dice(2);
                String st = sc.nextLine();
                int stor = 0;
                if(st.equals("")){
                    stor = dic.getFaceValue();
                }
                if(stor==1){
                    leader=4;
                }else if(stor==2){
                    leader=5;
                }
                System.out.println("Dice gave "+stor);
            }if(leader==4){
                emptystepfloor emfloor = new emptystepfloor(name,leader);
                arrayofsteps.add(emfloor);
                System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                System.out.println(emfloor.show());
                playerscore+=emfloor.gettotal();
                System.out.println("Total points "+playerscore);
                System.out.println("Hit enter to roll the dice");
                Dice dic = new Dice(2);
                String st = sc.nextLine();
                int stor = 0;
                if(st.equals("")){
                    stor = dic.getFaceValue();
                }
                if(stor==1){
                    leader=5;
                }else if(stor==2){
                    leader=6;
                }
                System.out.println("Dice gave "+stor);
            }if(leader==5){
                snake snke = new snake(name,leader);
                arrayofsteps.add(snke);
                System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                snke.show();
                playerscore+=snke.gettotal();
                System.out.println("Total points "+playerscore);
                if(snke.getnewposition()==1){
                    leader = 1;
                }
            }if(leader==6){
                emptystepfloor emfloor = new emptystepfloor(name,leader);
                arrayofsteps.add(emfloor);
                System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                System.out.println(emfloor.show());
                playerscore+=emfloor.gettotal();
                System.out.println("Total points "+playerscore);
                System.out.println("Hit enter to roll the dice");
                Dice dic = new Dice(2);
                String st = sc.nextLine();
                int stor = 0;
                if(st.equals("")){
                    stor = dic.getFaceValue();
                }
                if(stor==1){
                    leader=7;
                }else if(stor==2){
                    leader=8;
                }
                System.out.println("Dice gave "+stor);
            } if(leader==7){
                emptystepfloor emfloor = new emptystepfloor(name,leader);
                arrayofsteps.add(emfloor);
                System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                System.out.println(emfloor.show());
                playerscore+=emfloor.gettotal();
                System.out.println("Total points "+playerscore);
                System.out.println("Hit enter to roll the dice");
                Dice dic = new Dice(2);
                String st = sc.nextLine();
                int stor = 0;
                if(st.equals("")){
                    stor = dic.getFaceValue();
                }
                if(stor==1){
                    leader=8;
                }else if(stor==2){
                    leader=9;
                }
                System.out.println("Dice gave "+stor);
            } if (leader==8){
                ladder leder = new ladder(name,leader);
                arrayofsteps.add(leder);
                System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                leder.show();
                playerscore+=leder.gettotal();
                System.out.println("Total points "+playerscore);
                if(leder.getnewposition()==12){
                    leader = 12;
                }
            } if(leader==9){
                emptystepfloor emfloor = new emptystepfloor(name,leader);
                arrayofsteps.add(emfloor);
                System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                System.out.println(emfloor.show());
                playerscore+=emfloor.gettotal();
                System.out.println("Total points "+playerscore);
                System.out.println("Hit enter to roll the dice");
                Dice dic = new Dice(2);
                String st = sc.nextLine();
                int stor = 0;
                if(st.equals("")){
                    stor = dic.getFaceValue();
                }
                if(stor==1){
                    leader=10;
                }else if(stor==2){
                    leader=11;
                }
                System.out.println("Dice gave "+stor);
            } if(leader==10){
                emptystepfloor emfloor = new emptystepfloor(name,leader);
                arrayofsteps.add(emfloor);
                System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                System.out.println(emfloor.show());
                playerscore+=emfloor.gettotal();
                System.out.println("Total points "+playerscore);
                System.out.println("Hit enter to roll the dice");
                Dice dic = new Dice(2);
                String st = sc.nextLine();
                int stor = 0;
                if(st.equals("")){
                    stor = dic.getFaceValue();
                }
                if(stor==1){
                    leader=11;
                }else if(stor==2){
                    leader=12;
                }
                System.out.println("Dice gave "+stor);
            } if(leader==11){
                kingcobra kingcobrasnke = new kingcobra(name,leader);
                arrayofsteps.add(kingcobrasnke);
                System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                kingcobrasnke.show();
                playerscore+=kingcobrasnke.gettotal();
                System.out.println("Total points "+playerscore);
                if(kingcobrasnke.getnewposition()==3){
                    leader = 3;
                }
            }if(leader==12){
                emptystepfloor emfloor = new emptystepfloor(name,leader);
                arrayofsteps.add(emfloor);
                System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                System.out.println(emfloor.show());
                playerscore+=emfloor.gettotal();
                System.out.println("Total points "+playerscore);
                System.out.println("Hit enter to roll the dice");
                Dice dic = new Dice(2);
                String st = sc.nextLine();
                int stor = 0;
                if(st.equals("")){
                    stor = dic.getFaceValue();
                }
                if(stor==1){
                    System.out.println("Dice gave "+stor);
                    leader=13;
                }else{
                    while (true){
                        if(stor==1){
                            System.out.println("Dice gave "+stor);
                            leader=13;
                            break;
                        }else {
                            System.out.println("Dice gave "+stor);
                            System.out.println("Player cant move ");
                            System.out.println("Hit enter to roll the dice");
                            Dice dc = new Dice(2);
                            String stri = sc.nextLine();
                            stor = 0;
                            if(stri.equals("")){
                                stor = dc.getFaceValue();
                            }
                        }
                    }
                }
            }if(leader==13){
                emptystepfloor emfloor = new emptystepfloor(name,leader);
                arrayofsteps.add(emfloor);
                System.out.println("Player position floor "+arrayofsteps.get(arrayofsteps.size()-1).getCurrentpos());
                System.out.println(emfloor.show());
                playerscore+=emfloor.gettotal();
                System.out.println("Total points "+playerscore);
                System.out.println("Game over");
                break;
            }
        }
        System.out.println(name+" accumulated "+playerscore+" points ");
    }
}
class rand{
    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min)+1) + min;
    }
}
class Dice extends rand{
    private final int numFaces; //maximum face value
    private int faceValue; //current value showing on the dice
    // Constructor: Sets the initial face value.
    public Dice(int _numFaces) {
        numFaces = _numFaces;
        roll();
    }
    // Rolls the dice
    public void roll() {
        rand r = new rand();
        int curr_faceValue = r.getRandomNumberUsingNextInt(1,2);
        setFaceValue(curr_faceValue);
    }
    // Face value setter/mutator.
    private void setFaceValue (int value) {
        if (value <= numFaces)
            faceValue = value;
    }
    // Face value getter/setter.
    public int getFaceValue() {
        return faceValue;
    }
    // Face value getter/setter.
    public int getNumFaces() {
        return numFaces;
    }
}
class floor {
    public int totalscore;
    int newpossition;
    private String name;
    private int currentpos;

    floor(String name, int currentpos) {
        this.name = name;
        this.currentpos = currentpos;
        this.newpossition = currentpos;
        totalscore = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getCurrentpos() {
        return this.currentpos;
    }
    public int gettotal(){
        return totalscore;
    }
}
class ladder extends floor{
    String n;
    ladder(String name, int currentpos) {
        super(name, currentpos);
        n = name;
        totalscore+=2;
    }
    @Override
    public int gettotal(){
        return 2;
    }
    public void show(){
        System.out.println(n+" has reached a "+"ladder floor");
    }
    public int getnewposition(){
        return 12;
    }
}
class emptystepfloor extends floor{
    String n;
    emptystepfloor(String name, int currentpos) {
        super(name, currentpos);
        n = name;
        totalscore++;
    }
    @Override
    public int gettotal(){
        return 1;
    }
    public String show(){
        return n+" has reached an "+"Empty Floor";
    }
    public int getnewposition(){
        return 0;
    }
}
class snake extends floor{
    String n;
    snake(String name, int currentpos) {
        super(name, currentpos);
        n = name;
        totalscore-=2;
    }
    @Override
    public int gettotal(){
        return -2;
    }
    public void show(){
        System.out.print(n+" has reached an "+"snake Floor");
    }
    public int getnewposition(){
        return 1;
    }
}
class kingcobra extends floor{
    String n;
    kingcobra(String name, int currentpos) {
        super(name, currentpos);
        n = name;
        totalscore-=4;
    }
    @Override
    public int gettotal(){
        return -4;
    }
    public void show(){
        System.out.print(n+" has reached "+"king cobra");
    }
    public int getnewposition(){
        return 3;
    }
}
class elevator extends floor{
    String n;
    elevator(String name, int currentpos) {
        super(name, currentpos);
        n = name;
        totalscore+=4;
    }
    @Override
    public int gettotal(){
        return 4;
    }
    public void show(){
        System.out.println(n+" has reached the "+"elevator floor");
    }
    public int getnewposition() {
        return 10;
    }
}
//codevolt