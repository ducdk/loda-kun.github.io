/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.loda.postmaker.ui;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import vn.loda.postmaker.model.PostMaker;
import vn.loda.postmaker.util.PostHelper;

/**
 * @author namhn
 */
public class Gui extends javax.swing.JFrame {

    private final String APP_NAME = "Post Maker";

    PostMaker maker;

    /**
     * Creates new form App
     */
    public Gui() {
        this.setTitle(APP_NAME);

        initComponents();
        initData();
    }

    public void initData() {
        clearAll();
        maker = new PostMaker();
        tvAuthor.setText("loda");
        tv_Post.setText("./_posts/");
        tv_Images.setText("./assets/images/");
        lbCurrentInstance.setText("Current Instance: " + maker.id());
        textAreaOutput.setEditable(false);
    }

    /**
     * Clear all data in gui
     */
    public void clearAll() {
        tvAuthor.setText("");
        tvCategories.setText("");
        tvDescription.setText("");
        tvImage.setText("");
        tvTitle.setText("");
        tvRating.setText("0.0");
        textArea.setText("");
        textAreaOutput.setText("");

    }

    private boolean isValid = true;

    /**
     * assert that don't have any text view is empty
     */
    private void assertTextViewNotEmpty() {
        for (Component c : ((javax.swing.JPanel) tvAuthor.getParent()).getComponents()) {
            if (c instanceof JTextField) {
                JTextField tf = (JTextField) c;
                if (null == tf || tf.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "There are some field are empty");
                    throw new RuntimeException("There are some field are empty");
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tvTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tvDescription = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tvCategories = new javax.swing.JTextField();
        cbFeatured = new javax.swing.JCheckBox();
        cbHidden = new javax.swing.JCheckBox();
        tvRating = new javax.swing.JTextField();
        tvAuthor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tvImage = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnGenerate = new javax.swing.JButton();
        lbCurrentInstance = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tv_Post = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tv_Images = new javax.swing.JTextField();
        btnDownload = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tvFolderId = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaOutput = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Author");

        jLabel2.setText("Title");

        jLabel3.setText("Description");

        tvDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvDescriptionActionPerformed(evt);
            }
        });

        jLabel4.setText("Categories");

        cbFeatured.setText("featured");
        cbFeatured.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFeaturedActionPerformed(evt);
            }
        });

        cbHidden.setText("hidden");

        tvRating.setText("0.0");

        jLabel6.setText("Image");

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        jLabel7.setText("/ 5");

        jLabel8.setText("Download these  images:");

        btnNew.setText("New Instance");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnGenerate.setText("Generate");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        lbCurrentInstance.setText("Current Instance:");

        jLabel5.setText("_post");

        jLabel9.setText("_images");

        btnDownload.setText("Download");
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        jLabel10.setText("to folder id");

        tvFolderId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvFolderIdActionPerformed(evt);
            }
        });

        textAreaOutput.setColumns(20);
        textAreaOutput.setRows(5);
        jScrollPane2.setViewportView(textAreaOutput);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Tool Download Images");

        jLabel11.setText("<html>Xem hướng dẫn chi tiết tại: <a href=\"https://app.clickup.com/t/k3cak\">https://app.clickup.com/t/k3cak</a></html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCurrentInstance)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDownload)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnGenerate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tvFolderId)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tv_Images)
                            .addComponent(tvCategories)
                            .addComponent(tvImage, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tvTitle)
                            .addComponent(tvDescription, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tvAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbFeatured)
                                .addGap(18, 18, 18)
                                .addComponent(cbHidden)
                                .addGap(18, 18, 18)
                                .addComponent(tvRating, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                            .addComponent(tv_Post)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tvAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbFeatured)
                        .addComponent(cbHidden)
                        .addComponent(tvRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tvTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tvDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tvCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tvImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tv_Post, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tv_Images, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerate)
                    .addComponent(btnNew)
                    .addComponent(lbCurrentInstance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnDownload)
                    .addComponent(jLabel10)
                    .addComponent(tvFolderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tvDescriptionActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvDescriptionActionPerformed
        // TODO add your handling code here:
  }//GEN-LAST:event_tvDescriptionActionPerformed

    private void cbFeaturedActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFeaturedActionPerformed
        // TODO add your handling code here:
  }//GEN-LAST:event_cbFeaturedActionPerformed

    private void btnNewActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        initData();
        // TODO add your handling code here:
  }//GEN-LAST:event_btnNewActionPerformed

    private void btnGenerateActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        // TODO add your handling code here:
        assertTextViewNotEmpty();
        try {
            // set attribute to maker
            maker.title(PostHelper.normalize(tvTitle.getText()))
                    .author(tvAuthor.getText())
                    .description(tvDescription.getText())
                    .categories(tvCategories.getText().split(","))
                    .featured(cbFeatured.isSelected())
                    .hidden(cbHidden.isSelected());

            // download image and set it to the post
            String image = PostHelper.normalizeImagePath(downloadImage(tvImage.getText().trim(), maker.id(), 1));
            maker.image(image);
            
            // create folder and post template
            String folder = tv_Post.getText() + maker.getFileName();
            FileUtils.writeStringToFile(
                    new File(folder),
                    maker.getHeader(),
                    "UTF-8"
            );

            // update folderId for download tool in case necessary
            tvFolderId.setText(maker.id());

            JOptionPane.showMessageDialog(this, "Successful create post in folder: " + folder);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
  }//GEN-LAST:event_btnGenerateActionPerformed

    /**
     * get available number for image name 
     * @param folderId
     * @return 
     */
    private int getAvailableNumber(String folderId) {
        File folder = new File(tv_Images.getText() + folderId);
        File[] listOfFiles = folder.listFiles();

        int max = 0;
        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    String filename = listOfFiles[i].getName();
                    Pattern p = Pattern.compile("\\d+");
                    Matcher m = p.matcher(filename);
                    while (m.find()) {
                        try {
                            Integer number = Integer.valueOf(m.group());
                            if (number > max) {
                                max = number;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "thư mục không tồn tại");
            throw new RuntimeException("java.lang.NullPointerException");
        }
        return max + 1;
    }

    private void btnDownloadActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        // TODO add your handling code here:
        if (tvFolderId.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập Folder Id");
            throw new RuntimeException("Chưa nhập Folder Id");
        }
        textAreaOutput.setText("");
        for (String line : textArea.getText().split("\n")) {
            if (line != null && !line.isEmpty()) {
                String filename = downloadImage(line, tvFolderId.getText(), getAvailableNumber(tvFolderId.getText()));
                textAreaOutput.append("![image-title-here]("+PostHelper.normalizeImagePath(filename)+"){:class=\"center-image\"}");
                textAreaOutput.append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(this, "Successful download all images to folder: "+tvFolderId.getText());
        textArea.setText("");

  }//GEN-LAST:event_btnDownloadActionPerformed

    private void tvFolderIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvFolderIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tvFolderIdActionPerformed

    private String downloadImage(String url, String folderId, int number) {
        try {
            String image = tv_Images.getText()
                    + folderId + "/"
                    + number + "."
                    + FilenameUtils.getExtension(url);
            FileUtils.copyURLToFile(new URL(url), new File(image));
            return image;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Image link có vấn đề" + e.getMessage());
            throw new RuntimeException("Image link có vấn đề");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDownload;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnNew;
    private javax.swing.JCheckBox cbFeatured;
    private javax.swing.JCheckBox cbHidden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCurrentInstance;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextArea textAreaOutput;
    private javax.swing.JTextField tvAuthor;
    private javax.swing.JTextField tvCategories;
    private javax.swing.JTextField tvDescription;
    private javax.swing.JTextField tvFolderId;
    private javax.swing.JTextField tvImage;
    private javax.swing.JTextField tvRating;
    private javax.swing.JTextField tvTitle;
    private javax.swing.JTextField tv_Images;
    private javax.swing.JTextField tv_Post;
    // End of variables declaration//GEN-END:variables
}
