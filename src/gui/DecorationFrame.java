package gui;

import game.entities.sportsman.ColoredSportsman;
import game.entities.sportsman.IWinterSportsman;
import game.entities.sportsman.SpeedySportsman;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  
 * @author Asher Yasia and  Yogev Orenshtein.
 * 
 *  ID's : 310273370   and   200844272
 *  
 *  Campus : Beer - Sheva 
 *  
 */

public class DecorationFrame extends JFrame {
    ArenaPanel panel = null;
    private final String[] ColorArr = {"Blue", "Pink", "Red", "Green"};
    private final JComboBox<String> cmbColor;
    private JTextField tfAcceleration;


    public DecorationFrame(ArenaPanel panel){
        this.panel = panel;

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(200,200);
        this.setLayout(null);


        JLabel l1 = new JLabel("Color:");
        l1.setSize(65,25);
        l1.setLocation(15,15);
        add(l1);

        cmbColor = new JComboBox<>(ColorArr);
        cmbColor.setSize(65,30);
        cmbColor.setLocation(15,45);
        add(cmbColor);

        JLabel l2 = new JLabel("Acceleration:");
        l2.setSize(100,25);
        l2.setLocation(100,15);
        add(l2);

        tfAcceleration = new JTextField();
        tfAcceleration.setSize(65,30);
        tfAcceleration.setLocation(100,45);
        add(tfAcceleration);

        JButton btn = new JButton("Submit Changes");
        btn.setSize(150,25);
        btn.setLocation(15,100);
        add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                IWinterSportsman tmp = panel.getCompetitors().get(panel.getCompetitors().size()-1);
                double acc = 0;
                if(!tfAcceleration.getText().equals("")){
                    acc = Double.parseDouble(tfAcceleration.getText());
                }
                String color = cmbColor.getSelectedItem().toString();
                IWinterSportsman sm  = new ColoredSportsman(new SpeedySportsman(tmp,acc),color);


                panel.getCompetitors().remove(tmp);
                panel.getCompetitors().add(sm);
                panel.updateCompetitorImage();
                System.out.println(panel.getCompetitors().get(panel.getCompetitors().size()-1).getAcceleration());
                panel.updateFrame();
                dispose();
            }
        });
    }
}
