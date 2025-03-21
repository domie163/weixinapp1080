<template>
<view class="content">
	<view :style='{"width":"100%","padding":"0 0 64rpx","background":"url(http://codegen.caihongy.cn/20221108/581bb1956ffe4c8182127ca1e196e95e.png) fixed","height":"auto"}'>
		<swiper :style='{"width":"100%","background":"#fff","height":"360rpx"}' class="swiper" :indicator-dots='false' :autoplay='true' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
			<swiper-item :style='{"width":"100%","background":"#fff","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index" @tap="onSwiperTap(swiper)">
				<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img"></image>
				<view v-if="false" :style='{"width":"100%","padding":"0 8rpx","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","background":"#fff"}'>{{ swiper.title }}</view>
			</swiper-item>
		</swiper>

		<view class="cu-bar bg-white search" :style="[{top:CustomBar + 'px'}]">
			<picker v-if="queryList.length>1" mode="selector" :range="queryList" range-key="queryName" :value="queryIndex" @change="queryChange" style="padding-left: 20upx;">
				<view><image style="width: 20upx;height: 33upx;" src="../../static/center/to.png"></image></view>
			</picker>
			<view v-if="queryIndex==0" class="search-form round">
				<text class="cuIcon-search"></text>
				<input v-model="searchForm.rexiaonongchanpinnongchanpinmingcheng" type="text" placeholder="农产品名称" ></input>
			</view>
			<view v-if="queryIndex==0" class="action">
				<button @tap="onPageTap('rexiaonongchanpin')" class="cu-btn shadow-blur round">搜索</button>
			</view>
		</view>

		<!-- menu -->
		<view v-if="true" class="menu" :style='{"padding":"0","margin":"0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
            <block v-for="item in menuList" v-bind:key="item.roleName">
                <block v-if="role==item.roleName" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
                    <block v-bind:key="sort" v-for=" (child,sort) in menu.child">
                        <block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
                            <view :style='{"width":"23%","padding":"12rpx 0","margin":"10rpx 0","height":"auto"}' class="menu-list" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2('../'+child.tableName+'/list')">
                                <view class="iconarr" :class="child.appFrontIcon" :style='{"padding":"0","margin":"0px auto","color":"#333","borderRadius":"100%","background":"#fff","display":"block","width":"64rpx","lineHeight":"64rpx","fontSize":"64rpx","height":"64rpx"}'></view>
                                <view :style='{"padding":"0","margin":"12rpx auto 0","color":"#333","textAlign":"center","width":"100%","lineHeight":"28rpx","fontSize":"28rpx"}'>{{child.menu.split("列表")[0]}}</view>
                            </view>
                        </block>
                    </block>
                </block>
            </block>
		</view>
		<!-- menu -->
		
		
		<!-- 关于我们 -->
		<view :style='{"padding":"0 24rpx","margin":"24rpx 16rpx 16rpx 16rpx","borderColor":"#afade4","borderRadius":"8rpx","flexWrap":"wrap","background":"#fff","borderWidth":"8rpx 2rpx 2rpx 2rpx","display":"flex","width":"calc(100% - 32rpx)","borderStyle":"solid","height":"auto"}'>
		  <view :style='{"padding":"8rpx 0 0 8rpx","margin":"24rpx 48rpx 0 0","borderColor":"#afade4","color":"#333","textAlign":"center","borderWidth":"8rpx 0 0 8rpx","width":"48rpx","fontSize":"48rpx","borderStyle":"solid"}'>{{aboutUsDetail.title}}</view>
		  <view :style='{"width":"8rpx","margin":"24rpx 16rpx 0 32rpx","fontSize":"32rpx","color":"#999","textAlign":"center","display":"none"}'>{{aboutUsDetail.subtitle}}</view>
		  <view :style='{"border":"4rpx solid #ccc","padding":"8rpx","margin":"24rpx 0 0 0","flexWrap":"wrap","display":"flex","width":"calc(100% - 108rpx)","height":"360rpx"}'>
		    <img :style='{"width":"100%","margin":"0px","objectFit":"cover","display":"block","height":"100%"}' v-if="aboutUsDetail.picture1" :src="baseUrl+aboutUsDetail.picture1">
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"none","height":"160rpx"}' v-if="aboutUsDetail.picture2" :src="baseUrl+aboutUsDetail.picture2">
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"none","height":"160rpx"}' v-if="aboutUsDetail.picture3" :src="baseUrl+aboutUsDetail.picture3">
		  </view>
		  <view :style='{"padding":"0","margin":"24rpx 0 20rpx 0","color":"rgb(102, 102, 102)","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textIndent":"2em"}' v-html="aboutUsDetail.content"></view>
		  <view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
		  <view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
		</view>

		<!-- 商品推荐 -->
		<view class="listBox recommend">
			<view v-if="false && 1 == 1" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			<view class="title" :style='{"width":"100%","padding":"0 24rpx","boxShadow":"0px 4rpx 12rpx #ccc","margin":"24rpx 0 0 0","background":"radial-gradient(circle, rgba(216,214,246,1) 0%, rgba(204,189,235,1) 24%, rgba(181,191,232,1) 62%, rgba(175,173,228,1) 100%),rgb(216,214,246)"}'>
				<view :style='{"color":"#fff","fontSize":"32rpx","lineHeight":"76rpx"}'>热销农产品推荐</view>
			</view>
			
			<view v-if="false && 1 == 2" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			<!-- 样式1 -->
			<view class="list-box style1" :style='{"padding":"24rpx","margin":"24rpx 0 0 0","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
				<view @tap="onDetailTap('rexiaonongchanpin',product.id)" v-for="(product,index) in rexiaonongchanpinlist" :key="index" class="list-item" :style='{"boxShadow":"-8rpx 0px 0px rgba(188,188,226,.9)","padding":"16rpx","margin":"0 0 20rpx","backgroundColor":"#ecebf6","borderRadius":"12rpx","width":"48%","height":"auto"}'>
					<view :style='{"padding":"4rpx 20rpx","color":"#333","borderRadius":"8rpx 8rpx 0 0","background":"#fff","width":"100%","lineHeight":"48rpx","fontSize":"28rpx"}' class="list-item-title ">{{product.nongchanpinmingcheng}}</view>
					<image :style='{"width":"100%","padding":"0","margin":"0","objectFit":"cover","display":"block","height":"300rpx"}' class="list-item-image" mode="aspectFill" v-if="product.nongchanpintupian.substring(0,4)=='http'" :src="product.nongchanpintupian"></image>
					<image :style='{"width":"100%","padding":"0","margin":"0","objectFit":"cover","display":"block","height":"300rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.nongchanpintupian?baseUrl+product.nongchanpintupian.split(',')[0]:''"></image>
					<view :style='{"padding":"4rpx 20rpx","color":"#333","borderRadius":"8rpx 8rpx 0 0","background":"#fff","width":"100%","lineHeight":"48rpx","fontSize":"28rpx"}' class="list-item-title ">品牌:{{product.pinpai}}</view>
					<view :style='{"padding":"4rpx 20rpx","color":"red","borderRadius":"0 0 8rpx 8rpx","textAlign":"right","background":"#fff","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"700"}' class="list-item-pirce">￥{{product.price}}</view>
				</view>
			</view>
			
			
			
			  
			
			
			  
			
			  
			<view v-if="false && 1 == 3" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
		<!-- 商品推荐 -->
		
		

		<!-- 商品列表 -->
														<view class="listBox list">
			<view v-if="false && 1 == 1" class="idea listIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		  
			<view class="title" :style='{"padding":"0 24rpx","boxShadow":"0px 4rpx 12rpx #ccc","margin":"24rpx 0 0 0","background":"radial-gradient(circle, rgba(216,214,246,1) 0%, rgba(204,189,235,1) 24%, rgba(181,191,232,1) 62%, rgba(175,173,228,1) 100%),rgb(216,214,246)","display":"flex","width":"100%","justifyContent":"space-between"}'>
				<view :style='{"color":"#fff","fontSize":"32rpx","lineHeight":"76rpx"}'>热销农产品</view>
				<text :style='{"color":"#fff","fontSize":"28rpx","lineHeight":"76rpx"}' @tap="onPageTap('rexiaonongchanpin')">查看更多</text>
			</view>
			
			<view v-if="false && 1 == 2" class="idea listIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
		  		  <!-- 样式1 -->
		  <view class="list-box style1" :style='{"padding":"24rpx","margin":"24rpx 0 0 0","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
			<view @tap="onDetailTap('rexiaonongchanpin',product.id)" v-for="(product,index) in homerexiaonongchanpinlist" :key="index" class="list-item" :style='{"boxShadow":"-8rpx 0px 0px rgba(188,188,226,.9)","padding":"16rpx","margin":"0 0 20rpx","backgroundColor":"#ecebf6","borderRadius":"12rpx","width":"48%","height":"auto"}'>
			                			  			  			                			  <view :style='{"padding":"4rpx 20rpx","color":"#333","borderRadius":"8rpx 8rpx 0 0","background":"#fff","width":"100%","lineHeight":"48rpx","fontSize":"28rpx"}' class="list-item-title ">{{product.nongchanpinmingcheng}}</view>
			  			  			  			                			  			  <image :style='{"width":"100%","padding":"0","margin":"0","objectFit":"cover","display":"block","height":"300rpx"}' class="list-item-image" mode="aspectFill" v-if="product.nongchanpintupian.substring(0,4)=='http'" :src="product.nongchanpintupian"></image>
			  <image :style='{"width":"100%","padding":"0","margin":"0","objectFit":"cover","display":"block","height":"300rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.nongchanpintupian?baseUrl+product.nongchanpintupian.split(',')[0]:''"></image>
			  			  			                			  			  			                			  			  			                			  <view :style='{"padding":"4rpx 20rpx","color":"#333","borderRadius":"8rpx 8rpx 0 0","background":"#fff","width":"100%","lineHeight":"48rpx","fontSize":"28rpx"}' class="list-item-title ">品牌:{{product.pinpai}}</view>
			  			  			  			                			  			  			                			  			  			                			  			  			                			  			  			                			  			  			                			  			  			                			  			  			                			  			  			  <view :style='{"padding":"4rpx 20rpx","color":"#ff0000","borderRadius":"0 0 8rpx 8rpx","textAlign":"right","background":"#fff","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"700"}' class="list-item-pirce">￥{{product.price}}</view>
			  			  			</view>
		  </view>
		  		  
		  		  
		  		  
		  		  
		  		  
		  		  
		  		  
		  		  
		  		  
			<view v-if="false && 1 == 3" class="idea listIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
																																						<!-- 商品列表 -->
		
		
		<!-- 新闻资讯 -->
																																						<view class="listBox news">
			<view v-if="false && 1 == 1" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			<view class="title" :style='{"padding":"0 24rpx","boxShadow":"0px 4rpx 12rpx #ccc","margin":"24rpx 0 0 0","background":"radial-gradient(circle, rgba(216,214,246,1) 0%, rgba(204,189,235,1) 24%, rgba(181,191,232,1) 62%, rgba(175,173,228,1) 100%),rgb(216,214,246)","display":"flex","width":"100%","justifyContent":"space-between"}'>
				<view :style='{"color":"#fff","fontSize":"32rpx","lineHeight":"76rpx"}'>网站公告</view>
				<text :style='{"color":"#fff","fontSize":"28rpx","lineHeight":"76rpx"}' @tap="onPageTap('news')">查看更多</text>
			</view>
			
			<view v-if="false && 1 == 2" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
					  
						
						
		  <!-- 样式4 -->
		  		  <view class="news-box1" :style='{"width":"100%","padding":"24rpx","margin":"24rpx 0 0 0","height":"auto"}'>
			<view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","padding":"16rpx","margin":"0 0 32rpx","borderColor":"#c5c3ed","borderRadius":"12rpx","flexWrap":"wrap","background":"#fafafe","borderWidth":"0 0 0 12rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
			  <view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","height":"auto"}'>
				<view :style='{"padding":"0 20rpx","margin":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#333","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis","fontWeight":"bold"}' class="title ">{{item.title}}</view>
				<view :style='{"padding":"0 20rpx","margin":"0","overflow":"hidden","color":"#666","textAlign":"left","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textIndent":"2em","height":"144rpx"}' class="desc ">{{item.introduction}}</view>
				<view :style='{"padding":"0 20rpx","margin":"0","color":"#999","textAlign":"left","width":"100%","lineHeight":"48rpx","fontSize":"28rpx"}' class="time">{{item.addtime.split(" ")[0]}}</view>
			  </view>
			  <image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"8rpx","display":"block","height":"200rpx"}' mode="aspectFill" class="listmpic" :src="baseUrl+item.picture"></image>
			</view>
		  </view>
		  		  
		  <!-- 样式5 -->
		  		  
		  <!-- 样式6 -->
		  		  
		  <!-- 样式7 -->
		  		  
		  <!-- 样式8 -->
		  		  
		  <!-- 样式9 -->
		  			
			<view v-if="false && 1 == 3" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
														<!-- 新闻资讯 -->
				

	</view>
</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
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
                role : '',
                aboutUsDetail: {},
                menuList: [],
                swiperMenuList:[],
                user: {},
                tableName:'',
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				queryList:[
					{
						queryName:"农产品名称",
					},
				],
				queryIndex: 0,
				searchForm:{
					rexiaonongchanpinnongchanpinmingcheng:'',
				},
				CustomBar: '0',

				//轮播
				swiperList: [],
				rexiaonongchanpinlist: [],
				homerexiaonongchanpinlist: [],
				news: [],
			}
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
            this.menuList.forEach((item,key) => {
                if(this.role==item.roleName) {
                    item.frontMenu.forEach((item2,key2) => {
                        if(item2.child[0].buttons.indexOf("查看")>-1) {
                            this.swiperMenuList.push(item2);
                        }
                    })
                }
            })
        },
		async onShow() {
            this.btnColor = this.btnColor.sort(()=> {
                    return (0.5-Math.random());
            });
            let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.page('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
                        title: item.name
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
            this.getAboutUs();
			// 网站公告
			res = await this.$api.list('news', {
				page: 1,
				limit: 6
			});
			this.news = res.data.list

			// 推荐信息
			if(uni.getStorageSync("userid")!==null) {
				res = await this.$api.recommend2('rexiaonongchanpin', {
                    page: 1,
                    limit: 4
                });
			} else {
				res = await this.$api.recommend('rexiaonongchanpin', {                                              
                    page: 1,
                    limit: 4
                });
			}
			this.rexiaonongchanpinlist = res.data.list

			res = await this.$api.list('rexiaonongchanpin', {
				page: 1,

				limit: 4
			});
			this.homerexiaonongchanpinlist = res.data.list
		},

		methods: {

			//查询条件切换
			queryChange(e) {
				this.queryIndex=e.detail.value;
				this.searchForm.rexiaonongchanpinnongchanpinmingcheng="";
			},
			//轮播图跳转
			onSwiperTap(e) {

			},
            async getAboutUs() {
                let res = await this.$api.info('aboutus', 1)
                this.aboutUsDetail = res.data;
            },
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){
				if(this.queryIndex==0) {
					uni.setStorageSync('indexQueryCondition',this.searchForm.rexiaonongchanpinnongchanpinmingcheng);
					this.searchForm.rexiaonongchanpinnongchanpinmingcheng = '';
				}

				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
            onPageTap2(url) {
                uni.setStorageSync("useridTag",0);
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
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
