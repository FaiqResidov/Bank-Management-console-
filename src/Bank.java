public class Bank {
    public static User[] users = new User[5];


    public static void addUser(User user){
        boolean isFull=true;
       for(int i=0;i<users.length;i++){
        if(users[i]==null){
            isFull=false;
            users[i]=user;
            break;
        }
       }
       if(isFull){
           User[] user1=new User[users.length*2];
           for(int i=0;i<users.length;i++){
               user1[i]=users[i];
           }
           user1[users.length]=user;
           users=user1;
       }

    }

    public static void updateUserById(int id,User user){
         for(int i=0;i<users.length;i++){
            if(users[i]!=null && id==users[i].id){
                users[i]=user;
                System.out.println("User ugurla deyisdirildi :)");
            }

         }

    }

    public static void removeUserById(int id){
        User [] user1=new User[users.length-1];
        boolean isFind=true;
        for(int i=0;i<users.length;i++){
            if(users[i]!=null && id==users[i].id){
                System.out.println("User ugurla silindi :)");
                isFind=false;
                break;
            }
        }
        if(isFind){
            System.out.println("Bu id-li user movcud deyil :(");
        }

        int index=0;
       for(int i=0;i<users.length;i++){
           if(users[i]!=null && id!=users[i].id){
               user1[index++]=users[i];
           }

       }
       if(!isFind){
           users=user1;
       }



    }

    public static User[] getAllUser(){
        return users;
    }
    public static User getUserById(int id){
        boolean isFind=true;
        for(int i=0;i<users.length;i++){
            if(users[i]!=null && id==users[i].id){

              return users[i];

            }
        }
        if(isFind){
                System.out.println("Bu id-e uygun user movcud deyil!");

        }
            return null;
    }
}
