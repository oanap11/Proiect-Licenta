package dsa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;


public class ListPanel extends javax.swing.JPanel {

    ListComponent listComponent;
    SinglyCircular singlyCircular;

    SingleLinkedList listA, listCircular;

    private JButton deleteButtonList, deleteButtonCircular;
    private JSeparator jSeparator3, jSeparator7, jSeparator8, jSeparator9;
    private JTabbedPane lsitPane;
    private JTextField singlyListDelField, circularListDelField;
    private JPanel singlyCircularPanel;

    private JPanel singlyListNorthPanel;
    private JPanel singlyListSouthPanel;
    private JPanel singlyCircularNorthPanel;
    private JPanel singlyCircularSouthPanel;
    private JPanel singlyListPanel;

    private JSlider singlySlider;
    private JSlider singlySlider1;

    private JButton singlyaddButton;
    private JButton singlyaddButton1;
    private JTextField singlyaddNodeText;
    private JTextField circularAddNodeField;
    
    public ListPanel() {
	        initComponents();
	        
	        singlyCircular = new SinglyCircular();
	        listComponent = new ListComponent();
	        
	        singlyListPanel.add(listComponent,BorderLayout.CENTER);
	        singlyCircularPanel.add(singlyCircular,BorderLayout.CENTER);
	
	        
	        listA = new SingleLinkedList();
	        listCircular = new SingleLinkedList();
	        
	        listComponent.setValues(listA, 0);
	        singlyCircular.setValues(listCircular, 0);
	
	        
	        singlyListPanel.revalidate();
	        singlyCircularPanel.revalidate();
	        
    }

        private void initComponents() {

        lsitPane = new JTabbedPane();
        singlyListPanel =  new JPanel() {
            public void paint(Graphics g)
            {
                super.paint(g);

            }

        };
        singlyListNorthPanel = new JPanel();
        singlyListSouthPanel = new JPanel();
        singlyaddNodeText = new JTextField();
        singlyaddButton = new JButton();
        singlyListDelField = new JTextField();
        deleteButtonList = new JButton();
        
        singlySlider = new JSlider();
        
        jSeparator3 = new JSeparator();
        singlyCircularPanel = new JPanel();
        singlyCircularNorthPanel = new JPanel();
        singlyCircularSouthPanel = new JPanel();
        circularAddNodeField = new JTextField();
        singlyaddButton1 = new JButton();
        circularListDelField = new JTextField();
        deleteButtonCircular = new JButton();
        
        singlySlider1 = new JSlider();
        
        jSeparator7 = new JSeparator();
        jSeparator8 = new JSeparator();
        jSeparator9 = new JSeparator();
       

        setLayout(new BorderLayout());

        singlyListPanel.setBackground(Color.white);
        singlyListPanel.setLayout(new BorderLayout());

        singlyaddNodeText.setColumns(5);
        singlyaddNodeText.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                singlyaddNodeTextKeyPressed(evt);
            }
        });

        singlyaddButton.setText("Insereaza");
        singlyaddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                singlyaddButtonActionPerformed(evt);
            }
        });

        singlyListDelField.setColumns(5);
        singlyListDelField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                singlyListDelFieldActionPerformed(evt);
            }
        });
        singlyListDelField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                singlyListDelFieldKeyPressed(evt);
            }
        });

        deleteButtonList.setBackground(Color.white);
        deleteButtonList.setText("Sterge");
        deleteButtonList.setFocusable(false);
        deleteButtonList.setHorizontalTextPosition(SwingConstants.CENTER);
        deleteButtonList.setVerticalTextPosition(SwingConstants.BOTTOM);
        deleteButtonList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        GroupLayout singlyListNorthPanelLayout = new GroupLayout(singlyListNorthPanel);
        singlyListNorthPanel.setLayout(singlyListNorthPanelLayout);
        singlyListNorthPanelLayout.setHorizontalGroup(
            singlyListNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(singlyListNorthPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGap(18, 18, 18)
                .addComponent(singlyaddNodeText, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(singlyaddButton, 0, GroupLayout.DEFAULT_SIZE, 150)
                .addGap(35, 35, 35)
                .addComponent(singlyListDelField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButtonList)
                .addContainerGap(304, Short.MAX_VALUE))
        );
        singlyListNorthPanelLayout.setVerticalGroup(
            singlyListNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(singlyListNorthPanelLayout.createSequentialGroup()
                .addGroup(singlyListNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(singlyListNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(singlyaddButton)
                        .addComponent(singlyaddNodeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(singlyListDelField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(deleteButtonList))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        singlyListPanel.add(singlyListNorthPanel, BorderLayout.NORTH);
        singlyListSouthPanel.setBackground(new Color(255, 87, 51));
        singlyListSouthPanel.setPreferredSize(new Dimension(100, 100));
        singlyListPanel.add(singlyListSouthPanel, BorderLayout.SOUTH);

        singlySlider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(), "Animation Speed", TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 0, 12), new java.awt.Color(222, 29, 29))); // NOI18N

        lsitPane.addTab("Lista simplu inlantuita", singlyListPanel);

        singlyCircularPanel.setBackground(new Color(254, 254, 254));
        singlyCircularPanel.setLayout(new BorderLayout());

        circularAddNodeField.setColumns(5);
        circularAddNodeField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                circularAddNodeFieldKeyPressed(evt);
            }
        });

        singlyaddButton1.setText("Adauga element");
        singlyaddButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                singlyaddButton1ActionPerformed(evt);
            }
        });

        circularListDelField.setColumns(5);
        circularListDelField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                circularListDelFieldKeyPressed(evt);
            }
        });

        deleteButtonCircular.setBackground(Color.white);
        deleteButtonCircular.setText("Sterge element");
        deleteButtonCircular.setFocusable(false);
        deleteButtonCircular.setHorizontalTextPosition(SwingConstants.CENTER);
        deleteButtonCircular.setVerticalTextPosition(SwingConstants.BOTTOM);
        deleteButtonCircular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        GroupLayout singlyCircularNorthPanelLayout = new GroupLayout(singlyCircularNorthPanel);
        singlyCircularNorthPanel.setLayout(singlyCircularNorthPanelLayout);
        singlyCircularNorthPanelLayout.setHorizontalGroup(
            singlyCircularNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(singlyCircularNorthPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGap(18, 18, 18)
                .addComponent(circularAddNodeField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(singlyaddButton1, 0, GroupLayout.DEFAULT_SIZE, 200)
                .addGap(41, 41, 41)
                .addComponent(circularListDelField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButtonCircular, 0, GroupLayout.DEFAULT_SIZE, 200)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        singlyCircularNorthPanelLayout.setVerticalGroup(
            singlyCircularNorthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, singlyCircularNorthPanelLayout.createSequentialGroup()
                .addGroup(singlyCircularNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(singlyCircularNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(singlyaddButton1)
                        .addComponent(circularAddNodeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(circularListDelField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(deleteButtonCircular))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        singlyCircularPanel.add(singlyCircularNorthPanel, BorderLayout.NORTH);
        singlyCircularSouthPanel.setBackground(new Color(255, 87, 51));
        singlyCircularSouthPanel.setPreferredSize(new Dimension(100, 100));
        singlyCircularPanel.add(singlyCircularSouthPanel, BorderLayout.SOUTH);
        

        singlySlider1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(), "Animation Speed", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 0, 12), new java.awt.Color(222, 29, 29))); // NOI18N

        lsitPane.addTab("Lista circulara simplu inlantuita", singlyCircularPanel);
        add(lsitPane, BorderLayout.CENTER);
    }

    
    //eveniment la apasarea butonului de inserare pentru a adauga elemente lista simplu inlantuita
    private void singlyaddButtonActionPerformed(ActionEvent evt) {
        listA.insert(Integer.parseInt(singlyaddNodeText.getText()));
        listComponent.setValues(listA, 1);
        singlyaddNodeText.setText("");
    }
    
    //eveniment la apasarea butonului de inserare pentru a adauga elemente lista circulara simplu inlantuita
    private void singlyaddButton1ActionPerformed(ActionEvent evt) {
        listCircular.insert(Integer.parseInt(circularAddNodeField.getText()));
        singlyCircular.setValues(listCircular, 1);
        circularAddNodeField.setText("");
    }
 
    //eveniment la apasarea butonului de stergere pentru a scoate elemente din lista simplu inlantuita
    private void deleteButtonActionPerformed(ActionEvent evt) {
        if(listA.delete(Integer.parseInt(singlyListDelField.getText())) == null){
        	JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
        }
        else {
            singlyListDelField.setText("");
        }
        listComponent.setValues(listA,0);
    }
    
  //eveniment la apasarea tastei Enter pentru adaugarea de elemente in lista simplu inlantuita
    private void singlyaddNodeTextKeyPressed(KeyEvent evt) {
    	if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
	        listA.insert(Integer.parseInt(singlyaddNodeText.getText()));
	        listComponent.setValues(listA, 1);
	        singlyaddNodeText.setText("");
    	}       
    }

    //eveniment la apasarea butonului de stergere elemente in lista circulara simplu inlantuita
    private void jButton37ActionPerformed(ActionEvent evt) {
         if(listCircular.delete(Integer.parseInt(circularListDelField.getText())) == null){
        	 JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
        }
        else {
            circularListDelField.setText("");
        }
        singlyCircular.setValues(listCircular, 0);
    }
    
	//eveniment la apasarea tastei Enter pentru adaugarea de elemente in lista circulara simplu inlantuita
    private void circularAddNodeFieldKeyPressed(KeyEvent evt) {
    	if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            listCircular.insert(Integer.parseInt(circularAddNodeField.getText()));
            singlyCircular.setValues(listCircular, 1);
            circularAddNodeField.setText("");
       }
    }
    
  //eveniment la apasarea tastei Enter pentru stergerea de elemente in lista circulara simplu inlantuita
    private void circularListDelFieldKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          if(listCircular.delete(Integer.parseInt(circularListDelField.getText())) == null){
        	  JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
        }
        else {
            circularListDelField.setText("");
        }
        singlyCircular.setValues(listCircular, 0);
       }
    
    }
    
    //eveniment la apasarea tastei Enter pentru stergerea de elemente in lista simplu inlantuita
    private void singlyListDelFieldKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           if(listA.delete(Integer.parseInt(singlyListDelField.getText())) == null){
        	  JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
        }
        else {
            singlyListDelField.setText("");
        }
        listComponent.setValues(listA, 0);
       }
    }

    private void singlyListDelFieldActionPerformed(ActionEvent evt) {}
       
}
