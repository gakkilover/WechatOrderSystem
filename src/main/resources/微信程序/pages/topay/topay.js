var app = getApp();
var util = require("../../utils/util.js");

let that;
// pages/test/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
	  orderId: '',
	  total:0

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
	  that=this;

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },
  pay:function(){
	  util.okHttp('/order/confirmOrderPay', {
		  'orderNumber': that.data.orderId,
		  'status': 1100
	  }, function (state, data) {

	  });
	  wx.navigateTo({
		  url: '/pages/topay/msg/msg_success',
	  })
	  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
	  wx.getStorage({
		  key: 'orderId',
		  success: function(res) {
			  that.setData({
				  orderId:res.data
			  })
		  },
	  })
	  wx.getStorage({
		  key: 'total',
		  success: function (res) {
			  that.setData({
				  total: res.data
			  })
		  },
	  })


  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})