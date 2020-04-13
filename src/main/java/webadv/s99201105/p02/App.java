package webadv.s99201105.p02;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        String account,password;
        Scanner sc = new Scanner(System.in); 
        account = sc.nextLine(); 
        password = sc.nextLine(); 
        FileInputStream fisAccount = new FileInputStream("account.txt");
        FileInputStream fisPassword = new FileInputStream("password.txt");
        BufferedReader brAccount = new BufferedReader(new InputStreamReader(fisAccount));
        BufferedReader brPassword = new BufferedReader(new InputStreamReader(fisPassword));
        if(account.equals(brAccount.readLine()) && sha256hex(password).equals(sha256hex(brPassword.readLine())))
            System.out.println("登录成功");
        else
            System.out.println("登录失败");
        sc.close();
        fisAccount.close();
        fisPassword.close();
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
