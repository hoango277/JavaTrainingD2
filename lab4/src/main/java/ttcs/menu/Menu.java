package ttcs.menu;

import ttcs.dao.UserDAO;
import ttcs.entity.User;

import java.util.Scanner;

public class Menu {
    private UserDAO userDao;
    private boolean isRunning;

    public Menu()
    {
        this.userDao = new UserDAO();
        this.isRunning = true;
    }

    public void showMenu()
    {
        Scanner sc = new Scanner(System.in);
        int n;
        while(this.isRunning)
        {
            System.out.println("=== MENU ===");
            System.out.println("1. Insert user");
            System.out.println("2. View all user");
            System.out.println("3. Get user with id");
            System.out.println("4. Delete user with id");
            System.out.println("5. Login");
            System.out.println("7. exit");
            System.out.print("Chọn chức năng: ");
            n = Integer.parseInt(sc.nextLine());
            switch(n)
            {
                case 1:
                    insertUser(sc);
                    break;
                case 2:
                    getAllUser();
                    break;
                case 3:
                    fetchUserById(sc);
                    break;
                case 4:
                    deleteUserById(sc);
                    break;
                case 5:
                    int choice = login(sc);
                    if(choice == 1)
                    {
                        boolean isAdminLogin = true;
                        while(isAdminLogin)
                        {
                            System.out.println("=== MENU ADMIN ===");
                            System.out.println("1. Đăng xuất tài khoản admin");
                            System.out.println("2. Tạo tài khoản employee");
                            int adminChoice = Integer.parseInt(sc.nextLine());
                            if(adminChoice == 1) {
                                isAdminLogin = false;
                            }
                            else {
                                createEmployee(sc);
                            }
                        }
                    }
                    break;

                case 7:
                    exit();
                    break;

            }
        }
    }

    public void exit()
    {
        this.isRunning = false;
    }

    public void getAllUser()
    {
        this.userDao.showAllUser();
    }

    public void insertUser(Scanner sc)
    {
        System.out.println("Điền full name");
        String fullname = sc.nextLine();
        String email = emailNormalize(sc);
        String password = passwordNormalize(sc);
        System.out.println("Loại user ? 1. employee, 2. Admin");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                System.out.println("Nhập kĩ năng cho employee");
                String proSkill = sc.nextLine();
                User user = new User(fullname, email, password, proSkill);
                this.userDao.insertUser(user);
                break;
            case 2:
                System.out.println("Nhập số năm cho admin");
                int expInYears = Integer.parseInt(sc.nextLine());
                User admin = new User(fullname, email, password, expInYears);
                this.userDao.insertUser(admin);
                break;
        }
    }

    public void fetchUserById(Scanner sc)
    {
        System.out.println("Nhập id user muốn tìm");
        int id = Integer.parseInt(sc.nextLine());
        this.userDao.fetchUserById(id);
    }
    public void deleteUserById(Scanner sc)
    {
        System.out.println("Nhập id user muốn xóa");
        int id = Integer.parseInt(sc.nextLine());
        this.userDao.deleteUserById(id);
    }



    public String emailNormalize(Scanner sc)
    {
        System.out.println("Nhập email");
        String regex = "^[a-z]+(\\.[a-z]+)+@vti\\.com\\.vn$";
        String email = sc.nextLine().toLowerCase().trim();
        while(!email.matches(regex))
        {
            System.out.println("Email ko match định dạng, vui lòng nhập lại");
            email = sc.nextLine().toLowerCase().trim();
        }
        return email;
    }

    public String passwordNormalize(Scanner sc)
    {
        System.out.println("Nhập password");
        String regexPass = "^(?=.*[A-Z])(?=.{6,12}).*$";
        String password = sc.nextLine().trim();
        while(!password.matches(regexPass)) {
            System.out.println("Password không đúng định dạng");
            password = sc.nextLine().trim();
        }
        return password;
    }
    public int login(Scanner sc)
    {
            String email = emailNormalize(sc);
            String password = passwordNormalize(sc);
            return this.userDao.login(email, password);
    }

    public void createEmployee(Scanner sc)
    {
        System.out.println("Điền full name");
        String fullname = sc.nextLine();
        String email = emailNormalize(sc);
        String password = passwordNormalize(sc);
        System.out.println("Nhập kĩ năng cho employee");
        String proSkill = sc.nextLine();
        User user = new User(fullname, email, password, proSkill);
        this.userDao.insertUser(user);
    }


}
