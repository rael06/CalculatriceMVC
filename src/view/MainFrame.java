package view;

import controller.Controlleur;
import utils.MyObserver;
import utils.Result;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame implements MyObserver<Result> {
    private static MainFrame instance;
    private Controlleur controlleur = Controlleur.getInstance();
    private JButton calculerBouton;
    private JButton resetBouton;
    private JTextField ecran;

    private MainFrame() {
    }

    public static MainFrame getInstance() {
        return instance = instance == null ? new MainFrame() : instance;
    }

    public void start() {
        init();
        initListeners();
    }

    private void init() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 400));
        ecran = new JTextField(10);
        calculerBouton = new JButton("calculer");
        resetBouton = new JButton("reset");
        setButtonsProps(calculerBouton);
        setButtonsProps(resetBouton);

        gbc.weightx = 1;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridy = 0;
        gbc.weighty = 1;
        add(ecran, gbc);
        gbc.weighty = 0;
        gbc.gridy++;
        add(calculerBouton, gbc);
        gbc.gridy++;
        add(resetBouton, gbc);
        gbc.gridy++;
        gbc.weighty = 1;
        add(new JLabel(), gbc);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void setButtonsProps(JButton bouton) {
        bouton.setForeground(Color.WHITE);
        bouton.setBackground(Color.RED);
    }

    private void initListeners() {
        calculerBouton.addActionListener(this::calculActionButton);
        resetBouton.addActionListener(this::resetActionButton);
        ecran.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    calcul();
                }
                if(e.getKeyChar() == KeyEvent.VK_ESCAPE){
                    reset();
                }
            }
        });
    }

    private void calculActionButton(ActionEvent e) {
        calcul();
    }

    private void calcul() {
        String saisie = ecran.getText();
        controlleur.calculer(saisie);
    }

    private void resetActionButton(ActionEvent e) {
        ecran.setText("");
    }

    private void reset() {
        ecran.setText("");
    }

    @Override
    public void update(Result result) {
        if (result.isError()) {
            ecran.setText("ERROR");
        } else {
            String resultat = result.getOperationResult() + "";
            ecran.setText(resultat);
        }
    }
}
