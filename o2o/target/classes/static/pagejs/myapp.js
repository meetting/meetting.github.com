var app = new Framework7({
    // App root element
    root: '#app',
    // App Name
    name: 'My App',
    routes: [
        {
            name: 'about',
            path: '/about/',
            componentUrl: 'about',
        },
        {
            name: 'login',
            path: '/login/',
            componentUrl: 'login',
        },
        {
            name: 'register',
            path: '/register/',
            componentUrl: 'register',
        },
        {
            name: 'SecondhandMarket',
            path: '/SecondhandMarket/',
            componentUrl: 'SecondhandMarket',
        },
        {
            name: 'cosmetology',
            path: '/cosmetology/',
            componentUrl: 'cosmetology',
        },
        {
            name: 'foodordrink',
            path: '/foodordrink/',
            componentUrl: 'foodordrink',
        },
        {
            name: 'fun',
            path: '/fun/',
            componentUrl: 'fun',
        },
        {
            name: 'edu',
            path: '/edu/',
            componentUrl: 'edu',
        },
        {
            name: 'rentalmarket',
            path: '/rentalmarket/',
            componentUrl: 'rentalmarket',
        },
        {
            name: 'userlogin',
            path: '/userlogin/',
            componentUrl: 'userlogin',
        },
        {
            name: 'intoshop',
            path: '/intoshop/',
            componentUrl: 'intoshop',
        },
        {
            name: 'shopkeeperlogin',
            path: '/shopkeeperlogin/',
            componentUrl: 'shopkeeperlogin',
        },
        {
            name: 'index',
            path: '/index/',
            url: 'index',
        },
        {
            name: 'index',
            path: '/index/',
            url: 'index',
        },
        {
            name: 'shopmanagement',
            path: '/shopmanagement/',
            componentUrl: 'shopmanagement',
        },
        {
            name: 'shopinfo',
            path: '/shopinfo/',
            componentUrl: 'shopinfo',
        }

    ]

});
var mainView = app.views.create('.view-main',{
    pushState:true

});
var swiper = app.swiper.create('.swiper-container', {
    speed: 300,
    effect:"coverflow",
    autoplay:{
        stopOnLastSlide:false,
        disableOnInteraction:false
    },
    pagination:{
        el:'.swiper-pagination',
        clickable:true
    }
});


