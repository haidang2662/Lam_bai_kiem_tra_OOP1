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
    public void dilayMenuLogin(Scanner scanner,ArrayList<User> users) {

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
//                        userLogin.setPassWord(userTest1.getPassWord());
//                        System.out.println("Password moi cua ban la : "+(userLogin.getPassWord()));
                        check = true;
                        break;
                    }
                    if (!user.getEmail().equalsIgnoreCase(userTest1.getEmail())) {
                        System.out.println("Khong ton tai tai khoan dang ky bang email nay ");
                        break;
                    }
                }}


                    break;

        }

    }
    }
