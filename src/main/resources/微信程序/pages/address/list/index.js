var app = getApp();
var util = require("../../../utils/util.js");

let that;
// pages/test/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
	  defaultAddress:'',
	  addressList: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
	  that=this
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },
  setAddressToShow:function(e){
	//   console.log(e)
	  for (var i in that.data.addressList){
		  if (that.data.addressList[i].addressId == e.currentTarget.dataset.addressid){
			  app.globalData.addressToShow = that.data.addressList[i]
			  app.globalData.addressId = that.data.addressList[i].addressId
			  break;
		  }
	  }
	  console.log(app.globalData.addressToShow)
	  app.globalData.isFirst = 0
	  wx.navigateBack({
		  delta: 1
	  })
  },
  toAdd:function(){
	  wx.navigateTo({
		  url: '/pages/address/add/index',
	  })
  },
  setDefault:function(e){
	  console.log(e)
	  util.okHttp('/mycollect/defaultAddress', {
		  'userId': 1,
		  'addressId': e.currentTarget.dataset.id
	  }, function (state, data) {
		  util.okHttp('/mycollect/addressList', {
			  'userId': 1,
		  }, function (state, data) {
			//   console.log(data);
			  that.setData({
				  addressList: data,
			  });
		  })
		  wx.showToast({
			  title: '设置成功',
			  icon: 'none',
			  duration: 1000
		  })
	  })

  },
  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
	  util.okHttp('/mycollect/addressList', {
		  'userId': 1,
	  }, function (state, data) {
		  console.log(data);
		  that.setData({
			  addressList: data,
		  });
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