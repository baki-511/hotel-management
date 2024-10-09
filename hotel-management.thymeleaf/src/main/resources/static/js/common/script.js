//Header Scroll
let nav = document.querySelector(".navbar");

console.log("Hello Hotel World!!!")

window.onscroll = function () {
  if (document.documentElement.scrollTop > 50) {
    nav.classList.add("header-scrolled");
  } else {
    nav.classList.remove("header-scrolled");
  }
};

//nav hide
let navBar = document.querySelectorAll(".nav-link");
let navCollapse = document.querySelector(".navbar-collapse.collapse");

navBar.forEach(function (a) {
  a.addEventListener("click", function () {
    navCollapse.classList.remove("show");
  });
});

//Swiper Slider
var swiper = new Swiper(".mySwiper", {
  direction: "vertical",
  loop: true,
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  },
  autoplay: {
    delay: 3500,
  },
});

// Counter Design

//Slider JS
var swiper = new Swiper(".our-partner", {
  slidesPerView: 5,
  spaceBetween: 30,
  loop: true,
  autoplay: {
    delay: 2000,
  },

  breakpoints: {
    '991': {
      slidesPerView: 5,
      spaceBetween: 10,
    },
    '767': {
      slidesPerView: 3,
      spaceBetween: 10,
    },
    '320': {
      slidesPerView: 3,
      spaceBetween: 8,
    },
  },
});
