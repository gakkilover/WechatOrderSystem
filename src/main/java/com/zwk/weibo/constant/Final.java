package com.zwk.weibo.constant;

public final class Final {
    /**
     * 空字串
     */
    public static final String EMPTY = "";

    /**
     * 数据库已存在记录
     */
    public final static Integer EXIST_ERROE_CODE=1001;

    /**
     * 数据库已存在记录
     */
    public final static Integer NULL_ERROE_CODE=1002;

    /**
     * 类别默认状态
     */
    public final static String GENRE_ERROE_CODE="1000";

    /**
     * MD5加密失败
     */
    public final static String MD5_ERROE_CODE="2000";

    /**
     * MD5加密默认密码
     */
    public final static String DEFAULT_PASSWORD="zwk@123456";

    /**
     * 成功
     */
    public final static String SUCCESS="SUCCESS";
    /**
     * 失败
     */
    public final static String FAILURE="SUCCESS";

    /**
     * 订单下单已支付状态
     */
    public final static String ORDER_STATUS_PAY="1100";

    /**
     * 订单下单未支付状态
     */
    public final static String ORDER_STATUS_UNNPAY="1101";

    /**
     * 订单拒绝状态
     */
    public final static String ORDER_STATUS_REFUSE="1102";

    /**
     * 订单撤单（无效）状态
     */
    public final static String ORDER_STATUS_UNEFFECT="1103";
    /**
     * 订单已配送（待收货）状态
     */
    public final static String ORDER_STATUS_SENDED="1104";

    /**
     * 订单已完成(送达)状态
     */
    public final static String ORDER_STATUS_DONE="1105";

    /**
     * 订单下单待配送状态
     */
    public final static String ORDER_STATUS_UNDISPATCH="1106";
}
