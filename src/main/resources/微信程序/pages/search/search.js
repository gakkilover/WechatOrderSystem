var app = getApp();
var util = require("../../utils/util.js");

let that;
// pages/test/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
	  value:"",
	  dishList: [], //菜品集合
	  cartList: [], //购物车集合
	  total: 0, //总价
	  count: 0, //数量
	  cartShow: 0,
	  msg:"查找不到菜品"
  },
  onReduce: function (e) {
	  that = this;
	  var index = e.currentTarget.dataset.idx;
	  var num = that.data.dishList[index].foodNum;
	  var temp = "dishList[" + index + "].foodNum"
	  num = num - 1;
	  that.setData({
		  [temp]: num
	  });
	  that.setCart(that.data.dishList[index], false);

  },
  onAdd: function (e) {
	  that = this;
	  var index = e.currentTarget.dataset.idx;
	  var num = that.data.dishList[index].foodNum;
	  var temp = "dishList[" + index + "].foodNum"
	  num = num + 1;
	  that.setData({
		  [temp]: num
	  });
	  that.setCart(that.data.dishList[index], true);
  },
  setCart: function (good, isAdd) {
	  var exists = false;
	  for (var i in that.data.cartList) {
		  if (good.foodId == that.data.cartList[i].foodId) {
			  exists = true;
			  if (isAdd) {
				  that.data.cartList[i].foodNum++;
			  } else {
				  that.data.cartList[i].foodNum--;
				  if (that.data.cartList[i].foodNum == 0) {
					  that.data.cartList.splice(i, 1);
				  }
			  }
			  break;
		  }
	  }
	  if (!exists && isAdd) {
		  that.data.cartList.push(JSON.parse(JSON.stringify(good)));
	  }
	  that.setData({
		  cartList: that.data.cartList
	  });
	  wx.setStorage({
		  key: 'cart',
		  data: that.data.cartList,
	  });
	  console.log(that.data.cartList)
	  that.getTotal();
	  wx.getStorageInfo({
		  success(res) {
			  console.log(res.keys)
		  }
	  })
  },
  getTotal: function () {
	  var total = 0;
	  for (var i in that.data.cartList) {
		  // console.log(total);
		  // console.log(parseFloat(that.data.cartList[i].foodPrice))
		  total += that.data.cartList[i].foodPrice * that.data.cartList[i].foodNum;
		  // console.log(total);
	  }
	  if (that.data.cartList) {
		  that.setData({
			  total: total,
			  count: that.data.cartList.length
		  })
	  }
	  else {
		  that.setData({
			  total: total,
			  count: 0,
		  })
	  }

  },
  onCartToggle: function () {
	  that.setData({
		  cartShow: !that.data.cartShow
	  })
  },
  addOrder: function () {
	  wx.navigateTo({
		  url: '/pages/confirm/index'
	  })

  },
  getInput:function(e){
	//   console.log(e.detail.value);
	that.setData({
		value:e.detail.value
	})
  },
  searchFood:function(){
	  util.okHttp('/food/foodListByGenre', {
		  'genreId': -2,
		  'foodName': that.data.value,
	  }, function (state, data) {
		  console.log("======="+data)
		  that.setData({
			  dishList: data,
		  })
		  that.initNum();
	  });
  },
  loadDish: function (id) {
	  util.okHttp('/food/foodListByGenre', {
		  'genreId': id,
		  'foodName': '',
	  }, function (state, data) {
		  that.setData({
			  dishList: data,
		  });
		  that.initNum();
	  });
  },
  onCancel:function(){
	  that.loadDish("-1");
  },
  initNum: function () {
	  var cartList = that.data.cartList;
	  var dishList = that.data.dishList;
	  for (var i in cartList) {
		  for (var j in dishList) {
			  if (cartList[i].foodName == dishList[j].foodName) {
				  dishList[j].foodNum = cartList[i].foodNum;
				  continue;
			  }
		  }
	  }
	  that.setData({
		  dishList: dishList
	  })
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

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
	  wx.getStorage({
		  key: 'cart',
		  success: function (res) {
			  that.setData({
				  cartList: res.data
			  });
			  that.getTotal();
		  },
	  });
	  that.loadDish("-1");
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