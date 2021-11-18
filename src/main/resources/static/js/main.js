function goBack() {
    window.history.back();
}

$(function() {
    'use strict';

    // MENU ACTIVE
    var current = location.pathname;
    $('.br-sideleft-menu li a').each(function () {
        var $this = $(this);
        // if the current path is like this link, make it active
        if (current.indexOf($this.attr('href')) !== -1) {
            $this.addClass('active');
            if($this.hasClass("sub-link")){
                $this.closest(".br-menu-item").find(".br-menu-link").addClass("show-sub active");
            }
        }
    })
})

// END OF MENU ACTIVE