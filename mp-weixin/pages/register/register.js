(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/register/register"],{"00a5":function(t,e,n){"use strict";var i=n("e7d3"),r=n.n(i);r.a},"0453":function(t,e,n){"use strict";(function(t){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var i=r(n("a34a"));function r(t){return t&&t.__esModule?t:{default:t}}function u(t,e,n,i,r,u,a){try{var o=t[u](a),s=o.value}catch(l){return void n(l)}o.done?e(s):Promise.resolve(s).then(i,r)}function a(t){return function(){var e=this,n=arguments;return new Promise((function(i,r){var a=t.apply(e,n);function o(t){u(a,i,r,o,s,"next",t)}function s(t){u(a,i,r,o,s,"throw",t)}o(void 0)}))}}var o=function(){return n.e("components/momo-multipleSelect/momo-multipleSelect").then(n.bind(null,"bd56"))},s={data:function(){return{yonghuxingbieOptions:[],yonghuxingbieIndex:0,ruleForm:{yonghuzhanghao:"",mima:"",yonghuxingming:"",touxiang:"",xingbie:"",lianxifangshi:"",money:""},tableName:""}},components:{multipleSelect:o},computed:{baseUrl:function(){return this.$base.url}},onLoad:function(){var e=a(i.default.mark((function e(){var n;return i.default.wrap((function(e){while(1)switch(e.prev=e.next){case 0:[],n=t.getStorageSync("loginTable"),this.tableName=n,"yonghu"==this.tableName&&(this.yonghuxingbieOptions="男,女".split(","),this.ruleForm.xingbie=this.yonghuxingbieOptions[0]),this.styleChange();case 5:case"end":return e.stop()}}),e,this)})));function n(){return e.apply(this,arguments)}return n}(),methods:{yonghutouxiangTap:function(){var t=this;this.$api.upload((function(e){t.ruleForm.touxiang="upload/"+e.file,t.$forceUpdate()}))},yonghuxingbieChange:function(t){this.yonghuxingbieIndex=t.target.value,this.ruleForm.xingbie=this.yonghuxingbieOptions[this.yonghuxingbieIndex]},toggleTab:function(t){this.$refs[t].show()},styleChange:function(){this.$nextTick((function(){}))},getUUID:function(){return(new Date).getTime()},register:function(){var t=a(i.default.mark((function t(){return i.default.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!("yonghu"==this.tableName&&this.ruleForm.yonghuzhanghao.length<3)){t.next=3;break}return this.$utils.msg("用户账号长度不能小于3"),t.abrupt("return");case 3:if(!("yonghu"==this.tableName&&this.ruleForm.yonghuzhanghao.length>10)){t.next=6;break}return this.$utils.msg("用户账号长度不能大于10"),t.abrupt("return");case 6:if(this.ruleForm.mima||"yonghu"!=this.tableName){t.next=9;break}return this.$utils.msg("密码不能为空"),t.abrupt("return");case 9:if(!("yonghu"==this.tableName&&this.ruleForm.mima.length<3)){t.next=12;break}return this.$utils.msg("密码长度不能小于3"),t.abrupt("return");case 12:if(!("yonghu"==this.tableName&&this.ruleForm.mima.length>10)){t.next=15;break}return this.$utils.msg("密码长度不能大于10"),t.abrupt("return");case 15:if("yonghu"!=this.tableName||this.ruleForm.mima==this.ruleForm.mima2){t.next=18;break}return this.$utils.msg("两次密码输入不一致"),t.abrupt("return");case 18:if("yonghu"!=this.tableName||!this.ruleForm.lianxifangshi||this.$validate.isMobile(this.ruleForm.lianxifangshi)){t.next=21;break}return this.$utils.msg("联系方式应输入手机格式"),t.abrupt("return");case 21:if("yonghu"!=this.tableName||!this.ruleForm.money||this.$validate.isNumber(this.ruleForm.money)){t.next=24;break}return this.$utils.msg("余额应输入数字"),t.abrupt("return");case 24:return t.next=26,this.$api.register("".concat(this.tableName),this.ruleForm);case 26:this.$utils.msgBack("注册成功");case 28:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}()}};e.default=s}).call(this,n("543d")["default"])},"0943":function(t,e,n){"use strict";(function(t){n("6cdc"),n("921b");i(n("66fd"));var e=i(n("3735"));function i(t){return t&&t.__esModule?t:{default:t}}t(e.default)}).call(this,n("543d")["createPage"])},3735:function(t,e,n){"use strict";n.r(e);var i=n("75b4"),r=n("48c7");for(var u in r)"default"!==u&&function(t){n.d(e,t,(function(){return r[t]}))}(u);n("00a5");var a,o=n("f0c5"),s=Object(o["a"])(r["default"],i["b"],i["c"],!1,null,"246d62f5",null,!1,i["a"],a);e["default"]=s.exports},"48c7":function(t,e,n){"use strict";n.r(e);var i=n("0453"),r=n.n(i);for(var u in i)"default"!==u&&function(t){n.d(e,t,(function(){return i[t]}))}(u);e["default"]=r.a},"75b4":function(t,e,n){"use strict";var i,r=function(){var t=this,e=t.$createElement;t._self._c},u=[];n.d(e,"b",(function(){return r})),n.d(e,"c",(function(){return u})),n.d(e,"a",(function(){return i}))},e7d3:function(t,e,n){}},[["0943","common/runtime","common/vendor"]]]);