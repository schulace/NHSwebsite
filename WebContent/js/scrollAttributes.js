$(document).ready(function() {
$("#learnMoreButton").click(function() {
  console.log("Success!");
    $('html, body').animate({
        scrollTop: $("#part1").offset().top
    }, 1500);
});
});
