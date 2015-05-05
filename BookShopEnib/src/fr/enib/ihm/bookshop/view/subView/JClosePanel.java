/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.view.subView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;

/**
 *
 * @author Yoann
 */
public class JClosePanel extends JPanel {
    private ImageIcon closeXIcon;
    private Dimension closeButtonSize;
    //private JPanel contentPanel;
    /* Constructeur */
    public JClosePanel(String title, JTabbedPane tabbedPane, JPanel panelName) {
        super();                                // JPanel
        this.setOpaque(false);                  // Transparence
        final JPanel content = panelName;       //Necessaire d'avoir un panel final
        final JTabbedPane tabbePanel = tabbedPane;
        //contentPanel = content;
        JLabel tabLabel = new JLabel(title);    // Label du tabButton
        tabLabel.setForeground(Color.lightGray);
        /* Bouton de fermeture du panneau */
        // -- Icon
        closeXIcon =
                new javax.swing.ImageIcon(getClass().getResource("/ressources/images/CloseX.gif"));
        // -- Size
        closeButtonSize = new Dimension(
                closeXIcon.getIconWidth()+2,
                closeXIcon.getIconHeight()+2);
        // -- Look & Feel du bouton.
        JButton tabCloseButton = new JButton(closeXIcon);
        tabCloseButton.setToolTipText("Close the tab " + title);
        tabCloseButton.setBorderPainted(false);
        tabCloseButton.setOpaque(true);
        tabCloseButton.setPreferredSize(closeButtonSize);
        tabCloseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int closeTabNumber = tabbePanel.indexOfComponent(content);
                tabbePanel.removeTabAt(closeTabNumber);
            }

        });
        /* Propriétés du JPanel */
        this.setName(title);     // Pour le différencier des autres...
        content.setName(title);  // ... et éviter les doublons
        /* Placement et intégration au JTabbedPane */
        content.setBackground(Color.decode("#cfdaf1"));
        this.add(tabLabel, BorderLayout.WEST);
        this.add(tabCloseButton, BorderLayout.EAST);
        tabbedPane.addTab(null, content);
        tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, this);

        final JPopupMenu jPop = new JPopupMenu();
        jPop.add(new AbstractAction("Close all tabs") {
            public void actionPerformed(ActionEvent e) {                
                for (int i = tabbePanel.getTabCount() - 1; i > 0; i--) {
                    tabbePanel.remove(i);
                }
            }
        });
        jPop.add(new AbstractAction("Close all other tabs") {
            public void actionPerformed(ActionEvent e) {                
                for (int i = tabbePanel.getTabCount() - 1; i > 0; i--) {
                    if(i != tabbePanel.getSelectedIndex())
                        tabbePanel.remove(i);
                }
            }
        });
        tabbePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ev) {
                if (ev.getButton() == ev.BUTTON3) {
                    jPop.show(ev.getComponent(), ev.getX(), ev.getY());
                }
            }
        });
    }
}
