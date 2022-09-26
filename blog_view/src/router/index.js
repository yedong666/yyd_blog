import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const router = new Router({
  base: '/blog_view/',
  routes: [
    {
      path: '/mobile',
      name: 'MHome',
      component: () => import('../mobile/pages/MHome.vue'),
      children: [
        {
          path: 'blog',
          component: () => import('../mobile/components/MobileBlog.vue'),
        },
        {
          path: 'writeBlog',
          component: () => import('../mobile/components/MobileWriteTalking.vue'),
        },
        {
          path: '',
          component: () => import('../mobile/components/MobileBlogList.vue'),
        },
      ],
    },

    {
      path: '/login',
      name: 'Login',
      component: () => import('../views/Login.vue'),
    },
    {
      path: '/manage',
      component: () => import('../views/BackManage.vue'),
      redirect: '/manage/dataview',
      children: [
        {
          path: '/manage/dataview',
          component: () => import('../components/manage/DataView.vue')
        },
        {
          path: '/manage/userDataview',
          component: () => import('../components/manage/UserDataView.vue')
        },
        {
          path: '/manage/userListView',
          component: () => import('../components/manage/UserListView.vue')
        },
      ]  
    },
    {
      path: '/reginster',
      name: 'Reginster',
      component: () => import('../views/Reginster.vue'),
    },
    {
      path: '/bg',
      name: 'Background',
      component: () => import('../components/Background.vue'),
    },
    {
      path: '/blogcard',
      name: 'BlogCard',
      component: () => import('../components/BlogCard.vue'),
    },
    {
      path: '/nav',
      name: 'Navbar',
      component: () => import('../components/NavBar.vue'),
    },

    {
      path: '/',
      redirect: '/home',
    },

    {
      path: '/home',
      component: () => import('../views/Home.vue'),
      redirect: '/home/bloglist',
      children: [
        {
          path: 'bloglist',
          component: () => import('../views/blog/BlogShow.vue')
        },
        {
          path: 'blogclassify',
          component: () => import('../components/Classify.vue'),
          children:[

          ]
        },
        {
          path: 'search',
          component: () => import('../components/search/SearchList.vue'),
          redirect: '/home/search/searchBlogList',
          children:[
            {
              path: 'searchBlogList',
              component: () => import('../components/search/SearchBlogList.vue'),
            },
            {
              path: 'searchTagList',
              component: () => import('../components/search/SearchTagList.vue'),
            },
            {
              path: 'searchUserList',
              component: () => import('../components/search/SearchUserList.vue'),
            },
          ]
        },
        {
          path: 'about',
          component: () => import('../components/About.vue'),
        },
      ],
      
    },
    {
      path: '/blogShow',
      name: 'BlogShow',
      component: () => import('../views/blog/BlogShow.vue'),
    },
    {
      path: '/me',
      name: 'MeShow',
      component: () => import('../components/MeShow.vue'),
    },

    {
      path: '/sort',
      name: 'SortBar',
      component: () => import('../components/SortBar.vue'),
    },
    {
      path: '/blogview',
      name: 'BlogView',
      component: () => import('../views/blog/BlogView.vue'),
    },
    {
      path: '/blogwrite',
      name: 'write',
      component: () => import('../views/blog/BlogWrite.vue'),
    },
    {
      path: '/foot',
      name: 'FootBar',
      component: () => import('../components/FootBar.vue'),
    },
  ],
})

export default router
