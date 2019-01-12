var app = getApp();
var util = require("../../utils/util.js");
var self;
//获取全局APP对象
Page({
  /**
   * 页面的初始数据
   */
  data: {
    title: "欢迎进入点餐系统!!"
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    self = this;
    //获取用户openId
    wx.login({
      success(res) {
        util.httpPost('/api/dinner/getOpenId', {
            code: res.code,
            shopid: app.globalData.shopId
          },
          function(response) {
            wx.setStorageSync('openid', response.data.openId);
            let formData={};
            formData.wxid = response.data.openId;
            //添加用户信息
            util.httpPost('/api/customer/saveOrUpdate2', formData, function (result) {
              //保存用户id
              wx.setStorage({
                key: 'uid',
                data: result.data.data.id,
              })
            });
          })
      },
      fail() {
        that.setData({
          errMsg: '登录失败,请重试'
        })
      }
    })
    
    //如果能获取用户信息，说明已经完成授权（登录），不再显示引导页，直接进入系统首页
    if (wx.getStorageSync("userInfo")) {
      wx.switchTab({
        url: '/pages/site/site'
      })
    }
  },

  bindGetUserInfo: function(e) {
    //同意授权后设置用户信息全局变量，并写入缓存
    if (e.detail.errMsg == 'getUserInfo:ok') {
      app.globalData.userInfo = e.detail.userInfo;
      wx.setStorage({
        key: 'userInfo',
        data: e.detail.userInfo,
      })
    }
    //跳转首页
    wx.switchTab({
      url: '/pages/site/site',
    })
  }

})