package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.UniversityProject;


public class AddProject implements ActionListener {
        

        public void actionPerformed(ActionEvent e){
        
        JFrame frame=new JFrame("Add student");
        
        frame.setSize(400,450);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        JLabel lname=new JLabel("Project name");
        JLabel ldescription=new JLabel("Description:");
        JLabel lsupervisor=new JLabel("Supervisor");
        
        JTextField tname=new JTextField();
        JTextArea tdescription=new JTextArea();
        JTextField tsupervisor=new JTextField();
        
        JButton save=new JButton("Add project");
        
        lname.setBounds(10,10,100,30);
        lname.setFont(new Font("", Font.BOLD, 15));
        
        tname.setBounds(120,10,200,30);
        tname.setFont(new Font("", Font.BOLD, 15));
        
        ldescription.setBounds(10,50,110,30);
        ldescription.setFont(new Font("", Font.BOLD, 15));
        
        tdescription.setBounds(10,90,350,180);
        tdescription.setFont(new Font("", Font.BOLD, 12));
        tdescription.setLineWrap(true);
        
        lsupervisor.setBounds(10,280,100,30);
        lsupervisor.setFont(new Font("", Font.BOLD, 15));
        
        tsupervisor.setBounds(120,280,200,30);
        tsupervisor.setFont(new Font("", Font.BOLD, 15));

        save.setBounds(75,320,250,80);
        save.setFont(new Font("",Font.BOLD,25));

        frame.add(lname);
        frame.add(tname);
        frame.add(ldescription);
        frame.add(tdescription);
        frame.add(lsupervisor);
        frame.add(tsupervisor);
        frame.add(save);


        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            UniversityProject a=new UniversityProject();
            a.setName(tname.getText());
            a.setDescription(tdescription.getText());
            a.setSupervisor(tsupervisor.getText());
                
            }
        });
    }
}

