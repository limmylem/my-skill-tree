import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SkillTree {
    public static void main(String[] args) {
        JFrame frame = new JFrame("main");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton ExitButton = new JButton("Exit");
        ExitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(ExitButton);

        JButton skillTreeButton = new JButton("Skill Tree");
        skillTreeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame skillTreeFrame = new JFrame("Skill Tree");
                skillTreeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                skillTreeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.dispose();
                // add the code for the popup menu here
                JPopupMenu popupMenu = new JPopupMenu();
                JMenuItem CreateSkill = new JMenuItem("Create Skill");
                CreateSkill.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String SkillName = JOptionPane.showInputDialog(null, "Enter skill name:");
                        String XPAmount = JOptionPane.showInputDialog(null, "Enter the skills XP:");
                        String TimeAmount = JOptionPane.showInputDialog(null, "Enter time to complete skill:");
                        String Category = JOptionPane.showInputDialog(null, "Enter the skills category:");
                        if (XPAmount != null) {
                            try {
                                int TimeNumber = Integer.parseInt(TimeAmount);
                                int XPNumber = Integer.parseInt(XPAmount);
                                JOptionPane.showMessageDialog(null, "The skills name is: " + SkillName + "\nThe skills XP is: " + XPNumber + "\nThe time to complete the skill is: " + TimeAmount + "\nThe skills category is: " + Category);

                                // Create a square
                                JFrame skillTreeFrame = null;
                                Frame[] frames = JFrame.getFrames();
                                for (Frame f : frames) {
                                    if (f.getTitle().equals("SkillTreeFrame")) {
                                        skillTreeFrame = (JFrame)f;
                                        break;
                                    }
                                }
                                if (skillTreeFrame != null) {
                                    JPanel panel = new JPanel() {
                                        public void paintComponent(Graphics g) {
                                            super.paintComponent(g);
                                            g.drawRect(50, 50, 100, 100); // Draw a square at (50,50) with width and height of 100 pixels
                                        }
                                    };
                                    skillTreeFrame.getContentPane().add(panel);
                                    skillTreeFrame.validate();
                                    skillTreeFrame.repaint();
                                }
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                                CreateSkill();
                            }
                        }
                    }

                });


                JMenuItem CreateChallenge = new JMenuItem("Create Challenge");
                JMenuItem CreateItem = new JMenuItem("Create Item");
                JMenuItem CreateNewTree = new JMenuItem("Create new skill tree");
                CreateNewTree.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String TreeName = JOptionPane.showInputDialog(null, "Enter skill tree name:");
                        JFrame NewSkillTree = new JFrame(TreeName);
                        NewSkillTree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        NewSkillTree.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        NewSkillTree.setVisible(true);
                        NewSkillTree.addMouseListener(new MouseAdapter() {
                            public void mousePressed(MouseEvent e) {
                                if (SwingUtilities.isRightMouseButton(e)) {
                                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                                }
                            }
                        });
                    }
                });
                popupMenu.add(CreateSkill);
                popupMenu.add(CreateChallenge);
                popupMenu.add(CreateItem);
                popupMenu.add(CreateNewTree);

                skillTreeFrame.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            popupMenu.show(e.getComponent(), e.getX(), e.getY());
                        }
                    }
                });

                JButton skillTreeExitButton = new JButton("Exit Skill Tree");
                skillTreeExitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        skillTreeFrame.dispose();
                        frame.setVisible(true);
                    }
                });
                JPanel skillTreePanel = new JPanel();
                skillTreePanel.setLayout(new FlowLayout());
                skillTreePanel.add(skillTreeExitButton);
                skillTreeFrame.add(skillTreePanel);

                skillTreeFrame.pack();
                skillTreeFrame.setVisible(true);
            }
        });

        panel.add(skillTreeButton);
        frame.add(panel);
        frame.setVisible(true);
    }
    static void CreateSkill() {
        String SkillName = JOptionPane.showInputDialog(null, "Enter skill name:");
        String XPAmount = JOptionPane.showInputDialog(null, "Enter the skills XP:");
        String TimeAmount = JOptionPane.showInputDialog(null, "Enter time to complete skill:");
        String Category = JOptionPane.showInputDialog(null, "Enter the skills category:");
        if (XPAmount != null) {
            try {
                int TimeNumber = Integer.parseInt(TimeAmount);
                int XPNumber = Integer.parseInt(XPAmount);
                JOptionPane.showMessageDialog(null, "The skills name is: " + SkillName + "\nThe skills XP is: " + XPNumber + "\nThe time to complete the skill is: " + TimeAmount + "\nThe skills category is: " + Category);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                CreateSkill();
            }
        }
    }
}
