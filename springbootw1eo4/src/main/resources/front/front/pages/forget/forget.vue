<template>
	<view class="content">
		<view class="box" :style='{"width":"100%","padding":"24rpx","backgroundSize":"100%","background":"url(http://codegen.caihongy.cn/20221109/ea2d226d42fe495daff146c9b99f4f24.jpg) center top  no-repeat","height":"100vh"}' v-if="type==1">
			<view :style='{"width":"70%","padding":"24rpx","margin":"120rpx 0 0 0","display":"block","height":"auto"}'>
				<view class="forget-input" :style='{"width":"100%","margin":"0 0 24rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}'>
					<input v-model="username" :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}' type="text" placeholder="请输入您的账号" />
				</view>
				<picker :style='{"width":"100%","margin":"0 0 24rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' @change="optionsChange" :value="index" :range="options">
					<view class="uni-input" :style='{"width":"100%","padding":"0 20rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#777"}'>{{options[index]}}</view>
				</picker>
				<button class="landing" :style='{"border":"0","padding":"0px","margin":"24rpx 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"8rpx","background":"url(http://codegen.caihongy.cn/20221108/9576aabc35484eca94c43b91cc41cced.png) no-repeat","width":"478rpx","lineHeight":"88rpx","fontSize":"32rpx","backgroundSize":"100% 100%","height":"88rpx"}' @tap="nextClick" type="primary">下一步</button>
			</view>
		</view>
        <view class="box" :style='{"width":"100%","padding":"24rpx","backgroundSize":"100%","background":"url(http://codegen.caihongy.cn/20221109/ea2d226d42fe495daff146c9b99f4f24.jpg) center top  no-repeat","height":"100vh"}' v-if="type==2">
            <view :style='{"width":"70%","padding":"24rpx","margin":"120rpx 0 0 0","display":"block","height":"auto"}'>
                <view class="forget-input" :style='{"width":"100%","margin":"0 0 24rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}'>
                    <input v-model="userForm.pquestion"  :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}' type="text" placeholder="密保问题" disabled="disabled"/>
                </view>
                <view class="forget-input" :style='{"width":"100%","margin":"0 0 24rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}'>
                    <input v-model="panswer1" :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}' type="text" placeholder="密保答案" />
                </view>
                <button class="landing" :style='{"border":"0","padding":"0px","margin":"24rpx 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"8rpx","background":"url(http://codegen.caihongy.cn/20221108/9576aabc35484eca94c43b91cc41cced.png) no-repeat","width":"478rpx","lineHeight":"88rpx","fontSize":"32rpx","backgroundSize":"100% 100%","height":"88rpx"}' @tap="confirmClick" type="primary">确定</button>
            </view>
        </view>
        <view class="box" :style='{"width":"100%","padding":"24rpx","backgroundSize":"100%","background":"url(http://codegen.caihongy.cn/20221109/ea2d226d42fe495daff146c9b99f4f24.jpg) center top  no-repeat","height":"100vh"}' v-if="type==3">
            <view :style='{"width":"70%","padding":"24rpx","margin":"120rpx 0 0 0","display":"block","height":"auto"}'>
                <view class="forget-input" :style='{"width":"100%","margin":"0 0 24rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}'>
                    <input v-model="password" :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}' type="password" placeholder="密码" />
                </view>
                <view class="forget-input" :style='{"width":"100%","margin":"0 0 24rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}'>
                    <input v-model="repassword" :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}' type="password" placeholder="确认密码" />
                </view>
                <button class="landing" :style='{"border":"0","padding":"0px","margin":"24rpx 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"8rpx","background":"url(http://codegen.caihongy.cn/20221108/9576aabc35484eca94c43b91cc41cced.png) no-repeat","width":"478rpx","lineHeight":"88rpx","fontSize":"32rpx","backgroundSize":"100% 100%","height":"88rpx"}' @tap="updateClick" type="primary">修改密码</button>
            </view>
        </view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				options: [
                    '请选择登陆用户类型',
                ],
                optionsValues: [
					'',
				],
				index: 0,
                tableName: '',
                type: 1,
                repassword: '',
                password: '',
                panswer1: '',
                userForm: {
                }
			}
		},
		onLoad() {
			this.styleChange()
		},
		methods: {
			async nextClick() {
				if(this.username==undefined) {
					this.$utils.msg('请输入账号')
					return;
                                }
				if(this.optionsValues[this.index]=="") {
					this.$utils.msg('请选择角色')
                    return;
				}
                this.tableName = this.optionsValues[this.index];
                let res = await this.$api.security(this.tableName,{
                    username: this.username
                })
                if(!res.data) {
                    this.$utils.msg('用户不存在')
                }
                if (res.code == 0) {
                    this.userForm = res.data
                    this.type = 2
                }
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.forget-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.restPwFrom.content.input.backgroundColor
					// })
				})
			},
            confirmClick() {
                if (this.userForm.panswer !== this.panswer1) {
                    this.$utils.msg('密保答案不正确')
                    return false
                }
                this.$utils.msg('验证成功')
                this.password = ''
                setTimeout(() => {
                    this.type = 3
                }, 1000)
            },
            async updateClick() {
                if(!this.password) {
                    this.$utils.msg('密码不能为空')
                    return false
                }
                if (this.password != this.repassword) {
                    this.$utils.msg('两次密码输入不一致')
                    return false
                }
                if(this.userForm.mima) {
                    this.userForm.mima=this.password;
                } else {
                    this.userForm.password=this.password;
                }
                await this.$api.update(this.tableName, this.userForm)
                this.$utils.msg('密码修改成功')
                setTimeout(() => {
                    uni.navigateBack({
            
                    })
                }, 1000)
            },
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
