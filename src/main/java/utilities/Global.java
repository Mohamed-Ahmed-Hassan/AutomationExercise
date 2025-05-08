package utilities;

public class Global {
    private static  String mobileNumber;
    private static String Email;
    private static String Password;
    private static String Name;

    public static void setMobileNumber(String Phone){
        mobileNumber=Phone;
    }
    public static String getMobileNumber()
    { return mobileNumber;}

    public static void setEmail(String email){
        Email=email;
    }
    public static  String getEmail()
    { return Email;}
    public static void setName(String name){
        Name=name;
    }
    public static  String getName()
    { return Name;}
    public static void setPassword(String password){
        Password=password;
    }
    public static String getPassword()
    { return Password;}
}