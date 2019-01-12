var app = getApp();
var util = require("../../utils/util.js");

let that;

Page({

    /**
     * 页面的初始数据
     */
    data: {
        typeList: [], //类别集合
        dishList: [], //菜品集合
        cartList: [], //购物车集合
        total: 0, //总价
        count: 0, //数量
		cartShow: 0,
		currentCateId: -1
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function(options) {
        that = this;
    },
	showInput(){
		wx.navigateTo({
			url: '/pages/search/search',
		})

	},
    /**
     * 加载所有的类别
     */
    loadType: function() {
        util.okHttp('/genre/genreList', {}, function(state, data) {
            that.setData({
                typeList: data
            })
        });
    },
    loadDish: function(id) {
        util.okHttp('/food/foodListByGenre', {
            'genreId': id,
            'foodName': '',
        }, function(state, data) {
            that.setData({
                dishList: data,
				currentCateId: id
            });
			wx.getStorage({
				key: 'cart',
				success: function (res) {
					that.setData({
						cartList: res.data
					});
					console.log(that.data.dishList)
					that.initNum();
					that.getTotal();
				},
			})
			
        });
    },
    onReduce: function(e) {
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
    onAdd: function(e) {
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
            // that.data.cartList.push(JSON.parse(JSON.stringify(good)));
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
		// wx.getStorageInfo({
		// 	success(res) {
		// 		console.log(res.keys)
		// 	}
		// })

    },
    getTotal: function() {
        var total = 0;
        for (var i in that.data.cartList) {
			// console.log(total);
			// console.log(parseFloat(that.data.cartList[i].foodPrice))
			total += that.data.cartList[i].foodPrice * that.data.cartList[i].foodNum;
			// console.log(total);
        }
		if (that.data.cartList){
			that.setData({
				total: total,
				count: that.data.cartList.length
			})
		}
		else{
			that.setData({
				total: total,
				count: 0,
			})
		}
        
    },
	addOrder:function(){
		if (that.data.cartList.length){
			wx.navigateTo({
				url: '/pages/confirm/index'
			})
		}else{
			wx.showToast({
				title: '您还未添加商品',
				icon: 'none',
				duration: 2000
			})
		}
	},
	onCartToggle:function(){
		that.setData({
			cartShow: !that.data.cartShow
		})
	},
	initNum: function () {
		var cartList = that.data.cartList;
		var dishList = that.data.dishList;
		for (let i in cartList){
			for (let j in dishList){
				// console.log(cartList[i].foodId + "===" + dishList[j].foodId);
				if (cartList[i].foodId == dishList[j].foodId){
					// console.log(dishList[j].foodNum + "=====================" + cartList[i].foodNum)
					dishList[j].foodNum = cartList[i].foodNum;
					break;
				}
			}
		}
		that.setData({
			dishList:dishList
		})
	},
    onReady: function() {

    },
    onShow: function() {
        //加载类别
        that.loadType();
        //加载所有菜
        that.loadDish(-1);
        // wx.getStorage({
        //     key: 'cart',
        //     success: function(res) {
        //         that.setData({
        //             cartList: res.data
        //         });
        //         that.getTotal();
        //     },
        // })
    },
    onCateChange: function(e) {
        that.loadDish(e.target.dataset.id);
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