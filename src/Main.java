public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(login("123233", "4561", "456"));
            System.out.println(login("12жд3323", "1234", "1234"));
        } catch (WrongPasswordException | WrongLoginException e) {
            System.out.println(e.getMessage());}
        System.out.println(login("123", "qaqweqw", "asdasd"));

    }


    public static boolean login (String login, String password, String confirmPassword) {
        if (!isAlphanumericOr_(login) || login.length() > 20) {
            throw new WrongLoginException("Wrong login");
        }
        if (!isAlphanumericOr_(password) || password.length() > 20 || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Wrong password");
        }
        return true;
    }

    private static boolean isAlphanumericOr_(String string) {
        for (char c:string.toCharArray()) {
            if (!isAlphanumericOr_(c)) {
                return false;
            }
        }
        return true;
    }
    private static boolean isAlphanumericOr_(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57) || (c == 95);
    }

}