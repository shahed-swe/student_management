
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shdwhntr
 */
public class Homepage extends javax.swing.JFrame {

    /**
     * Creates new form Homepage
     */
    public Homepage() {
        initComponents();
        
    }
    public ArrayList<User> userList_1(){
        ArrayList<User> usersList = new ArrayList<>();
        PreparedStatement ps;
        String query1 = "SELECT * FROM stu_data";
        try {
            ps = MyConnection.getConnection().prepareStatement(query1);
            ResultSet rs = ps.executeQuery(query1);
            User user;
            while(rs.next()){
                user = new User(rs.getString("stu_id"),rs.getString("stu_fname"),rs.getString("stu_lname"),rs.getInt("stu_age"),rs.getString("stu_father_name"),rs.getString("stu_mother_name"),rs.getString("stu_address"),rs.getString("stu_phone"));
                usersList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usersList;
    }
    public ArrayList<User> userList_2(String search_lite){
        ArrayList<User> usersList = new ArrayList<>();
        PreparedStatement ps;
        //String query5 = "SELECT * FROM `stu_data` WHERE CONCAT(`stu_id`,`stu_fname`,`stu_lname`,`stu_age`,`stu_address`,`stu_father_name`,`stu_mother_name`,`stu_phone`) LIKE '%"+search_lite+"%'";
        String query5 = "SELECT * FROM `stu_data` WHERE stu_id = "+search_lite+"";
        try {
            ps = MyConnection.getConnection().prepareStatement(query5);
            ResultSet rs = ps.executeQuery(query5);
            User user;
            while(rs.next()){
                user = new User(rs.getString("stu_id"),rs.getString("stu_fname"),rs.getString("stu_lname"),rs.getInt("stu_age"),rs.getString("stu_father_name"),rs.getString("stu_mother_name"),rs.getString("stu_address"),rs.getString("stu_phone"));
                usersList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Not found!!");
        }
        return usersList;
    }
    public void show_user_1(){
        ArrayList<User> list = userList_1();
        DefaultTableModel model = (DefaultTableModel)datatable.getModel();
        Object[] row = new Object[8];
        for(int i = 0;i < list.size();i++){
            row[0] = list.get(i).getstu_id();
            row[1] = list.get(i).getstu_fname();
            row[2] = list.get(i).getstu_lname();
            row[3] = list.get(i).getstu_age();
            row[4] = list.get(i).getstu_father_name();
            row[5] = list.get(i).getstu_mother_name();
            row[6] = list.get(i).getstu_address();
            row[7] = list.get(i).getstu_phone();
            model.addRow(row);
        }
    }
    public void show_user_2(){
        ArrayList<User> list = userList_2(search.getText());
        DefaultTableModel model = new DefaultTableModel();//datatable.getModel();
        model.setColumnIdentifiers(new Object[] {"Student ID","First Name","Last Name","Age","Father Name","Mother Name","Address","Phone No"});
        Object[] row = new Object[8];
        for(int i = 0;i < list.size();i++){
            row[0] = list.get(i).getstu_id();
            row[1] = list.get(i).getstu_fname();
            row[2] = list.get(i).getstu_lname();
            row[3] = list.get(i).getstu_age();
            row[4] = list.get(i).getstu_father_name();
            row[5] = list.get(i).getstu_mother_name();
            row[6] = list.get(i).getstu_address();
            row[7] = list.get(i).getstu_phone();
            model.addRow(row);
        }
        datatable.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        logout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_home = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        s_fname = new javax.swing.JTextField();
        s_lname = new javax.swing.JTextField();
        s_father = new javax.swing.JTextField();
        s_mother = new javax.swing.JTextField();
        s_address = new javax.swing.JTextField();
        s_age = new javax.swing.JTextField();
        s_pno = new javax.swing.JTextField();
        jbtninsert = new javax.swing.JButton();
        jbtnupdate = new javax.swing.JButton();
        jbtndelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        datatable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        s_id = new javax.swing.JTextField();
        jbtnsearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jbtnsearch1 = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logout1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(129, 207, 224));

        logout.setBackground(new java.awt.Color(213, 184, 255));
        logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel3.setBackground(new java.awt.Color(115, 101, 152));

        btn_home.setBackground(new java.awt.Color(159, 90, 253));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\shdwhntr\\Downloads\\project picture\\588a667fd06f6719692a2d19_vectorized.png")); // NOI18N
        jLabel1.setText("Home");

        javax.swing.GroupLayout btn_homeLayout = new javax.swing.GroupLayout(btn_home);
        btn_home.setLayout(btn_homeLayout);
        btn_homeLayout.setHorizontalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btn_homeLayout.setVerticalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_homeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(103, 128, 159));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("First Name:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Last Name:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Father Name:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Mother Name:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Address:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Age:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Phone Number:");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 255));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jbtninsert.setBackground(new java.awt.Color(213, 184, 255));
        jbtninsert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtninsert.setIcon(new javax.swing.ImageIcon("C:\\Users\\shdwhntr\\Downloads\\project picture\\insert_vectorized.png")); // NOI18N
        jbtninsert.setText("INSERT");
        jbtninsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtninsertActionPerformed(evt);
            }
        });

        jbtnupdate.setBackground(new java.awt.Color(213, 184, 255));
        jbtnupdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnupdate.setIcon(new javax.swing.ImageIcon("C:\\Users\\shdwhntr\\Downloads\\project picture\\update_vectorized.png")); // NOI18N
        jbtnupdate.setText("Update");
        jbtnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnupdateActionPerformed(evt);
            }
        });

        jbtndelete.setBackground(new java.awt.Color(213, 184, 255));
        jbtndelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtndelete.setIcon(new javax.swing.ImageIcon("C:\\Users\\shdwhntr\\Downloads\\project picture\\delete_vectorized.png")); // NOI18N
        jbtndelete.setText("Delete");
        jbtndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtndeleteActionPerformed(evt);
            }
        });

        datatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "First Name", "Last Name", "Age", "Father Name", "Mother Name", "Address", "Phone No"
            }
        ));
        datatable.setGridColor(new java.awt.Color(255, 102, 255));
        jScrollPane1.setViewportView(datatable);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Student ID:");

        jbtnsearch.setBackground(new java.awt.Color(213, 184, 255));
        jbtnsearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnsearch.setIcon(new javax.swing.ImageIcon("C:\\Users\\shdwhntr\\Downloads\\project picture\\search_vectorized.png")); // NOI18N
        jbtnsearch.setText("Search");
        jbtnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnsearchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Use Student Id :");

        jbtnsearch1.setBackground(new java.awt.Color(213, 184, 255));
        jbtnsearch1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnsearch1.setIcon(new javax.swing.ImageIcon("C:\\Users\\shdwhntr\\Downloads\\project picture\\show_vectorized.png")); // NOI18N
        jbtnsearch1.setText("Show ALL");
        jbtnsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnsearch1ActionPerformed(evt);
            }
        });

        Clear.setBackground(new java.awt.Color(213, 184, 255));
        Clear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtninsert)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(s_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(s_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(s_father, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(s_mother, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(s_address, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(s_age, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(s_id, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(s_pno, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtnupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                                        .addComponent(jbtndelete)
                                        .addGap(84, 84, 84)
                                        .addComponent(jbtnsearch)
                                        .addGap(14, 14, 14))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(168, 168, 168)
                                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jbtnsearch1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(244, 244, 244)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s_id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(s_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(s_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(s_father, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(s_mother, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(s_address, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s_age, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s_pno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator1))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtninsert)
                    .addComponent(jbtnupdate)
                    .addComponent(jbtndelete)
                    .addComponent(jbtnsearch))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\shdwhntr\\Downloads\\project picture\\diu_vectorized.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("Wellcome to admin panel");

        logout1.setBackground(new java.awt.Color(213, 184, 255));
        logout1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logout1.setText("Calculate");
        logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(logout)
                    .addComponent(logout1))
                .addGap(132, 132, 132)
                .addComponent(jLabel3)
                .addGap(0, 262, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(logout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logout1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        LoginFrom rpf = new LoginFrom();
        rpf.setVisible(true);
        rpf.pack();
        rpf.setLocationRelativeTo(null);
        rpf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void jbtninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtninsertActionPerformed
        String id = s_id.getText();
        String fname = s_fname.getText();
        String lname = s_lname.getText();
        String fathername = s_father.getText();
        String mothername = s_mother.getText();
        String address = s_address.getText();
        String age = s_age.getText();
        String phone = s_pno.getText();
        if(id.equals("")){
            JOptionPane.showMessageDialog(null, "Add Your Student ID!!");
        }
        else if(fname.equals("")){
            JOptionPane.showMessageDialog(null,"Add your First Name!!");
        }
        else if(lname.equals("")){
            JOptionPane.showMessageDialog(null,"Add your Last Name!!");
        }
        else if(fathername.equals("")){
            JOptionPane.showMessageDialog(null,"Add your Father Name!!");
        }
        else if(mothername.equals("")){
            JOptionPane.showMessageDialog(null,"Add your Mother Name!!");
        }
        else if(address.equals("")){
            JOptionPane.showMessageDialog(null,"Add your Address!!");
        }
        else if(age.equals("")){
            JOptionPane.showMessageDialog(null,"Add your age!!");
        }
        else if(phone.equals("")){
            JOptionPane.showMessageDialog(null,"Add your Phone Number!!");
        }
        else{
            PreparedStatement ps;
            String query;
            query = "INSERT INTO `stu_data`(`stu_id`, `stu_fname`, `stu_lname`, `stu_father_name`, `stu_mother_name`, `stu_address`,`stu_age`,`stu_phone`) VALUES (?,?,?,?,?,?,?,?)";
            try {
            ps = MyConnection.getConnection().prepareCall(query);
            
            ps.setString(1, id);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, fathername);
            ps.setString(5, mothername);
            ps.setString(6, address);
            ps.setString(7, age);
            ps.setString(8, phone);
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Student Data Added Successfully!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jbtninsertActionPerformed

    private void jbtnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnupdateActionPerformed
        String id = s_id.getText();
        String fname = s_fname.getText();
        String lname = s_lname.getText();
        String fathername = s_father.getText();
        String mothername = s_mother.getText();
        String address = s_address.getText();
        String age = s_age.getText();
        String phone = s_pno.getText();
        String searchid = search.getText();
        PreparedStatement ps;
        String query2;
        query2 = "UPDATE `stu_data` SET `stu_id`=?,`stu_fname`=?,`stu_lname`=?,`stu_father_name`=?,`stu_mother_name`=?,`stu_address`=?,`stu_age`=?,`stu_phone`=? WHERE `stu_id`=?";
        try {
            ps = MyConnection.getConnection().prepareCall(query2);
            ps.setString(1, id);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, fathername);
            ps.setString(5, mothername);
            ps.setString(6, address);
            ps.setString(7, age);
            ps.setString(8, phone);
            ps.setString(9, searchid);
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Student Data Updated Successfully!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnupdateActionPerformed

    private void jbtndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtndeleteActionPerformed
        PreparedStatement ps;
        String searchid = search.getText();
        String query3;
        query3 = "DELETE FROM `stu_data` WHERE `stu_id`=?";
        try {
            ps = MyConnection.getConnection().prepareCall(query3);
            ps.setString(1, searchid);
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Student Data  Successfully!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbtndeleteActionPerformed

    private void jbtnsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnsearch1ActionPerformed
        show_user_1();
    }//GEN-LAST:event_jbtnsearch1ActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        s_id.setText("");
        s_fname.setText("");
        s_lname.setText("");
        s_father.setText("");
        s_mother.setText("");
        s_address.setText("");
        s_age.setText("");
        s_pno.setText("");
        
        DefaultTableModel model = (DefaultTableModel)datatable.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_ClearActionPerformed

    private void jbtnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnsearchActionPerformed
        show_user_2();
    }//GEN-LAST:event_jbtnsearchActionPerformed

    private void logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout1ActionPerformed
        Calculate rpf = new Calculate();
        rpf.setVisible(true);
        rpf.pack();
        rpf.setLocationRelativeTo(null);
        rpf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_logout1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Homepage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JPanel btn_home;
    private javax.swing.JTable datatable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtndelete;
    private javax.swing.JButton jbtninsert;
    private javax.swing.JButton jbtnsearch;
    private javax.swing.JButton jbtnsearch1;
    private javax.swing.JButton jbtnupdate;
    private javax.swing.JButton logout;
    private javax.swing.JButton logout1;
    private javax.swing.JTextField s_address;
    private javax.swing.JTextField s_age;
    private javax.swing.JTextField s_father;
    private javax.swing.JTextField s_fname;
    private javax.swing.JTextField s_id;
    private javax.swing.JTextField s_lname;
    private javax.swing.JTextField s_mother;
    private javax.swing.JTextField s_pno;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
