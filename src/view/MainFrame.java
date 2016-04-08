package view;

import model.UniversityProject;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame {

    private JFrame frame = new JFrame("Project Management");
    private JPanel center;
    private JPanel east;
    private ProjectsListJPanels projectsWindow = new ProjectsListJPanels(MainFrame.this);

    private ArrayList<UniversityProject> universityProjects = new ArrayList<>();
    private ProgramDate date;
    private JLabel dateLabel;

    public MainFrame(ArrayList<UniversityProject> universityProjects, ProgramDate date) {
        this.universityProjects = universityProjects;
        this.date = date;
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(860, 500);
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
    }

    public JPanel getCenter() {
        return center;
    }

    public void setCenter(JPanel center) {
        this.center = center;
    }

    public JPanel getEast() {
        return east;
    }

    public void setEast(JPanel east) {
        this.east = east;
    }

    public ArrayList<UniversityProject> getUniversityProjects() {
        return universityProjects;
    }

    public ProjectsListJPanels getProjectsWindow() {
        return projectsWindow;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void showMainFrame() {
        east = showMenu(projectsWindow.createProjectButtons());
        center = projectsWindow.createProjectsList(universityProjects);

        frame.add(east, BorderLayout.EAST);
        frame.add(center);
        frame.setVisible(false);
    }

    public JPanel showMenu(JPanel panel) {
        JPanel mainPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        mainPanel.setLayout(layout);
        mainPanel.setPreferredSize(new Dimension(138, 0));
        mainPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.black),
                "Menu",
                TitledBorder.LEADING,
                TitledBorder.CENTER,
                new Font("Times New Roman", Font.BOLD, 20),
                Color.BLACK));
        mainPanel.add(panel);
        JPanel datePanel = showTime();
        mainPanel.add(datePanel);
        layout.putConstraint(SpringLayout.SOUTH, datePanel, 0, SpringLayout.SOUTH, mainPanel);
        return mainPanel;
    }

    private JPanel showTime() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        panel.setPreferredSize(new Dimension(128, 55));
        JButton button = new JButton("Change date");
        button.setPreferredSize(new Dimension(128, 30));
        JLabel dateStr = new JLabel("Date:");
        dateStr.setFont(new Font("Times New Roman", Font.BOLD, 18));
        this.dateLabel = new JLabel(String.format("%d/%d/%d", date.getProgramYear(), date.getProgramMonth(), date.getProgramDay()));
        dateLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date.time(MainFrame.this);
            }
        });
        panel.add(dateStr);
        layout.putConstraint(SpringLayout.WEST, dateStr, 0, SpringLayout.WEST, panel);
        panel.add(dateLabel);
        layout.putConstraint(SpringLayout.WEST, dateLabel, 44, SpringLayout.WEST, panel);
        panel.add(button);
        layout.putConstraint(SpringLayout.NORTH, button, 24, SpringLayout.NORTH, panel);
        return panel;
    }

    public void refresh() {
        dateLabel.setText(String.format("%d/%d/%d", date.getProgramYear(), date.getProgramMonth(), date.getProgramDay()));
    }
}
