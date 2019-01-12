var app = getApp();
var util = require("../../utils/util.js");

let that;
// pages/test/index.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        cartList: [],
        iscart: 0,
        edit: 0,
        count: 0,
        total: 0,
        selAll: 0
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
    onEdit: function() {
        that.setData({
            edit: !that.data.edit
        })

    },

    getTotal: function() {
        var total = 0;
        for (var i in that.data.cartList) {
            // console.log(total);
            // console.log(parseFloat(that.data.cartList[i].foodPrice))
            total += that.data.cartList[i].foodPrice * that.data.cartList[i].foodNum;
            // console.log(total);
        }
        that.setData({
            total: total,
            count: that.data.cartList.length
        })
    },

    onReduce: function(e) {
        var index = e.currentTarget.dataset.idx;
        that.setCart(that.data.cartList[index], false);

    },
    onAdd: function(e) {
        var index = e.currentTarget.dataset.idx;
        that.setCart(that.data.cartList[index], true);
    },
    setCart: function(good, isAdd) {
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
    selItem: function(e) {
        var index = e.currentTarget.dataset.index;
        var temp = "cartList[" + index + "].checked"
        that.setData({
            [temp]: !that.data.cartList[index].checked
        })
    },
    selAll: function() {
        var temp = ""
		for (var i in that.data.cartList) {
			temp = "cartList[" + i + "].checked"
			that.setData({
				[temp]: !that.data.selAll
			})
		}
		that.setData({
			selAll: !that.data.selAll
		})
    },
	tobuys:function(){
		wx.navigateTo({
			url: '/pages/confirm/index'
		})

	},
	delGoods:function(){
		var cartList = that.data.cartList;
		var checkedGoods = [];
		for (var i in cartList){
			if (!cartList[i].checked){
				checkedGoods.push(cartList[i])
			}
		}
		wx.showModal({
			title: '提示',
			content: '是否确认删除',
			success(res) {
				if (res.confirm) {
					that.setData({
						cartList: checkedGoods
					});

					wx.setStorage({
						key: 'cart',
						data: that.data.cartList,
					});
					// console.log(that.data.cartList)
					that.getTotal();
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
        wx.getStorage({
            key: 'cart',
            success: function(res) {
                that.setData({
                    cartList: res.data
                });
                if (that.data.cartList.length) {
                    that.setData({
                        iscart: 1,
                        count: that.data.cartList.length

                    })
                }
                that.getTotal();
                var temp = "";
                for (var i in that.data.cartList) {
                    temp = "cartList[" + i + "].checked"
                    that.setData({
                        [temp]: false
                    })
                }
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