class User {
    private String stu_id,stu_fname,stu_lname,stu_address;
    private int stu_age;
    private String stu_father_name,stu_mother_name,stu_phone;
    
    
    public User(String stu_id,String stu_fname,String stu_lname,int stu_age,String father_name,String mother_name,String stu_address,String stu_phone){
        this.stu_id = stu_id;
        this.stu_fname = stu_fname;
        this.stu_lname = stu_lname;
        this.stu_father_name = father_name;
        this.stu_mother_name = mother_name;
        this.stu_address = stu_address;
        this.stu_age = stu_age;
        this.stu_phone = stu_phone;
    }
    public String getstu_id(){
        return stu_id;
    }
    public String getstu_fname(){
        return stu_fname;
    }
    public String getstu_lname(){
        return stu_lname;
    }
    public int getstu_age(){
        return stu_age;
    }
    public String getstu_father_name(){
        return stu_father_name;
    }
    public String getstu_mother_name(){
        return stu_mother_name;
    }
    public String getstu_address(){
        return stu_address;
    }
    public String getstu_phone(){
        return stu_phone;
    }
    
    
}
