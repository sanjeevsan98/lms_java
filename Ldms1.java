package ldms.pkg1;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class Screen extends Frame
{
    Button screenButton1;
    Button screenButton2;
    Screen()
    {
        Label screenLabel=new Label("LIBRARY MANAGEMENT SYSTEM");
	screenLabel.setBounds(450,50,421,25);
	Font myFont=new Font("Serif",Font.BOLD,25);
	screenLabel.setFont(myFont);
	add(screenLabel);
        screenButton1 = new Button("Admin");
        screenButton2 = new Button("User");
        screenButton1.setBounds(600,150,100,50);
        screenButton2.setBounds(600,250,100,50);
        add(screenButton1);
        add(screenButton2);
        setSize(1373, 1000);
        setLayout(null);
        setVisible(true);
        setBackground(Color.GRAY);
        setTitle("LIBRARY MANAGEMENT SYSTEM");
        screenButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Admin();
            }
        });
        screenButton2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new User();
            }
        });
        
        Button screenButton3 = new Button("Close");
        screenButton3.setBounds(625,350,50,25);
        add(screenButton3);
        
        screenButton3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we)
        {
                System.exit(0);
             }
        });
    }
    void exit()
    {
        Frame exit = new Frame();
        exit.setSize(500, 200);
        exit.setLocation(400,175 );
        exit.setVisible(true);
        exit.setLayout(null);
        exit.setTitle("LDMS-Close");
        exit.setBackground(Color.gray);
        Label exitLabel1 = new Label("Are you sure want to exit");
        exitLabel1.setBounds(175,50,200,25);
        exit.add(exitLabel1);
        
        
        Button screenButton4 = new Button("Yes");
        screenButton4.setBounds(185,100,50,25);
        exit.add(screenButton4);
        
        screenButton4.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        Button screenButton5 = new Button("No");
        screenButton5.setBounds(255,100,50,25);
        exit.add(screenButton5);
        
        screenButton5.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                 exit.dispose();
                 dispose();
                 new Screen();
            }
        });
        
        exit.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we)
        {
                exit.dispose();
             }
        });
        
    }
}
class Admin extends User 
{
     String enteredPassword;
     Library adminHead = null;
     Library addBookNode = null;
     Library getDetailsNode = null,issueNode;
     
    Admin()
    {
        removeAll();
        
        Label adminLabel2=new Label("****ADMIN LOGIN****");
	adminLabel2.setBounds(550,50,300,100);
	Font myFont=new Font("Serif",Font.BOLD,20);
	adminLabel2.setFont(myFont);
	add(adminLabel2);
        
        Label adminLabel1 = new Label("Enter password:    :");
        adminLabel1.setBounds(500,150,100,25);
        add(adminLabel1);
        
        TextField adminTextField1 = new TextField();
        adminTextField1.setBounds(750,150,150,25);
        add(adminTextField1);
        adminTextField1.setEchoChar('*');
        
        Button adminButton1 = new Button("LOGIN");
        adminButton1.setBounds(650,200,50,25);
        add(adminButton1);
        
        adminButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                enteredPassword = adminTextField1.getText();
                if(checkPassword()==0)
                {
                   adminWindow();
                }
                else
                {
                    dispose();
                    new Screen();
                }
            }
        });
        
        Button adminButton9 = new Button("BACK");
        adminButton9.setBounds(650,250,50,25);
        add(adminButton9);
        
        adminButton9.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Screen();
            }
        });
    }
     int checkPassword()
    {
        return Ldms1.predefinedPassword.compareTo(enteredPassword);
    }
    void adminWindow()
    {
        removeAll();
        
        Label adminLabel3=new Label("****ADMIN****");
	adminLabel3.setBounds(550,25,300,50);
	Font myFont=new Font("Serif",Font.BOLD,20);
	adminLabel3.setFont(myFont);
	add(adminLabel3);
        
        Button adminButton2 = new Button("ADD BOOK");
        adminButton2.setBounds(575,100,100,50);
        add(adminButton2);
        
        adminButton2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });
        Button adminButton3 = new Button("DELETE BOOK");
        adminButton3.setBounds(575,175,100,50);
        add(adminButton3);

        adminButton3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBook();
            }
        });
        
        Button adminButton4 = new Button("ISSUE");
        adminButton4.setBounds(575,250,100,50);
        add(adminButton4);
        
        adminButton4.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                issueBook();
            }
        });
        
        Button adminButton5 = new Button("RETURN");
        adminButton5.setBounds(575,325,100,50);
        add(adminButton5);
        
        adminButton5.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnBook();
            }
        });
        
        Button adminButton6 = new Button("SEARCH BOOK");
        adminButton6.setBounds(575,400,100,50);
        add(adminButton6);
        
        adminButton6.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }
        });
        
        Button adminButton7 = new Button("SEARCH USER");
        adminButton7.setBounds(575,475,100,50);
        add(adminButton7);
        
        adminButton7.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayUser();
            }
        });
        
        Button adminButton10 = new Button("ADMIN SETTINGS");
        adminButton10.setBounds(575,550,100,50);
        add(adminButton10);
        
        adminButton10.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminSettings();
            }
        });
        
        Button adminButton8 = new Button("BACK");
        adminButton8.setBounds(600,625,50,25);
        add(adminButton8);
        
        adminButton8.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Screen();
            }
        });
    }
    
    void addBook()
    {
        this.adminHead = Ldms1.head;
        if(this.adminHead == null)
        {
          this.adminHead = new Library();
          this.adminHead.next = null;
          Ldms1.head = this.adminHead;
          getDetails(adminHead);
        }
        else
        {
           this.addBookNode = Ldms1.head;
           while(this.addBookNode.next != null)
           {
               this.addBookNode = this.addBookNode.next;
           }
           this.addBookNode.next = new Library();
           this.addBookNode.next.next = null;
           getDetails(this.addBookNode.next);
        }
    }
    void getDetails(Library getDetailsNode)
    {
        removeAll();
        Label topLabel=new Label("****BOOK REGISTRATION****");
	topLabel.setBounds(450,50,421,25);
	Font myFont=new Font("Serif",Font.BOLD,25);
	topLabel.setFont(myFont);
	add(topLabel);
        
        this.getDetailsNode = getDetailsNode;
        Label getDetailsLabel1 = new Label("Book Id");
        getDetailsLabel1.setBounds(100,100,100,25);
        add(getDetailsLabel1);
        
        TextField getDetailsTextField1 = new TextField();
        getDetailsTextField1.setBounds(300,100,200,25);
        add(getDetailsTextField1);
        
        Label getDetailsLabel2 = new Label("Book Name");
        getDetailsLabel2.setBounds(100,145,100,25);
        add(getDetailsLabel2);
        
        TextField getDetailsTextField2 = new TextField();
        getDetailsTextField2.setBounds(300,145,200,25);
        add(getDetailsTextField2);
        
        Label getDetailsLabel3 = new Label("Author Name");
        getDetailsLabel3.setBounds(100,190,100,25);
        add(getDetailsLabel3);
        
        TextField getDetailsTextField3 = new TextField();
        getDetailsTextField3.setBounds(300,190,200,25);
        add(getDetailsTextField3);
        
        Label getDetailsLabel4 = new Label("Subject");
        getDetailsLabel4.setBounds(100,235,100,25);
        add(getDetailsLabel4);
        
        TextField getDetailsTextField4 = new TextField();
        getDetailsTextField4.setBounds(300,235,200,25);
        add(getDetailsTextField4);
        
        Label getDetailsLabel5 = new Label("Description");
        getDetailsLabel5.setBounds(100,280,100,25);
        add(getDetailsLabel5);
        
        TextField getDetailsTextField5 = new TextField();
        getDetailsTextField5.setBounds(300,280,200,100);
        add(getDetailsTextField5);
        
        Label getDetailsLabel6 = new Label("Book Price");
        getDetailsLabel6.setBounds(100,425,100,25);
        add(getDetailsLabel6);
        
        TextField getDetailsTextField6 = new TextField();
        getDetailsTextField6.setBounds(300,425,200,25);
        add(getDetailsTextField6);
        
        Label getDetailsLabel7 = new Label("Book Location");
        getDetailsLabel7.setBounds(100,470,100,25);
        add(getDetailsLabel7);
        
        TextField getDetailsTextField7 = new TextField();
        getDetailsTextField7.setBounds(300,470,200,25);
        add(getDetailsTextField7);
        
        Label getDetailsLabel8 = new Label("Total Number");
        getDetailsLabel8.setBounds(100,515,200,25);
        add(getDetailsLabel8);
        
        TextField getDetailsTextField8 = new TextField();
        getDetailsTextField8.setBounds(300,515,200,25);
        add(getDetailsTextField8);
        
        Button getDetailsButton1 = new Button("Submit");
        getDetailsButton1.setBounds(300,550,50,25);
        add(getDetailsButton1);
        
        Button getDetailsButton2 = new Button("Reset");
        getDetailsButton2.setBounds(400,550,50,25);
        add(getDetailsButton2);
        
        Button getDetailsButton3 = new Button("Back");
        getDetailsButton3.setBounds(500,550,50,25);
        add(getDetailsButton3);
        
        getDetailsButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDetailsNode.bookIdentificationNo = getDetailsTextField1.getText();
                getDetailsNode.bookName = getDetailsTextField2.getText();
                getDetailsNode.bookAuthor = getDetailsTextField3.getText();
                getDetailsNode.bookSubject = getDetailsTextField4.getText();
                getDetailsNode.bookDescription = getDetailsTextField5.getText();
                getDetailsNode.bookPrice = getDetailsTextField6.getText();
                getDetailsNode.bookLocation = getDetailsTextField7.getText();
                getDetailsNode.orginialCount = Integer.parseInt(getDetailsTextField8.getText());
                getDetailsNode.bookCount = getDetailsNode.orginialCount;
                Ldms1.bookAccessionNo+=1;
                getDetailsNode.bookAccessionNO = Ldms1.bookAccessionNo;
                try {
                    fileWrite(getDetailsNode);
                } catch (IOException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
                sendMessage();
            }    
        });
        
        getDetailsButton2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDetailsTextField1.setText(" ");
                getDetailsTextField1.setText("");
                getDetailsTextField2.setText(" ");
                getDetailsTextField2.setText("");
                getDetailsTextField3.setText(" ");
                getDetailsTextField3.setText("");
                getDetailsTextField4.setText(" ");
                getDetailsTextField4.setText("");
                getDetailsTextField5.setText(" ");
                getDetailsTextField5.setText("");
                getDetailsTextField6.setText(" ");
                getDetailsTextField6.setText("");
                getDetailsTextField7.setText(" ");
                getDetailsTextField7.setText("");
                getDetailsTextField8.setText(" ");
                getDetailsTextField8.setText("");
            }});
        
        getDetailsButton3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminCancel();
                adminWindow();
            }});
    }
    void sendMessage()
    {
        Frame message = new Frame();
        message.setSize(500, 200);
        message.setLocation(400,175 );
        message.setVisible(true);
        message.setLayout(null);
        message.setTitle("Message");
        message.setBackground(Color.gray);
        Label messageLabel1 = new Label("Message has been sent to registered users");
        messageLabel1.setBounds(125,50,250,25);
        message.add(messageLabel1);
        
        
        Button messageButton1 = new Button("Ok");
        messageButton1.setBounds(195,100,50,25);
        message.add(messageButton1);
        
        messageButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                message.dispose();
                adminWindow();
            }
        });
    }
    Library adminCancelNode1;
    
    void adminCancel()
    {
        this.adminCancelNode1 = Ldms1.head;
        if(this.adminCancelNode1.next==null)
        {
            Ldms1.head = null;
        }
        else
        {
        while(this.adminCancelNode1.next.next!=null)
        {
            this.adminCancelNode1 = this.adminCancelNode1.next;
        }
       this.adminCancelNode1.next = null;
        }
    }
    int deleteBookIdTrack = 0;
    Library deleteNode;
    void deleteBook()
    {
        removeAll();
        Label screenLabel=new Label("DELETE BOOK");
	screenLabel.setBounds(200,50,400,25);
	Font myFont=new Font("Serif",Font.BOLD,25);
	screenLabel.setFont(myFont);
	add(screenLabel);
        Label deletelabel1=new Label("Book Id ");
	deletelabel1.setBounds(100,200,100,25);
	add(deletelabel1);
        
	TextField deleteTextfield1 = new TextField();
	deleteTextfield1.setBounds(300,200,100,25);
	add(deleteTextfield1);
		
	Button deleteButton1=new Button("Ok");
	deleteButton1.setBounds(300,300,100,25);
	add(deleteButton1);
        
        deleteButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                issueBookId = deleteTextfield1.getText();
                issueNode = Ldms1.head;
                while(issueNode != null)
                {
                    if(issueNode.bookIdentificationNo.contentEquals(issueBookId))
                    {
                        deleteBookIdTrack =1;
                        if(issueNode == Ldms1.head)
                        {
                            Ldms1.head = null;
                        }
                        else
                        {
                            deleteNode.next = issueNode.next;
                        }
                        Label deleteLabel3 = new Label("Book deleted");
                        deleteLabel3.setBounds(100,450,100,25);
                        add(deleteLabel3);
                        break;
                    }
                    else
                    {
                        deleteNode = issueNode;
                        issueNode = issueNode.next;
                    }
                }
                if(deleteBookIdTrack != 1)
                {
                    Label deleteLabel3 = new Label("Book not Found!!!");
                    deleteLabel3.setBounds(100,450,150,25);
                    add(deleteLabel3);
                }
               
            }
        });
		
	Button deleteButton2=new Button("Back");
	deleteButton2.setBounds(450,300,100,25);
	add(deleteButton2);
        
        deleteButton2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminWindow();
            }
        });
    
        
    }
    Label issuelabel1,issuelabel2,issueMainlabel;
    TextField issueTextfield1,issueTextfield2;
    Button issueButton1,issueButton2;
    String issueBookId;
    int issueUserId,issueBookIdTrack;

    void issueBook()
    {
        removeAll();
        issueMainlabel=new Label("**** BOOK ISSUE ****");
	issueMainlabel.setBounds(300,50,300,100);
	Font myFont=new Font("Serif",Font.BOLD,20);
	issueMainlabel.setFont(myFont);
	add(issueMainlabel);
		
        issuelabel1=new Label("User Id  ");
	issuelabel1.setBounds(100,150,100,25);
	add(issuelabel1);
		
	issueTextfield1=new TextField();
	issueTextfield1.setBounds(300,150,100,25);
	add(issueTextfield1);
		
	issuelabel2=new Label("Book Id ");
	issuelabel2.setBounds(100,200,100,25);
	add(issuelabel2);
		
		
	issueTextfield2=new TextField();
	issueTextfield2.setBounds(300,200,100,25);
	add(issueTextfield2);
		
	issueButton1=new Button("Ok");
	issueButton1.setBounds(300,250,100,25);
	add(issueButton1);
        
        issueButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                issueUserId = Integer.parseInt(issueTextfield1.getText());
                issueBookId = issueTextfield2.getText();
                if(issueUserId <= Ldms1.userId)
                {
                issueBookIdTrack = 0;
                issueNode = Ldms1.head;
                while(issueNode != null)
                {
                    if(issueNode.bookIdentificationNo.contentEquals(issueBookId))
                    {
                        issueBookIdTrack =1;
                        if(issueNode.bookCount>0)
                        {
                            //issueNode.bookUserId[issueNode.orginialCount-issueNode.bookCount] = issueUserId;
                            issueNode.bookCount--;
                            Label issueLabel3 = new Label("Book Issued");
                            issueLabel3.setBounds(100,300,100,25);
                            add(issueLabel3);
                            
                        }
                        else
                        {
                            Label issueLabel3 = new Label("Book Not Available");
                            issueLabel3.setBounds(100,300,150,25);
                            add(issueLabel3);
                        }
                        break;
                    }
                    else
                    {
                        issueNode = issueNode.next;
                    }
                }
                if(issueBookIdTrack != 1)
                {
                    Label issueLabel3 = new Label("Book not Found!!!");
                    issueLabel3.setBounds(100,300,100,25);
                    add(issueLabel3);
                }
                
            }
                else{
                    Label issueLabel3 = new Label("No user Found");
                    issueLabel3.setBounds(100,300,100,25);
                    add(issueLabel3);
                }
            }
        });
		
	issueButton2=new Button("Back");
	issueButton2.setBounds(425,250,100,25);
	add(issueButton2);
        
        issueButton2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminWindow();
            }
        });
		

    }
    Label returnlabel1,returnMainlabel;
    TextField returnTextfield1;
    Button returnButton1,returnButton2;
    String returnBookId;
    int returnBookIdTrack = 0;
    void returnBook()
    {
        removeAll();
        returnMainlabel=new Label("****BOOK RETURN****");
        returnMainlabel.setBounds(300,50,300,100);
        Font myFont=new Font("Serif",Font.BOLD,20);
        returnMainlabel.setFont(myFont);
        add(returnMainlabel);

	returnlabel1=new Label("Book Id ");
	returnlabel1.setBounds(100,200,100,25);
	add(returnlabel1);
        
	returnTextfield1=new TextField();
	returnTextfield1.setBounds(300,200,100,25);
	add(returnTextfield1);
		
	returnButton1=new Button("Ok");
	returnButton1.setBounds(300,300,100,25);
	add(returnButton1);
        
        returnButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnBookId = returnTextfield1.getText();
                issueNode = Ldms1.head;
                while(issueNode != null)
                {
                    if(issueNode.bookIdentificationNo.contentEquals(returnBookId))
                    {
                        returnBookIdTrack =1;
                        if(issueNode.bookCount < issueNode.orginialCount)
                        {
                            issueNode.bookCount++;
                            Label returnLabel3 = new Label("Book Returned");
                            returnLabel3.setBounds(100,450,100,25);
                            add(returnLabel3);
                            
                        }
                        else
                        {
                            Label returnLabel3 = new Label("Book cannot be returned");
                            returnLabel3.setBounds(100,450,300,25);
                            add(returnLabel3);
                        }
                        break;
                    }
                    else
                    {
                        issueNode = issueNode.next;
                    }
                }
                if(returnBookIdTrack != 1)
                {
                    Label returnLabel3 = new Label("Book not Found!!!");
                    returnLabel3.setBounds(100,450,150,25);
                    add(returnLabel3);
                }
               
            }
        });
		
	returnButton2=new Button("Back");
	returnButton2.setBounds(450,300,100,25);
	add(returnButton2);
        
        returnButton2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminWindow();
            }
        });
    
    }
    UserDetails displayUNode;
    String displayUserName;
    int displayUserNameTrack;
    void displayUser()
    {
       removeAll();
       this.displayUNode = Ldms1.uhead;
       Label displayUserLabel1 = new Label("User Name");
       displayUserLabel1.setBounds(100,100,100,25);
       add(displayUserLabel1);
       
       TextField displayUserTextField1 = new TextField();
       displayUserTextField1.setBounds(300,100,100,25);
       add(displayUserTextField1);
       
       Button displayUserButton1 = new Button("Submit");
       displayUserButton1.setBounds(150,150,50,25);
       add(displayUserButton1);
       
       Button displayUserButton2 = new Button("Back");
       displayUserButton2.setBounds(300,150,50,25);
       add(displayUserButton2);
        
       displayUserButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayUserNameTrack = 0;
                displayUserName = displayUserTextField1.getText();
                while(displayUNode != null)
                {
                    if(displayUNode.name.equalsIgnoreCase(displayUserName))
                    {
                        displayUserNameTrack = 1;
                        displayUserDetails(displayUNode);
                        break;
                    }
                    else
                    {
                        displayUNode = displayUNode.next;
                    }
                }
                if(displayUserNameTrack != 1)
                {
                    Label displayUserLabel2 = new Label("User not Found!!!");
                    displayUserLabel2.setBounds(150,300,100,25);
                    add(displayUserLabel2);
                }
                
            }
        });
       displayUserButton2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminWindow();
            }});
    }
    UserDetails displayNode;
    void displayUserDetails(UserDetails displayNode)
    {
        this.displayNode = displayNode;
        removeAll();
        
        Label screenLabel11=new Label("USER INFORMATION");
	screenLabel11.setBounds(200,50,421,25);
	Font myFont=new Font("Serif",Font.BOLD,25);
	screenLabel11.setFont(myFont);
	add(screenLabel11);
        
        Label displayUserLabel11 = new Label("User Id          :     "+displayNode.userId);
        displayUserLabel11.setBounds(100,100,500,25);
        add(displayUserLabel11);
        
        Label displayUserLabel12 = new Label("User Name        :     "+displayNode.name);
        displayUserLabel12.setBounds(100,150,500,25);
        add(displayUserLabel12);

        Label displayUserLabel13 = new Label("Age              :     "+displayNode.age);
        displayUserLabel13.setBounds(100,200,500,25);
        add(displayUserLabel13);

        Label displayUserLabel14 = new Label("Sex              :     "+displayNode.sex);
        displayUserLabel14.setBounds(100,250,500,25);
        add(displayUserLabel14);

        Label displayUserLabel15 = new Label("Address          :     "+displayNode.address);
        displayUserLabel15.setBounds(100,300,500,25);
        add(displayUserLabel15);

        Label displayUserLabel16 = new Label("Contact Number   :     "+displayNode.phoneNumber);
        displayUserLabel16.setBounds(100,350,300,25);
        add(displayUserLabel16);

        Label displayUserLabel17 = new Label("Email Id         :     "+displayNode.emailId);
        displayUserLabel17.setBounds(100,400,500,25);
        add(displayUserLabel17);
        
        Button displayUserButton11 = new Button("OK");
        displayUserButton11.setBounds(300,450,50,25);
        add(displayUserButton11);
        
        displayUserButton11.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminWindow();
            }
        });
    }
    Label adminSettingslabel1,adminSettingslabel2,adminSettingslabel3,adminSettingsMainlabel1,adminSettingsMainlabel2;
    TextField adminSettingsTextfield1,adminSettingsTextfield2,adminSettingsTextfield3;
    Button adminSettingsButton1,adminSettingsButton2;
    String oldPassword,newPassword1,newPassword2;
    void adminSettings()
    {
        removeAll();
        adminSettingsMainlabel1=new Label("**** ADMIN SETTINGS ****");
        adminSettingsMainlabel1.setBounds(300,50,300,50);
        Font myFont1=new Font("Serif",Font.BOLD,20);
        adminSettingsMainlabel1.setFont(myFont1);
        add(adminSettingsMainlabel1);

        adminSettingsMainlabel2=new Label("**** Change Password ****");
        adminSettingsMainlabel2.setBounds(300,120,300,50);
        Font myFont2=new Font("Serif",Font.BOLD,15);
        adminSettingsMainlabel2.setFont(myFont2);
        add(adminSettingsMainlabel2);

        adminSettingslabel1=new Label(" Old Password ");
        adminSettingslabel1.setBounds(100,200,100,25);
        add(adminSettingslabel1);

        adminSettingsTextfield1=new TextField();
        adminSettingsTextfield1.setBounds(300,200,100,25);
        add(adminSettingsTextfield1);
        adminSettingsTextfield1.setEchoChar('*');

        adminSettingslabel2=new Label("New Password ");
        adminSettingslabel2.setBounds(100,250,100,25);
        add(adminSettingslabel2);

        adminSettingsTextfield2=new TextField();
        adminSettingsTextfield2.setBounds(300,250,100,25);
        add(adminSettingsTextfield2);
        adminSettingsTextfield2.setEchoChar('*');

        adminSettingslabel3=new Label(" Confirm new Password ");
        adminSettingslabel3.setBounds(100,300,150,25);
        add(adminSettingslabel3);

        adminSettingsTextfield3=new TextField();
        adminSettingsTextfield3.setBounds(300,300,100,25);
        add(adminSettingsTextfield3);
        adminSettingsTextfield3.setEchoChar('*');

        adminSettingsButton1=new Button("Confirm");
        adminSettingsButton1.setBounds(300,400,100,25);
        add(adminSettingsButton1);
        
        adminSettingsButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {  
                oldPassword = adminSettingsTextfield1.getText();
                newPassword1 = adminSettingsTextfield2.getText();
                newPassword2 = adminSettingsTextfield3.getText();
                if(oldPassword.contentEquals(Ldms1.predefinedPassword))
                {
                    if(newPassword1.contentEquals(newPassword2))
                    {
                        Ldms1.predefinedPassword = newPassword1;
                        Label adminSettingslabel4=new Label(" Password Reset Success ");
                        adminSettingslabel4.setBounds(100,500,200,25);
                        add(adminSettingslabel4);
                    }
                    else
                    {
                        Label adminSettingslabel4=new Label(" Re-entered password wrong ");
                        adminSettingslabel4.setBounds(100,500,200,25);
                        add(adminSettingslabel4);
                    }
                }
                else
                {
                    Label adminSettingslabel4=new Label(" Enter correct Password ");
                    adminSettingslabel4.setBounds(100,500,200,25);
                    add(adminSettingslabel4);
                }
            }
        });

        adminSettingsButton2=new Button("Back");
        adminSettingsButton2.setBounds(450,400,100,25);
        add(adminSettingsButton2);
        
        adminSettingsButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                adminWindow();
            }
        });
        
    }
    void fileWrite(Library writeNode) throws IOException
    {
        File write= new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\ldms-1\\src\\ldms\\pkg1\\doc.txt");
        FileWriter writefile = new FileWriter(write,true);
        BufferedWriter bufferwrite = new BufferedWriter(writefile);
        if(write.length()!=0)
        {
            bufferwrite.newLine();
        }
        bufferwrite.append(writeNode.bookIdentificationNo);
        bufferwrite.newLine();
        bufferwrite.append(writeNode.bookName);
        bufferwrite.newLine();
        bufferwrite.append(writeNode.bookAuthor);
        bufferwrite.newLine();
        bufferwrite.append(writeNode.bookSubject);
        bufferwrite.newLine();
        bufferwrite.append(writeNode.bookDescription);
        bufferwrite.newLine();
        bufferwrite.append(writeNode.bookPrice);
        bufferwrite.newLine();
        bufferwrite.append(writeNode.bookLocation);
        bufferwrite.newLine();
        bufferwrite.append(Integer.toString(writeNode.orginialCount));
        bufferwrite.close();
        writefile.close();
    }
}
class User extends Screen{
    Library userHead;
    Library displayNode;
    UserDetails regHead;
    String searchBookName;
    String searchBookAuthor;
    String searchBookSubject;
    int searchBookNameTrack;
    int searchBookAuthorTrack;
    int searchBookSubjectTrack;
    int instanceTrack = 0;
    Label registrationLabel1,registrationLabel2,registrationLabel3,registrationLabel4,registrationLabel5,registrationLabel6,registrationMainLabel;
    TextField registrationTextField1,registrationTextField2,registrationTextField3,registrationTextField4,registrationTextField5;
    Checkbox registrationCheckBox1,registrationCheckBox2;
    Button registrationButton1,registrationButton2,registrationButton3;
    CheckboxGroup registrationCheckBoxGroup;
    User()
    {
        removeAll();
        
        Label adminLabel2=new Label("****USER****");
	adminLabel2.setBounds(550,25,300,50);
	Font myFont=new Font("Serif",Font.BOLD,20);
	adminLabel2.setFont(myFont);
	add(adminLabel2);
        
        Button userButton1 = new Button("SEARCH BOOK");
        userButton1.setBounds(575,100,100,50);
        add(userButton1);
        
        userButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
              searchBook();
            }
        });
        
        Button userButton2 = new Button("FEEDBACK");
        userButton2.setBounds(575,175,100,50);
        add(userButton2);
        
        userButton2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
               feedback();
            }
        });
        
        Button userButton3 = new Button("REGISTRATION");
        userButton3.setBounds(575,250,100,50);
        add(userButton3);
        
        userButton3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
               registration();
            }
        });
        
        Button userButton4 = new Button("BACK");
        userButton4.setBounds(600,325,50,25);
        add(userButton4);
        
        userButton4.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
               new Screen();
            }
        });
    }
    void searchBook()
    { 
        removeAll();
        if(this instanceof Admin)
        {
           instanceTrack = 1;
        }
        this.userHead = Ldms1.head;
        if(this.userHead == null)
        {
           Label searchBookByNameLabel1 = new Label("There are no books available");
           searchBookByNameLabel1.setBounds(300,200,500,25);
           add(searchBookByNameLabel1);  
           
           Button searchBookButton5 = new Button("Cancel");
           searchBookButton5.setBounds(400,300,50,25);
           add(searchBookButton5);
           
           searchBookButton5.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    if(instanceTrack == 1)
                        new Admin().adminWindow();
                    else
                        new User();
                }
            });
        }
        else
        {
            Label searchBookLabel1 = new Label("SEARCH BY");
            searchBookLabel1.setBounds(300,100,200,50);
            add(searchBookLabel1);

            Button searchBookButton1 = new Button("BOOK NAME");
            searchBookButton1.setBounds(450,200,100,50);
            add(searchBookButton1);

            Button searchBookButton2 = new Button("AUTHOR NAME");
            searchBookButton2.setBounds(450,300,100,50);
            add(searchBookButton2);

            Button searchBookButton3 = new Button("SUBJECT");
            searchBookButton3.setBounds(450,400,100,50);
            add(searchBookButton3);
            
            Button searchBookButton4 = new Button("Back");
            searchBookButton4.setBounds(475,500,50,25);
            add(searchBookButton4);

            searchBookButton1.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    searchBookByName();
                }
            });

            searchBookButton2.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    searchBookByAuthor();
                }
            });

            searchBookButton3.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    searchBookBySubject();
                }
            });
            
            searchBookButton4.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                     if(instanceTrack == 1)
                        new Admin().adminWindow();
                    else
                        new User();
                }
            });
        }
    }
    void searchBookByName()
    {
       removeAll();
       this.userHead = Ldms1.head;
       Label searchBookByNameLabel1 = new Label("Book Name");
       searchBookByNameLabel1.setBounds(100,100,100,25);
       add(searchBookByNameLabel1);
       
       TextField searchBookByNameTextField1 = new TextField();
       searchBookByNameTextField1.setBounds(300,100,100,25);
       add(searchBookByNameTextField1);
       
       Button searchBookByNameButton1 = new Button("Submit");
       searchBookByNameButton1.setBounds(150,150,50,25);
       add(searchBookByNameButton1);
       
       Button searchBookByNameButton2 = new Button("Back");
       searchBookByNameButton2.setBounds(300,150,50,25);
       add(searchBookByNameButton2);
        
       searchBookByNameButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBookNameTrack = 0;
                searchBookName = searchBookByNameTextField1.getText();
                while(userHead != null)
                {
                    if(userHead.bookName.equalsIgnoreCase(searchBookName))
                    {
                        searchDisplay(userHead);
                        searchBookNameTrack = 1;
                        break;
                    }
                    else
                    {
                        userHead = userHead.next;
                    }
                }
                if(searchBookNameTrack != 1)
                {
                    Label searchBookByNameLabel2 = new Label("Book not Found!!!");
                    searchBookByNameLabel2.setBounds(150,300,100,25);
                    add(searchBookByNameLabel2);
                }
                
            }
        });
       searchBookByNameButton2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }});
    }
    void searchDisplay(Library displayNode)
    {
        removeAll();
        this.displayNode = displayNode;
        
        Label screenLabel111=new Label("BOOK INFORMATION");
	screenLabel111.setBounds(200,50,421,25);
	Font myFont=new Font("Serif",Font.BOLD,25);
	screenLabel111.setFont(myFont);
	add(screenLabel111);
        
        Label searchDisplayLabel1 = new Label("Book Accession no        :     "+this.displayNode.bookAccessionNO);
        searchDisplayLabel1.setBounds(100,100,800,25);
        add(searchDisplayLabel1);
        
        Label searchDisplayLabel2 = new Label("Book Identification NO   :     "+this.displayNode.bookIdentificationNo);
        searchDisplayLabel2.setBounds(100,150,800,25);
        add(searchDisplayLabel2);
        
        Label searchDisplayLabel3 = new Label("Book Name                :     "+this.displayNode.bookName);
        searchDisplayLabel3.setBounds(100,200,800,25);
        add(searchDisplayLabel3);
        
        Label searchDisplayLabel4 = new Label("Author Name              :     "+this.displayNode.bookAuthor);
        searchDisplayLabel4.setBounds(100,250,800,25);
        add(searchDisplayLabel4);
        
        Label searchDisplayLabel5 = new Label("Subject                  :     "+this.displayNode.bookSubject);
        searchDisplayLabel5.setBounds(100,300,800,25);
        add(searchDisplayLabel5);
        
        Label searchDisplayLabel6 = new Label("Description              :     "+this.displayNode.bookDescription);
        searchDisplayLabel6.setBounds(100,350,800,25);
        add(searchDisplayLabel6);
        
        Label searchDisplayLabel7 = new Label("Book Price               :     "+this.displayNode.bookPrice);
        searchDisplayLabel7.setBounds(100,400,800,25);
        add(searchDisplayLabel7);
        
        Label searchDisplayLabel8 = new Label("Book Location            :     "+this.displayNode.bookLocation);
        searchDisplayLabel8.setBounds(100,450,700,25);
        add(searchDisplayLabel8);
        
        Label searchDisplayLabel9 = new Label("Book Count               :     "+this.displayNode.bookCount);
        searchDisplayLabel9.setBounds(100,500,700,25);
        add(searchDisplayLabel9);
       
        Button searchDisplayButton1 = new Button("OK");
        searchDisplayButton1.setBounds(150,550,50,25);
        add(searchDisplayButton1);

        searchDisplayButton1.addActionListener(new ActionListener() 
         {
             @Override
             public void actionPerformed(ActionEvent e) {
                 searchBook();
             }});
    }
    void searchBookByAuthor()
    {
       removeAll();
       this.userHead = Ldms1.head;
       Label searchBookByAuthorLabel1 = new Label("Author Name");
       searchBookByAuthorLabel1.setBounds(100,100,100,25);
       add(searchBookByAuthorLabel1);
       
       TextField searchBookByAuthorTextField1 = new TextField();
       searchBookByAuthorTextField1.setBounds(300,100,100,25);
       add(searchBookByAuthorTextField1);
       
       Button searchBookByAuthorButton1 = new Button("Submit");
       searchBookByAuthorButton1.setBounds(150,150,50,25);
       add(searchBookByAuthorButton1);
        
       Button searchBookByAuthorButton2 = new Button("Back");
       searchBookByAuthorButton2.setBounds(300,150,50,25);
       add(searchBookByAuthorButton2);
       
       searchBookByAuthorButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBookAuthorTrack = 0;
                searchBookAuthor = searchBookByAuthorTextField1.getText();
                while(userHead != null)
                {
                    if(userHead.bookAuthor.equalsIgnoreCase(searchBookAuthor))
                    {
                        searchDisplay(userHead);
                        searchBookAuthorTrack = 1;
                        break;
                    }
                    else
                    {
                        userHead = userHead.next;
                    }
                }
                if(searchBookAuthorTrack != 1)
                {
                    Label searchBookByAuthorLabel2 = new Label("Book not Found!!!");
                    searchBookByAuthorLabel2.setBounds(150,300,100,25);
                    add(searchBookByAuthorLabel2);
                }
                
            }
        });
       searchBookByAuthorButton2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }});
    }
    void searchBookBySubject()
    {
       removeAll();
       this.userHead = Ldms1.head;
       Label searchBookBySubjectLabel1 = new Label("Subject");
       searchBookBySubjectLabel1.setBounds(100,100,100,25);
       add(searchBookBySubjectLabel1);
       
       TextField searchBookBySubjectTextField1 = new TextField();
       searchBookBySubjectTextField1.setBounds(300,100,100,25);
       add(searchBookBySubjectTextField1);
       
       Button searchBookBySubjectButton1 = new Button("Submit");
       searchBookBySubjectButton1.setBounds(150,150,50,25);
       add(searchBookBySubjectButton1);
        
       Button searchBookBySubjectButton2 = new Button("Back");
       searchBookBySubjectButton2.setBounds(300,150,50,25);
       add(searchBookBySubjectButton2);
       
       searchBookBySubjectButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBookSubjectTrack = 0;
                searchBookSubject = searchBookBySubjectTextField1.getText();
                while(userHead != null)
                {
                    if(userHead.bookSubject.equalsIgnoreCase(searchBookSubject))
                    {
                        searchDisplay(userHead);
                        searchBookSubjectTrack = 1;
                        break;
                    }
                    else
                    {
                        userHead = userHead.next;
                    }
                }
                if(searchBookSubjectTrack != 1)
                {
                    Label searchBookBySubjectLabel2 = new Label("Book not Found!!!");
                    searchBookBySubjectLabel2.setBounds(150,300,100,25);
                    add(searchBookBySubjectLabel2);
                }
                
            }
        });
       searchBookBySubjectButton2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }});
    }
    String tempSex;
    void registration()
    {
        removeAll();
        registrationMainLabel=new Label("******USER REGISTRATION****** ");
	Font myFont=new Font("Serif",Font.BOLD,20);
	registrationMainLabel.setFont(myFont);
        registrationMainLabel.setBounds(350,50,400,100);
	add(registrationMainLabel);
		
	registrationLabel1= new Label("Name");
	registrationLabel1.setBounds(100,150,100,25);
	add(registrationLabel1);
	registrationTextField1=new TextField();
	registrationTextField1.setBounds(300,150,200,25);
	add(registrationTextField1);
		
		
	registrationLabel2=new Label("Age");
	registrationLabel2.setBounds(100,200,100,25);
	add(registrationLabel2);
	registrationTextField2=new TextField();
	registrationTextField2.setBounds(300,200,200,25);
	add(registrationTextField2);
		
		
	registrationLabel3=new Label("sex");
	registrationLabel3.setBounds(100,250,100,25);
	add(registrationLabel3);
		
	registrationLabel4=new Label("Address");
	registrationLabel4.setBounds(100,300,100,25);
	add(registrationLabel4);
	registrationTextField3=new TextField();
	registrationTextField3.setBounds(300,300,200,50);
	add(registrationTextField3);
		
	registrationLabel5=new Label("Contact Number");
	registrationLabel5.setBounds(100,400,100,25);
	add(registrationLabel5);
	registrationTextField4=new TextField();
	registrationTextField4.setBounds(300,400,200,25);
	add(registrationTextField4);
		
	registrationLabel6=new Label("Email Id");
	registrationLabel6.setBounds(100,450,100,25);
	add(registrationLabel6);
	registrationTextField5=new TextField();
	registrationTextField5.setBounds(300,450,200,25);
	add(registrationTextField5);
		
	registrationCheckBoxGroup= new CheckboxGroup();
	registrationCheckBox1= new Checkbox("Male",registrationCheckBoxGroup,false);
	registrationCheckBox1.setBounds(300,250,100,25);
	add(registrationCheckBox1);
		
	registrationCheckBox2= new Checkbox("Female",registrationCheckBoxGroup,false);
	registrationCheckBox2.setBounds(450,250,100,25);
	add(registrationCheckBox2);
		
	registrationButton1=new Button("Submit");
	registrationButton1.setBounds(300,500,100,25);
	add(registrationButton1);
		
	registrationButton2=new Button("Reset");
	registrationButton2.setBounds(450,500,100,25);
	add(registrationButton2);
		
	registrationButton3=new Button("Back");
	registrationButton3.setBounds(600,500,100,25);
	add(registrationButton3);
        
        registrationCheckBox1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                tempSex = e.getStateChange()==1?"Male":"";
            }
        });
        
        registrationCheckBox2.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                tempSex = e.getStateChange()==1?"Female":"";
            }
        });
        
        registrationButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                regHead=Ldms1.uhead;
                if(regHead == null)
                {
                    regHead = new UserDetails();
                    regHead.next = null;
                    Ldms1.uhead = regHead;
                }
                else
                {
                    while(regHead.next != null)
                    {
                        regHead = regHead.next;
                    }
                    regHead.next = new UserDetails();
                    regHead.next.next = null;
                    regHead = regHead.next;
                }
                regHead.name = registrationTextField1.getText();
                regHead.age = Integer.parseInt(registrationTextField2.getText());
                regHead.address = registrationTextField3.getText();
                regHead.phoneNumber = registrationTextField4.getText();
                regHead.emailId = registrationTextField5.getText();
                regHead.sex = tempSex;
                Ldms1.userId+=1;
                regHead.userId = Ldms1.userId;
                try {
                    userFileWrite(regHead);
                } catch (IOException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
                new User();
            }
        });
        
        registrationButton2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
               registrationTextField1.setText(" ");
               registrationTextField1.setText("");
               registrationTextField2.setText(" ");
               registrationTextField2.setText("");
               registrationTextField3.setText(" ");
               registrationTextField3.setText("");
               registrationTextField4.setText(" ");
               registrationTextField4.setText("");
               registrationTextField5.setText(" ");
               registrationTextField5.setText("");
            }
        });
        
        registrationButton3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                new User();
            }
        });
    }
    Label feedbacklabel1, feedbacklabel2, feedbackMainlabel;
    TextField feedbackTextfield1, feedbackTextfield2;
    Button feedbackButton1, feedbackButton2, feedbackButton3;
    String[] name = new String [100];
    String[] feedback = new String[100];
    int index=0;
    void feedback()
    {
        removeAll();
        feedbackMainlabel=new Label("****USER FEEDBACK****");
	feedbackMainlabel.setBounds(300,50,300,100);
	Font myFont=new Font("Serif",Font.BOLD,20);
	feedbackMainlabel.setFont(myFont);
	add(feedbackMainlabel);
		
	feedbacklabel1=new Label("Name  ");
	feedbacklabel1.setBounds(100,150,100,25);
	add(feedbacklabel1);
		
	feedbackTextfield1=new TextField();
	feedbackTextfield1.setBounds(300,150,100,25);
	add(feedbackTextfield1);
		
	feedbacklabel2=new Label("Feedback  ");
	feedbacklabel2.setBounds(100,200,100,25);
	add(feedbacklabel2);
		
	feedbackTextfield2=new TextField();
	feedbackTextfield2.setBounds(300,200,500,100);
	add(feedbackTextfield2);
		
	feedbackButton1=new Button("Submit");
	feedbackButton1.setBounds(300,400,100,25);
	add(feedbackButton1);
		
	feedbackButton2=new Button("Back");
	feedbackButton2.setBounds(450,400,100,25);
	add(feedbackButton2);
        
        if(index==99)
        {
            index = 0;
        }
        
        feedbackButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
               name[index] = feedbackTextfield1.getText();
               feedback[index] = feedbackTextfield2.getText();
               index++;
               new User();
            }
        });
        
        
        feedbackButton2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
               new User();
            }
        });
    }
    void userFileWrite(UserDetails userFileNode) throws IOException
    {
        File userwrite= new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\ldms-1\\src\\ldms\\pkg1\\user.txt");
        FileWriter writeuserfile = new FileWriter(userwrite,true);
        BufferedWriter userbufferwrite = new BufferedWriter(writeuserfile);
        if(userwrite.length()!=0)
        {
            userbufferwrite.newLine();
        }
        userbufferwrite.append(Integer.toString(userFileNode.userId));
        userbufferwrite.newLine();
        userbufferwrite.append(userFileNode.name);
        userbufferwrite.newLine();
        userbufferwrite.append(Integer.toString(userFileNode.age));
        userbufferwrite.newLine();
        userbufferwrite.append(userFileNode.sex);
        userbufferwrite.newLine();
        userbufferwrite.append(userFileNode.address);
        userbufferwrite.newLine();
        userbufferwrite.append(userFileNode.phoneNumber);
        userbufferwrite.newLine();
        userbufferwrite.append(userFileNode.emailId);
        userbufferwrite.close();
        writeuserfile.close();
    }
}
class Library
{
    int bookAccessionNO;
    int bookCount;
    int orginialCount;
    String bookPrice,bookLocation;
    String bookName;
    String bookIdentificationNo;
    String bookAuthor;
    String bookSubject;
    String bookDescription;  
    int[] bookUserId = new int[this.orginialCount];
    Library next;
}
class UserDetails
{
    String name;
    String address,emailId,phoneNumber,sex;
    int age;
    int userId;
    UserDetails next;
}
public class Ldms1 {
    public static Library head = null;
    public static UserDetails uhead = null;
    public static int bookAccessionNo=0;
    public static int userId=0;
    public static String predefinedPassword = "0000";
    public static void main(String[] args) throws IOException {
      new FileHandling(); 
      Screen s = new Screen();
      //new Admin().addBook();
    }  
}
class FileHandling 
{
    Library newFile;
    UserDetails newUserFile;
    FileHandling() throws IOException {
    File readfilebook= new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\ldms-1\\src\\ldms\\pkg1\\doc.txt");
    Scanner doc = new Scanner(readfilebook);
    while(doc.hasNext())
    {
        this.newFile = Ldms1.head;
        if(this.newFile == null)
        {
          this.newFile = new Library();
          this.newFile.next = null;
          Ldms1.head = this.newFile;
        }
        else
        {
           while(this.newFile.next != null)
           {
               this.newFile = this.newFile.next;
           }
           this.newFile.next = new Library();
           this.newFile.next.next = null;
           this.newFile = this.newFile.next;
        }
        newFile.bookIdentificationNo = doc.nextLine();
        newFile.bookName = doc.nextLine();
        newFile.bookAuthor = doc.nextLine();
        newFile.bookSubject = doc.nextLine();
        newFile.bookDescription = doc.nextLine();
        newFile.bookPrice = doc.nextLine();
        newFile.bookLocation = doc.nextLine();
        newFile.orginialCount = Integer.parseInt(doc.nextLine());
        newFile.bookCount = newFile.orginialCount;
        Ldms1.bookAccessionNo+=1;
        newFile.bookAccessionNO = Ldms1.bookAccessionNo;
    }
    doc.close();
    File readuserfile= new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\ldms-1\\src\\ldms\\pkg1\\user.txt");
    Scanner userdocread = new Scanner(readuserfile);
    while(userdocread.hasNext())
    {   
        this.newUserFile = Ldms1.uhead;
        if(this.newUserFile == null)
        {
          this.newUserFile = new UserDetails();
          this.newUserFile.next = null;
          Ldms1.uhead = this.newUserFile;
        }
        else
        {
           while(this.newUserFile.next != null)
           {
               this.newUserFile = this.newUserFile.next;
           }
           this.newUserFile.next = new UserDetails();
           this.newUserFile.next.next = null;
           this.newUserFile = this.newUserFile.next;
        }
        newUserFile.userId = Integer.parseInt(userdocread.nextLine());
        newUserFile.name = userdocread.nextLine();
        newUserFile.age = Integer.parseInt(userdocread.nextLine());
        newUserFile.sex = userdocread.nextLine();
        newUserFile.address = userdocread.nextLine();
        newUserFile.phoneNumber = userdocread.nextLine();
        newUserFile.emailId = userdocread.nextLine(); 
        
    }
     userdocread.close();    
}
}
