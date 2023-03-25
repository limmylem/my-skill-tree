import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SkillTree {

    public static void main(String[] args) {
        JFrame Main = new JFrame("main");
        Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Main.setVisible(true);

        JPanel MainPanel = new JPanel();
        MainPanel.setLayout(new FlowLayout());
        JButton ExitButton = new JButton("Exit");
        ExitButton.addActionListener(e -> System.exit(0));

        MainPanel.add(ExitButton);

        JButton skillTreeButton = new JButton("Skill Tree");
        skillTreeButton.addActionListener(e -> {
            JFrame SkillTreeFrame = new JFrame("Skill Tree");
            SkillTreeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            SkillTreeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            Main.dispose();

            JMenuBar MenuBar = new JMenuBar();

            JMenu FileMenu = new JMenu("file");
            JMenu EditMenu = new JMenu("Edit");

            JMenu ExitMenu = new JMenu("Exit");

            JMenuItem ExitBarButton = new JMenuItem("exit");
            ExitBarButton.addActionListener(e1 -> {
                SkillTreeFrame.dispose();
                Main.setVisible(true);
            });

            JMenuItem NewTree = new JMenuItem("new tree");
            NewTree.addActionListener(e16 -> {
                String TreeName = JOptionPane.showInputDialog(null, "Enter skill tree name:");
                JFrame NewSkillTree = new JFrame(TreeName);
                NewSkillTree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                NewSkillTree.setExtendedState(JFrame.MAXIMIZED_BOTH);
                NewSkillTree.setVisible(true);
                JPanel SkillTreePanel = new JPanel();
                SkillTreePanel.setLayout(new FlowLayout());
                SkillTreeFrame.dispose();
            });

            MenuBar.add(FileMenu);
            MenuBar.add(EditMenu);
            MenuBar.add(ExitMenu);

            SkillTreeFrame.setJMenuBar(MenuBar);

            FileMenu.add(NewTree);
            ExitMenu.add(ExitBarButton);


            JPopupMenu popupMenu = new JPopupMenu();
            JMenuItem CreateSkill = new JMenuItem("Create Skill");
            CreateSkill.addActionListener(e1 -> {
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
            });


            JMenuItem CreateChallenge = new JMenuItem("Create Challenge");
            CreateChallenge.addActionListener(e12 -> {
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
            });
            JMenuItem CreateItem = new JMenuItem("Create Item");
            CreateItem.addActionListener(e13 -> {
                String ItemName = JOptionPane.showInputDialog(null, "Enter the items name:");
                String ItemEmoji = JOptionPane.showInputDialog(null, "get emojis from https://emojipedia.org\nEnter the items emoji:");
                String ItemLink = JOptionPane.showInputDialog(null, "Enter the items Link");
                JOptionPane.showMessageDialog(null, "The items name is: " + ItemName + "\nThe item emoji is: " + ItemEmoji + "\nThe items link is: " + ItemLink);
            });
            JMenuItem CreateNewTree = new JMenuItem("Create new skill tree");
            CreateNewTree.addActionListener(e14 -> {
                String TreeName = JOptionPane.showInputDialog(null, "Enter skill tree name:");
                JFrame NewSkillTree = new JFrame(TreeName);
                NewSkillTree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                NewSkillTree.setExtendedState(JFrame.MAXIMIZED_BOTH);
                NewSkillTree.setVisible(true);

                JPanel SkillTreePanel = new JPanel();
                SkillTreePanel.setLayout(new FlowLayout());

                SkillTreeFrame.dispose();

                JButton MenuButton = new JButton("Menu");
                MenuButton.addActionListener(e141 -> {
                    NewSkillTree.setVisible(false);
                    Main.setVisible(true);
                });
                SkillTreePanel.add(MenuButton);
                NewSkillTree.add(SkillTreePanel);
                NewSkillTree.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            // Show the popup menu
                            popupMenu.show(e.getComponent(), e.getX(), e.getY());
                            System.out.println("Mouse clicked on NewSkillTree");
                        }
                    }
                });
            });
            popupMenu.add(CreateSkill);
            popupMenu.add(CreateChallenge);
            popupMenu.add(CreateItem);
            popupMenu.add(CreateNewTree);

            SkillTreeFrame.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        popupMenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            });

            JPanel skillTreePanel = new JPanel();
            skillTreePanel.setLayout(new FlowLayout());
            SkillTreeFrame.add(skillTreePanel);

            SkillTreeFrame.pack();
            SkillTreeFrame.setVisible(true);
        });

        MainPanel.add(skillTreeButton);
        Main.add(MainPanel);
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
}
