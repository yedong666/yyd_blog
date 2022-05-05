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
      path: '',
      name: 'Home',
      component: () => import('../views/Home.vue'),
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
