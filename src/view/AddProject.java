package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.UniversityProject;


public class AddProject {
        
    public AddProject(){
     
     addProjectGUI();   
    }
        public JPanel addProjectGUI(){
            
        
        
        JPanel panel=new JPanel();
        
        panel.setLayout(null);
        
        JLabel lname=new JLabel("Project name");
        JLabel ldescription=new JLabel("Description");
        JLabel lsupervisor=new JLabel("Supervisor");
        
        JTextField tname=new JTextField();
        JTextArea tdescription=new JTextArea();
        JTextField tsupervisor=new JTextField();
        
        JButton save=new JButton("Save");
        JButton cancel=new JButton("Cancel");
        
        lname.setBounds(140,10,180,50);
        lname.setFont(new Font("", Font.BOLD, 20));
        
        tname.setBounds(280,10,270,50);
        tname.setFont(new Font("", Font.BOLD, 19));
        
        ldescription.setBounds(90,155,110,30);
        ldescription.setFont(new Font("", Font.BOLD, 20));
        
        tdescription.setBounds(220,90,400,180);
        tdescription.setFont(new Font("", Font.BOLD, 12));
        tdescription.setLineWrap(true);
        
        lsupervisor.setBounds(140,280,180,50);
        lsupervisor.setFont(new Font("", Font.BOLD, 20));
        
        tsupervisor.setBounds(280,280,270,50);
        tsupervisor.setFont(new Font("", Font.BOLD, 20));

        save.setBounds(130,340,250,80);
        save.setFont(new Font("",Font.BOLD,25));
        
        cancel.setBounds(400,340,250,80);
        cancel.setFont(new Font("",Font.BOLD,25));
        
        panel.add(lname);
        panel.add(tname);
        panel.add(ldescription);
        panel.add(tdescription);
        panel.add(lsupervisor);
        panel.add(tsupervisor);
        panel.add(save);
        panel.add(cancel);

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            UniversityProject a=new UniversityProject();
            a.setName(tname.getText());
            a.setDescription(tdescription.getText());
            a.setSupervisor(tsupervisor.getText());
                
            }
        });
        
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            
            }
        });
        
        
        return panel;
    }
}



