package com.groupfour.Library.Utils;


import com.groupfour.Library.exception.BusinessException;
import com.groupfour.Library.pojo.Books;
import com.groupfour.Library.pojo.Users;
import com.groupfour.Library.pojo.utiils.RegistUser;
import com.groupfour.Library.pojo.utiils.User;


public class Check {


    //校验用户信息格式是否正确
    public static Boolean  CheckUsers(Users user){
        String userId="201001[0-9]{5}";
        if(!user.getUserId().matches(userId)){
            throw new BusinessException(Code.BUSINESS_ERR,"账号格式错误或字符过长，仅限11位,且必须以201001开头，并且必须全为整数");
        }

        String psWord="[0-9a-zA-Z]{5,16}";
        if(!user.getPsWord().matches(psWord)){
            throw new BusinessException(Code.BUSINESS_ERR,"密码格式错误，应为5-16位且由字母或数字组成");
        }

        String email = "[0-9]{6}@[0-9a-z]{2,3}.(com|cn)";
        if(!user.getEmail().matches(email)){
            throw new BusinessException(Code.BUSINESS_ERR,"邮箱格式错误！必须由六位数字组成开头，且必须为com或cn结尾，@和.之间必须有两到三位小数或整数");
        }

        String phone = "^[1][3|4|5|7|8][0-9]{9}$";
        if(!user.getPhone().matches(phone)){
            throw new BusinessException(Code.BUSINESS_ERR,"手机号格式错误");
        }
        return true;
    }

    public static Boolean CheckUser(User user){
        String userId="201001[0-9]{5}";
        if(!user.getUserId().matches(userId)){
            throw new BusinessException(Code.BUSINESS_ERR,"账号格式错误或字符过长，仅限11位,且必须以201001开头，并且必须全为整数");
        }

        String psWord="[0-9a-zA-Z]{5,16}";
        if(!user.getPsWord().matches(psWord)){
            throw new BusinessException(Code.BUSINESS_ERR,"密码格式错误，应为5-16位且由字母或数字组成");
        }
        return true;
    }


    public static Boolean Regist(RegistUser user){
        String userId="201001[0-9]{5}";
        if(!user.getUserId().matches(userId)){
            throw new BusinessException(Code.BUSINESS_ERR,"账号格式错误或字符过长，仅限11位,且必须以201001开头，并且必须全为整数");
        }

        String psWord="[0-9a-zA-Z]{5,16}";
        if(!user.getPsWord().matches(psWord)){
            throw new BusinessException(Code.BUSINESS_ERR,"密码格式错误，应为5-16位且由字母或数字组成");
        }

        if(!user.getIspsWord().matches(psWord)){
            throw new BusinessException(Code.BUSINESS_ERR,"确认密码格式错误，应为5-16位且由字母或数字组成");
        }

        String email = "[0-9]{6}@[0-9a-z]{2,3}.(com|cn)";
        if(!user.getEmail().matches(email)){
            throw new BusinessException(Code.BUSINESS_ERR,"邮箱格式错误！必须由六位数字组成开头，且必须为com或cn结尾，@和.之间必须有两到三位小数或整数");
        }

        String phone = "^[1][3|4|5|7|8][0-9]{9}$";
        if(!user.getPhone().matches(phone)){
            throw new BusinessException(Code.BUSINESS_ERR,"手机号格式错误");
        }
        return true;

    }


}
