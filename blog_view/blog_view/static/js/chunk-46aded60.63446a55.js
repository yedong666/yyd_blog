(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-46aded60"],{"25f0":function(e,t,r){"use strict";var s=r("e330"),o=r("5e77").PROPER,a=r("6eeb"),n=r("825a"),i=r("3a9b"),c=r("577e"),u=r("d039"),l=r("ad6d"),p="toString",m=RegExp.prototype,d=m[p],f=s(l),g=u((function(){return"/a/b"!=d.call({source:"a",flags:"b"})})),b=o&&d.name!=p;(g||b)&&a(RegExp.prototype,p,(function(){var e=n(this),t=c(e.source),r=e.flags,s=c(void 0===r&&i(m,e)&&!("flags"in m)?f(e):r);return"/"+t+"/"+s}),{unsafe:!0})},"2c3e":function(e,t,r){var s=r("da84"),o=r("83ab"),a=r("9f7f").MISSED_STICKY,n=r("c6b6"),i=r("9bf2").f,c=r("69f3").get,u=RegExp.prototype,l=s.TypeError;o&&a&&i(u,"sticky",{configurable:!0,get:function(){if(this!==u){if("RegExp"===n(this))return!!c(this).sticky;throw l("Incompatible receiver, RegExp required")}}})},"3ebd":function(e,t,r){"use strict";r.r(t);var s=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"reginsterContainer"},[r("el-form",{ref:"form",staticClass:"loginForm",attrs:{"label-position":"left",model:e.user,rules:e.rules}},[r("h2",{staticStyle:{"margin-bottom":"10px",color:"rgb(0, 195, 255"}},[e._v("注册")]),r("el-form-item",{attrs:{prop:"name"}},[r("el-input",{attrs:{type:"text","auto-complete":"false",placeholder:"昵称"},model:{value:e.user.name,callback:function(t){e.$set(e.user,"name",t)},expression:"user.name"}})],1),r("el-form-item",{attrs:{prop:"password"}},[r("el-input",{attrs:{type:"password","auto-complete":"false",placeholder:"密码"},model:{value:e.user.password,callback:function(t){e.$set(e.user,"password",t)},expression:"user.password"}})],1),r("el-form-item",{attrs:{prop:"passwords"}},[r("el-input",{attrs:{type:"password","auto-complete":"false",placeholder:"确认密码"},model:{value:e.user.passwords,callback:function(t){e.$set(e.user,"passwords",t)},expression:"user.passwords"}})],1),r("el-form-item",{attrs:{prop:"phoneNumber"}},[r("el-input",{attrs:{type:"text","auto-complete":"false",placeholder:"手机号码"},model:{value:e.user.phoneNumber,callback:function(t){e.$set(e.user,"phoneNumber",t)},expression:"user.phoneNumber"}})],1),r("el-form-item",{attrs:{prop:"email"}},[r("el-input",{attrs:{type:"text","auto-complete":"false",placeholder:"邮箱"},model:{value:e.user.email,callback:function(t){e.$set(e.user,"email",t)},expression:"user.email"}})],1),r("el-form-item",{attrs:{prop:"code"}},[r("el-input",{staticStyle:{width:"188px",float:"left","margin-right":"10px"},attrs:{type:"text","auto-complete":"false",placeholder:"验证码"},model:{value:e.user.code,callback:function(t){e.$set(e.user,"code",t)},expression:"user.code"}}),r("valid-code",{on:{listen:e.getCode}})],1),r("el-button",{on:{click:function(t){return e.test()}}},[e._v("test")]),r("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"注册成功后账号将发送至您的邮箱",placement:"top"}},[r("el-button",{on:{click:function(t){return e.doReginster("form")}}},[e._v("注册")])],1)],1)],1)},o=[],a=(r("b0c0"),r("ac1f"),r("00b4"),r("4d63"),r("c607"),r("2c3e"),r("25f0"),r("fd8f")),n=r("1602"),i={name:"Register",components:{ValidCode:a["a"]},data:function(){return{user:{name:"",password:"",passwords:"",phoneNumber:"",email:"",code:""},code:"",rules:{name:[{required:!0,message:"请输入昵称",trigger:"blur"},{min:6,max:12,message:"长度在 6 到 12 个字符",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"change"},{min:4,max:8,message:"长度在 4 到 8 个字符",trigger:"blur"}],passwords:[{required:!0,message:"请确认密码",trigger:"change"},{min:4,max:8,message:"长度在 4 到 8 个字符",trigger:"blur"}],phoneNumber:[{required:!0,message:"请输入电话号码",trigger:"blur"},{min:11,max:11,message:"请输入正确的电话号码",trigger:"blur"}],email:[{required:!0,message:"请输入邮箱账号",trigger:"blur"},{min:6,max:12,message:"请输入正确的邮箱",trigger:"blur"}],code:[{required:!0,message:"请输入验证码",trigger:"blur"},{min:4,max:4,message:"请输入正确的验证码",trigger:"blur"}]}}},methods:{doReginster:function(e){var t=this;this.$refs[e].validate((function(e){if(!e||!t.checkReginsterData(t.user.phoneNumber,t.user.email,t.user.code))return console.log("error submit!!"),!1;Object(n["d"])({password:t.user.password,nickname:t.user.name,phoneNumber:t.user.phoneNumber,email:t.user.email}),t.$message({message:"账号注册成功",type:"success",showClose:!0})}))},test:function(){Object(n["d"])({account:"20223025",password:"1234",nickname:"tyojd",phoneNumber:"dadwda",email:"dadda"})},checkReginsterData:function(e,t,r){return/^\d+$/.test(e)?new RegExp(".*@.*\\.com").test(t)?r==this.code&&""!=r||(this.$message({message:"验证码错误",type:"error",showClose:!0}),!1):(this.$message({message:"邮箱格式错误",type:"error",showClose:!0}),!1):(this.$message({message:"电话号码格式错误",type:"error",showClose:!0}),!1)},getCode:function(e){this.code=e}}},c=i,u=(r("e6a8"),r("2877")),l=Object(u["a"])(c,s,o,!1,null,"8e063434",null);t["default"]=l.exports},"44e7":function(e,t,r){var s=r("861d"),o=r("c6b6"),a=r("b622"),n=a("match");e.exports=function(e){var t;return s(e)&&(void 0!==(t=e[n])?!!t:"RegExp"==o(e))}},"4d63":function(e,t,r){var s=r("83ab"),o=r("da84"),a=r("e330"),n=r("94ca"),i=r("7156"),c=r("9112"),u=r("9bf2").f,l=r("241c").f,p=r("3a9b"),m=r("44e7"),d=r("577e"),f=r("ad6d"),g=r("9f7f"),b=r("6eeb"),h=r("d039"),x=r("1a2d"),w=r("69f3").enforce,v=r("2626"),y=r("b622"),E=r("fce3"),R=r("107c"),k=y("match"),C=o.RegExp,$=C.prototype,S=o.SyntaxError,N=a(f),q=a($.exec),_=a("".charAt),I=a("".replace),O=a("".indexOf),A=a("".slice),D=/^\?<[^\s\d!#%&*+<=>@^][^\s!#%&*+<=>@^]*>/,T=/a/g,j=/a/g,P=new C(T)!==T,Y=g.MISSED_STICKY,J=g.UNSUPPORTED_Y,K=s&&(!P||Y||E||R||h((function(){return j[k]=!1,C(T)!=T||C(j)==j||"/a/i"!=C(T,"i")}))),M=function(e){for(var t,r=e.length,s=0,o="",a=!1;s<=r;s++)t=_(e,s),"\\"!==t?a||"."!==t?("["===t?a=!0:"]"===t&&(a=!1),o+=t):o+="[\\s\\S]":o+=t+_(e,++s);return o},U=function(e){for(var t,r=e.length,s=0,o="",a=[],n={},i=!1,c=!1,u=0,l="";s<=r;s++){if(t=_(e,s),"\\"===t)t+=_(e,++s);else if("]"===t)i=!1;else if(!i)switch(!0){case"["===t:i=!0;break;case"("===t:q(D,A(e,s+1))&&(s+=2,c=!0),o+=t,u++;continue;case">"===t&&c:if(""===l||x(n,l))throw new S("Invalid capture group name");n[l]=!0,a[a.length]=[l,u],c=!1,l="";continue}c?l+=t:o+=t}return[o,a]};if(n("RegExp",K)){for(var F=function(e,t){var r,s,o,a,n,u,l=p($,this),f=m(e),g=void 0===t,b=[],h=e;if(!l&&f&&g&&e.constructor===F)return e;if((f||p($,e))&&(e=e.source,g&&(t="flags"in h?h.flags:N(h))),e=void 0===e?"":d(e),t=void 0===t?"":d(t),h=e,E&&"dotAll"in T&&(s=!!t&&O(t,"s")>-1,s&&(t=I(t,/s/g,""))),r=t,Y&&"sticky"in T&&(o=!!t&&O(t,"y")>-1,o&&J&&(t=I(t,/y/g,""))),R&&(a=U(e),e=a[0],b=a[1]),n=i(C(e,t),l?this:$,F),(s||o||b.length)&&(u=w(n),s&&(u.dotAll=!0,u.raw=F(M(e),r)),o&&(u.sticky=!0),b.length&&(u.groups=b)),e!==h)try{c(n,"source",""===h?"(?:)":h)}catch(x){}return n},V=function(e){e in F||u(F,e,{configurable:!0,get:function(){return C[e]},set:function(t){C[e]=t}})},z=l(C),B=0;z.length>B;)V(z[B++]);$.constructor=F,F.prototype=$,b(o,"RegExp",F)}v("RegExp")},"7a9d":function(e,t,r){},c607:function(e,t,r){var s=r("da84"),o=r("83ab"),a=r("fce3"),n=r("c6b6"),i=r("9bf2").f,c=r("69f3").get,u=RegExp.prototype,l=s.TypeError;o&&a&&i(u,"dotAll",{configurable:!0,get:function(){if(this!==u){if("RegExp"===n(this))return!!c(this).dotAll;throw l("Incompatible receiver, RegExp required")}}})},e6a8:function(e,t,r){"use strict";r("7a9d")}}]);
//# sourceMappingURL=chunk-46aded60.63446a55.js.map