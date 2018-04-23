/**
 * Funções utilizadas na página de login parafunção "Lembre-se de mim" que seta um cookie no navegador
 */

$(document).ready(function(){
    $('#frmLogin').submit(function(){
        var inputChecked = $('#remember').prop('checked');
        if(inputChecked) {
            var emailUsr = $('#email').val();
            /**
             * aqui precisa gerar um cookie para guardar email do usuário
             * 
             */
        }
    });
});


