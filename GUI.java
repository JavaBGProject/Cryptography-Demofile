import javax.swing.*;    
import java.awt.event.*;   
import java.io.*; 
import java.awt.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;


import java.nio.file.*;
import java.security.spec.KeySpec;
class GUI extends JFrame implements ActionListener{  

    private static final String ALGORITHM = "AES";
    private static final String KEY = "mysecretpassword"; 

JRadioButton rb1,rb2,rb3;    
JButton b;   
JLabel L1; 
GUI(){      
L1=new JLabel("Welcome to CryptographMe");
L1.setFont(new Font("Verdana",Font.PLAIN,15));
L1.setBounds(30,0,220,30);
rb1=new JRadioButton("Text");    
rb1.setBounds(100,50,100,30);      
rb2=new JRadioButton("File");    
rb2.setBounds(100,100,100,30);    
rb3=new JRadioButton("Image");    
rb3.setBounds(100,150,100,30);  
rb1.setFocusPainted(false);
rb2.setFocusPainted(false);
rb3.setFocusPainted(false);  
ButtonGroup bg=new ButtonGroup();    
bg.add(rb1);bg.add(rb2);bg.add(rb3);  
Color color1=new Color(160,213,255);
rb1.setBackground(color1);
rb2.setBackground(color1);
rb3.setBackground(color1);
b=new JButton("click");    
b.setBounds(70,200,140,30);
Color color2=new Color(55,57,55);
b.setBackground(color2);
b.setForeground(Color.white);
b.setFocusPainted(false);
b.setBorder(BorderFactory.createLineBorder(color2));   
b.addActionListener(this);    
add(rb1);add(rb2);add(rb3);add(b);add(L1);    
setSize(300,300);    
setLayout(null);    
setVisible(true);   
Color color=new Color(160,213,255);
this.getContentPane().setBackground(color);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setResizable(false);
}    
public void actionPerformed(ActionEvent e){    
if(rb1.isSelected()){    
    JFrame f1=new JFrame();
    f1.setSize(330,350);
    f1.setVisible(true);
    f1.setLayout(null);
    Color color=new Color(255,239,213);
    f1.getContentPane().setBackground(color);
    f1.setLocationRelativeTo(null);
    f1.setResizable(false);
    JLabel l=new JLabel("CryptographText");
    l.setFont(new Font("Verdana",Font.PLAIN,15));
    l.setBounds(90,0,150,30);
    JRadioButton r1=new JRadioButton("Encryption");
    r1.setBounds(50,50,100,30);
    JRadioButton r2=new JRadioButton("Decryption");
    r2.setBounds(160,50,100,30);
    r1.setFocusPainted(false);
    r2.setFocusPainted(false);
    r1.setBackground(color);
    r2.setBackground(color);
    ButtonGroup bg1=new ButtonGroup();
    bg1.add(r1);
    bg1.add(r2);
    f1.add(r1);
    f1.add(r2);
    JLabel l2=new JLabel("Enter Your Text");
    l2.setBounds(100,100,100,50);
    f1.add(l2);
    JTextField t1=new JTextField();
    t1.setBounds(50,150,200,30);
    t1.setBorder(BorderFactory.createLineBorder(Color.black));
    f1.add(t1);
    f1.add(l);
    JButton btn=new JButton("Compute");
    btn.setFocusPainted(false);
    Color color1=new Color(55,57,55);
    btn.setBackground(color1);
    btn.setForeground(Color.white);
    btn.setBorder(BorderFactory.createLineBorder(color1)); 
    btn.setBounds(75,250,150,30);
    f1.add(btn);
    JTextField t2=new JTextField();
    t2.setBounds(50,200,200,30);
    t2.setBorder(BorderFactory.createLineBorder(Color.black));
    f1.add(t2);
    btn.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            if(r1.isSelected())
            {
                String plainText=t1.getText();
                      try {
                            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
                            Cipher cipher = Cipher.getInstance(ALGORITHM);
                            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                            byte[] encryptedValue = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
                            String encryptedText=Base64.getEncoder().encodeToString(encryptedValue);
                             t2.setText(encryptedText);
                     } 
                     catch (Exception ex) {
                        ex.printStackTrace();
                        }
                       
            }

            if(r2.isSelected())
            {
                String plainText=t1.getText();
                      try {
                             SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
                            Cipher cipher = Cipher.getInstance(ALGORITHM);
                            cipher.init(Cipher.DECRYPT_MODE, secretKey);
                            byte[] decryptedValue = cipher.doFinal(Base64.getDecoder().decode(plainText));
                            String decryptedText=new String(decryptedValue, StandardCharsets.UTF_8);
                            t2.setText(decryptedText);
                     } 
                     catch (Exception ex) {
                        ex.printStackTrace();
                        }          
            }
        }
    });
 
}    
if(rb2.isSelected())
{
    JFrame fr=new JFrame();
    fr.setSize(310,350);
    fr.setVisible(true);
    Color color=new Color(226,151,226);
    fr.getContentPane().setBackground(color);
    fr.setResizable(false);
    fr.setLocationRelativeTo(null);
    fr.setLayout(null);
    JLabel l1=new JLabel("CryptographFile");
    l1.setFont(new Font("Verdana",Font.PLAIN,15));
    l1.setBounds(90,0,150,50);
    fr.add(l1);

    JRadioButton rbtn1=new JRadioButton("Encryption");
    rbtn1.setBounds(50,50,100,50);
    rbtn1.setFocusPainted(false);
    
    JRadioButton rbtn2=new JRadioButton("Decryption");
    rbtn2.setBounds(150,50,100,50);
    rbtn2.setFocusPainted(false);
    ButtonGroup bg=new ButtonGroup();
    rbtn1.setBackground(color);
    rbtn2.setBackground(color);
    bg.add(rbtn1);
    bg.add(rbtn2);
    fr.add(rbtn1);
    fr.add(rbtn2);
    
    JLabel l2=new JLabel("Choose a file:");
    l2.setBounds(60,100,100,30);
    fr.add(l2);
    JButton btn=new JButton(new ImageIcon("D:\\Java Tutorial\\Crypto Project\\img.png"));
    btn.setBounds(150,100,30,30);
    btn.setFocusPainted(false);
    btn.setBorder(BorderFactory.createLineBorder(Color.black));
    fr.add(btn);
     JLabel result=new JLabel("Details of your encrypted file:");
                result.setBounds(50,130,200,50);
                fr.add(result);
                JLabel  lb1=new JLabel("File Name:");
                lb1.setBounds(50,170,100,50);
                fr.add(lb1);
                JTextField t1=new JTextField();
                t1.setBounds(120,180,140,30);
                t1.setBorder(BorderFactory.createLineBorder(Color.black));
                fr.add(t1);
               
                JLabel  lb2=new JLabel("File Path:");
                lb2.setBounds(50,220,100,50);
                fr.add(lb2);
                JTextField t2=new JTextField();
                t2.setBounds(120,230,140,30);
                t2.setBorder(BorderFactory.createLineBorder(Color.black));
                fr.add(t2);
    btn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            if(rbtn1.isSelected())
            {
            JFileChooser j=new JFileChooser();
            int i=j.showOpenDialog(null);
            if(i==JFileChooser.APPROVE_OPTION)
            {
                File f=j.getSelectedFile();
                String name=f.getName();
                String inputFilePath = f.getAbsolutePath(); // path to the input file
                Path inputFile = Paths.get(inputFilePath);
                String x1=name;
                String path2=inputFilePath.replace(x1,"Encrypted")+".txt";
                String outputFilePath = path2; // path to the output file
                String password = "myPassword123";
                Path outputFile = Paths.get(outputFilePath);
                try{
                byte[] fileContent = Files.readAllBytes(inputFile);
                // generate a secret key
                byte[] keyBytes = "MySecretKey12345".getBytes();
                SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                // initialize the cipher
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
                // encrypt the file content
                byte[] encryptedFileContent = cipher.doFinal(fileContent);
                // write the encrypted content to a new file
                Files.write(outputFile, encryptedFileContent);
                t1.setText("Encrypted");
                t2.setText(outputFilePath);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
            }


            if(rbtn2.isSelected())
            {
            JFileChooser j1=new JFileChooser();
            int i1=j1.showOpenDialog(null);
            if(i1==JFileChooser.APPROVE_OPTION)
            {
                File f1=j1.getSelectedFile();
                String name=f1.getName();
                String inputFilePath = f1.getAbsolutePath(); // path to the input file
                Path inputFile = Paths.get(inputFilePath);
                String x1=name;
                String path2=inputFilePath.replace(x1,"Decrypted")+".txt";
                String outputFilePath = path2; // path to the output file
                String password = "myPassword123";
                Path outputFile = Paths.get(outputFilePath);
                try{
                byte[] encryptedFileContent = Files.readAllBytes(inputFile);
                byte[] keyBytes = "MySecretKey12345".getBytes();
                SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                byte[] decryptedFileContent = cipher.doFinal(encryptedFileContent);
                Files.write(outputFile, decryptedFileContent);
                t1.setText("Decrypted");
                t2.setText(outputFilePath);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
            }

            
              
            }     
        
    });
}  

if(rb3.isSelected())
{
    JFrame fr=new JFrame();
    fr.setSize(300,350);
    fr.setVisible(true);
    Color color=new Color(220,199,91);
    fr.getContentPane().setBackground(color);
    fr.setResizable(false);
    fr.setLocationRelativeTo(null);
    fr.setLayout(null);
    JLabel l1=new JLabel("CryptographImage");
    l1.setFont(new Font("Verdana",Font.PLAIN,15));
    l1.setBounds(80,0,150,50);
    fr.add(l1);

    JRadioButton rbtn1=new JRadioButton("Encryption");
    rbtn1.setBounds(50,50,100,50);
    rbtn1.setFocusPainted(false);
    
    JRadioButton rbtn2=new JRadioButton("Decryption");
    rbtn2.setBounds(150,50,100,50);
    rbtn2.setFocusPainted(false);
    ButtonGroup bg=new ButtonGroup();
    bg.add(rbtn1);
    bg.add(rbtn2);
    fr.add(rbtn1);
    fr.add(rbtn2);
    rbtn1.setBackground(color);
    rbtn2.setBackground(color);
    
    JLabel l2=new JLabel("Choose a Image:");
    l2.setBounds(60,100,120,30);
    fr.add(l2);
    JButton btn=new JButton(new ImageIcon("D:\\Java Tutorial\\Crypto Project\\img.png"));
    btn.setBounds(170,100,30,30);
    btn.setBorder(BorderFactory.createLineBorder(Color.black));
    btn.setFocusPainted(false);
    fr.add(btn);
     JLabel result=new JLabel("Details of your encrypted Image:");
                result.setBounds(50,130,200,50);
                fr.add(result);
                JLabel  lb1=new JLabel("Image Name:");
                lb1.setBounds(50,170,100,50);
                fr.add(lb1);
                JTextField t1=new JTextField();
                t1.setBounds(140,180,120,30);
                t1.setBorder(BorderFactory.createLineBorder(Color.black));
                fr.add(t1);
               
                JLabel  lb2=new JLabel("Image Path:");
                lb2.setBounds(50,220,100,50);
                fr.add(lb2);
                JTextField t2=new JTextField();
                t2.setBounds(140,230,120,30);
                t2.setBorder(BorderFactory.createLineBorder(Color.black));
                fr.add(t2);
    btn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            if(rbtn1.isSelected())
            {
            JFileChooser j=new JFileChooser();
            int i=j.showOpenDialog(null);
            if(i==JFileChooser.APPROVE_OPTION)
            {
                File f=j.getSelectedFile();
                String name=f.getName();
                String inputPath = f.getAbsolutePath(); 
                String x=name;
                String path2=inputPath.replace(x,"EnryptImage")+".jpg";
                String outputPath = path2;
                try{
                Path imagePath = Paths.get(inputPath);
                byte[] imageData = Files.readAllBytes(imagePath);
                String password = "myPassword";
                byte[] keyBytes = password.getBytes("UTF-8");
                MessageDigest sha = MessageDigest.getInstance("SHA-256");
                keyBytes = sha.digest(keyBytes);
                keyBytes = Arrays.copyOf(keyBytes, 16); 
                SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
                byte[] encryptedData = cipher.doFinal(imageData);
                Path encryptedImagePath = Paths.get(outputPath);
                Files.write(encryptedImagePath, encryptedData);
                t1.setText("EncryptImage");
                t2.setText(outputPath);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
            }
            if(rbtn2.isSelected())
            {
                JFileChooser j1=new JFileChooser();
                int i1=j1.showOpenDialog(null);
                
                if(i1==JFileChooser.APPROVE_OPTION)
                {
                File f1=j1.getSelectedFile();
                String name1=f1.getName();
                String inputPath = f1.getAbsolutePath(); 
                String x1=name1;
                String path2=inputPath.replace(x1,"DecryptImage")+".jpg";
                String outputPath = path2;
                try{
                    Path encryptedImagePath = Paths.get(inputPath);
                    byte[] encryptedData = Files.readAllBytes(encryptedImagePath);
                    String password = "myPassword";
                    byte[] keyBytes = password.getBytes("UTF-8");
                    MessageDigest sha = MessageDigest.getInstance("SHA-256");
                    keyBytes = sha.digest(keyBytes);
                    keyBytes = Arrays.copyOf(keyBytes, 16);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                    byte[] imageData = cipher.doFinal(encryptedData);
                    Path imagePath = Paths.get(outputPath);
                    Files.write(imagePath, imageData);
                    t1.setText("DecryptImage");
                    t2.setText(path2);
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
                }   
            }     
        }
    });
}  
}    

public static void main(String args[]){    
new GUI();    
}}