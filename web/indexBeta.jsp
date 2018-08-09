<%-- 
    Document   : indexBeta
    Created on : 10/07/2018, 20:37:08
    Author     : onurb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="google-signin-client_id" content="416664861929-ceaen1jvonlg3vecdhpmnks7029a2gnd.apps.googleusercontent.com">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="g-signin2" data-onsuccess="onSignIn"></div>
        <a href="#" onclick="signOut();">Sign out</a>
    <script>
        function signOut() {
            var auth2 = gapi.auth2.getAuthInstance();
            auth2.signOut().then(function () {
                console.log('User signed out.');
            });
        }
    </script>
    <script>
        function onSignIn(googleUser) {
            var profile = googleUser.getBasicProfile();
            console.log('id_token: ' + googleUser.getAuthResponse().id_token);
            var redirectUrl = 'loginGoogle'
            var form = $('<form action="' + redirectUrl + '" method="post">' +
                    '<input type="text" name="id_token" value="' +
                    googleUser.getAuthResponse().id_token + '" />' +
                    '<input type="text" name="foto" value="' +
                    googleUser.getBasicProfile().getImageUrl() + '" />' +
                    '</form>');
            $('body').append(form);
            form.submit();
        }
    </script>
    
</body>
</html>
