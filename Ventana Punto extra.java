package org.example;

import javax.imageio.ImageIO;
import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class Ventana extends JFrame{
        private JPanel panel1;
        private JButton botonPanel1;
        private JLabel etiquetaPanel1;
        private JPanel panel2;
        private JLabel etiquetaPanel2;
        private JPanel panel3;
        private JComboBox<String> comboBoxPanel3;
        private JPanel panel4;
        private GridLayout layout;

        public Ventana(String title) throws HeadlessException {
            super(title);
            this.setSize(800, 600);
            layout = new GridLayout(2, 2);
            this.getContentPane().setLayout(layout);

            //Panel 1
            panel1 = new JPanel();
            panel1.setBackground(new Color(253, 255, 103));
            panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
            botonPanel1 = new JButton("Presioname");
            panel1.add(botonPanel1);
            etiquetaPanel1 = new JLabel("....");
            panel1.add(etiquetaPanel1);
            botonPanel1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    etiquetaPanel1.setText("Hola, precinaste el boton del panel 1");
                }
            });
            this.getContentPane().add(panel1, 0);


            //Panel 2
            String urlImagen = "https://e-cdn-images.dzcdn.net/images/cover/5481b92f28a77bbd669abe1648fdb38b/256x256-000000-80-0-0.jpg";
            panel2 = new JPanel();
            panel2.setBackground(new Color(117, 255, 103));
            panel2.setLayout(new FlowLayout());
            //carganfo imagen

            try {
                URL url = new URL(urlImagen);
                Image imagen = ImageIO.read(url);
                ImageIcon imageIcon = new ImageIcon(imagen);
                etiquetaPanel2 = new JLabel(imageIcon);
                panel2.add(etiquetaPanel2);
                this.getContentPane().add(panel2, 1);
            } catch (MalformedURLException me) {
                System.out.println("URL no valida");
            } catch (Exception e) {
                System.out.println("Error al cargar la imagen");
            }


            //Panel 3
            panel3 = new JPanel();
            panel3.setBackground(new Color(101, 232, 255));

            panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
            String[] elementos = {"Opcion 1","Opcion 2","Opcion 3","Opcion 4"};
            comboBoxPanel3 = new JComboBox<>(elementos);
            comboBoxPanel3.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(e.paramString().toString() );
                    System.out.println(comboBoxPanel3.getSelectedIndex());
                }
            });
            panel3.add(comboBoxPanel3);
            this.getContentPane().add(panel3, 2);

            //Panel 4
            panel4 = new JPanel();
            panel4.setBackground(new Color(178, 101, 255));
            this.getContentPane().add(panel4, 3);


            this.setVisible(true);
        }
    }
