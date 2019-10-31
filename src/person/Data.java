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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

    public static ArrayList<Person> persons = new ArrayList<>();
    public static Scanner kb = new Scanner(System.in);

    public static boolean isUserPasswordCorrect(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }
        for (Person p : persons) {
            if (p.getUsername().equals(username)) {
                if (p.getPassword().equals(password)) {
                    System.out.println("Login Success!!");
                    return true;
                }
            }
        }
        return false;
        // TODO Auto-generated method stub
    }

    static void add() {
        String name = checkInput("name : ");
        String lastname = checkInput("lastname : ");
        String gender = checkInput("gender : ");
        int age = addAge();
        String tel = checkInput("tel : ");
        String username = checkInput("username : ");
        String password = checkInput("password : ");

        if (checkUser(username)) {

            persons.add(new Person(name, lastname, gender, age, tel, username, password));
            System.out.println("Add user success");
            save();
            Menu.showMenu();
        }
        System.out.println("Username already exists!!");
        Menu.showMenu();

    }

    static String checkInput(String nameInput) {
        String printType = nameInput;
        System.out.print(printType);
        String input = kb.next();
        if (input.equals(null)) {
            return checkInput(printType);
        } else {
            return input;
        }

    }

    public static int addAge() {
        System.out.print("age : ");
        String a = kb.next();
        try {
            int age = Integer.parseInt(a);
            if(age <=0){
                System.out.println("Input Age Again");
                return addAge();
            }else{
               return age; 
            }
            
        } catch (Exception e) {
            System.out.println("Input Age Again");
            return addAge();
        }

        /*
            System.out.print("age : ");
            Integer age = kb.nextInt();
            try {
                if(age instanceof Integer){
                
                }else{
                    System.out.println("Input age Again"); 
                    addAge();
                }
            }catch(Exception e){
                    System.out.println("Input age Again"); 
                    addAge();
		}*/
    }

    static Boolean checkUser(String username) {
        for (Person p : persons) {
            if (p.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    static void save() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("PersonList.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(persons);
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        } catch (IOException e) {
            System.out.println("Error");
        }

        if (oos != null) {
            try {
                oos.close();
            } catch (IOException e) {
                System.out.println("Error");
            }
        }

        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }

    static void load() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("PersonList.bin");
            ois = new ObjectInputStream(fis);
            persons = (ArrayList<Person>) ois.readObject();
        } catch (FileNotFoundException e) {
            save();
            load();
            //System.out.println("File not found Error");
        } catch (ClassNotFoundException e) {
            System.out.println("Error");
        } catch (IOException e) {
            System.out.println("Error");
        }

        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }

    static void showUser() {
        System.out.println("Show User");
        System.out.println("No. |  Name");
        for (int i = 0; i < persons.size(); i++) {
            System.out.println(" " + (i + 1) + "  |  " + persons.get(i).getName() + " " + persons.get(i).getLastname());
        }

        showUserDetail();
    }

    public static void showUserDetail() {
        try {
            System.out.print("input Username : ");
            String select = kb.next();
            int index = Integer.parseInt(select)-1;
            System.out.println("------------------");
            System.out.println("Name : " + persons.get(index).getName());
            System.out.println("Lastname : " + persons.get(index).getLastname());
            System.out.println("Gender : " + persons.get(index).getGender());
            System.out.println("Age : " + persons.get(index).getAge());
            System.out.println("Tel. : " + persons.get(index).getTel());
            System.out.println("Username : " + persons.get(index).getUsername());
            System.out.println("------------------");
            showUserBack();
        } catch (Exception e) {
            System.out.println("Input Error");
            showUserBack();
        }
        /*for (;;) {
            System.out.print("input Username : ");
            String select = kb.next();
            System.out.println("------------------");
            for (int i = 0; i < persons.size(); i++) {
                if (select.equals(persons.get(i).getUsername())) {
                    System.out.println("Name : " + persons.get(i).getName());
                    System.out.println("Lastname : " + persons.get(i).getLastname());
                    System.out.println("Gender : " + persons.get(i).getGender());
                    System.out.println("Age : " + persons.get(i).getAge());
                    System.out.println("Tel. : " + persons.get(i).getTel());
                    System.out.println("Username : " + persons.get(i).getUsername());
                    System.out.println("------------------");
                    showUserBack();
                }
                if (persons.size() == (i + 1)) {
                    System.out.println("Username Not Found!!");
                    showUserBack();
                }
            }
            System.out.println("-----------------");

        }*/

    }

    public static void showUserBack() {
        System.out.println("Select (0) Back to Menu");
        System.out.println("Select (1) Show User Detail Again");
        try {
            System.out.print("Input Number : ");
            String select = kb.next();
            switch (select) {
                case "0":
                    Menu.showMenu();
                case "1":
                    showUser();
                default:
                    System.out.println("Input Again!!");
                    showUserBack();

            }
        } catch (Exception e) {
            System.out.println("Input Number Again");
            showUserBack();
        }
    }

    public static void showEditUser() {
        for (int i = 0; i < persons.size(); i++) {
            if (PersonDB.userName.equals(persons.get(i).getUsername())) {
                System.out.println("Edit User");
                System.out.println("Please select number");
                System.out.println("(1) Name : " + persons.get(i).getName());
                System.out.println("(2) Lastname : " + persons.get(i).getLastname());
                System.out.println("(3) Gender : " + persons.get(i).getGender());
                System.out.println("(4) Age : " + persons.get(i).getAge());
                System.out.println("(5) Tel. : " + persons.get(i).getTel());
                System.out.println("(6) Password : " + persons.get(i).getPassword());
                System.out.println("(0) Back to menu");
                editUserDetail(i);
            }
        }
    }

    public static void editUserDetail(int index) {
        System.out.print("Input edit number : ");
        String editNumber = kb.next();
        String edit;
        switch (editNumber) {
            case "1":
                System.out.print("Name : ");
                edit = kb.next();
                if (editConfirm(index)) {

                    persons.get(index).setName(edit);
                    save();
                    showEditUser();
                } else {
                    showEditUser();
                }
            case "2":
                System.out.print("Lastname : ");
                edit = kb.next();
                if (editConfirm(index)) {
                    persons.get(index).setLastname(edit);
                    save();
                    showEditUser();
                } else {
                    showEditUser();
                }
            case "3":
                System.out.print("Gender : ");
                edit = kb.next();
                if (editConfirm(index)) {
                    persons.get(index).setGender(edit);
                    save();
                    showEditUser();
                } else {
                    showEditUser();
                }
            case "4":
                System.out.print("Age : ");
                int sAge;
                sAge = addAge();
                if (editConfirm(index)) {
                    if (sAge != (int) sAge) {
                        System.out.println("age is correct!!!");

                    }
                    persons.get(index).setAge(sAge);
                    save();
                    showEditUser();
                } else {
                    showEditUser();
                }
            case "5":
                System.out.print("Tel. : ");
                edit = kb.next();
                if (editConfirm(index)) {
                    persons.get(index).setTel(edit);
                    save();
                    showEditUser();
                } else {
                    showEditUser();
                }
            case "6":
                System.out.print("Old Password : ");
                String passW = kb.next();
                System.out.print("new Password : ");
                edit = kb.next();
                if (persons.get(index).getPassword().equals(passW)) {
                    System.out.println("Edit Success");
                    persons.get(index).setPassword(edit);
                    save();
                    showEditUser();
                } else {
                    System.out.println("Old password incorrect!!");
                    showEditUser();
                }
            case "del":
                persons.remove(index);
                save();
                PersonDB.Login();
            case "0":
                Menu.showMenu();
            default:
                System.out.println("Try again");
                showEditUser();

        }
    }

    public static boolean editConfirm(int index) {
        System.out.print("Please confirm password : ");
        String sure = kb.next();
        System.out.println(sure);
        if (sure.equals(persons.get(index).getPassword())) {
            System.out.println("Edit Success");
            return true;
        } else {
            System.out.println("Edit Fail");
            return false;
        }
    }

}
