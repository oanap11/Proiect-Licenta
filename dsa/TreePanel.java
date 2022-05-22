package dsa;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

public class TreePanel extends javax.swing.JPanel {
	
    private JButton bstDelButton;
    private JTextField bstDelText;
    private JButton bstInsertButton;
    private JTextField bstInsertText;
    private JPanel bstNorthPanel;
    private JPanel bstPanel;
    private JSlider bstSlider;
    private JPanel bstSouthPanel;
    private JSeparator jSeparator3;
    private JPanel treeCenterPanel;
    private JTabbedPane treePane;
    
    JTextField bstFindText;
    JButton bstFindButton;
    
    TreeComponent comp;
    GraphicalTree gt;
    public TreePanel() {
        initComponents();
        comp = new TreeComponent();
        bstPanel.add(comp,BorderLayout.CENTER);
        gt = new GraphicalTree();
    }

    private void initComponents() {

        treeCenterPanel = new JPanel();
        treePane = new JTabbedPane();
        bstPanel = new JPanel();
        bstNorthPanel = new JPanel();
        bstInsertButton = new JButton();
        bstDelButton = new JButton();
        bstInsertText = new JTextField();
        bstDelText = new JTextField();
        bstSouthPanel = new JPanel();
        bstSlider = new JSlider();
        
        bstFindText = new JTextField();
        bstFindButton = new JButton();

        jSeparator3 = new JSeparator();

        setLayout(new BorderLayout());

        treeCenterPanel.setLayout(new BoxLayout(treeCenterPanel, BoxLayout.LINE_AXIS));

        bstPanel.setBackground(new Color(254, 254, 254));
        bstPanel.setLayout(new BorderLayout());

        bstInsertButton.setText("Insereaza element");
        bstInsertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bstInsertButtonActionPerformed(evt);
            }
        });

        bstDelButton.setText("Sterge element");
        bstDelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bstDelButtonActionPerformed(evt);
            }
        });

        bstInsertText.setColumns(10);
        bstInsertText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bstInsertTextActionPerformed(evt);
            }
        });
        bstInsertText.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                bstInsertTextKeyPressed(evt);
            }
        });

        bstDelText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bstDelTextActionPerformed(evt);
            }
        });

        GroupLayout bstNorthPanelLayout = new GroupLayout(bstNorthPanel);
        bstNorthPanel.setLayout(bstNorthPanelLayout);

        bstNorthPanelLayout.setHorizontalGroup(
            bstNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bstNorthPanelLayout.createSequentialGroup()
            	.addContainerGap()
                .addComponent(bstInsertText, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bstInsertButton)
                .addGap(24, 24, 24)
                .addComponent(bstDelText, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bstDelButton)
                .addGap(30, 30, 30)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addContainerGap(172, Short.MAX_VALUE))
                
        );

        bstNorthPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {bstDelText, bstInsertText});

        bstNorthPanelLayout.setVerticalGroup(
            bstNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bstNorthPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bstNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bstInsertButton)
                    .addComponent(bstDelButton)
                    .addComponent(bstInsertText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bstDelText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bstPanel.add(bstNorthPanel, BorderLayout.NORTH);

        bstSlider.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(), "Animation Speed", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 0, 12), new java.awt.Color(222, 29, 29))); // NOI18N

        bstSouthPanel.setBackground(new Color(255, 87, 51));
        bstSouthPanel.setPreferredSize(new Dimension(100, 100));
        bstPanel.add(bstSouthPanel, BorderLayout.SOUTH);

        treePane.addTab("Arbore binar de cautare", bstPanel);

        treeCenterPanel.add(treePane);

        add(treeCenterPanel, BorderLayout.CENTER);
    }
    private void bstInsertTextActionPerformed(ActionEvent evt) {      
    }

    private void bstDelButtonActionPerformed(ActionEvent evt) {
        bstInsertButton.setEnabled(false);
        bstDelButton.setEnabled(false);
        
        comp.setValues(gt,'d', bstDelText.getText());
        bstDelText.setText("");
        
        bstInsertButton.setEnabled(true);
        bstDelButton.setEnabled(true);
    }

    private void bstDelTextActionPerformed(ActionEvent evt) {}

    private void bstRunButtonActionPerformed(ActionEvent evt) {}

    private void bstInsertButtonActionPerformed(ActionEvent evt) {
        bstInsertButton.setEnabled(false);
        bstDelButton.setEnabled(false);
        
        comp.setValues(gt,'i', bstInsertText.getText());
        bstInsertText.setText("");
        
        bstInsertButton.setEnabled(true);
        bstDelButton.setEnabled(true);
    }

    private void bstInsertTextKeyPressed(KeyEvent evt) {
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
	        bstInsertButton.setEnabled(false);
	        bstDelButton.setEnabled(false);
	        
	        comp.setValues(gt,'i', bstInsertText.getText());
	        bstInsertText.setText("");
	        
	        bstInsertButton.setEnabled(true);
	        bstDelButton.setEnabled(true);

       }
    }


}
