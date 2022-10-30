package com.mason.chapter_02;

import java.util.Map;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * @author yongshi
 * @date 2022/10/30 21:34
 * @Description switch+枚举的使用案例：因为有个判断需要处理不同系统类型跳转到不同系统
 */
public class EnumsAndSwitch {
//    private ErpResponse getLoginResponse(Map<String, Object> paramMap, ErpResponse checkData) throws Exception {
//
//        ErpResponse loginData = null;
//
//        Map<String, Object> user = (Map<String, Object>) checkData.getData();
//
//        //获取user的系统类型，然后区分是哪个系统实例用户登录
//
//        String sysBaseType = (String) user.get("sys_base_type");
//
//        SystemType systemType = SystemType.getTypeByValue(sysBaseType);
//
//        switch (systemType) {
//
//            case ERP:
//
//                erpLogin((String) user.get("user_id"));
//
//                loginData.setData(user);
//
//                break;
//
//            case ORDER_PLATFORM:
//
//                //订货平台
//
//                orderPlatformLoginByCheck(paramMap);
//
//                loginData.setData(user);
//
//                break;
//
//            case PERSONAL:
//
//                //个人中心
//
//                loginData = personalLogin(user);
//
//                break;
//
//            default:
//
//                LOGGER.info("系统类型不满足");
//
//                break;
//
//        }
//
//        return loginData;
//
//    }
}
