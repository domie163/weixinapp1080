<template>
	<view class="content">
		<view :style='{"width":"100%","padding":"0 0 64rpx","position":"relative","background":"url(http://codegen.caihongy.cn/20221108/581bb1956ffe4c8182127ca1e196e95e.png) fixed","height":"100%"}'>
			<view :style='{"padding":"0 24rpx","boxShadow":"0px 4rpx 4rpx #ccc","margin":"0 0 24rpx 0","background":"url(http://codegen.caihongy.cn/20221109/53c3ca7135ec48488fc0683a2bf29ddf.jpg) no-repeat","display":"flex","width":"100%","backgroundSize":"100%","height":"280rpx"}' @tap="onPageTap('../user-info/user-info')" class="header" v-bind:class="{'status':isH5Plus}">
				<view :style='{"width":"calc(100% - 112rpx)","alignItems":"center","display":"flex","height":"100%"}' v-if="tableName=='yonghu'" class="userinfo">
					<image :style='{"width":"88rpx","padding":"0","margin":"0 20rpx 0 0","borderRadius":"100%","height":"88rpx"}' :src="user.touxiang?baseUrl+user.touxiang:'/static/gen/upload.png'"></image>
					<view :style='{"width":"100%","flex":"1","flexDirection":"column","justifyContent":"center","display":"flex","height":"100%"}' class="info">
						<view :style='{"width":"100%","lineHeight":"36rpx","fontSize":"24rpx","color":"#333"}'>{{user.yonghuzhanghao}}<text v-if="user.vip&& user.vip=='是'">(VIP)</text></view>
						<view :style='{"width":"100%","lineHeight":"36rpx","fontSize":"24rpx","color":"#333"}' v-if="user.money">余额：{{user.money}}</view>
						<view :style='{"width":"100%","lineHeight":"36rpx","fontSize":"24rpx","color":"#333"}' v-if="user.jf||user.jf==0">积分：{{user.jf}}</view>
					</view>
				</view>
				<view :style='{"width":"112rpx","alignItems":"center","justifyContent":"center","display":"flex","height":"100%"}' class="setting">
					<view :style='{"border":"0","width":"64rpx","lineHeight":"64rpx","fontSize":"64rpx","color":"#333","borderRadius":"0"}' class="cuIcon-settings"></view>
				</view>
			</view>
		
		
			<view :style='{"width":"100%","padding":"0 24rpx 160rpx","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20221108/581bb1956ffe4c8182127ca1e196e95e.png) fixed","display":"flex","height":"auto"}' class="list">

				<block v-for="item in menuList" v-bind:key="item.roleName">
					<block v-if="role==item.roleName" v-bind:key="index" v-for=" (menu,index) in item.backMenu">
						<block v-bind:key="sort" v-for=" (child,sort) in menu.child">
							<view :style='{"boxShadow":"0px 0.10rpx 2rpx #ccc","borderColor":"#ccc","margin":"0 0 16rpx","alignItems":"center","borderWidth":"0 0 2rpx","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' && child.tableName!='exampaper' && child.tableName!='examquestion' " @tap="onPageTap('../'+child.tableName+'/list?userid='+user.id)" class="li" hover-class="hover">
								<view v-if="true" :style='{"width":"64rpx","padding":"0 0 0 16rpx","lineHeight":"64rpx","fontSize":"64rpx","color":"#afade4"}' :class="child.appFrontIcon"></view>
								<view :style='{"width":"100%","padding":"0 32rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#333","flex":"1"}' class="text">{{child.menu}}</view>
								<view v-if="true" :style='{"width":"28rpx","padding":"0 48rpx 0 0","lineHeight":"28rpx","fontSize":"28rpx","color":"#999"}' class="cuIcon-right"></view>
							</view>
						</block>
					</block>
				</block>

				<view @tap="onPageTap('../shop-recharge/pay-confirm')" :style='{"boxShadow":"0px 0.10rpx 2rpx #ccc","borderColor":"#ccc","margin":"0 0 16rpx","alignItems":"center","borderWidth":"0 0 2rpx","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="li" hover-class="hover">
					<view v-if="true" :style='{"width":"64rpx","padding":"0 0 0 16rpx","lineHeight":"64rpx","fontSize":"64rpx","color":"#afade4"}' class="cuIcon-moneybag"></view>
					<view class="text" :style='{"width":"100%","padding":"0 32rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#333","flex":"1"}'>用户充值</view>
					<view v-if="true" :style='{"width":"28rpx","padding":"0 48rpx 0 0","lineHeight":"28rpx","fontSize":"28rpx","color":"#999"}' class="cuIcon-right"></view>
				</view>
				<view @tap="onPageTap('../chat/chat')" :style='{"boxShadow":"0px 0.10rpx 2rpx #ccc","borderColor":"#ccc","margin":"0 0 16rpx","alignItems":"center","borderWidth":"0 0 2rpx","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="li" hover-class="hover">
					<view v-if="true" :style='{"width":"64rpx","padding":"0 0 0 16rpx","lineHeight":"64rpx","fontSize":"64rpx","color":"#afade4"}' class="cuIcon-service"></view>
					<view class="text" :style='{"width":"100%","padding":"0 32rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#333","flex":"1"}'>在线客服</view>
					<view v-if="true" :style='{"width":"28rpx","padding":"0 48rpx 0 0","lineHeight":"28rpx","fontSize":"28rpx","color":"#999"}' class="cuIcon-right"></view>
				</view>
				<view @tap="onPageTap('../shop-cart/shop-cart')" :style='{"boxShadow":"0px 0.10rpx 2rpx #ccc","borderColor":"#ccc","margin":"0 0 16rpx","alignItems":"center","borderWidth":"0 0 2rpx","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="li" hover-class="hover">
					<view v-if="true" :style='{"width":"64rpx","padding":"0 0 0 16rpx","lineHeight":"64rpx","fontSize":"64rpx","color":"#afade4"}' class="cuIcon-cart"></view>
					<view class="text" :style='{"width":"100%","padding":"0 32rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#333","flex":"1"}'>购物车</view>
					<view v-if="true" :style='{"width":"28rpx","padding":"0 48rpx 0 0","lineHeight":"28rpx","fontSize":"28rpx","color":"#999"}' class="cuIcon-right"></view>
				</view>
				<view @tap="onPageTap('../shop-order/shop-order')" :style='{"boxShadow":"0px 0.10rpx 2rpx #ccc","borderColor":"#ccc","margin":"0 0 16rpx","alignItems":"center","borderWidth":"0 0 2rpx","background":"radial-gradient(circle, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 100%)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="li" hover-class="hover">
					<view v-if="true" :style='{"width":"64rpx","padding":"0 0 0 16rpx","lineHeight":"64rpx","fontSize":"64rpx","color":"#afade4"}' class="cuIcon-order"></view>
					<view class="text" :style='{"width":"100%","padding":"0 32rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#333","flex":"1"}'>我的订单</view>
					<view v-if="true" :style='{"width":"28rpx","padding":"0 48rpx 0 0","lineHeight":"28rpx","fontSize":"28rpx","color":"#999"}' class="cuIcon-right"></view>
				</view>

			</view>
		</view>
	</view>
</template>
<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				isH5Plus: true,
				user: {},
				tableName:'',
				role: '',
				menuList: [],
        iconArr: [
          'cuIcon-same',
          'cuIcon-deliver',
          'cuIcon-evaluate',
          'cuIcon-shop',
          'cuIcon-ticket',
          'cuIcon-cascades',
          'cuIcon-discover',
          'cuIcon-question',
          'cuIcon-pic',
          'cuIcon-filter',
          'cuIcon-footprint',
          'cuIcon-pulldown',
          'cuIcon-pullup',
          'cuIcon-moreandroid',
          'cuIcon-refund',
          'cuIcon-qrcode',
          'cuIcon-remind',
          'cuIcon-profile',
          'cuIcon-home',
          'cuIcon-message',
          'cuIcon-link',
          'cuIcon-lock',
          'cuIcon-unlock',
          'cuIcon-vip',
          'cuIcon-weibo',
          'cuIcon-activity',
          'cuIcon-friendadd',
          'cuIcon-friendfamous',
          'cuIcon-friend',
          'cuIcon-goods',
          'cuIcon-selection'
        ],
			};
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onLoad(){
			this.role = uni.getStorageSync("role");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
		},
		async onShow(){
            uni.removeStorageSync("useridTag");
			this.role = uni.getStorageSync("role");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
		},
		methods: {
			onPageTap(url) {
                uni.setStorageSync("useridTag",1);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		height: calc(100vh - 94px);
		box-sizing: border-box;
	}
</style>
