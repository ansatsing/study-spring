package cn.antsing.thinking.in.spring.bean.factory;

import cn.antsing.thinking.in.spring.ioc.overview.domain.User;

 /**
  *
  *   {@link User}工厂类<br>
  *
  * @author <a href="mailto:ansatsing@gmail.com">antsing</a> <br>
  * 创建时间: 2020.04.30 16:22:41 <br>
  *
  * @since
  */
public interface UserFactory {
    default User createUser(){
        return User.createUser();
    }

}
