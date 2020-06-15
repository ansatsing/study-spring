package cn.antsing.thinking.in.spring.ioc.overview.domain;

 /**
  *
  * 描述: 用户类  <br>
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020.04.30 10:27:22 <br>
  *
  */
public class User {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr:"+super.toString()+
                '}';
    }

    public static User createUser(){
        User user = new User();
        user.setName("antsing");
        user.setId(2L);
        return user;
    }
     public static User createUser(long id,String name){
         User user = new User();
         user.setName(name);
         user.setId(id);
         return user;
     }
}
