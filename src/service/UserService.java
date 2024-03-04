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
        notFounded = true;
        Menu menu = new Menu();
        while (notFounded) {
            notFounded=false;
            for (User user : users) {
                if (!user.getPassWord().equalsIgnoreCase(userLogin.getPassWord())) {
                    System.out.println("Nhap password sai kiểm tra lại Password : ");
                    menu.dilayMenuLogin(scanner,users);
                    notFounded=true;
                    break;
                }
            }
            break;
        }
        System.out.println("chao mung "+(userLogin.getUserName()+", ban co the thuc hien cac cong viec sau"));
        System.out.println("1 : Thay doi username : ");
        System.out.println("2 : Thay doi email : ");
        System.out.println("3 : Thay doi mat khau  : ");
        System.out.println("4 : Dang xuat quay ve muc dang ky : ");
        System.out.println("0 : Thoat khoi chuong trinh  ");
        System.out.println("Please chooose : ");
        int choice2 = Integer.parseInt(scanner.nextLine());
        UserService userService = new UserService();
        switch (choice2){

            case 1 :
                System.out.println("Da chon 1 : ");
                System.out.println("Moi ban nhap username moi : ");
                User newUser = new User();
                newUser.setUserName(scanner.nextLine());
                notFounded = true;
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
                System.out.println("chuc mung ban da thay doi username thanh cong ");
                userLogin.setUserName(newUser.getUserName());
                System.out.println("Username moi cua ban la "+(userLogin.getUserName()));
                break;
            case 2 :
                System.out.println("Da chon 2 : ");
                System.out.println("Moi ban nhap email moi : ");
                User newUser1 = new User();
                newUser1.setEmail(scanner.nextLine());
                notFounded = true;
                while (notFounded) {
                    notFounded=false;
                    for (User user : users) {
                        if (user.getEmail().equalsIgnoreCase(newUser1.getEmail())) {
                            System.out.println("Email da ton tai vui long chon email khac : ");
                            newUser1.setEmail(scanner.nextLine());
                            notFounded=true;
                            break;
                        }
                    }
                }
                System.out.println("chuc mung ban da thay doi email thanh cong ");
                userLogin.setEmail(newUser1.getEmail());
                System.out.println("Email moi cua ban la "+(userLogin.getEmail()));
                break;
            case 3 :
                System.out.println("Da chon 3 : ");
                System.out.println("Moi ban nhap mat khau moi : ");
                User newUser2 = new User();
                newUser2.setPassWord(scanner.nextLine());
                boolean notAccept=true;
                while (notAccept) {
                    notAccept=false;
                    if (!newUser2.getPassWord().matches("^(?=.*[A-Z])(?=.*[.,-_;])[a-zA-Z0-9.,-_;]{7,15}$")) {
                        System.out.println("Password khong hop le chon password khac : ");
                        newUser2.setPassWord(scanner.nextLine());
                        notAccept=true;
                    }
                }
                System.out.println("Chuc mung doi password thanh cong ");
                userLogin.setPassWord(newUser2.getPassWord());
                System.out.println("Password moi la "+userLogin.getPassWord());

                break;
            case 4 :
                System.out.println("Da chon 4 : ");
                menu.dilayMenuLogin(scanner,users);
                break;
            case 0 :

                break;

        }


        return userLogin;
    }


    }

