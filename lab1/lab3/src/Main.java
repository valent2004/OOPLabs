// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String str = "Park patter Paaq pawer pAA";
        for(int i = 0; i < str.length(); i++)
        {
            switch(str.charAt(i))
            {
                case 'p':
                case 'P':
                    switch(str.charAt(i + 1))
                    {
                        case 'a':
                            i++;
                            str = str.replace(str.charAt(i), 'o');
                            break;
                        case 'A':
                            i++;
                            str = str.replace(str.charAt(i), 'O');
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(str);
    }
}