package gui;

import game.entities.sportsman.IWinterSportsman;
import game.entities.sportsman.WinterSportsman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class CloneFrame extends JFrame {

    ArenaPanel panel = null;

    JLabel colorLbl;
    JComboBox<String> colorCmb;

    JLabel numberLbl;
    JTextField numberTf;

    JLabel optionLbl;
    JComboBox optionCmb;

    JButton btn;

    private final String[] Colors = {"Blue", "Pink"};

    public CloneFrame(ArenaPanel panel){
        this.panel = panel;

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400,400);
        this.setLayout(null);

        colorLbl = new JLabel("Choose Color:");
        colorLbl.setSize(100,50);
        colorLbl.setLocation(15,15);
        add(colorLbl);

        colorCmb = new JComboBox<String>(Colors);
        colorCmb.setSize(100,50);
        colorCmb.setLocation(15,70);
        add(colorCmb);

        numberLbl = new JLabel("Choose Number:");
        numberLbl.setSize(100,50);
        numberLbl.setLocation(150,15);
        add(numberLbl);

        numberTf = new JTextField("");
        numberTf.setSize(100,50);
        numberTf.setLocation(150,70);
        add(numberTf);

        optionLbl = new JLabel("Choose Player:");
        optionLbl.setSize(100,50);
        optionLbl.setLocation(275,15);
        add(optionLbl);


        optionCmb = new JComboBox<WinterSportsman>();
        for (IWinterSportsman ws: panel.getCompetitors()) {
            optionCmb.addItem(ws);
        }
        optionCmb.setSize(100,50);
        optionCmb.setLocation(275,70);
        add(optionCmb);

        btn = new JButton("Submit Changes");
        btn.setSize(100,50);
        btn.setLocation(150,300);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IWinterSportsman copy = (IWinterSportsman) ((IWinterSportsman)optionCmb.getSelectedItem()).makeCopy(); // cloning the last competitor
                try {
                    panel.addCompetitor(copy.getName(),copy.getAge(),copy.getMaxSpeed(),copy.getAcceleration(),copy.getColor());
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (NoSuchMethodException e1) {
                    e1.printStackTrace();
                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (InvocationTargetException e1) {
                    e1.printStackTrace();
                }

                panel.updateCompetitorImage();

                if(!numberTf.getText().equals(""))
                {
                    int x = Integer.parseInt(numberTf.getText());
                    if(panel.getCompetitors().get(panel.getCompetitors().size()-1).setCompetitorNumber(x)){
                        System.out.println("Competitor number has been successfully changed.");
                    }
                    else{
                        System.out.println("Competitor number "+ x +"is already take." + "number stay " + copy.getCompetitorNumber());
                    }
                }
                panel.updateFrame();
                dispose();
                // TODO - Gender or Image? , note: will always update the last one
            }
        });
        add(btn);
    }

    public int getLastCompetitorIndex(){
        if (panel != null)
        {
            return panel.getCompetitors().size()-1;
        }
        return -1;
    }
}
