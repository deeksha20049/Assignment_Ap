package assi;

import java.util.*;

public class Ap_Assignment2 {
    static ArrayList<String > student = new ArrayList<>();
    static ArrayList<String > instructors = new ArrayList<>();
    static ArrayList<addclassmateriallecslide> arrayofslide = new ArrayList<>();
    static ArrayList<addclassmateriallecrec> arrayofvedio = new ArrayList<>();
    static HashMap<String,addassesments_assignment> mapofproffndassignmentassesments = new HashMap<>();
    static ArrayList<addassesments_assignment> arrayofassignments = new ArrayList<>();
    static ArrayList<quiz> arrayofquizquestion = new ArrayList<>();
    static ArrayList<comment> comments = new ArrayList<>();
    static ArrayList<submit_assignment> arrayofassignmentsubmission = new ArrayList<>();
    static ArrayList<submit_quiz> arrayofquizsubmission = new ArrayList<>();
    static int choosen;
    public static void main(String[] args)

    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to backpack!");

        instructors.add("I0");
        instructors.add("I1");

        student.add("S0");
        student.add("S1");
        student.add("S3");

        while(true){
            System.out.println("1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");
            int n = Integer.parseInt(sc.nextLine());
            if(n==1){
                System.out.println("Instructors");
                //String sinstructors = "";
                for(int i = 0;i<instructors.size();i++){
                    System.out.println(i+" - "+instructors.get(i));
                }
                System.out.println("Choose id:");
                choosen = Integer.parseInt(sc.nextLine());
                if(choosen>=instructors.size()){
                    System.out.println("please enter correct ID!");
                }
                System.out.println("Welcome "+instructors.get(choosen));
                while(true){
                    System.out.println(
                            "INSTRUCTOR MENU\n" +
                                    "1. Add class material\n" +
                                    "2. Add assessments\n" +
                                    "3. View lecture materials\n" +
                                    "4. View assessments\n" +
                                    "5. Grade assessments\n" +
                                    "6. Close assessment\n" +
                                    "7. View comments\n" +
                                    "8. Add comments\n" +
                                    "9. Logout\n"
                    );
                    int num = Integer.parseInt(sc.nextLine());;
                    if(num==1){
                        System.out.println("1. Add Lecture Slide\n" +
                                "2. Add Lecture Video");
                        int menu1 = Integer.parseInt(sc.nextLine());
                        if(menu1==1){
                            System.out.println("Enter topic of slides:");
                            String topic = sc.nextLine();
                            System.out.println("Enter number of slides:");
                            int noofslides = Integer.parseInt(sc.nextLine());
                            ArrayList<String> slidepagecontent = new ArrayList<>();
                            System.out.println("Enter content of slides:");
                            int idx = 1;
                            for(int i = 0;i<noofslides;i++){
                                System.out.println("content of slide "+idx+":");
                                String str = sc.nextLine();
                                slidepagecontent.add(str);
                            }
                            addclassmateriallecslide addslide = new addclassmateriallecslide(topic,noofslides,slidepagecontent);
                            arrayofslide.add(addslide);
                        }else if(menu1==2){
                            System.out.println("Enter topic of video:");
                            String topicofvideo = sc.nextLine();
                            System.out.println("Enter filename of video:");
                            String filename = sc.nextLine();
                            if(filename.endsWith(".mp4")){
                                addclassmateriallecrec recofclass = new addclassmateriallecrec(topicofvideo,filename);
                                arrayofvedio.add(recofclass);
                            }else{
                                System.out.println("please upload file in correct format");
                            }

                        }else {
                            System.out.println("please enter correct input!");
                        }
                    }else if(num==2){
                        System.out.println("1. Add Assignment\n" +
                                "2. Add Quiz\n");
                        int numofassesment = Integer.parseInt(sc.nextLine());
                        if(numofassesment==1){
                            System.out.println("Entre problem statement:");
                            String statementofassignment = sc.nextLine();
                            System.out.println("Enter maxmarks");
                            int maxmarks = Integer.parseInt(sc.nextLine());
                            addassesments_assignment addassignment = new addassesments_assignment(statementofassignment,maxmarks);
                            mapofproffndassignmentassesments.put(instructors.get(choosen),addassignment);
                            arrayofassignments.add(addassignment);
                        }else if(numofassesment==2){
                            System.out.println("Enter quiz question:");
                            String queofquiz = sc.nextLine();
                            quiz q = new addassements_quiz(queofquiz,instructors.get(choosen));
                            arrayofquizquestion.add(q);
                        }
                    }else if(num==3){
                        instructor si = new instructor();
                        si.veiwlecmaterialslide();
                        si.veiwlecmaterialrec();
                    }else if(num==4){
                        instructor si = new instructor();
                        si.veiwassement();
                    }else if(num==5){
                        int idx = 0;
                        int i;
                        for(i = 0;i<arrayofassignments.size();i++){
                            System.out.println("ID:"+idx+" Assignment:"+arrayofassignments.get(i).getProb()+" Max Marks:"+Ap_Assignment2.arrayofassignments.get(i).getMaxmarks());
                            idx++;
                        }
                        for(int ii = 0;ii<arrayofquizquestion.size();ii++){
                            System.out.println("ID:"+idx+" Question:"+arrayofquizquestion.get(ii).quizque());
                            idx++;
                        }
                        System.out.println("Enter ID of assesment to view submissions:");
                        int id = Integer.parseInt(sc.nextLine());
                        String s = "";
                        if(id>=arrayofassignments.size()){
                            s = arrayofquizquestion.get(id-arrayofassignments.size()).quizque();
                        }else{
                            s = arrayofassignments.get(id).getProb();
                        }
                        System.out.println("Choose ID from these ungraded submissions");
                        for(int k = 0;k<arrayofassignmentsubmission.size();k++){
                            if(arrayofassignmentsubmission.get(k).getStatus()==0 && s.equals(arrayofassignmentsubmission.get(k).getProblemassignment())){
                                System.out.println(k+"."+arrayofassignmentsubmission.get(k).getStudentname());
                            }
                        }
                        for(int j = 0;j<arrayofquizsubmission.size();j++){
                            if(arrayofquizsubmission.get(j).getStatus()==0 && (s.equals(arrayofquizsubmission.get(j).getQue()))){
                                System.out.println(j+"."+arrayofquizsubmission.get(j).getStudentname());
                            }
                        }
                        int n1=Integer.parseInt(sc.nextLine());
                        System.out.println("submission");
                        if(id<i){
                            submit_assignment studentsub = arrayofassignmentsubmission.get(n1);
                            System.out.println("submission:"+arrayofassignmentsubmission.get(id).getAssignmentsub());
                            System.out.println("Max Marks:"+arrayofassignments.get(id).getMaxmarks());
                            System.out.println("Marks obtained :");
                            int mks=Integer.parseInt(sc.nextLine());
                            if(arrayofassignments.get(id).getMaxmarks()<mks){
                                System.out.println("plese enter valid no.!");
                            }else {
                                studentsub.setMarks(mks);
                                arrayofassignmentsubmission.add(studentsub);
                                studentsub.setStatus(1);
                                studentsub.setGraded_by(instructors.get(choosen));
                            }
                        }
                        else{
                            submit_quiz studentquizsub = arrayofquizsubmission.get(n1);
                            System.out.println("Marks obtained :");
                            int mks=Integer.parseInt(sc.nextLine());
                            if(mks>2){
                                System.out.println("Please enter correct number!");
                            }else {
                                studentquizsub.setMarks(mks);
                                arrayofquizsubmission.add(studentquizsub);
                                studentquizsub.setGraded_by(instructors.get(choosen));
                                studentquizsub.setStatus(1);
                            }
                        }
                    }else if(num==6){
                        int idx = 0;
                        int i;
                        for(i = 0;i<arrayofassignments.size();i++){
                            if(arrayofassignments.get(i).getFlag()==0) {
                                System.out.println("ID:" + idx + " Assignment:" + arrayofassignments.get(i).getProb() + " Max Marks:" + arrayofassignments.get(i).getMaxmarks());
                                idx++;
                            }

                        }
                        for(int ii = 0;ii<arrayofquizquestion.size();ii++){
                            if(arrayofquizquestion.get(ii).getFlag()==0) {
                                System.out.println("ID:" + idx + " Question:" + arrayofquizquestion.get(ii).quizque());
                                idx++;
                            }
                        }
                        System.out.println("Enter ID to close");
                        int id = Integer.parseInt(sc.nextLine());
                        if(id>=i){
                            quiz q = arrayofquizquestion.get(id-i);
                            q.setflag(1);
                        }else{
                            addassesments_assignment a = arrayofassignments.get(i);
                            a.setflag(1);
                        }
                    }else if(num==7){
                        instructor i = new instructor();
                        i.veiwcomment();
                    }else if(num==8){
                        instructor i = new instructor();
                        i.addcomment();
                    }else{
                        break;
                    }
                    System.out.println("Welcome "+instructors.get(choosen));
                }
            }else if(n==2){
                System.out.println("Students");
                for(int i = 0;i<student.size();i++){
                    System.out.println(i+" - "+student.get(i));
                }
                System.out.println("Choose id:");
                choosen = Integer.parseInt(sc.nextLine());
                System.out.println("Welcome "+student.get(choosen));
                while(true){
                    System.out.println(
                            "STUDENT MENU\n" +
                                    "1. View lecture materials\n" +
                                    "2. View assessments\n" +
                                    "3. Submit assessment\n" +
                                    "4. View grades\n" +
                                    "5. View comments\n" +
                                    "6. Add comments\n" +
                                    "7. Logout"
                    );
                    int num = Integer.parseInt(sc.nextLine());
                    if(num==1){
                        studentclass s = new studentclass();
                        s.veiwlecmaterialslide();
                        s.veiwlecmaterialrec();
                    }else if(num==2){
                        studentclass s = new studentclass();
                        s.veiwassement();
                    }else if(num==3){
                        System.out.println("Pending assessments ");
                        int idx = 0;
                        int i;
                        int non = 0;
                        for(i = 0;i<arrayofassignments.size();i++){
                            boolean flg=true;
                            for(int j=0;j<arrayofassignmentsubmission.size();j++){
                                if(arrayofassignmentsubmission.get(j).getProblemassignment()!=null && arrayofassignmentsubmission.get(j).getProblemassignment().equals(arrayofassignments.get(i).getProb()) && arrayofassignmentsubmission.get(j).getStudentname().equals(student.get(choosen))){
                                    flg=false;
                                }
                            }
                            if(flg&&arrayofassignments.get(i).getFlag()==0){
                                System.out.println("ID: "+idx+" Assignment:"+arrayofassignments.get(i).getProb()+"Max Marks:"+ arrayofassignments.get(i).getMaxmarks());
                                idx++;
                                non++;
                            }
                        }
                        boolean flg2=true;
                        for(int ii = 0;ii<arrayofquizquestion.size();ii++){

                            for(int j=0;j<arrayofquizsubmission.size();j++){
                                if(arrayofquizsubmission.get(j).getQue()!=null &&arrayofquizsubmission.get(j).getStudentname().equals(arrayofquizquestion.get(ii).quizque())&& arrayofquizsubmission.get(j).getStudentname().equals(student.get(choosen))){
                                    flg2=false;

                                }
                            }
                            if(flg2 && arrayofquizquestion.get(ii).getFlag()==0){
                                System.out.println("ID: "+idx+" Question:"+arrayofquizquestion.get(ii).quizque());
                                idx++;
                                non++;
                            }
                        }
                        if(non==0){
                            System.out.println("No pending assignmnet!");
                        }else {
                            System.out.println("Enter ID of assesment:");
                            int id = Integer.parseInt(sc.nextLine());
                            if (id >= arrayofassignments.size()) {
                                System.out.println(arrayofquizquestion.get(id - arrayofassignments.size()).quizque());
                                System.out.println("Enter your ans!");
                                String ans = sc.nextLine();
                                submit_quiz subquizandass = new submit_quiz(ans, arrayofquizquestion.get(id - arrayofassignments.size()).quizque(), student.get(choosen));
                                arrayofquizsubmission.add(subquizandass);
                            } else {
                                System.out.println("Enter filename of assignment:");
                                String filenameassignment = sc.nextLine();
                                if (filenameassignment.endsWith(".zip")) {
                                    System.out.println(id + " " + choosen);
                                    submit_assignment subquizandass = new submit_assignment(filenameassignment, arrayofassignments.get(id).getProb(), student.get(choosen));
                                    arrayofassignmentsubmission.add(subquizandass);
                                } else {
                                    System.out.println("please enter in correct format");
                                }
                            }
                        }
                    }else if(num==4){

                        System.out.println("Graded submission ");
                        for(int i = 0;i<arrayofassignmentsubmission.size();i++){
                            if( (arrayofassignmentsubmission.get(i).getAssignmentsub()!=null) && arrayofassignmentsubmission.get(i).getMarks() != -1 && arrayofassignmentsubmission.get(i).getStudentname().equals(student.get(choosen))){
                                System.out.println("Submission "+arrayofassignmentsubmission.get(i).getAssignmentsub());
                                System.out.println("Marks obtained "+arrayofassignmentsubmission.get(i).getMarks());
                                System.out.println("Graded by "+arrayofassignmentsubmission.get(i).getGraded_by());
                                break;//kyuu??
                            }
                        }
                        for(int i = 0;i<arrayofquizsubmission.size();i++){
                            if((arrayofquizsubmission.get(i).getQuesub()!=null) && arrayofquizsubmission.get(i).getMarks() != -1 && arrayofquizsubmission.get(i).getStudentname().equals(student.get(choosen)) ){
                                System.out.println("Submission "+arrayofquizsubmission.get(i).getQue());
                                System.out.println("Marks obtained "+arrayofquizsubmission.get(i).getMarks());
                                System.out.println("Graded by "+arrayofquizsubmission.get(i).getGraded_by());
                            }
                        }
                        System.out.println("UnGraded submission ");
                        for(int i = 0;i<arrayofassignmentsubmission.size();i++){
                            if( ( arrayofassignmentsubmission.get(i).getAssignmentsub()!=null) && arrayofassignmentsubmission.get(i).getMarks() == -1 && arrayofassignmentsubmission.get(i).getStudentname().equals(student.get(choosen))){
                                System.out.println("submission "+arrayofassignmentsubmission.get(i).getAssignmentsub());
                                break;//why??
                            }
                        }
                        for(int i = 0;i<arrayofquizsubmission.size();i++){
                            if((arrayofquizsubmission.get(i).getQuesub()!=null) && arrayofquizsubmission.get(i).getMarks() == -1 && arrayofquizsubmission.get(i).getStudentname().equals(student.get(choosen))){
                                System.out.println("Submission "+arrayofquizsubmission.get(i).getQuesub());
                            }
                        }
                    }else if(num==5){
                        studentclass s =  new studentclass();
                        s.veiwcomment();
                    }else if(num==6){
                        studentclass s = new studentclass();
                        s.addcomment();
                    }else {
                        break;
                    }

                }
            } else{
                break;
            }
        }
    }
}

interface common{
    void veiwlecmaterialslide();
    void veiwlecmaterialrec();
    void veiwassement();
    void veiwcomment();
    void addcomment();
}
class instructor implements common{
    Scanner sc = new Scanner(System.in);
    @Override
    public void veiwlecmaterialslide() {
        for(int i = 0;i<Ap_Assignment2.arrayofslide.size();i++){
            System.out.println("Title:"+Ap_Assignment2.arrayofslide.get(i).getTopicofslide());
            int p = 1;
            for(int j = 0;j<Ap_Assignment2.arrayofslide.get(i).getContent().size();j++){
                System.out.println("Slide "+p+":"+Ap_Assignment2.arrayofslide.get(i).getContent().get(j));
                p++;
            }
            System.out.println("Number of slides:"+Ap_Assignment2.arrayofslide.get(i).getNoofslide());
            System.out.println("Date of upload:"+Ap_Assignment2.arrayofslide.get(i).getDate());
            System.out.println("Uploaded by:"+Ap_Assignment2.instructors.get(Ap_Assignment2.choosen));
        }
    }
    @Override
    public void veiwlecmaterialrec() {
        for(int i = 0;i<Ap_Assignment2.arrayofvedio.size();i++){
            System.out.println("Title of video:"+Ap_Assignment2.arrayofvedio.get(i).getTopicofvidio());
            System.out.println("video file:"+Ap_Assignment2.arrayofvedio.get(i).getFilenameofvidio());
            System.out.println("Date of upload:"+Ap_Assignment2.arrayofvedio.get(i).getDate());
            System.out.println("Uploaded by:"+Ap_Assignment2.instructors.get(Ap_Assignment2.choosen));
        }
    }
    @Override
    public void veiwassement() {
        int idx = 0;
        for(int i = 0;i<Ap_Assignment2.arrayofassignments.size();i++){
            System.out.println("ID:"+idx+" Assignment:"+Ap_Assignment2.arrayofassignments.get(i).getProb()+" Max Marks:"+Ap_Assignment2.arrayofassignments.get(i).getMaxmarks());
            idx++;
        }
        for(int i = 0;i<Ap_Assignment2.arrayofquizquestion.size();i++){
            System.out.println("ID:"+idx+" Question:"+Ap_Assignment2.arrayofquizquestion.get(i).quizque());
            idx++;
        }
    }

    @Override
    public void veiwcomment() {
        for(comment cmt: Ap_Assignment2.comments){
            System.out.println(cmt.getCom()+"\nby = "+cmt.getUser()+" on\n"+cmt.getDate());
        }
    }

    @Override
    public void addcomment() {
        System.out.println("Enter comment:");
        String comment = sc.nextLine();
        comment c = new comment(comment, Ap_Assignment2.instructors.get(Ap_Assignment2.choosen));
        Ap_Assignment2.comments.add(c);
    }
}
class studentclass implements common{
    Scanner sc = new Scanner(System.in);
    @Override
    public void veiwlecmaterialslide() {
        for(int i = 0;i<Ap_Assignment2.arrayofslide.size();i++){
            System.out.println("Title:"+Ap_Assignment2.arrayofslide.get(i).getTopicofslide());
            int p = 1;
            for(int j = 0;j<Ap_Assignment2.arrayofslide.get(i).getContent().size();j++){
                System.out.println("Slide "+p+":"+Ap_Assignment2.arrayofslide.get(i).getContent().get(j));
                p++;
            }
            System.out.println("Number of slides:"+Ap_Assignment2.arrayofslide.get(i).getNoofslide());
            System.out.println("Date of upload:"+Ap_Assignment2.arrayofslide.get(i).getDate());
            System.out.println("Uploaded by:"+Ap_Assignment2.instructors.get(Ap_Assignment2.choosen));
        }
    }
    @Override
    public void veiwlecmaterialrec() {
        for(int i = 0;i<Ap_Assignment2.arrayofvedio.size();i++){
            System.out.println("Title of video:"+Ap_Assignment2.arrayofvedio.get(i).getTopicofvidio());
            System.out.println("video file:"+Ap_Assignment2.arrayofvedio.get(i).getFilenameofvidio());
            System.out.println("Date of upload:"+Ap_Assignment2.arrayofvedio.get(i).getDate());
            System.out.println("Uploaded by:"+Ap_Assignment2.instructors.get(Ap_Assignment2.choosen));
        }
    }
    @Override
    public void veiwassement() {
        int idx = 0;
        for(int i = 0;i<Ap_Assignment2.arrayofassignments.size();i++){
            System.out.println("ID:"+idx+" Assignment:"+Ap_Assignment2.arrayofassignments.get(i).getProb()+" Max Marks:"+Ap_Assignment2.arrayofassignments.get(i).getMaxmarks());
            idx++;
        }
        for(int i = 0;i<Ap_Assignment2.arrayofquizquestion.size();i++){
            System.out.println("ID:"+idx+" Question:"+Ap_Assignment2.arrayofquizquestion.get(i).quizque());
            idx++;
        }
    }

    @Override
    public void veiwcomment() {
        for(comment cmt: Ap_Assignment2.comments){
            System.out.println(cmt.getCom()+"\nby = "+cmt.getUser()+" on\n"+cmt.getDate());
        }
    }

    @Override
    public void addcomment() {
        System.out.println("Enter comment:");
        String comment = sc.nextLine();
        comment c = new comment(comment, Ap_Assignment2.student.get(Ap_Assignment2.choosen));
        Ap_Assignment2.comments.add(c);
    }
}
class comment{
    private String com;
    private String user;
    private Date date;
    comment(String com,String user){
        this.com = com;
        this.user = user;
        this.date = new Date();
    }
    public String getCom(){
        return this.com;
    }
    public String getUser(){
        return this.user;
    }
    public Date getDate(){
        return this.date;
    }
}
class addclassmateriallecslide{
    private String topicofslide;
    private int noofslide;
    private Date date;
    private ArrayList<String> content = new ArrayList<>();
    //static HashMap<Integer,String> map;
    addclassmateriallecslide(String topicofslide,int noofslide,ArrayList content){
        this.topicofslide = topicofslide;
        this.noofslide = noofslide;
        this.content = content;
        this.date = new Date();
    }
    public String getTopicofslide(){
        return this.topicofslide;
    }
    public int getNoofslide(){
        return this.noofslide;
    }
    public ArrayList<String> getContent(){
        return this.content;
    }
    public Date getDate(){
        return this.date;
    }
}
class addclassmateriallecrec{
    private String topicofvidio;
    private String filenameofvidio;
    private Date date;
    //static HashMap<String,String> mapoflecrec;
    addclassmateriallecrec(String topicofvidio,String filenameofvidio){
        this.topicofvidio = topicofvidio;
        this.filenameofvidio = filenameofvidio;
        this.date = new Date();
    }
    public String getTopicofvidio(){
        return this.topicofvidio;
    }
    public String getFilenameofvidio(){
        return this.filenameofvidio;
    }
    public Date getDate(){
        return this.date;
    }
}
class addassesments_assignment{
    private int flag = 0;
    private String prob;
    private int maxmarks;
    addassesments_assignment(String prob,int maxmarks){
        this.prob = prob;
        this.maxmarks = maxmarks;
    }
    public String getProb(){
        return this.prob;
    }
    public int getMaxmarks(){
        return this.maxmarks;
    }
    public void setflag(int i){
        this.flag = i;
    }
    public int getFlag(){
        return this.flag;
    }
}
class addassements_quiz implements quiz{
    private int flag = 0;
    String que;
    private String by;
    addassements_quiz(String que,String by){
        this.que = que;
        this.by = by;
    }
    @Override
    public String quizque() {
        return this.que;
    }
    private String getBy(){
        return this.by;
    }
    public int getFlag(){
        return this.flag;
    }
    @Override
    public void setflag(int i) {
        this.flag = i;
    }
}
class submit_assignment{
    private String assignmentsub;
    private String problemassignment;
    private String studentname;
    private int marks = -1;
    private int status =0;
    private String graded_by ;

    public void setGraded_by(String graded_by) {
        this.graded_by = graded_by;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getGraded_by() {
        return graded_by;
    }
    submit_assignment(String assignmentsub,String problemassignment,String studentname){
        this.assignmentsub = assignmentsub;
        this.problemassignment = problemassignment;
        this.studentname = studentname;
        this.status=0;
    }
    public void setMarks(int marks){
        this.marks = marks;
    }
    public int getMarks(){
        return this.marks;
    }
    public String getAssignmentsub(){
        return this.assignmentsub;
    }
    public String getProblemassignment(){
        return this.problemassignment;
    }
    public String getStudentname(){
        return this.studentname;
    }
}
class submit_quiz {
    private String studentname;
    private String que;
    private String quesub;
    private int marks = -1;
    private int status = 0;
    private String graded_by;

    public void setGraded_by(String graded_by) {
        this.graded_by = graded_by;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getGraded_by() {
        return graded_by;
    }

    submit_quiz(String quesub, String que, String studentname) {
        this.quesub = quesub;
        this.que = que;
        this.studentname = studentname;
        this.status = 0;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getMarks() {
        return this.marks;
    }

    public String getQue(){
        return this.que;
    }
    public String getQuesub(){
        return this.quesub;
    }
    public String getStudentname(){
        return this.studentname;
    }
}
interface quiz{
    String quizque();
    int getFlag();
    void setflag(int i);
}