import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        repeat();
    }


    public static void printMenu() {
        System.out.println("1.Bankdakı işçiləri gör");
        System.out.println("2.Bankdakı spesfik işçini gör");
        System.out.println("3.Banka user əlavə et");
        System.out.println("4.Useri update et");
        System.out.println("5.Useri sil");
    }

    public static void repeat() {
        printMenu();
        process();
    }

    public static void process() {
        System.out.print("Seçim edin:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                showAllUser();
                break;
            case 2:
                showUserById();
                break;
            case 3:
                Bank.addUser(createUser());
                break;
            case 4:
                updateUser();
                break;
            case 5:
                deleteUser();
                break;
            default:
                System.out.println("Duzgun secim edin!");
        }
        repeat();
    }

    public static void updateUser() {
        System.out.println("Yenilemek istediyiniz userin id-i daxil edin:");
        int ide = sc.nextInt();
        boolean isFind=true;
        boolean isFull=true;
        for (int i=0;i<Bank.users.length;i++) {
            if (Bank.users[i] != null) {
                isFull=false;

            }
        }if(isFull) {
            System.out.println("Bu id-li user movcud deyil ::");
            return;
        }
        for(int i=0;i<Bank.users.length;i++){
            if(Bank.users[i]!=null && ide==Bank.users[i].id){
                isFind=false;
                break;
            }
        }
        if(isFind){
            System.out.println("Bu id-li user movcud deyil ");
            return;
        }

        System.out.println("Yeni userin id-i daxil edin:");
        int id = sc.nextInt();
        System.out.println("Yeni userin name-i daxil edin:");
        String name = sc.next();
        System.out.println("Yeni userin surname-i daxil edin:");
        String surname = sc.next();
        System.out.println("Yeni userin email-i daxil edin:");
        String email = sc.next();
        System.out.println("Yeni userin password-u daxil edin:");
        String password = sc.next();

        User use = new User(id, name, surname, email, password);
        Bank.updateUserById(ide,use);
    }

    public static void deleteUser() {
        System.out.println("Silmek istediyiniz userin id-i daxil edin");
        int id = sc.nextInt();
        Bank.removeUserById(id);
    }


    public static User createUser() {
        System.out.println("Userin id-i daxil edin:");
        int id = sc.nextInt();
        System.out.println("Userin name-i daxil edin:");
        String name = sc.next();
        System.out.println("Userin surname-i daxil edin:");
        String surname = sc.next();
        System.out.println("Userin email-i daxil edin:");
        String email = sc.next();
        System.out.println("Userin password-u daxil edin:");
        String password = sc.next();

        User user = new User(id, name, surname, email, password);
        System.out.println("User ugurla elave edilidi :)");
        return user;
    }

    public static void showAllUser() {
        boolean isFull=true;
        for (int i = 0; i < Bank.getAllUser().length; i++) {
            if (Bank.getAllUser()[i] != null) {
                System.out.println(Bank.getAllUser()[i]);
                isFull=false;
            }
        }
        if(isFull){
                System.out.println("Bankda isci movcud deil :( zehmet olmasa isci elave edin!");
        }
    }

    public static void showUserById() {
        System.out.println("Gormek istediyinz userin id-i daxil edin:");
        int id = sc.nextInt();
        User user = Bank.getUserById(id);
        if (user != null) {
            System.out.println(user);
        }
    }


}