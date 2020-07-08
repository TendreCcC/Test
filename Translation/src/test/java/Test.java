import com.itheima.service.CategoryService;

public class Test {
 @org.junit.Test
    public void testFindAll(){
     CategoryService service = new CategoryService();
     String all = service.FindAll();
     System.out.println(all);
 }
}
