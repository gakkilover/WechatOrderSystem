var app = getApp();
var util = require("../../../utils/util.js");

let that;
// pages/test/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
	  region: ["请选择","请选择","请选择"],
	//   receiver: null,
	//   receiverPhone:null,
	//   completeAddress: null,
	  userId: 1,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
	  that = this
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },
//   getReceiver:function(e){
// 	  that.setData({
// 		  peopleNum: e.detail.value
// 	  })
//   },
//   getReceiverPhone: function (e) {
// 	  that.setData({
// 		  receiverPhone: e.detail.value
// 	  })
//   },
//   getCompleteAddress: function (e) {
// 	  that.setData({
// 		  completeAddress: e.detail.value
// 	  })
//   },
  regionChange:function(e){
	  console.log(e.detail.value)
	  var temp0 = "region[0]"
	  var temp1 = "region[1]"
	  var temp2 = "region[2]"
	  that.setData({
		  [temp0]: e.detail.value[0],
		  [temp1]: e.detail.value[1],
		  [temp2]: e.detail.value[2],
	  })
  },
  formSubmit:function(e){
	  var formdata = e.detail.value;
	  formdata.province = formdata.region[0];
	  formdata.city = formdata.region[1];
	  formdata.county = formdata.region[2];
	  delete formdata.region
	//   console.log(JSON.stringify(formdata))
	  util.okHttp('/mycollect/insertAddress', {
		  'addressInfo': JSON.stringify(formdata)
	  }, function (state, data) {
		  wx.navigateTo({
			  url: '/pages/address/list/index',
		  })
	  })
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

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