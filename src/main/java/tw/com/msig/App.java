package tw.com.msig;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import tw.com.msig.entity.Policy;
import tw.com.msig.service.PolicyService;

import java.util.List;

/** @author Matt S.Y Ho */
public class App {

  // ctrl + 1 : eclispe 建議視窗
  // 打 main 按 alt + /
  // ctrl + shift + f : 排版
  // ctrl + shift + o : 整理 import
  // ctrl + sfhit + t :  找 class
  // ctrl + sfhit + r :  找 resource

  public static void main(String... args) {
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext(
            "spring-config.xml", "spring-service.xml", "spring-dao.xml");
    try {
      PolicyService service = context.getBean(PolicyService.class);

      List<Policy> all = service.getAll();
      System.out.println("initial policy: " + all);

    } finally {
      context.close();
    }
  }
}
