///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
// */
//package gui;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextPane;
//import javax.swing.border.EmptyBorder;
//import modelo.Dijkstra;
//import modelo.Grafo;
//import modelo.Vertice;
//import repositorio.Repositorio;
//
///**
// *
// * @author luann
// */
//public class ConfiguracoesMapa extends javax.swing.JFrame {
//
//    private List<JLabel> listaPontos = new ArrayList<>();
//    private JLabel barco;
//    private JLabel mapa;
//    private JPanel panelMapa;
//    private int cliques;
//    private int count = 0;
//    private JPanel conteudoTela;
//    private JTextPane log;
//    private Vertice origem = null;
//    private Grafo grafo;
//    private Repositorio repositorio = new Repositorio();
//
//    public void inicializar() throws FileNotFoundException {
//        grafo = repositorio.lerArquivos();
//        Grafo g = repositorio.lerArquivos();
//        Dijkstra d = new Dijkstra(g, g.getVertices().get(0));
//    }
//
//    public ConfiguracoesMapa() throws FileNotFoundException {
//
//        inicializar();
//        initComponents();
//        try {
//            //criando mapa
//            mapa = (new JLabel(new ImageIcon(ImageIO.read(new File("src/resource/img/mapa.jpg")))));
//            mapa.setVisible(true);
//
//            //criando barco
//            barco = (new JLabel(new ImageIcon(ImageIO.read(new File("src/resource/img/gartic.png")))));
//            barco.setVisible(false);
//            //mapa.setBorder(new EmptyBorder(0,0,0,0));
//            //tela para abrir o main ficara aqui
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        this.pack();
//        this.setVisible(true);
//
//        //instancia do JPanel que contem todass imagens
//        grafico = new JPanel();
//
//        //configuracoes JFrame
//        setTitle("<<GPS One Piece>>");
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setBounds(100, 100, 1162, 651);
//
//        this.grafico.add(mapa);
//        barco.setBounds(25, 25, 100, 100);
//        this.grafico.add(barco);
//        grafico.setVisible(true);
//
//        //conteudo generico da tela, configuracoes etc
//        conteudoTela = new JPanel();
//        conteudoTela.setBackground(new Color(255, 255, 255));
//
//        panelMapa = new JPanel();
//        panelMapa.setBounds(0, 0, 959, 625);
//        conteudoTela.add(panelMapa);
//        
//        log = new JTextPane();
//        log.setFont(new Font("Tahoma", Font.PLAIN, 7));
//        log.setForeground(Color.BLACK);
//        log.setBackground(Color.WHITE);
//        log.setBounds(969, 54, 64, 563);
//        conteudoTela.add(log);
//        
//        
//        
//        conteudoTela.addMouseListener(new MouseAdapter() {
//
//            public void mouseClicked(MouseEvent arg0) {
//                //ponto do clique do usuario
//                if (cliques < 2) {
//                    try {
//                        pontoXY(arg0);
//                    } catch (IOException ex) {
//                        Logger.getLogger(JFrameMapa.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    cliques++;
//                }
//            }
//        });
//
//        conteudoTela.setBorder(new EmptyBorder(0, 0, 0, 0));
//        conteudoTela.setVisible(true);
//        setContentPane(conteudoTela);
//
//        //configuracoes do JPanel que contem todas imagens
//        grafico.setLocation(0, 0);
//        //grafico.setBorder(new EmptyBorder(0, 0, 0, 0));
//
//        conteudoTela.add(grafico);
//
//        //configurando barco
//    }
//
//    private void pontoXY(MouseEvent ponto) throws IOException {
//        //pegar as cordanadas x e y do clique
//        int x = ponto.getX();
//        int y = ponto.getY();
//
//        //criar varuaveus para calcular o ponto mais proximo do clique do usuario
//        double distancia = 0;
//        double menorDistancia = Double.POSITIVE_INFINITY;
//
//        //vertice que o user selecionou
//        Vertice vertice = null;
//
//        //calcular vertice mais próximo do clique
//        for (v : grafo.getArestas()) {
//            distancia = Math.sqrt(Math.pow((v.getX() - x), 2) + Math.pow((v.getY() - y), 2));
//            System.out.println(v);
//            if (menorDistancia > distancia) {
//                menorDistancia = distancia;
//                //Caso o vertice for menor que o anterior atribui para o objeto vertice
//                vertice = v;
//            }
//        }
//        //caso o vertice de saida seja nulo, seleciona o barco
//        if (origem == null) {
//            barco.setBounds(vertice.getX() - 38, vertice.getY() - 93, 100, 100);
//            barco.setVisible(true);
//            origem = vertice;
//            vertice.getPontoMapa().setIcon(new ImageIcon(ImageIO.read(new File("src/resource/img/azul.png"))));
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
//    private void initComponents() {
//
//        grafico = new javax.swing.JPanel();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        javax.swing.GroupLayout graficoLayout = new javax.swing.GroupLayout(grafico);
//        grafico.setLayout(graficoLayout);
//        graficoLayout.setHorizontalGroup(
//                graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 100, Short.MAX_VALUE)
//        );
//        graficoLayout.setVerticalGroup(
//                graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addGap(197, 197, 197)
//                                .addComponent(grafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(907, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addGap(143, 143, 143)
//                                .addComponent(grafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(397, Short.MAX_VALUE))
//        );
//
//        pack();
//    }// </editor-fold>                        
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JFrameMapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JFrameMapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JFrameMapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JFrameMapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new JFrameMapa().setVisible(true);
//                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(JFrameMapa.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }
//
//    // Variables declaration - do not modify                     
//    private javax.swing.JPanel grafico;
//    // End of variables declaration                   
//}
