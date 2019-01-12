var app = getApp();
var util = require("../../../../utils/util.js");
let that;
Page({

    /**
     * 页面的初始数据
     */
    data: {
        tabs: ["全部", "待付款", "待配送", "待收货", "待评价"],
        orderList: [],
		allOrder:[],
		activeIndex: 0,
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function(options) {
        that = this;

    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function() {

    },
	goPay:function(e){
		// var orderNumber = e.target.dataset.order
		// console.log(e.target.dataset.order)
		// console.log(e.target.dataset.total)
		wx.setStorage({
			key: 'orderId',
			data: e.target.dataset.order
		})
		wx.setStorage({
			key: 'total',
			data: e.target.dataset.total
		})
		wx.navigateTo({
			url: '/pages/topay/topay',
		});
		
	},
	tabClick: function(e) {
		var status = ['', 1101, 1106, 1104, 1105]
		util.okHttp('/order/orderList', {
			'userId': 1,
			'status': status[e.currentTarget.id]
		}, function (state, data) {
			that.setData({
				activeIndex: e.currentTarget.id,
				orderList: data
			});
		});


        // var cateid = e.currentTarget.id;
		// var status = ['', 1101, 1106, 1104, 1105]
        // var allOrder = that.data.allOrder;
		// var arr = [];
		// if (cateid == 0){
		// 	that.setData({
		// 		orderList: allOrder,
		// 		activeIndex: cateid
		// 	})
		// }else{
		// 	for (var i in allOrder) {
		// 		// console.log(allOrder);
		// 		console.log(status[cateid]);
		// 		if (allOrder[i].status == status[cateid]) {
		// 			arr.push(allOrder[i])
		// 		}
		// 	}
		// 	that.setData({
		// 		orderList: arr,
		// 		activeIndex: cateid
		// 	})
		// 	// console.log("orderList"+that.data.orderList)
		// }
        
    },
	deliveryGood:function(e){
		wx.showModal({
			title: '提示',
			content: '是否确认收货',
			success(res) {
				if (res.confirm) {
					util.okHttp('/order/confirmOrderPay', {
						'orderNumber': e.currentTarget.dataset.orderid,
						'status': 1105
					}, function (state, data) {

					});
					wx.navigateTo({
						url: '/pages/my/order/index/index',
					})
					console.log('用户点击确定')
				} else if (res.cancel) {
					console.log('用户点击取消')
				}
			}
		})
	},

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function() {
        util.okHttp('/order/orderList', {
            'userId': 1,
			'status': ''
        }, function(state, data) {
            that.setData({
				allOrder: data,
				orderList: data
            });
			
        });
		console.log(that.data.allOrder)
		console.log(that.data.orderList)
		
    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function() {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function() {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function() {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function() {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function() {

    }
})