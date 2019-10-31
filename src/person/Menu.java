/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

/**
 *
 * @author ASUS
 */
import java.util.Scanner;
import static person.Data.add;
import static person.Data.load;
import static person.Data.showUser;

public class Menu {
	public static void showMenu() {
		System.out.println("Select (1) go to Add User");
		System.out.println("Select (2) go to Edit User");
		System.out.println("Select (3) go to Show User");
		System.out.println("Select (4) go to Logout");
                inputSelectMenu();
	}
	public static void inputSelectMenu() {
		Scanner max = new Scanner(System.in);
		try {
			System.out.print("Input Number : ");
			int select = max.nextInt();
			switch(select) {
			case 1 :
				add();
                                showMenu();
                               
			case 2 :
				Data.showEditUser();
                                showMenu();
                                
				
			case 3 :
                                showUser();
                                showMenu();
			case 4 :
				System.out.println("Logout Success!!");
                                PersonDB.Login();
				
			default :
				System.out.println("Input Again!!");
				inputSelectMenu();
				
			}
		}catch(Exception e){
			System.out.println("Input Number Again");
			inputSelectMenu();
		}
		
	}
        

    private static void addUsertoList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

