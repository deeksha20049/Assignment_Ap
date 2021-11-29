package ap_assignment;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ap_Assignment4 {
    static Scanner sc = new Scanner(System.in);
    //The generted strings of length 4 are alpha-numeric
    public static String getstr(){
        String store="1234567890qazwsxedcrfvtgbyhnujmikolpMKOPLIJNUHBYGVTFCRDXESZWAQ";
        Random rand=new Random();
        String ret="";
        for(int i=0;i<4;i++){
            int k=rand.nextInt(store.length());
            ret=ret.concat(store.substring(k,k+1));
        }
        return ret;
    }

    public static int strcheck() {
        String s1 = getstr();
        String s2 = getstr();
        calcultor<String> c = new calcultor<String>();
        System.out.println("Enter the concatanation of these two strings s1+s2");
        System.out.println("s1 => " + s1 + " s2 => " + s2);
        try {
            String ans = sc.nextLine().strip();
            //if (ans instanceof String) {
                return c.answer(s1, s2, ans);
            //}
        } catch (InputMismatchException se) {
            System.out.println("This type is not Allowed!");
            return -1;
        }
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        Player p = new Player();
        Carpet carpet = new Carpet();
        System.out.println("Hit enter to initialize the game");

        String str = sc.nextLine();
        if(str.equals("")) {
            System.out.println("Game is ready");
            int i = 1;
            System.out.println("Hit Enter for your 1 hop");
            String s = sc.nextLine();
            if(s.equals("")) {
                for (; i <= 5; i++) {
                    String s1 = sc.nextLine();
                    if(s1.equals("")) {
                        jumpgenerator jump = new jumpgenerator(21);
                        if (jump.getFaceValue() == 1) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            System.out.println("Question Answer round. Integer or String?");
                            String st = sc.nextLine().strip();
                            if(st.equals("integer") || st.equals("INTEGER") || st.equals("Integer")){
                                calcultor<Integer> c = new calcultor<Integer>();
                                Random rand=new Random();
                                int x=1+rand.nextInt(Integer.MAX_VALUE-1);
                                int y=1+rand.nextInt(Integer.MAX_VALUE-1);
                                System.out.println("Enter the division of these two numbers x/y\n"+"x = "+x+" y = "+y);
                                boolean flag = false;
                                while (!flag) {
                                    try {
                                        Scanner u = new Scanner(System.in);
                                        int ans = u.nextInt();
                                            int check = c.answer(x, y, ans);
                                            if (check == 1) {
                                                System.out.println("Correct answer");
                                                carpet.getArr().get(jump.getFaceValue() - 1).cloneToy(p);
                                                System.out.println("you won a " + (carpet.getArr().get(jump.getFaceValue() - 1).getToy().getNameoftoy()));
                                                //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                            }
                                        flag = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("This type is not Allowed!");
                                    }
                                }
                            }else if(st.equals("string") || st.equals("STRING") || st.equals("String")){
                                    int check = strcheck();
                                if(check==1){
                                    System.out.println("Correct answer");
                                    carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                                    System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
                                    //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                }
                            }
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 2) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                            System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
////                         arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 3) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            System.out.println("Question answer round. Integer or String?");
                            String st = sc.nextLine().strip();
                            if(st.equals("integer") || st.equals("INTEGER") || st.equals("Integer")){
                                calcultor<Integer> c=new calcultor<Integer>();
                                Random rand=new Random();
                                int x=1+rand.nextInt(Integer.MAX_VALUE-1);
                                int y=1+rand.nextInt(Integer.MAX_VALUE-1);
                                System.out.println("Enter the division of these two numbers x/y\n"+"x = "+x+" y = "+y);
                                boolean flag = false;
                                while (!flag) {
                                    try {
                                        Scanner u = new Scanner(System.in);
                                        int ans = u.nextInt();
                                            int check = c.answer(x, y, ans);
                                            if (check == 1) {
                                                System.out.println("Correct answer");
                                                carpet.getArr().get(jump.getFaceValue() - 1).cloneToy(p);
                                                System.out.println("you won a " + (carpet.getArr().get(jump.getFaceValue() - 1).getToy().getNameoftoy()));
                                                //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                            }
                                        flag = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("This type is not Allowed!");
                                    }
                                }
                            }
                            else if(st.equals("string") || st.equals("STRING") || st.equals("String")){
                                int check = strcheck();
                                if(check==1){
                                    System.out.println("Correct answer");
                                    carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                                    System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
                                    //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                }
                            }
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 4) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                            System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
////                        arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 5) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            System.out.println("Question answer round. Integer or String?");
                            String st = sc.nextLine().strip();
                            if(st.equals("integer") || st.equals("INTEGER") || st.equals("Integer")){
                                calcultor<Integer> c=new calcultor<Integer>();
                                Random rand=new Random();
                                int x=1+rand.nextInt(Integer.MAX_VALUE-1);
                                int y=1+rand.nextInt(Integer.MAX_VALUE-1);
                                System.out.println("Enter the division of these two numbers x/y\n"+"x = "+x+" y = "+y);
                                boolean flag = false;
                                while (!flag) {
                                    try {
                                        Scanner u = new Scanner(System.in);
                                        int ans = u.nextInt();
                                        int check = c.answer(x, y, ans);
                                        if (check == 1) {
                                            System.out.println("Correct answer");
                                            carpet.getArr().get(jump.getFaceValue() - 1).cloneToy(p);
                                            System.out.println("you won a " + (carpet.getArr().get(jump.getFaceValue() - 1).getToy().getNameoftoy()));
                                            //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                        }
                                        flag = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("This type is not Allowed!");
                                    }
                                }
                            }
                            else if(st.equals("string") || st.equals("STRING") || st.equals("String")){
                                int check = strcheck();
                                if(check==1){
                                    System.out.println("Correct answer");
                                    carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                                    System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
                                    //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                }
                            }
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 6) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                            System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
////                        arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 7) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            System.out.println("Question answer round. Integer or String?");
                            String st = sc.nextLine().strip();
                            if(st.equals("integer") || st.equals("INTEGER") || st.equals("Integer")){
                                calcultor<Integer> c=new calcultor<Integer>();
                                Random rand=new Random();
                                int x=1+rand.nextInt(Integer.MAX_VALUE-1);
                                int y=1+rand.nextInt(Integer.MAX_VALUE-1);
                                System.out.println("Enter the division of these two numbers x/y\n"+"x = "+x+" y = "+y);
                                boolean flag = false;
                                while (!flag) {
                                    try {
                                        Scanner u = new Scanner(System.in);
                                        int ans = u.nextInt();
                                        int check = c.answer(x, y, ans);
                                        if (check == 1) {
                                            System.out.println("Correct answer");
                                            carpet.getArr().get(jump.getFaceValue() - 1).cloneToy(p);
                                            System.out.println("you won a " + (carpet.getArr().get(jump.getFaceValue() - 1).getToy().getNameoftoy()));
                                            //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                        }
                                        flag = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("This type is not Allowed!");
                                    }
                                }
                            }
                            else if(st.equals("string") || st.equals("STRING") || st.equals("String")){
                                int check = strcheck();
                                if(check==1){
                                    System.out.println("Correct answer");
                                    carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                                    System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
                                    //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                }
                            }
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 8) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                            System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
////                        arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 9) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            System.out.println("Question answer round. Integer or String?");
                            String st = sc.nextLine().strip();
                            if(st.equals("integer") || st.equals("INTEGER") || st.equals("Integer")){
                                calcultor<Integer> c=new calcultor<Integer>();
                                Random rand=new Random();
                                int x=1+rand.nextInt(Integer.MAX_VALUE-1);
                                int y=1+rand.nextInt(Integer.MAX_VALUE-1);
                                System.out.println("Enter the division of these two numbers x/y\n"+"x = "+x+" y = "+y);
                                boolean flag = false;
                                while (!flag) {
                                    try {
                                        Scanner u = new Scanner(System.in);
                                        int ans = u.nextInt();
                                        int check = c.answer(x, y, ans);
                                        if (check == 1) {
                                            System.out.println("Correct answer");
                                            carpet.getArr().get(jump.getFaceValue() - 1).cloneToy(p);
                                            System.out.println("you won a " + (carpet.getArr().get(jump.getFaceValue() - 1).getToy().getNameoftoy()));
                                            //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                        }
                                        flag = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("This type is not Allowed!");
                                    }
                                }
                            }
                            else if(st.equals("string") || st.equals("STRING") || st.equals("String")){
                                int check = strcheck();
                                if(check==1){
                                    System.out.println("Correct answer");
                                    carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                                    System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
                                    //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                }
                            }
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 10) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                            System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
////                        arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 11) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            System.out.println("Question answer round. Integer or String?");
                            String st = sc.nextLine().strip();
                            if(st.equals("integer") || st.equals("INTEGER") || st.equals("Integer")){
                                calcultor<Integer> c=new calcultor<Integer>();
                                Random rand=new Random();
                                int x=rand.nextInt(Integer.MAX_VALUE-1);
                                int y=rand.nextInt(Integer.MAX_VALUE-1);

                                System.out.println("Enter the division of these two numbers x/y\n"+"x = "+x+" y = "+y);
                                boolean flag = false;
                                while (!flag) {
                                    try {
                                        Scanner u = new Scanner(System.in);
                                        int ans = u.nextInt();
                                        int check = c.answer(x, y, ans);
                                        if (check == 1) {
                                            System.out.println("Correct answer");
                                            carpet.getArr().get(jump.getFaceValue() - 1).cloneToy(p);
                                            System.out.println("you won a " + (carpet.getArr().get(jump.getFaceValue() - 1).getToy().getNameoftoy()));
                                            //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                        }
                                        flag = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("This type is not Allowed!");
                                    }
                                }
                            }
                            else if(st.equals("string") || st.equals("STRING") || st.equals("String")){
                                int check = strcheck();
                                if(check==1){
                                    System.out.println("Correct answer");
                                    carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                                    System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
                                    //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                }
                            }
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 12) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                            System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
////                        arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 13) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            System.out.println("Question answer round. Integer or String?");
                            String st = sc.nextLine().strip();
                            if(st.equals("integer") || st.equals("INTEGER") || st.equals("Integer")){
                                calcultor<Integer> c=new calcultor<Integer>();
                                Random rand=new Random();
                                int x=1+rand.nextInt(Integer.MAX_VALUE-1);
                                int y=1+rand.nextInt(Integer.MAX_VALUE-1);
                                System.out.println("Enter the division of these two numbers x/y\n"+"x = "+x+" y = "+y);
                                boolean flag = false;
                                while (!flag) {
                                    try {
                                        Scanner u = new Scanner(System.in);
                                        int ans = u.nextInt();
                                        int check = c.answer(x, y, ans);
                                        if (check == 1) {
                                            System.out.println("Correct answer");
                                            carpet.getArr().get(jump.getFaceValue() - 1).cloneToy(p);
                                            System.out.println("you won a " + (carpet.getArr().get(jump.getFaceValue() - 1).getToy().getNameoftoy()));
                                            //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                        }
                                        flag = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("This type is not Allowed!");
                                    }
                                }
                            }
                            else if(st.equals("string") || st.equals("STRING") || st.equals("String")){
                                int check = strcheck();
                                if(check==1){
                                    System.out.println("Correct answer");
                                    carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                                    System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
                                    //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                }
                            }
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 14) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                            System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
////                        arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 15) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            System.out.println("Question answer round. Integer or String?");
                            String st = sc.nextLine().strip();
                            if(st.equals("integer") || st.equals("INTEGER") || st.equals("Integer")){
                                calcultor<Integer> c=new calcultor<Integer>();
                                Random rand=new Random();
                                int x=1+rand.nextInt(Integer.MAX_VALUE-1);
                                int y=1+rand.nextInt(Integer.MAX_VALUE-1);
                                System.out.println("Enter the division of these two numbers x/y\n"+"x = "+x+" y = "+y);
                                boolean flag = false;
                                while (!flag) {
                                    try {
                                        Scanner u = new Scanner(System.in);
                                        int ans = u.nextInt();
                                        int check = c.answer(x, y, ans);
                                        if (check == 1) {
                                            System.out.println("Correct answer");
                                            carpet.getArr().get(jump.getFaceValue() - 1).cloneToy(p);
                                            System.out.println("you won a " + (carpet.getArr().get(jump.getFaceValue() - 1).getToy().getNameoftoy()));
                                            //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                        }
                                        flag = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("This type is not Allowed!");
                                    }
                                }
                            }
                            else if(st.equals("string") || st.equals("STRING") || st.equals("String")){
                                int check = strcheck();
                                if(check==1){
                                    System.out.println("Correct answer");
                                    carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                                    System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
                                    //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                }
                            }
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 16) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                            System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
////                        arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 17) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            System.out.println("Question answer round. Integer or String?");
                            String st = sc.nextLine().strip();
                            if(st.equals("integer") || st.equals("INTEGER") || st.equals("Integer")) {
                                calcultor<Integer> c = new calcultor<Integer>();
                                Random rand = new Random();
                                int x = 1 + rand.nextInt(Integer.MAX_VALUE - 1);
                                int y = 1 + rand.nextInt(Integer.MAX_VALUE - 1);
                                System.out.println("Enter the division of these two numbers x/y\n" + "x = " + x + " y = " + y);
                                boolean flag = false;
                                while (!flag) {
                                    try {
                                        Scanner u = new Scanner(System.in);
                                        int ans = u.nextInt();
                                        int check = c.answer(x, y, ans);
                                        if (check == 1) {
                                            System.out.println("Correct answer");
                                            carpet.getArr().get(jump.getFaceValue() - 1).cloneToy(p);
                                            System.out.println("you won a " + (carpet.getArr().get(jump.getFaceValue() - 1).getToy().getNameoftoy()));
                                            //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                        }
                                        flag = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("This type is not Allowed!");
                                    }
                                }
                            }
                            else if(st.equals("string") || st.equals("STRING") || st.equals("String")){
                                int check = strcheck();
                                if(check==1){
                                    System.out.println("Correct answer");
                                    carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                                    System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
                                    //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                }
                            }
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 18) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                            System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
////                        arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 19) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            System.out.println("Question answer round. Integer or String?");
                            String st = sc.nextLine().strip();
                            if(st.equals("integer") || st.equals("INTEGER") || st.equals("Integer")){
                                calcultor<Integer> c=new calcultor<Integer>();
                                Random rand=new Random();
                                int x=1+rand.nextInt(Integer.MAX_VALUE-1);
                                int y=1+rand.nextInt(Integer.MAX_VALUE-1);
                                System.out.println("Enter the division of these two numbers x/y\n"+"x = "+x+" y = "+y);
                                boolean flag = false;
                                while (!flag) {
                                    try {
                                        Scanner u = new Scanner(System.in);
                                        int ans = u.nextInt();
                                        int check = c.answer(x, y, ans);
                                        if (check == 1) {
                                            System.out.println("Correct answer");
                                            carpet.getArr().get(jump.getFaceValue() - 1).cloneToy(p);
                                            System.out.println("you won a " + (carpet.getArr().get(jump.getFaceValue() - 1).getToy().getNameoftoy()));
                                            //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                        }
                                        flag = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("This type is not Allowed!");
                                    }
                                }
                            }
                            else if(st.equals("string") || st.equals("STRING") || st.equals("String")){
                                int check = strcheck();
                                if(check==1){
                                    System.out.println("Correct answer");
                                    carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                                    System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
                                    //arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                                }
                            }
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        } else if (jump.getFaceValue() == 20) {
                            System.out.println("You landed on tile " + jump.getFaceValue());
                            p.setPositionOfPlayer(jump.getFaceValue());
                            carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
                            System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
////                        arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        }else if(jump.getFaceValue()==21){
                            p.setPositionOfPlayer(jump.getFaceValue());
                            System.out.println("You are too energetic and zoomed past all the tiles Muddy Puddle Splash! ");
//                            carpet.getArr().get(jump.getFaceValue()-1).cloneToy(p);
//                            System.out.println("you won a "+(carpet.getArr().get(jump.getFaceValue()-1).getToy().getNameoftoy()));
////                        arrayofgifts.add(softtoy.get(jump.getFaceValue()-1));
                            if (i < 5) {
                                int x = i + 1;
                                System.out.println("Hit Enter for your " + x+" hop");
                                s1 = sc.nextLine();
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Soft toys won by you are:");
        for(int i=0;i<p.getBucket().size()-1;i++){
            System.out.print(p.getBucket().get(i).getNameoftoy()+", ");
        }
        System.out.println(p.getBucket().get(p.getBucket().size()-1).getNameoftoy());
    }
}
class randnum{
    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min)+1) + min;
    }
}
class jumpgenerator extends randnum{
    private final int numFaces;
    private int faceValue;
    public jumpgenerator(int _numFaces) {
        numFaces = _numFaces;
        roll();
    }
    public void roll() {
        rand r = new rand();
        int curr_faceValue = r.getRandomNumberUsingNextInt(1,21);
        setFaceValue(curr_faceValue);
    }
    private void setFaceValue (int value) {
        if (value <= numFaces)
            faceValue = value;
    }
    public int getFaceValue() {
        return faceValue;
    }
    public int getNumFaces() {
        return numFaces;
    }
}

class calcultor<T> {
    public int answer(T o,T o1,T ans){
        if(o.getClass().getSimpleName().equals("String") && o1.getClass().getSimpleName().equals("String") && ans.getClass().getSimpleName().equals("String")){
            String s1=(String)o;
            String s2=(String)o1;
            String an=(String)ans;
            s1=s1.concat(s2);
            if(s1.equals(an)){
                return 1;
            }
            else{
                return 0;
            }
        }
        else if(o.getClass().getSimpleName().equals("Integer") && o1.getClass().getSimpleName().equals("Integer") && ans.getClass().getSimpleName().equals("Integer")){
            int s1=(int)o;
            int s2=(int)o1;
            int an= (int) ans;
            boolean flag = false;
            while (!flag){
                try{
                    int x = (s1/s2);
                    flag = true;
                    if(an == x){
                        return 1;
                    }
                }catch (ArithmeticException ae){
                    System.out.println("This Division is not possible!");
                }
            }
//            if(an == (s1 / s2)){
//                try{
//                    return 1;
//                }catch (ArithmeticException ae){
//                    System.out.println("This Division is not possible!");
//                }
//                return 1;
//            }
//            else{
                return 0;
//            }

        }
        else{
            return -1;
        }
    }
}
class Toy implements Cloneable{
    private String nameoftoy;
    public Toy(String nameoftoy){
        this.nameoftoy = nameoftoy;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public String getNameoftoy(){
        return this.nameoftoy;
    }
}
class Tile{
    private Toy toy;
    public void cloneToy(Player p) throws CloneNotSupportedException {
        p.addToy((Toy) toy.clone());
    }
    Tile(String nameoftoy){
        this.toy = new Toy(nameoftoy);
    }
    public Toy getToy(){
        return this.toy;
    }
}
class Player{
    private ArrayList<Toy> bucket = new ArrayList<>();
    private int positionOfPlayer;
    public void addToy(Toy t){
        this.bucket.add(t);
        this.positionOfPlayer = 0;
    }
    public ArrayList<Toy> getBucket(){
        return this.bucket;
    }
    public void setPositionOfPlayer(int positionOfPlayer) {
        this.positionOfPlayer = positionOfPlayer;
    }
    public int getPositionOfPlayer(){
        return this.positionOfPlayer;
    }
}
class Carpet{
    private ArrayList<Tile> arr = new ArrayList<>();
    public Carpet(){
        arr.add(new Tile("BELLA"));
        arr.add(new Tile("SUISHY"));
        arr.add(new Tile("WALLY"));
        arr.add(new Tile("BEERHUGZ"));
        arr.add(new Tile("BALLO"));
        arr.add(new Tile("SOOTY"));
        arr.add(new Tile("LOVEBUG"));
        arr.add(new Tile("WINNIE"));
        arr.add(new Tile("HONEY"));
        arr.add(new Tile("BABYBEAR"));
        arr.add(new Tile("FUZZY"));
        arr.add(new Tile("SOFTY"));
        arr.add(new Tile("SNUGGLEBUG"));
        arr.add(new Tile("FUZZBALL"));
        arr.add(new Tile("HONEYPOT"));
        arr.add(new Tile("BUBSY"));
        arr.add(new Tile("WINNEI"));
        arr.add(new Tile("MR.~FLUFF"));
        arr.add(new Tile("TUBBY"));
        arr.add(new Tile("PEACHES"));
    }
    public ArrayList<Tile> getArr(){
        return this.arr;
    }
}
