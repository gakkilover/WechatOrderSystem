var app = getApp();
var util = require("../../utils/util.js");

let that;
// pages/test/index.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
		tabs:["外卖","到店"],
        cartList: [],
        addressDef: '',
		addressList:[],
        activeIndex: 0,
        deliveryPrice: 80,
        bzfee: 10,
        count: 0,
        discount: 0,
        total: 0,
        peopleNum: 1,
        remark: '',
		addressStatus: 1,
		addressId: 1,
		orderId:''
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
	selectAddress:function(){
		wx.navigateTo({
			url: '/pages/address/list/index',
			success: function(res) {},
			fail: function(res) {},
			complete: function(res) {},
		})
	},
	addAddress:function(){
		wx.navigateTo({
			url: '/pages/address/add/index',
		})
	},
    getTotal: function() {
        var total = 0;
        for (var i in that.data.cartList) {
            total += that.data.cartList[i].foodPrice * that.data.cartList[i].foodNum;
        }
        that.setData({
            total: total,
            count: that.data.cartList.length
        })
    },
    getPeopleNum: function(e) {
        that.setData({
            peopleNum: e.detail.value
        })
    },
    getRemark: function(e) {
        that.setData({
            remark: e.detail.value
        })
        console.log(that.data.remark);
    },
    loadAddress: function() {
		// console.log(app.globalData)
		if (app.globalData.isFirst == 1){
			util.okHttp('/mycollect/addressList', {
				'userId': 1
			}, function (state, data) {
				var defaultadd = null;
				that.setData({
					addressList: data
				});
				if (that.data.addressList.length) {
					for (var i in data) {
						if (data[i].defaultAddress == 0) {
							defaultadd = data[i];
							console.log(defaultadd)
							break;
						}
					}
					that.setData({
						addressDef: defaultadd
					})
				} else {
					that.setData({
						addressStatus: 0
					})
				}
			})
			
		}else{
			that.setData({
				addressDef: app.globalData.addressToShow
			})
			app.globalData.isFirst = 0
		}
        
    },
	settlement:function(){
		console.log(JSON.stringify(that.data.cartList));
		util.okHttp('/order/insertOrder', {
			'totalPrice': that.data.total,
			'addressId': app.globalData.addressId,
			'orderDescription': that.data.remark,
			'coversNumber': that.data.peopleNum,
			'orderDetail': JSON.stringify(that.data.cartList),
			'userId':1
		}, function (state, data) {
			console.log(data);
			that.setData({
				orderId: data,
			});
			wx.setStorage({
				key: 'orderId',
				data: that.data.orderId,
			})
			wx.setStorage({
				key: 'total',
				data: that.data.total
			})
			wx.setStorage({
				key: 'cart',
				data: [],
			})
			// wx.removeStorage({
			// 	key: 'cart',
			// 	success(res) {
			// 		console.log(res.data)
			// 	}
			// })
			
			// console.log(that.data.orderId+"================================");
			wx.navigateTo({
				url: '/pages/topay/topay',
			})
		});

	},

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function() {
        that.loadAddress()
		// console.log(that.data.addressList)
        wx.getStorage({
            key: 'cart',
            success: function(res) {
                that.setData({
                    cartList: res.data
                });
                that.getTotal();
            },
        })

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