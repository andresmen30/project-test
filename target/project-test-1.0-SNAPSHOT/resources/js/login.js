
/* global PF */

window.onload = function () {
    PF('buttonLogin').disable();
};

function buttonLogin(inputValidat) {
    var input = jQuery('#loginForm\\:' + inputValidat).val();
    var inputPassword = jQuery('#loginForm\\:password').val();
    var button = PF('buttonLogin');
    if (input.length >= 5 
            && inputPassword !== 'undefined'
            && inputPassword !== '') {
        button.enable();
    } else {
        button.disable(); 
    }

}
