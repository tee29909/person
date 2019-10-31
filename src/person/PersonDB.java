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
import static person.Data.load;

public class PersonDB {
	public static String userName;
	private static String passWord;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		load();
                Login();
                
	}
	
	public static Boolean Login() {
		for(;;) {
			showLogin();
			inputLogin();
			if(!Data.isUserPasswordCorrect(userName,passWord)) {
				showLoginError();
				continue;
			}
                        Menu();
			break;
		}
		return true;
	}
	public static void showLogin() {
		System.out.println("Login");
	}
	public static void inputLogin() {
		Scanner max = new Scanner(System.in);
		System.out.print("Username : ");
		userName = max.next(); 
		System.out.print("Password : ");
		passWord = max.next(); 
	}
	private static void showLoginError() {
		System.out.println("username or password incorrect!!");
		
	}
	private static void Menu() {
		Menu.showMenu();
		
	}

	

	

}
