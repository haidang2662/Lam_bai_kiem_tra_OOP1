package service;

import entities.User;
import view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    public void checkUsername(){

    }

    public void register(Scanner scanner,ArrayList<User> users){

        System.out.println("Moi ban nhap username moi : ");
        User newUser = new User();

        newUser.setUserName(scanner.nextLine());
        boolean notFounded = true;
        while (notFounded) {
            notFounded=false;
            for (User user : users) {
                if (user.getUserName().equalsIgnoreCase(newUser.getUserName())) {
                    System.out.println("Ten dang nhap da ton tai vui long chon ten khac : ");
                    newUser.setUserName(scanner.nextLine());
                    notFounded=true;
                    break;
                }
            }
        }
        System.out.println("Moi ban nhap email : ");
        newUser.setEmail(scanner.nextLine());
        boolean notAccept = true;
        while (notAccept) {
            notAccept=false;
            for (User user : users) {
                if (user.getEmail().equalsIgnoreCase(newUser.getEmail())) {
                    System.out.println("Email Bi trung chon email khac : ");
                    newUser.setEmail(scanner.nextLine());
                    notAccept=true;
                    break;
                }
            }
        }
        notAccept = true;
        while (notAccept) {
            notAccept=false;
            if (!newUser.getEmail().matches("^[a-zA-Z0-9][a-zA-Z0-9\\._%+\\-]{0,63}@[a-zA-Z0-9\\.-]+\\.[a-zA-Z]{2,30}$")) {
                System.out.println("Email Khong dung format chon email khac : ");
                newUser.setEmail(scanner.nextLine());
                System.out.println("email cua new la "+newUser.getEmail());
                notAccept=true;
            }
        }
        System.out.println("Moi ban nhap password : ");
        newUser.setPassWord(scanner.nextLine());
        notAccept=true;
        while (notAccept) {
            notAccept=false;
                if (!newUser.getPassWord().matches("^(?=.*[A-Z])(?=.*[.,-_;])[a-zA-Z0-9.,-_;]{7,15}$")) {
                    System.out.println("Password khong hop le chon password khac : ");
                    newUser.setPassWord(scanner.nextLine());
                    notAccept=true;
                }
        }
        System.out.println("Chuc mung tao thanh cong ");
        users.add(newUser);
        System.out.println("Danh sach user dang co : ");
        System.out.println(users);
    }
    public User login(Scanner scanner,ArrayList<User> users){
        User userLogin = new User();
        User userTest = new User("a","b","c");
        users.add(userTest);
        System.out.println("Moi ban nhap tai khoan : ");
        userLogin.setUserName(scanner.nextLine());
        boolean notFounded = true;

        while (notFounded) {
            notFounded=false;
            for (User user : users) {
                if (!user.getUserName().equalsIgnoreCase(userLogin.getUserName())) {
                    System.out.println("Kiểm tra lại username : ");
                    userLogin.setUserName(scanner.nextLine());
                    notFounded=true;
                    break;
                }
            }
        }
        System.out.println("Moi ban nhap password : ");
        userLogin.setPassWord(scanner.nextLine());

//        users.add(userLogin);
//        System.out.println(users);
        notFounded = true;
        Menu menu = new Menu();
        while (notFounded) {
            notFounded=false;
            for (User user : users) {
                if (!user.getPassWord().equalsIgnoreCase(userLogin.getPassWord())) {
                    System.out.println("Nhap password sai kiểm tra lại Password : ");
                    menu.dilayMenuLogin(scanner,users,userLogin);
                    notFounded=true;
                    break;
                } else {System.out.println("Chuc mung ban nhap dung password");
                    menu.displayMenuLast(scanner,users,userLogin);
                }
            }
            break;
        }

        return userLogin;
    }


    }

