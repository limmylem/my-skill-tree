import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SkillTree {
    public static void main(String[] args) {
        JFrame Main = new JFrame("main");
        Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());


        JButton MenuButton = new JButton("Menu");
        MenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.setVisible(true);
            }
        });
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
                Main.dispose();
                // add the code for the popup menu here
                JPopupMenu popupMenu = new JPopupMenu();
                JMenuItem CreateSkill = new JMenuItem("Create Skill");
                CreateSkill.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String SkillName = JOptionPane.showInputDialog(null, "Enter skill name:");
                        String SkillGoal = JOptionPane.showInputDialog(null, "Enter the skills goal:");
                        String SkillXP = JOptionPane.showInputDialog(null, "Enter the skills XP:");
                        String SkillTime = JOptionPane.showInputDialog(null, "Enter time to complete skill:");
                        String Category = JOptionPane.showInputDialog(null, "Enter the skills category:");
                        if (SkillXP != null) {
                            try {
                                int XPNumber = Integer.parseInt(SkillXP);
                                JOptionPane.showMessageDialog(null, "The skills name is: " + SkillName + "\nThe skills goal is : " + SkillGoal + "\nThe skills XP is: " + XPNumber + "\nThe time to complete the skill is: " + SkillTime + "\nThe skills category is: " + Category);


                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                                CreateSkill();
                            }
                        }
                    }

                });


                JMenuItem CreateChallenge = new JMenuItem("Create Challenge");
                CreateChallenge.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String ChallengeName = JOptionPane.showInputDialog(null, "Enter the challenges name:");
                        String ChallengeGoal = JOptionPane.showInputDialog(null, "Enter the challenges goal:");
                        String ChallengeXP = JOptionPane.showInputDialog(null, "Enter the challenges XP:");
                        if (ChallengeXP != null) {
                            try {
                                int XPNumber = Integer.parseInt(ChallengeXP);
                                JOptionPane.showMessageDialog(null, "The challenges name is: " + ChallengeName + "\nThe challenges goal is : " + ChallengeGoal + "\nThe challenges XP is: " + XPNumber);


                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                                CreateChallenge();
                            }
                        }
                    }
                });
                JMenuItem CreateItem = new JMenuItem("Create Item");
                CreateItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String ItemName = JOptionPane.showInputDialog(null, "Enter the items name:");
                        String ItemEmoji = JOptionPane.showInputDialog(null, "get emojis from https://emojipedia.org\nEnter the skills emoji:");
                        String ItemLink = JOptionPane.showInputDialog(null, "Enter the items Link");
                        JOptionPane.showMessageDialog(null, "The items name is: " + ItemName + "\nThe item emoji is: " + ItemEmoji + "\nThe items link is: " + ItemLink);
                    }
                });
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
                        Main.setVisible(true);
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
        Main.add(panel);
        Main.setVisible(true);
    }
    static void CreateSkill() {
        String SkillName = JOptionPane.showInputDialog(null, "Enter skill name:");
        String XPAmount = JOptionPane.showInputDialog(null, "Enter the skills XP:");
        String TimeAmount = JOptionPane.showInputDialog(null, "Enter time to complete skill:");
        String Category = JOptionPane.showInputDialog(null, "Enter the skills category:");
        if (XPAmount != null) {
            try {
                int XPNumber = Integer.parseInt(XPAmount);
                JOptionPane.showMessageDialog(null, "The skills name is: " + SkillName + "\nThe skills XP is: " + XPNumber + "\nThe time to complete the skill is: " + TimeAmount + "\nThe skills category is: " + Category);


            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                CreateSkill();
            }
        }
    }
    static  void CreateChallenge() {

    }
}
