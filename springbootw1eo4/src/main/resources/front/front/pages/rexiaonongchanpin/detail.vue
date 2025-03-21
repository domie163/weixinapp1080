
<template>
<view>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view class="container" :style='{"width":"100%","padding":"0","position":"relative","background":"url(http://codegen.caihongy.cn/20221108/581bb1956ffe4c8182127ca1e196e95e.png) fixed","height":"auto"}'>
						<swiper :style='{"width":"100%","background":"#fff","height":"360rpx"}' class="swiper" :indicator-dots='false' :autoplay='true' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
				<swiper-item :style='{"width":"100%","background":"none","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index">
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" v-if="swiper.substring(0,4)=='http'" :src="swiper"></image>
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" v-else :src="baseUrl+swiper"></image>
				</swiper-item>
			</swiper>
									            <view :style='{"width":"100%","padding":"24rpx","background":"none","height":"auto"}' class="detail-content">
				<view :style='{"boxShadow":"0px 0.10rpx 4rpx #ccc","margin":"0 0 16rpx 0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"space-between","height":"auto"}' class="detail-list-item price priceFavor">
					<view :style='{"padding":"0 0 0 24rpx","display":"flex"}' class="text">
						<view :style='{"color":"red","lineHeight":"80rpx","fontSize":"48rpx"}'>￥</view>
						<view :style='{"color":"red","lineHeight":"80rpx","fontSize":"32rpx"}'>{{detail.price}}</view>
					</view>
					<view :style='{"padding":"0 24rpx 0 0","lineHeight":"80rpx","fontSize":"48rpx","color":"#6553CA","display":"block"}' v-if="storeupFlag==1" class="cuIcon-favorfill" @click="shoucang"></view>
					<view :style='{"padding":"0 24rpx 0 0","lineHeight":"80rpx","fontSize":"48rpx","color":"#6553CA","display":"block"}' v-if="storeupFlag==0" class="cuIcon-favor" @click="shoucang"></view>
				</view>

				<view :style='{"boxShadow":"0px 0.10rpx 4rpx #ccc","padding":"16rpx 20rpx","margin":"0 0 16rpx 0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"block","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"left","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"600"}' class="lable">农产品名称：</view>
					<view :style='{"width":"100%","padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' class="text">{{detail.nongchanpinmingcheng}}</view>
				</view>
				<view :style='{"boxShadow":"0px 0.10rpx 4rpx #ccc","padding":"16rpx 20rpx","margin":"0 0 16rpx 0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"block","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"left","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"600"}' class="lable">品牌：</view>
					<view :style='{"width":"100%","padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' class="text">{{detail.pinpai}}</view>
				</view>

				<view class="detail-list-item" :style='{"boxShadow":"0px 0.10rpx 4rpx #ccc","padding":"16rpx 20rpx","margin":"0 0 16rpx 0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"block","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"left","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"600"}'>产品编号：</view>
					<view  class="text" :style='{"width":"100%","padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.chanpinbianhao}}</view>
				</view>
				<view class="detail-list-item" :style='{"boxShadow":"0px 0.10rpx 4rpx #ccc","padding":"16rpx 20rpx","margin":"0 0 16rpx 0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"block","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"left","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"600"}'>产品分类：</view>
					<view  class="text" :style='{"width":"100%","padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.chanpinfenlei}}</view>
				</view>
				<view class="detail-list-item" :style='{"boxShadow":"0px 0.10rpx 4rpx #ccc","padding":"16rpx 20rpx","margin":"0 0 16rpx 0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"block","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"left","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"600"}'>是否有机：</view>
					<view  class="text" :style='{"width":"100%","padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.shifouyouji}}</view>
				</view>
				<view class="detail-list-item" :style='{"boxShadow":"0px 0.10rpx 4rpx #ccc","padding":"16rpx 20rpx","margin":"0 0 16rpx 0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"block","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"left","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"600"}'>规格包装：</view>
					<view  class="text" :style='{"width":"100%","padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.guigebaozhuang}}</view>
				</view>
				<view class="detail-list-item" :style='{"boxShadow":"0px 0.10rpx 4rpx #ccc","padding":"16rpx 20rpx","margin":"0 0 16rpx 0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"block","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"left","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"600"}'>产地：</view>
					<view  class="text" :style='{"width":"100%","padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.chandi}}</view>
				</view>
				<view class="detail-list-item" :style='{"boxShadow":"0px 0.10rpx 4rpx #ccc","padding":"16rpx 20rpx","margin":"0 0 16rpx 0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"block","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"left","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"600"}'>库存：</view>
					<view  class="text" :style='{"width":"100%","padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.alllimittimes}}</view>
				</view>
				<view class="detail-list-item" :style='{"boxShadow":"0px 0.10rpx 4rpx #ccc","padding":"16rpx 20rpx","margin":"0 0 16rpx 0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"block","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"left","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"600"}'>点击次数：</view>
					<view  class="text" :style='{"width":"100%","padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.clicknum}}</view>
				</view>





				<view class="detail-list-item rich" :style='{"margin":"0 0 24rpx 0","borderColor":"#ccc","borderWidth":"0 0 0px 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>农产品介绍</view>
					<view class="rich-text" :style='{"border":"2rpx solid #ccc","minHeight":"240rpx","padding":"20rpx","boxShadow":"0px 0.10rpx 2rpx #ccc","margin":"0","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","width":"calc(100% - 160rpx)","lineHeight":"1.5"}'>
						<rich-text :nodes="detail.nongchanpinjieshao"></rich-text>
					</view>
				</view>


				<view class="time-content" :style='{"width":"100%","margin":"40rpx 0 40rpx 0","height":"auto"}'>
					<view class="comoment-header" :style='{"boxShadow":"rgb(0 0 0 / 20%) 0px 4rpx 8rpx","margin":"0 0 32rpx","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
						<view :style='{"padding":"0 24rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333"}'>评论</view>
						<view :style='{"padding":"0 20rpx","background":"#a9a7e5","display":"flex"}' @click="onCommentTap" class="btn-comment-content" style="display: flex;align-items: center;">
							<view :style='{"margin":"0 8rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#fff"}' class="cuIcon-add"></view>
							<view :style='{"color":"#fff","lineHeight":"80rpx","fontSize":"28rpx"}'>添加评论</view>
						</view>
					</view>
				
					<view :style='{"width":"100%","boxShadow":"0 4rpx 6rpx rgb(0 0 0 / 20%)","padding":"24rpx","margin":"32rpx 0 32rpx 0","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","height":"auto"}' v-for="(item,index) in commentList" v-bind:key="index" class="cu-item comment-item">
						<view :style='{"width":"100%","display":"flex","height":"auto"}'>
							<image :style='{"width":"60rpx","margin":"0 8rpx 0 0","borderRadius":"100%","display":"block","height":"60rpx"}' v-if="item.avatarurl" mode="aspectFill" :src="baseUrl+item.avatarurl"></image>
							<view :style='{"color":"#333","lineHeight":"60rpx","fontSize":"28rpx"}' class="text-grey">{{item.nickname}}</view>
						</view>
						<view :style='{"margin":"8rpx 0","lineHeight":"1.5","fontSize":"28rpx","color":"#666"}' class="text-gray text-content text-df">
							{{item.content}}
						</view>
						<view :style='{"color":"#999","lineHeight":"24rpx","fontSize":"24rpx"}' class="margin-top-sm text-gray text-df">{{item.addtime}}</view>
						<view v-if="item.reply" :style='{"margin":"8rpx 0","lineHeight":"1.5","fontSize":"28rpx","color":"#666"}' class="text-gray text-content text-df">
							回复:{{item.reply}}
						</view>
					</view>
				</view>

				<view class="bottom-content bg-white tabbar border shop" :style='{"width":"100%","padding":"10rpx 24rpx","flexWrap":"wrap","background":"rebeccapurple","display":"flex","height":"auto"}'>

					<button :style='{"border":"0","padding":"0 20rpx","margin":"0","color":"rgb(255, 255, 255)","background":"rgb(255, 170, 51)","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="detail.alllimittimes>0" @tap="onCartTap" class="cu-btn bg-orange round shadow-blur" >加入购物车</button>
					<button :style='{"border":"0","padding":"0 20rpx","margin":"0","color":"rgb(255, 255, 255)","background":"rgb(255, 170, 51)","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="detail.alllimittimes>0" @tap="onBuyTap">立即购买</button>
				</view>
			</view>

		</view>
	</view>
</mescroll-uni>
</view>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				id: '',
                userid: '',
				detail: {},
				swiperList: [],
				commentList: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				user: {},
				storeupFlag: 0,
				count: 0,
				timer: null
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(options) {
			this.id = options.id;
            if(options.userid) {
                this.userid = options.userid;
            }
		},
        onUnload() {
            if(this.timer!=null) {
                clearInterval(this.timer);
            }
        },
		async onShow(options) {
			// 渲染数据
			this.init();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.getStoreup();
			let cleanType = uni.getStorageSync('discussrexiaonongchanpinCleanType')
			if(cleanType){
				uni.removeStorageSync('discussrexiaonongchanpinCleanType')
				this.mescroll.num = 1
				this.upCallback(this.mescroll)
			}
		},
		destroyed: function() {
			//window.clearInterval(this.inter);
		},
		methods: {
			// 支付
			onPayTap(){
				uni.setStorageSync('paytable','rexiaonongchanpin');
				uni.setStorageSync('payObject',this.detail);
				this.$utils.jump('../pay-confirm/pay-confirm?type=1')
			},
            onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
                this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
            },
			// 收藏
			async getStoreup() {
				let params = {
					page: 1,
					limit: 1,
					refid : this.id,
					tablename : 'rexiaonongchanpin',
					userid: this.user.id,
					type: 1,
				}
				let res = await this.$api.list(`storeup`, params);
				this.storeupFlag = res.data.list.length;
			},
			async shoucang(){
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid : _this.detail.id,
					tablename : 'rexiaonongchanpin',
					userid: _this.user.id,
					type: 1,
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length == 1) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消',
						success: async function(res) {
							if (res.confirm) {
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.$utils.msg('取消成功');
								_this.getStoreup();
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否收藏',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
								name: _this.detail.nongchanpinmingcheng,
                                inteltype: _this.detail.chanpinfenlei,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'rexiaonongchanpin',
                                type: 1
							});
							_this.$utils.msg('收藏成功');
							_this.getStoreup();
						}
					}
				});
			},
			// 跨表
			onAcrossTap(tableName,crossOptAudit,statusColumnName,tips,statusColumnValue){
				uni.setStorageSync('crossTable','rexiaonongchanpin');
				uni.setStorageSync(`crossObj`, this.detail);
				uni.setStorageSync(`statusColumnName`, statusColumnName);
				uni.setStorageSync(`statusColumnValue`, statusColumnValue);
				uni.setStorageSync(`tips`, tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = uni.getStorageSync('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$utils.msg(tips);
							return
						}
					}
				}
				this.$utils.jump(`../${tableName}/add-or-update?cross=true`);
			},
			// 获取详情
			async init(){
				let res = await this.$api.info('rexiaonongchanpin', this.id);
				this.detail = res.data;
				// 轮播图片
				this.swiperList = this.detail.nongchanpintupian ? this.detail.nongchanpintupian.split(",") : [];
				//修改富文本的图片样式
				this.detail.nongchanpinjieshao = this.detail.nongchanpinjieshao.replace(/img src/gi,"img style=\"width:100%;\" src");
			},

			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},

			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				mescroll.resetUpScroll()
			},

			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
                let res = await this.$api.list('discussrexiaonongchanpin', {
					page: mescroll.num,
					limit: 10,
					refid: this.id
				});
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.commentList = [];
				this.commentList = this.commentList.concat(res.data.list);
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);

            },

            async onCartTap() {
				if (uni.getStorageSync(`cart${this.detail.id}${this.user.id}`)) {
					this.$utils.msg('该商品已添加到购物车')
					return
				}
				await this.$api.add('cart', {
					tablename: 'rexiaonongchanpin',
					goodid: this.detail.id,
					goodname: this.detail.nongchanpinmingcheng,
					goodtype: this.detail.chanpinfenlei,
					picture: this.swiperList[0],
					buynumber: 1,
					userid: this.user.id,
					price: this.detail.price,
					discountprice: this.detail.vipprice
				});
				uni.setStorageSync(`cart${this.detail.id}${this.user.id}`, true);
				this.$utils.msg('添加到购物车成功')
			},
            onBuyTap() {
				uni.setStorageSync('orderGoods', [{
					tablename: 'rexiaonongchanpin',
					goodid: this.detail.id,
					goodname: this.detail.nongchanpinmingcheng,
					goodtype: this.detail.chanpinfenlei,
					picture: this.swiperList[0],
					buynumber: 1,
					price: this.detail.price,
					discountprice: this.detail.vipprice
				}])
				this.$utils.jump('../shop-order-confirm/shop-order-confirm?type=1');
			},


			onChatTap() {
				this.$utils.jump('../chat/chat')
			},
			// 下载
			download(url){
				let _this = this;
				url=_this.$base.url +  url;
				uni.downloadFile({
					url: url,
					success: (res) => {
						if (res.statusCode === 200) {
							_this.$utils.msg('下载成功');
							 window.open(url);
						}
					}
				});
			},
			//
			onCartTabTap() {
				this.$utils.tab('../shop-cart/shop-cart')
			},
			// 添加评论
			async onCommentTap() {
                let params = {
                    page: 1,
                    limit: 1,
					status: '已完成',
					goodid: this.detail.id
                }
                let res = await this.$api.page('orders', params);
                if (res.data.list.length == 0) {
                this.$utils.msg('请完成订单后再评论');
					return;
				}
				this.$utils.jump(`../discussrexiaonongchanpin/add-or-update?refid=${this.id}`)
			},
			onSHTap() {
				this.$refs.popup.open()
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.seat-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		background: #FFFFFF;
		margin: 20upx;
		border-radius: 20upx;
		padding: 20upx;
		font-size: 30upx;
		.seat-item {
			width: 33.33%;
			display: flex;
			align-items: center;
			flex-direction: column;
			margin-bottom: 20upx;
	
			.seat-icon {
				width: 50upx;
				height: 50upx;
				margin-bottom: 10upx;
			}
		}
	}
	
	audio {
		display: flex;
		flex-direction: column;
	}
	
	.audio /deep/ .uni-audio-default {
		width: inherit;
	}
</style>
