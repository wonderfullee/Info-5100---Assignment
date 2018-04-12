package class10.Assignment_8.class9;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;



public class StudentManagerSystem extends JFrame implements ActionListener {
    private JTable jt;
    private JScrollPane jsp;
    private JButton addStudent, removeStudent, modifyStudent, save, load,find;
    private JTextField nameTxt, rollTxt, genderTxt, gradeTxt;
    private JLabel state = new JLabel();
    private Object[] colNames = {"Roll", "Name", "Gender", "Grade"};
    private JFrame frame;
    private JPanel jPanel;
    DefaultTableModel model = new DefaultTableModel();
    public static StudentsPersistorImpl sp = new StudentsPersistorImpl();
    public static StudentsManager sm = new StudentsManagerImpl();


    public StudentManagerSystem() {
        frame = new JFrame("Student Manager System");
        jPanel = new JPanel();

        jt = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(colNames);
        jt.setModel(model);

        addStudent = new JButton("Add");
        removeStudent = new JButton("Remove");
        modifyStudent = new JButton("Modify ");
        load = new JButton("Display ");
        save = new JButton("Save");
        find = new JButton("Find");


        JLabel namelab = new JLabel("Name");
        nameTxt = new JTextField(5);
        namelab.setLabelFor(nameTxt);
        JLabel rolllab = new JLabel("Roll");
        rollTxt = new JTextField(5);
        rolllab.setLabelFor(rollTxt);
        JLabel genderlab = new JLabel("Gender");
        genderTxt = new JTextField(5);
        genderlab.setLabelFor(genderTxt);
        JLabel gradelab = new JLabel("Grade");
        gradeTxt = new JTextField(5);
        gradelab.setLabelFor(gradeTxt);
        state.setText("Waiting");
        state.setForeground(Color.red);

        addStudent.setPreferredSize(new Dimension(100, 50));
        removeStudent.setPreferredSize(new Dimension(100, 50));
        modifyStudent.setPreferredSize(new Dimension(100, 50));
        save.setPreferredSize(new Dimension(100, 50));
        find.setPreferredSize(new Dimension(100, 50));
        load.setPreferredSize(new Dimension(100, 50));
        addStudent.addActionListener(this);
        removeStudent.addActionListener(this);
        modifyStudent.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);
        find.addActionListener(this);



        jPanel.add(rolllab);
        jPanel.add(rollTxt);
        jPanel.add(namelab);
        jPanel.add(nameTxt);
        jPanel.add(genderlab);
        jPanel.add(genderTxt);
        jPanel.add(gradelab);
        jPanel.add(gradeTxt);


        jsp = new JScrollPane(jt);
        jsp.setPreferredSize(new Dimension(580, 580));
        jPanel.add(addStudent);
        jPanel.add(removeStudent);
        jPanel.add(modifyStudent);
        jPanel.add(load);
        jPanel.add(find);
        jPanel.add(save);
        jPanel.add(state);
        jPanel.add(jsp);

        frame.add(jPanel);
        frame.setSize(700, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void refreshTable() throws Exception {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(colNames);
        jt.setModel(model);
        sp.load();
        for (class9.Student s : sm.getStudents()) {
            Object[] data = {s.getRoll(), s.getName(), s.getGender(), s.getGrade()};
            model.addRow(data);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == addStudent) {
            if (!rollTxt.getText().isEmpty() && !nameTxt.getText().isEmpty() && !genderTxt.getText().isEmpty() && !gradeTxt.getText().isEmpty()) {
                Object[] row = {rollTxt.getText(), nameTxt.getText(), genderTxt.getText(), gradeTxt.getText()};
                class9.Student st = new class9.Student();
                st.setRoll(rollTxt.getText());
                st.setName(nameTxt.getText());
                st.setGender(genderTxt.getText());
                st.setGrade(gradeTxt.getText());
                sm.addStudent(st);
                model.addRow(row);
                jt.setModel(model);
                state.setText("added");
            } else {
                state.setText("Empty input");
            }

        } else if (ae.getSource() == removeStudent) {
            if (!rollTxt.getText().isEmpty()) {
                class9.Student st = sm.findStudent(rollTxt.getText());
                if(st != null) {
                    sm.deleteStudent(rollTxt.getText());
                    state.setText("removed");
                    try {
                        refreshTable();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else
                    state.setText("can not find roll number ");
            } else {
                state.setText("Empty Roll");
            }



        } else if (ae.getSource() == modifyStudent) {
            if (!gradeTxt.getText().isEmpty()) {
                class9.Student st = sm.findStudent(rollTxt.getText());
                st.setGrade(gradeTxt.getText());
                state.setText("Changed");
                try {
                    refreshTable();
                } catch (Exception e) {
                    state.setText("Fail");
                    e.printStackTrace();
                }
            } else
                state.setText("Empty Grade");

        } else if (ae.getSource() == load) {
            try {
                refreshTable();
                state.setText("Load");
            } catch (Exception e) {
                state.setText("Fail");
                e.printStackTrace();
            }
        } else if (ae.getSource() == save) {
            try {
                sp.save(sm);
                state.setText("Saved");
            } catch (Exception e) {
                state.setText("Fail");
                e.printStackTrace();
            }
        }else if(ae.getSource() == find){
            if(!rollTxt.getText().isEmpty()){
                class9.Student st = sm.findStudent(rollTxt.getText());
                if(st == null){
                    state.setText("No roll number found");
                }else {
                    state.setText(st.getLine());
                }
            }else {
                state.setText("Empty Roll");
            }

        }

    }

    public static void main(String[] args) throws Exception {
        StudentManagerSystem sms = new StudentManagerSystem();
        ReadFromFile rf = new ReadFromFile();
        rf.setWindowFilePath("Z:\\neu\\test\\Student.txt"); // window system user only
                                                            // for changing file path
        
        //ReadFromFile.filePath = ""; // Mac OS user use only
                                    // for changing file path

        sm = sp.load();
        sms.refreshTable();
    }

}
