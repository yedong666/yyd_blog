(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4865e064"],{"162a":function(t,e,a){t.exports=a.p+"static/img/noComments.e4a60225.png"},"18a8":function(t,e,a){"use strict";a.d(e,"a",(function(){return i})),a.d(e,"b",(function(){return n})),a.d(e,"c",(function(){return r}));var s=a("8daa");function i(t){return Object(s["a"])({url:"/addArticle",method:"post",data:JSON.stringify(t)})}function n(){return Object(s["a"])({url:"/articles",method:"get",headers:{"Content-Type":"application/json"}})}function r(t){return Object(s["a"])({url:"/getArticleById",method:"get",headers:{"Content-Type":"application/json"},params:{id:t}})}},7284:function(t,e,a){"use strict";a.d(e,"b",(function(){return i})),a.d(e,"a",(function(){return n}));var s=a("8daa");function i(t){return Object(s["a"])({url:"/getCommentsByArticleId",method:"get",headers:{"Content-Type":"application/json"},params:{articleId:t}})}function n(t){return Object(s["a"])({url:"/addComment",method:"post",headers:{"Content-Type":"application/json"},data:JSON.stringify(t)})}},a41e:function(t,e,a){"use strict";a("c05c")},bf65:function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"home"},[s("div",{staticClass:"articleHead"},[s("h1",[t._v(t._s(t.article.title))]),s("div",[t._v(t._s(t.article.author))]),t.article.tags?s("div",[s("el-tag",{staticStyle:{left:"14px"}},[t._v(t._s(t.article.tags[0]))]),s("el-tag",{staticStyle:{left:"74px"},attrs:{type:"success"}},[t._v(t._s(t.article.tags[1]))]),s("el-tag",{staticStyle:{left:"144px"},attrs:{type:"info"}},[t._v(t._s(t.article.tags[2]))])],1):t._e()]),s("div",{directives:[{name:"highlight",rawName:"v-highlight"}],staticClass:"articleContent",domProps:{innerHTML:t._s(t.article.content)}}),s("div",{staticClass:"articleFooter"},[s("div",{staticClass:"articleMessages"},[s("label",{attrs:{for:""}},[s("i",{staticClass:"el-icon-view"}),t._v(" "+t._s(t.article.numberOfView))]),s("label",{attrs:{for:""}},[s("i",{staticClass:"el-icon-thumb"}),t._v(" "+t._s(t.article.numberOfLike))]),s("label",{attrs:{for:""}},[s("i",{staticClass:"el-icon-chat-dot-square"}),t._v(" "+t._s(t.article.numberOfComment))]),t._m(0),t._m(1)]),s("div",{staticClass:"writeComment"},[s("el-input",{staticStyle:{"font-size":"20px"},attrs:{type:"textarea",icon:"el-icon-bell",placeholder:"留下你的评论...",maxlength:"100",rows:3,"show-word-limit":""},model:{value:t.comment,callback:function(e){t.comment=e},expression:"comment"}}),s("el-button",{staticStyle:{width:"100%","margin-top":"5px","font-size":"20px"},attrs:{type:"primary"},on:{click:t.publishComment}},[t._v("确认发表")])],1),0==t.comments.length?s("div",{staticClass:"nullMsg"},[s("img",{attrs:{src:a("162a"),alt:""}}),s("span",[t._v(" 还没有人对本文发表过评论哦 ")])]):t._e(),t.comments?s("div",{staticClass:"comments"},t._l(t.comments,(function(e,a){return s("div",{key:a,staticClass:"comment"},[s("div",{staticClass:"commenter"},[s("el-avatar",{attrs:{icon:"el-icon-user-solid"}}),t.users[a]?s("p",{staticClass:"commentName"},[t._v(t._s(t.users[a].nickname))]):t._e()],1),s("div",{staticClass:"commentContent"},[s("p",[t._v(" "+t._s(e.content)+" ")])]),s("div",{staticClass:"commentMessages"},[s("label",{attrs:{for:""}},[s("i",{staticClass:"el-icon-view"}),t._v(" "+t._s(e.numberOfView))]),s("label",{attrs:{for:""}},[s("i",{staticClass:"el-icon-thumb"}),t._v(" "+t._s(e.numberOfLike))]),s("label",{attrs:{for:""}},[s("i",{staticClass:"el-icon-chat-dot-square"}),t._v(" "+t._s(e.numberOfReply))]),t._m(2,!0),t._m(3,!0)])])})),0):t._e()])])},i=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("label",{},[a("i",{staticClass:"el-icon-bell"}),t._v("2022-3-22 15:39")])},function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("label",{staticStyle:{float:"right"}},[a("i",{staticClass:"el-icon-date"}),t._v("发表评论")])},function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("label",[a("i",{staticClass:"el-icon-date"}),t._v("2022-3-22 15:39")])},function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("label",{staticStyle:{float:"right"}},[a("i",{staticClass:"el-icon-top-left"}),t._v("回复")])}],n=a("18a8"),r=a("7284"),c=a("1602"),l={data(){return{id:Number,article:{},comments:[],users:[],comment:"",isShow:!1}},mounted(){let t=this;this.id=Number(this.$route.query.articleId),Object(n["c"])(this.id).then(t=>{this.article=t.data.data,this.article.tags=this.article.tags.split(",")}),Object(r["b"])(this.id).then(t=>(this.comments=t.data.data,t.data.data)).then(e=>{e.forEach(e=>{Object(c["a"])(Number(e.observerId)).then(e=>{t.users.push(e.data.data)})})})},computed:{},methods:{showUserMenuBar(t){this.isShow=t},addZero(t){return t<10?"0"+t:t},getNowDate(){var t=new Date,e=t.getFullYear(),a=t.getMonth()+1,s=t.getDate(),i=t.getHours(),n=t.getMinutes(),r=t.getSeconds(),c=e+"-"+this.addZero(a)+"-"+this.addZero(s)+" "+this.addZero(i)+":"+this.addZero(n)+":"+this.addZero(r);return c},publishComment(){if(0==this.comment.length)alert("评论不可以为空哦");else if(null==this.$store.state.userData)alert("需要登录后才可以评论");else{let t={content:this.comment,observerId:JSON.parse(this.$store.state.userData).id,articleId:this.id,replyId:0,date:this.getNowDate(),numberOfLike:0,numberOfReply:0,numberOfView:0};Object(r["a"])(t).then(t=>{alert(t.data.data),location.reload()}).catch(t=>{console.log(t),alert("发布评论失败")})}}},components:{}},o=l,u=(a("a41e"),a("2877")),d=Object(u["a"])(o,s,i,!1,null,"1fecf130",null);e["default"]=d.exports},c05c:function(t,e,a){}}]);
//# sourceMappingURL=chunk-4865e064.e928fa89.js.map