package view;

import entities.User;
import service.UserService;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void displayMenuHome(Scanner scanner, ArrayList<User> users){
        System.out.println("1 : Dang nhap :");
        System.out.println("2 : Dang ky : ");
        System.out.println("Please choose : ");
        int choice = Integer.parseInt(scanner.nextLine());
        UserService userService = new UserService();
        switch (choice){
            case 1 :
                System.out.println("Da chon 1 : ");
                userService.login(scanner,users);
                break;
            case 2 :
                System.out.println("Da chon 2 : ");
                userService.register(scanner,users);
                break;
        }
    }
    public void dilayMenuLogin(Scanner scanner,ArrayList<User> users,User userLogin) {

        System.out.println("1 - Dang nhap lai : ");
        System.out.println("2 - Quen mat khau : ");
        System.out.println("Please chooose : ");
        int choice1 = Integer.parseInt(scanner.nextLine());

        switch (choice1) {
            case 1:
                System.out.println("Da chon 1 : ");
                Menu userTest = new Menu();
                userTest.displayMenuHome(scanner, users);
                break;
            case 2:
                System.out.println("Da chon 2 : ");
                System.out.println("Moi ban nhap dia chi email : ");
                User userTest1 = new User();
                userTest1.setEmail(scanner.nextLine());
                boolean check = true;
                while (check){for (User user : users) {
                    check = false;
                    if (user.getEmail().equalsIgnoreCase(userTest1.getEmail()) ) {
                        System.out.println("Moi ban nhap password moi ");

                        userTest1.setPassWord(scanner.nextLine());
                        userLogin.setPassWord(userTest1.getPassWord());
                        System.out.println("Password moi cua ban la : "+(userLogin.getPassWord()));

                        Menu menu = new Menu();
                        menu.displayMenuHome(scanner,users);
                        check = true;
                        break;
                    }
                    if (!user.getEmail().equalsIgnoreCase(userTest1.getEmail())) {
                        System.out.println("Khong ton tai tai khoan dang ky bang email nay ");
                        break;
                    }
                }
                }


                    break;

        }
    }
    public void displayMenuLast(Scanner scanner,ArrayList<User> users,User userLogin){
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
                Boolean notFounded = true;
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
                Menu menu = new Menu();
                menu.dilayMenuLogin(scanner,users,userLogin);
                break;
            case 0 :

                break;

        }

    }
    }
