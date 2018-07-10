package rsa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class RSAUserInterface
  extends JFrame
{
  private static final long serialVersionUID = 4192081049915088589L;
  private static final int textAreaColumns = 40;
  private static final int textAreaRows = 5;
  private JSplitPane splitPane;
  private JTabbedPane tabPane;
  private JTextArea modulusJTA;
  private JTextArea publicKeyJTA;
  private JTextArea privateKeyJTA;
  private JTextArea encryptInputJTA;
  private JTextArea encryptOutputJTA;
  private JTextArea decryptInputJTA;
  private JTextArea decryptOutputJTA;
  private JTextArea generatePublicKeyJTA;
  private JTextArea generatePrivateKeyJTA;
  private JScrollPane modulusJSP;
  private JButton encryptJB;
  private JButton decryptJB;
  private JButton generateJB;
  
  public static void main(String[] args)
  {
    RSAUserInterface application = new RSAUserInterface();
    application.setDefaultCloseOperation(3);
  }
  
  public RSAUserInterface()
  {
    makeAllTextAreas();
    assembleUI();
  }
  
  private void makeAllTextAreas()
  {
    this.publicKeyJTA = makeTextArea("Public Key");
    this.encryptInputJTA = makeTextArea("Plaintext Message");
    this.encryptOutputJTA = makeTextArea("Encrypted Message");
    
    this.privateKeyJTA = makeTextArea("Private Key");
    this.decryptInputJTA = makeTextArea("Encrypted Message");
    this.decryptOutputJTA = makeTextArea("Decrypted Message");
    
    this.generatePublicKeyJTA = makeTextArea("New Public Key");
    this.generatePrivateKeyJTA = makeTextArea("New Private Key");
    
    this.modulusJTA = makeTextArea("Encryption Modulus");
  }
  
  private JTextArea makeTextArea(String title)
  {
    JTextArea ta = new JTextArea(5, 40);
    ta.setLineWrap(true);
    ta.setBorder(BorderFactory.createTitledBorder(title));
    return ta;
  }
  
  private JScrollPane assembleEncryptionScrollPane()
  {
    JPanel encryptPanel = new JPanel();
    encryptPanel.setLayout(new BoxLayout(encryptPanel, 1));
    
    this.encryptJB = new JButton("Encrypt Message");
    this.encryptJB.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent event)
      {
        RSAEncryptor rsa = new RSAEncryptor();
        
        BigInteger plainText = rsa.messageToInteger(RSAUserInterface.this.encryptInputJTA.getText());
        BigInteger publicKey = KeySet.parseInt(RSAUserInterface.this.publicKeyJTA.getText());
        BigInteger modulus = KeySet.parseInt(RSAUserInterface.this.modulusJTA.getText());
        BigInteger result = rsa.encrypt(plainText, publicKey, modulus);
        
        RSAUserInterface.this.encryptOutputJTA.setText(KeySet.intString(result));
      }
    });
    encryptPanel.add(this.publicKeyJTA);
    encryptPanel.add(this.encryptInputJTA);
    encryptPanel.add(this.encryptJB);
    encryptPanel.add(this.encryptOutputJTA);
    
    return new JScrollPane(encryptPanel);
  }
  
  private JScrollPane assembleDecryptionScrollPane()
  {
    JPanel decryptPanel = new JPanel();
    decryptPanel.setLayout(new BoxLayout(decryptPanel, 1));
    
    this.decryptJB = new JButton("Decrypt Message");
    this.decryptJB.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent event)
      {
        RSAEncryptor rsa = new RSAEncryptor();
        
        BigInteger cipherText = KeySet.parseInt(RSAUserInterface.this.decryptInputJTA.getText());
        BigInteger privateKey = KeySet.parseInt(RSAUserInterface.this.privateKeyJTA.getText());
        BigInteger modulus = KeySet.parseInt(RSAUserInterface.this.modulusJTA.getText());
        
        RSAUserInterface.this.decryptOutputJTA.setText(rsa.integerToMessage(
          rsa.decrypt(cipherText, privateKey, modulus)));
      }
    });
    decryptPanel.add(this.privateKeyJTA);
    decryptPanel.add(this.decryptInputJTA);
    decryptPanel.add(this.decryptJB);
    decryptPanel.add(this.decryptOutputJTA);
    
    return new JScrollPane(decryptPanel);
  }
  
  private JScrollPane assembleKeyGeneratorScrollPane()
  {
    JPanel generatorPanel = new JPanel();
    generatorPanel.setLayout(new BoxLayout(generatorPanel, 1));
    
    this.generateJB = new JButton("Generate Keys");
    this.generateJB.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent event)
      {
        KeySet set = new RSAKeyGenerator().generateKeys();
        
        RSAUserInterface.this.modulusJTA.setText(KeySet.intString(set.modulus));
        RSAUserInterface.this.generatePublicKeyJTA.setText(KeySet.intString(set.publicKey));
        RSAUserInterface.this.generatePrivateKeyJTA.setText(KeySet.intString(set.privateKey));
      }
    });
    generatorPanel.add(this.generateJB);
    generatorPanel.add(new JLabel("This may take a minute..."));
    generatorPanel.add(this.generatePublicKeyJTA);
    generatorPanel.add(this.generatePrivateKeyJTA);
    
    return new JScrollPane(generatorPanel);
  }
  
  private void assembleUI()
  {
    this.tabPane = new JTabbedPane();
    this.tabPane.addTab("Encrypt", assembleEncryptionScrollPane());
    this.tabPane.addTab("Decrypt", assembleDecryptionScrollPane());
    this.tabPane.addTab("Generate Keys", assembleKeyGeneratorScrollPane());
    
    this.modulusJSP = new JScrollPane(this.modulusJTA);
    this.splitPane = new JSplitPane(0, this.modulusJSP, this.tabPane);
    add(this.splitPane);
    
    setTitle("RSA Encryption");
    pack();
    setVisible(true);
  }
}
