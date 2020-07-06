public class Mytest {
    public static void main(String[] args) {
        String name="ctj";
        Class<? extends String> aClass = name.getClass();//获取name字符串的类对象
        //System.out.println(aClass.getName());//然后获取并输出他的名字
        Class<Boolean> type = Boolean.TYPE;
        System.out.println(Boolean.TYPE);
    }
}
