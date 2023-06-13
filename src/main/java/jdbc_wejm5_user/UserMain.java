package jdbc_wejm5_user;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		User user = new User();
		
		UserCRUD crud = new UserCRUD();
		
		boolean condition = true;
		do {
			System.out.println("Enter the choice \n1. SignUp User \n2. LoginUser \n3.Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("Enter the id");
				user.setId(scanner.nextInt());
				System.out.println("Enter the name");
				user.setName(scanner.next());
				System.out.println("Enter the Email");
				user.setEmail(scanner.next());
				System.out.println("Enter the password");
				user.setPassword(scanner.next());
				System.out.println("Enter the address");
				user.setAddress(scanner.next());
			
				crud.signupUser(user);
				
			}
			case 2:{
				System.out.println("Enter the Email");
				String email= scanner.next();
				user.setEmail(email);
				
				System.out.println("Enter the password");
				user.setPassword(scanner.next());
				
				boolean result = crud.loginUser(user);
				if (result) {
					System.out.println("Logged in Successfully");
					crud.displayPassword(email);
					
					boolean flag = true;
					do {
						System.out.println("Enter the choice \n1. Update passwords \n2.Log out");
						int choice1= scanner.nextInt();
						switch (choice1) {
						case 1:{
							System.out.println("Enter facebook password");
							String facebook = scanner.next();
							System.out.println("Enter Whatsapp password");
							String whatsapp = scanner.next();
							System.out.println("Enter snapchat password");
							String snapchat = scanner.next();
							System.out.println("Enter twitter password");
							String twitter = scanner.next();
							System.out.println("Enter instagram password");
							String instagram = scanner.next();
							
						    user.setFacebook(facebook);
						    user.setWhatsapp(whatsapp);
						    user.setSnapchat(snapchat);
						    user.setTwitter(twitter);
						    user.setInstagram(instagram);
						    
						    crud.updatePasswords(user);
						}

						default: flag =false;
							break;
						}
					} while (flag);
				} else {
	                System.out.println("Failed to login");
				}
				
				
			}
			break;

			default:
				condition = false;
				
			}
		} while (condition);
		
	}
}
