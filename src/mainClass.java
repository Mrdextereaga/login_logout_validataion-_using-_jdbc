import java.util.*;
public class mainClass {

	public static void main(String[] args) throws Exception {

		Scanner sc=new Scanner (System.in);
		DBMethos db=new DBMethos();
		db.establishConnection();
//		String restcolor="\u001B[0m";
//		String yellow="\u001B[33m";
		User ul=null;
		boolean ch=true;
		do {
			
			System.out.println("---------------------VANAKAM DA MAPLA"+" "+Character.toString(0x1F60E)+"-------------");
			System.out.println("1.newUser\n2.Login\n3.Logout\n4.Exit");
			System.out.println("--------------------------------------------------");
			int choose=sc.nextInt();
			
		switch (choose) {
		case 1: {
			User u=new User();
			try{
				System.out.println("enter your id");
				int id=sc.nextInt();
				System.out.println("enter your first_name");
				String fname=sc.next();
				System.out.println("enter your last_namme");
				String lname=sc.next();
				System.out.println("enter your gender");
				String gender=sc.next();
				System.out.println("enter your email");
				String email=sc.next();
				System.out.println("enter your password");
				String password=sc.next();
				u.setId(id);
				u.setFirst_name(fname);
				u.setLast_name(lname);
				u.setGender(gender);
				u.setEmail(email);
				u.setPassword(password);
				db.saveUser(u);
				break;
			}
			catch(Exception e) {
			  System.out.println("enter valid input");
			  break;
			}
		
		}
		case 2:{ 
			
			System.out.println("Enter your email");
			String email=sc.next();

			User u=db.fecthByEmail(email);
			if(u==null) {
				System.out.println("enter valid email");
				break;
				}
//			System.out.println(u);
			if(email.equals(u.getEmail())) {
				System.out.println("enter your password");
				String pass=sc.next();
				if(pass.equals(u.getPassword())) {
					System.out.println("login successfull"+" "+Character.toString(0x1F601));
					ul=u;
					boolean check1=true;
					do {
						System.out.println("1.My profile \n 2.Edit your profile \n 3.Deactivate your profile\n4.Exit");
						int ch1=sc.nextInt();
	                    switch(ch1) {
	                    case 1:{
	                    	String che=email;
	                    	System.out.println("UNODA JATHAGAM DA AMBI...");
	                    	System.out.println( db.fecthByEmail(che));
	                    	break;
	                    }case 2:{
	                    	  System.out.println("1.edit your first_name\n2.edit your last_name\n3.edit your gender\n4.edit your email\n5.reset your password\n6.exit");
	                    	        int ed=sc.nextInt();
	                    	   switch(ed) {
	                    	   case 1:{
	                             System.out.println("edit your first_name");
	                             String edfname=sc.next();
	                             u.setFirst_name(edfname);
	                             db.upadate(u);
	                             break;
	                    
	                    	   }
	                    	   case 2:{
	                    		   System.out.println("edit your Last_name");
		                             String edlname=sc.next();
		                             u.setLast_name(edlname);
		                             db.upadate(u);
		                             break;
	                    	   }
	                    	   case 3:{
	                    		   System.out.println("edit your gender");
		                             String edgender=sc.next();
		                             u.setGender(edgender);
		                             db.upadate(u);
		                             break;
	                    	   }
	                    	   
	                    	   case 4:{
	                    		   System.out.println("edit your email");
		                             String edemail=sc.next();
		                             u.setEmail(edemail);
		                             db.upadate(u);
		                             break;
	                    	   }
	                    	   case 5:{
	                    		   System.out.println("enter your current password");
	                    		   String cur=sc.next();
	                    		   if(cur.equals(u.getPassword())) {
	                    			   System.out.println("enter new password");
	                    			   String newpass=sc.next();
	                    			   u.setPassword(newpass);
	                    			   db.upadate(u);
	                    			   break;
	                    		   }
	                    		   else {
	                    			   System.out.println("enter crt password");
	                    			   break;
	                    		   }
		                             
	                    	   }
	                    	   
	                    	   }
	                    	   
	                    	   }
	                    	 
	                    	  break;
	                    
	                    case 3:{
	                    	System.out.println("enter your email");
	                    	String deemail=sc.next();
	                    	User u1=db.fecthByEmail(deemail);
	                    	if(deemail.equals(u1.getEmail())) {
	                    		System.out.println("enter your password");
	                    		String depass=sc.next();
	                    		if(depass.equals(u1.getPassword())) {
	                    			db.deleteById(u1.getId());
		                    		System.out.println("deactivate successfull");
		                    		check1=false;
		                    		break;
	                    		}
	                    		
	                    	}
	                    	else {
	                    		System.out.println("enter valid email");
	                    		break;
	                    	}
	                    }
	                    case 4:{
	                    	check1=false;
	                    }
	                    }
					}while(check1);
					break;
				}
				else {
					System.out.println("enter valid password");
					break;
				}
				
			}
		 break;	
		}
		case 3:{
			if(ul!=null) {
			System.out.println("Logout successfull"+" "+Character.toString(0x1F62E)+" "+Character.toString(0x1F62E));
			ul=null;
			break;
			}
			else {
				System.out.println("first you have to login first");
			break;
			}
		}
		case 4:{
			ch=false;
			int em1=0x1F60D;
			int em2=0x1F44B;
			System.out.println("APP CLOSED DA MAPLA"+" "+Character.toString(em1)+" "+Character.toString(em2));
			break;
		}
			
		}
		}while(ch);
		
	}

}
