package gui;

import game.entities.sportsman.WinterSportsman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class ControlsPanel extends JPanel implements ActionListener{
    private final JTextField tfArenaLength;
    private final JTextField tfMaxCompetitors;
    private final JTextField tfCompetitorName;
    private final JTextField tfMaxSpeed;
    private final JTextField tfAcceleration;
    private final JTextField tfAge;
    private final JTextField tfThreads;
    private final JComboBox<String> cmbColor;
    private final JComboBox<String> cmbArenaSurface;
    private final JComboBox<String> cmbArenaWeather;
    private final JComboBox<String> cmbCompetition;
    private final JComboBox<String> cmbDiscipline;
    private final JComboBox<String> cmbLeague;
    private final JComboBox<String> cmbGender;
    private final JComboBox<String> cmbType;
    private final String[] ColorsArray = {"Blue", "Pink"};
    private final String[] TypeArray = {"Winter", "Summer"};

    public static boolean[] numbers;

    private ArenaPanel arenaPanel = null;
    public int numOfThreads = -1;
    
    
    public ControlsPanel(ArenaPanel arenaPanel) {
        numbers = new boolean[99];
        for (boolean b:numbers) {
            b = false;
        }
        this.arenaPanel = arenaPanel;
        setLayout(null);
        setPreferredSize(new Dimension(165,arenaPanel.getArenaLength()));

        
        JLabel l1 = new JLabel("<HTML><font color='blue'><U>BUILD ARENA</U></font></HTML>");
        add(l1);
        l1.setLocation(10,10);
        l1.setSize(145, 20);
        
        JLabel l2 = new JLabel("Arena length + Type");
        l2.setLocation(10,33);
        l2.setSize(185, 15);
        add(l2);
        
        tfArenaLength = new JTextField(""+arenaPanel.getArenaLength());
        tfArenaLength.setLocation(10,50);
        tfArenaLength.setSize(45, 25);
        add(tfArenaLength);

        cmbType = new JComboBox<>(TypeArray);
        cmbType.setLocation(60,50);
        cmbType.setSize(95,25);
        add(cmbType);
        
        
        JLabel l4 = new JLabel("Snow surface");
        l4.setLocation(10,78);
        l4.setSize(170, 15);
        add(l4);
        
        cmbArenaSurface = new JComboBox<>();       
        cmbArenaSurface.addItem("Powder");
        cmbArenaSurface.addItem("Crud");
        cmbArenaSurface.addItem("Ice");  
        
        if (arenaPanel.getSurface() != null)
        	cmbArenaSurface.setSelectedItem(arenaPanel.getSurface()); 
        else
        	cmbArenaSurface.setSelectedItem("Powder");
        
        add(cmbArenaSurface);
        cmbArenaSurface.setLocation(10,95);
        cmbArenaSurface.setSize(145,20);
        
        JLabel l5 = new JLabel("Weather condition");
        l5.setLocation(10,118);
        l5.setSize(170, 15);
        add(l5);
        
        cmbArenaWeather = new JComboBox<>();       
        cmbArenaWeather.addItem("Sunny");
        cmbArenaWeather.addItem("Cloudy");
        cmbArenaWeather.addItem("Stormy");  
        
        if (arenaPanel.getWeather() != null)
        	cmbArenaWeather.setSelectedItem(arenaPanel.getWeather()); 
        else
        	cmbArenaWeather.setSelectedItem("Sunny");
        
        add(cmbArenaWeather);
        cmbArenaWeather.setLocation(10,135);
        cmbArenaWeather.setSize(145,20);
        
        
        JButton buildArenaBut = new JButton("Build arena");
        buildArenaBut.setLocation(10,160);
        buildArenaBut.setSize(145, 30);
        buildArenaBut.addActionListener(this);
        add(buildArenaBut);
        
        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setLocation(0,195);
        sep.setSize(170, 10);
        add(sep);
        
        
        //-------------------------------------------------------------------
        
        JLabel l6 = new JLabel("<HTML><font color='blue'><U>CREATE COMPETITION</U></font></HTML>");
        add(l6);
        l6.setLocation(10,197);
        l6.setSize(145, 20);
        
        JLabel l7 = new JLabel("Choose competition");
        l7.setLocation(10,220);
        l7.setSize(170, 15);
        add(l7);
        
        cmbCompetition = new JComboBox<>();       
        cmbCompetition.addItem("Ski");
        cmbCompetition.addItem("Snowboard");         
        if (arenaPanel.getCompetition() != null)
        	cmbCompetition.setSelectedItem(arenaPanel.getCompetition()); 
        else
        	cmbCompetition.setSelectedItem("Ski");   
        add(cmbCompetition);
        cmbCompetition.setLocation(10,238);
        cmbCompetition.setSize(145,20);
        
        
        JLabel l8 = new JLabel("Max competitors number");
        l8.setLocation(10,261);
        l8.setSize(170, 15);
        add(l8);
        
        tfMaxCompetitors = new JTextField(""+arenaPanel.getMaxCompetitors());
        tfMaxCompetitors.setLocation(10,278);
        tfMaxCompetitors.setSize(145, 25);
        add(tfMaxCompetitors);
        
        
        JLabel l9 = new JLabel("Discipline");
        l9.setLocation(10,306);
        l9.setSize(170, 15);
        add(l9);
        
        cmbDiscipline = new JComboBox<>();       
        cmbDiscipline.addItem("Slalom");
        cmbDiscipline.addItem("Giant-Slalom");
        cmbDiscipline.addItem("Downhill");
        cmbDiscipline.addItem("Freestyle");
        if (arenaPanel.getCompetition() != null)
        	cmbDiscipline.setSelectedItem(arenaPanel.getDiscipline()); 
        else
        	cmbDiscipline.setSelectedItem("Slalom"); 
        add(cmbDiscipline);
        cmbDiscipline.setLocation(10,324);
        cmbDiscipline.setSize(145,20);
        
        
        JLabel l10 = new JLabel("League");
        l10.setLocation(10,347);
        l10.setSize(170, 15);
        add(l10);
        
        cmbLeague = new JComboBox<>();       
        cmbLeague.addItem("Junior");
        cmbLeague.addItem("Adult");
        cmbLeague.addItem("Senior");
        if (arenaPanel.getCompetition() != null)
        	cmbLeague.setSelectedItem(arenaPanel.getLeague()); 
        else
        	cmbLeague.setSelectedItem("Junior");
        add(cmbLeague);
        cmbLeague.setLocation(10,364);
        cmbLeague.setSize(145,20);
        
        
        JLabel l11 = new JLabel("Gender");
        l11.setLocation(10,387);
        l11.setSize(170, 15);
        add(l11);
        
        cmbGender = new JComboBox<>();       
        cmbGender.addItem("Male");
        cmbGender.addItem("Female");
        if (arenaPanel.getCompetition() != null)
        	cmbGender.setSelectedItem(arenaPanel.getGender()); 
        else
        	cmbGender.setSelectedItem("Male");
        add(cmbGender);
        cmbGender.setLocation(10,404);
        cmbGender.setSize(145,20);
        
        JButton createCompetitionBut = new JButton("Create competition");
        createCompetitionBut.setLocation(10,429);
        createCompetitionBut.setSize(145, 30);
        createCompetitionBut.addActionListener(this);
        add(createCompetitionBut);
        
        JSeparator sep2 = new JSeparator(SwingConstants.HORIZONTAL);
        sep2.setLocation(0,464);
        sep2.setSize(170, 10);
        add(sep2);
        
        //-------------------------------------------------------------------------------
        
        JLabel l12 = new JLabel("<HTML><font color='blue'><U>ADD COMPETITOR</U></font></HTML>");
        add(l12);
        l12.setLocation(10,466);
        l12.setSize(145, 20);
        
        JLabel l13 = new JLabel("Name");
        l13.setLocation(10,489);
        l13.setSize(85, 15);
        add(l13);

        tfCompetitorName = new JTextField("");
        tfCompetitorName.setLocation(10,506);
        tfCompetitorName.setSize(85, 25);
        add(tfCompetitorName);

        JLabel colorLbl = new JLabel("Color");
        colorLbl.setLocation(100,489);
        colorLbl.setSize(85, 15);
        add(colorLbl);

        cmbColor = new JComboBox<>(ColorsArray);
        cmbColor.setLocation(100,506);
        cmbColor.setSize(65, 25);
        add(cmbColor);

        JLabel l14 = new JLabel("Age");
        l14.setLocation(10,532);
        l14.setSize(150, 15);
        add(l14);
        
        tfAge = new JTextField("");
        tfAge.setLocation(10,549);
        tfAge.setSize(145, 25);
        add(tfAge);
           
        JLabel l15 = new JLabel("Max speed");
        l15.setLocation(10,577);
        l15.setSize(150, 15);
        add(l15);
        
        tfMaxSpeed = new JTextField("");
        tfMaxSpeed.setLocation(10,594);
        tfMaxSpeed.setSize(145, 25);
        add(tfMaxSpeed);
        
        JLabel l16 = new JLabel("Acceleration");
        l16.setLocation(10,622);
        l16.setSize(150, 15);
        add(l16);
        
        tfAcceleration = new JTextField("");
        tfAcceleration.setLocation(10,639);
        tfAcceleration.setSize(145, 25);
        add(tfAcceleration);
        
        JButton addCompetitorBut = new JButton("Add competitor");
        JButton cloneCompetitorBtn = new JButton("Clone last competitor");
        JButton decorateCompetitorBtn = new JButton("Decorate Competitor");

        addCompetitorBut.setFont(new Font("Arial", Font.PLAIN, 6));
        decorateCompetitorBtn.setFont(new Font("Arial", Font.PLAIN, 6));
        cloneCompetitorBtn.setFont(new Font("Arial", Font.PLAIN, 6));

        addCompetitorBut.setLocation(10,668);
        addCompetitorBut.setSize(50, 25);

        cloneCompetitorBtn.setLocation(65,668);
        cloneCompetitorBtn.setSize(50, 25);

        decorateCompetitorBtn.setLocation(120,668);
        decorateCompetitorBtn.setSize(50, 25);

        addCompetitorBut.addActionListener(this);
        cloneCompetitorBtn.addActionListener(this);
        decorateCompetitorBtn.addActionListener(this);

        add(addCompetitorBut);
        add(cloneCompetitorBtn);
        add(decorateCompetitorBtn);

        JSeparator sep3 = new JSeparator(SwingConstants.HORIZONTAL);
        sep3.setLocation(0,702);
        sep3.setSize(170, 10);
        add(sep3);
      
        //---------------------------------------------

        tfThreads = new JTextField("Num of threads");
        tfThreads.setSize(45,30);
        tfThreads.setLocation(110,708);
        add(tfThreads);
       
        JButton startCompetitionBut = new JButton("Start competition");
        startCompetitionBut.setLocation(10,708);
        startCompetitionBut.setSize(100, 30);
        startCompetitionBut.addActionListener(this);
        add(startCompetitionBut);
        
        JButton printInfoBut = new JButton("Show info");
        printInfoBut.setLocation(10,742);
        printInfoBut.setSize(145, 30);
        printInfoBut.addActionListener(this);
        add(printInfoBut);   
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
               
				case "Build arena":  
                    int arenaLength = arenaPanel.getArenaLength();
                    if (arenaPanel.isCompetitionStarted() && !arenaPanel.isCompetitionFinished()){
                        JOptionPane.showMessageDialog(arenaPanel, "Competition started! Please wait.");
                        return;
                    }
                    try{
                        arenaLength = Integer.parseInt(tfArenaLength.getText());
                        arenaPanel.setArenaLength(arenaLength);
                        if (arenaLength<700 || arenaLength>900) throw new Exception();
                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(arenaPanel, "Invalid input values! Please try again.");
                        return;
                    }                  
                                                        
                    arenaPanel.buildArena((String)cmbArenaSurface.getSelectedItem(),(String)cmbArenaWeather.getSelectedItem(),(String)cmbType.getSelectedItem());
                    break;  
                    
				case "Create competition":
					int maxCompetitors = arenaPanel.getMaxCompetitors();
                    if (arenaPanel.isCompetitionStarted() && !arenaPanel.isCompetitionFinished()){
                        JOptionPane.showMessageDialog(arenaPanel, "Competition started! Please wait.");
                        return;
                    }
                    
                    if (arenaPanel.noArena()){
                        JOptionPane.showMessageDialog(arenaPanel, "Please build arena first!");
                        return;
                    } 
					
                    try{
                        maxCompetitors = Integer.parseInt(tfMaxCompetitors.getText());
                        arenaPanel.setMaxCompetitors(maxCompetitors); 
                        if (maxCompetitors<=0 || maxCompetitors > 20) throw new Exception();
                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(arenaPanel, "Invalid input values! Please try again.");
                        return;
                    }
                    
					try {
						arenaPanel.createCompetition((String)cmbCompetition.getSelectedItem(),(String)cmbDiscipline.getSelectedItem(),
								(String)cmbLeague.getSelectedItem(),(String)cmbGender.getSelectedItem());
					} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		                    
					break;
                    
               case "Add competitor":                 
                    if (arenaPanel.isCompetitionFinished()){
                        JOptionPane.showMessageDialog(arenaPanel, "Competition finished! Please create new competition.");
                        return;
                    }
                    if (arenaPanel.isCompetitionStarted()){
                        JOptionPane.showMessageDialog(arenaPanel, "Competition started! No competitors can be added.");
                        return;
                    }
                    if (arenaPanel.noArena()){
                        JOptionPane.showMessageDialog(arenaPanel, "Please build arena first!");
                        return;
                    }
                    if (arenaPanel.getCompetition() == null) {
                        JOptionPane.showMessageDialog(arenaPanel, "Please create competition first!");
                        return;
                    }
                    if (arenaPanel.fullArena()){
                        JOptionPane.showMessageDialog(arenaPanel, "No more competitors can be added!");
                        return;
                    }
                    String name;
                    double age;
                    double maxSpeed;
                    double acceleration;
                    String color;
                    try {
                        name = tfCompetitorName.getText();
                        age = Double.parseDouble(tfAge.getText());
                        maxSpeed = Double.parseDouble(tfMaxSpeed.getText());
                        acceleration = Double.parseDouble(tfAcceleration.getText());
                        if (name.isEmpty() || maxSpeed <=0 || acceleration <=0 || age<=0) throw new Exception();
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(arenaPanel, "Invalid input values! Please try again.");
                        return;
                    }

					try {
						arenaPanel.addCompetitor(name, age, maxSpeed, acceleration,"Blue");
					} catch (ClassNotFoundException e1) {
						
						e1.printStackTrace();
					} catch (NoSuchMethodException e1) {
						
						e1.printStackTrace();
					} catch (SecurityException e1) {
						
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						
						e1.printStackTrace();
					}
                    break;

            case "Clone last competitor":

                if (arenaPanel.isCompetitionFinished()){
                    JOptionPane.showMessageDialog(arenaPanel, "Competition finished! Please create new competition.");
                    return;
                }
                if (arenaPanel.isCompetitionStarted()){
                    JOptionPane.showMessageDialog(arenaPanel, "Competition started! No competitors can be added.");
                    return;
                }
                if (arenaPanel.noArena()){
                    JOptionPane.showMessageDialog(arenaPanel, "Please build arena first!");
                    return;
                }
                if (arenaPanel.getCompetition() == null) {
                    JOptionPane.showMessageDialog(arenaPanel, "Please create competition first!");
                    return;
                }
                if (arenaPanel.fullArena()){
                    JOptionPane.showMessageDialog(arenaPanel, "No more competitors can be added!");
                    return;
                }
                if(arenaPanel.noCompetitors()){
                    JOptionPane.showMessageDialog(arenaPanel, "Cannot clone. Competitors list is empty!");
                    return;
                }



                CloneFrame cf = new CloneFrame(this.arenaPanel);
                cf.show();


                break;

            case "Decorate Competitor":
                    DecorationFrame  decorationFrame = new DecorationFrame(arenaPanel);
                    decorationFrame.setVisible(true);
                break;
                    
                case "Start competition":
                    
                    if (arenaPanel.noArena() || arenaPanel.getCompetition()==null || arenaPanel.noCompetitors()){
                        JOptionPane.showMessageDialog(arenaPanel, "Please build arena, create competition and add competitors!");
                        return;
                    } 
                    if (arenaPanel.isCompetitionFinished()){
                        JOptionPane.showMessageDialog(arenaPanel, "Competition finished! Please create a new competition and add competitors.");
                        return;
                    }
                    if (arenaPanel.isCompetitionStarted()){
                        JOptionPane.showMessageDialog(arenaPanel, "Competition already started!");
                        return;
                    }
                    try{

                        numOfThreads = 2 ;/*Integer.parseInt(tfThreads.getText());*/
                        if (numOfThreads <= 0){
                            JOptionPane.showMessageDialog(arenaPanel, "Invalid input for threads number. try again.");
                            return;
                        }
                        else if (numOfThreads > arenaPanel.getCompetitors().size()){
                            JOptionPane.showMessageDialog(arenaPanel, "Cannot make more threads then competitors!");
                            return;
                        }
                        else{ //if we got here then numbers of threads is valid.
                            arenaPanel.startRace(numOfThreads);
                        }
                    }catch (Exception exc){
                        exc.printStackTrace();
                    }

                    break;
                    
                case "Show info":
                    
                    if (arenaPanel.noArena() || arenaPanel.getCompetition()==null || arenaPanel.noCompetitors()){
                        JOptionPane.showMessageDialog(arenaPanel, "Please build arena, create competition and add competitors!");
                        return;
                    } 
                    
                    arenaPanel.showInfo();
                    break;
        }
    }

}
