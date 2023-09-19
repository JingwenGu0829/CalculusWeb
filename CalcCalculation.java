/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class calccalculator extends JFrame {
    private JPanel topPanel,middlePanel,scrollContentPanel;
    private JScrollPane scrollPane;
    private JButton addBtn,removeBtn,derivativeBtn,integralBtn,plotBtn;
    private Plotpane pltPanel;
    private JFrame drawFrame;
    private Vector<String[]> equations;

    public calccalculator() {
        setTitle("Calculus Web");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        topPanel.setLayout(new BorderLayout());

        scrollContentPanel = new JPanel();
        scrollContentPanel.setLayout(new BoxLayout(scrollContentPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(scrollContentPanel);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        topPanel.add(scrollPane, BorderLayout.CENTER);

        middlePanel = new JPanel();
        middlePanel.setSize(500, 500);
        middlePanel.setLayout(new FlowLayout());

        //button
        addBtn = new JButton("Add");
        removeBtn = new JButton("Remove");
        derivativeBtn = new JButton("Derivative");
        integralBtn = new JButton("Integral");
        plotBtn = new JButton("Plot");
        
        //draw part
        pltPanel = new Plotpane();
        drawFrame = new JFrame();
        drawFrame.setSize(500,500);
        drawFrame.setTitle("Plot");
        
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel newPanel = createNewPanel();
                scrollContentPanel.add(newPanel);
                scrollContentPanel.revalidate();
            }
        });

        removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component[] components = scrollContentPanel.getComponents();
                for (Component component : components) {
                    if (component instanceof JPanel) {
                        JPanel panel = (JPanel) component;
                        JCheckBox checkBox = (JCheckBox) panel.getComponent(0);
                        if (checkBox.isSelected()) {
                            scrollContentPanel.remove(panel);
                        }
                    }
                }
                scrollContentPanel.revalidate();
                scrollContentPanel.repaint();
            }
        });
        
        
        
        plotBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawFrame.add(pltPanel);
                drawFrame.setVisible(true);
            }
        });

        middlePanel.add(addBtn);
        middlePanel.add(removeBtn);
        middlePanel.add(derivativeBtn);
        middlePanel.add(integralBtn);
        middlePanel.add(plotBtn);

        add(topPanel, BorderLayout.CENTER);
        add(middlePanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createNewPanel() {
        JPanel panel = new JPanel();
        JButton edit = new JButton("Edit");
        JButton Done = new JButton("Done");
        
        
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(new FlowLayout());

        JCheckBox checkBox = new JCheckBox();
        JTextField equation = new JTextField(10);
        equation.setText("equation");
        JTextField variable = new JTextField(10);
        variable.setText("var");

        panel.add(checkBox);
        panel.add(equation);
        panel.add(variable);
        panel.add(edit);
        panel.add(Done);
        
        
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setEditable(true);
                variable.setEditable(true);
            }
        });
        
        Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setEditable(false);
                variable.setEditable(false);
                
                //index 0 is equaiton, 1 is variable
                String[] Arry={equation.getText(),variable.getText()};
                equations.add(Arry);    
            }
        });
        
        

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                calccalculator frame = new calccalculator();
                frame.setVisible(true);
            }
        });
    }
}

class Plotpane extends JPanel{
    
    public Plotpane(){
        this.setSize(500, 500);
        this.setName("Plot");
        
        
    }
    
    
}
