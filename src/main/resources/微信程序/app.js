//app.js
const Towxml = require('/towxml/main');     //引入towxml库
App({
  onLaunch: function () {

  },
  globalData: {
    userInfo: null,
	api:"http://192.168.10.193:8080/Weibo/api",
	IMG_URL:'http://192.168.10.193:8080/Weibo/img',
    shopId:1,
    bzfee:5,
	isFirst: 1,
    addressToShow:null,
    shop:null,
    shopName:'洛阳小嘴煲煲掂',
	addressId:1
  },
  orderStatus:{
    //1待付款1101 6已付款1100  3待收货 4已完成 （已收货） 9交易完成（评价完）
    notpay:1,
    payed:6,
    notreceive:3,
    received:4,
    complete:9
  },
  towxml: new Towxml()
})