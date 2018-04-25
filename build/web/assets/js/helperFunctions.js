/* 
 * Contém diversas funções que podem vir a ser usadas em várias páginas
 * que ficaram reunidas aqui para facilitar na utlização
 */

/**
 * Seta um cookie na caminho (path) espeficidado
 * @param String nome - Nome do cookie
 * @param String path - Caminho do cookie, caso vazio o caminho é a página atual
 * @param Mixed valor - Valor a ser guardado no cookie
 * @param int expiresTime - Tempo de válidade do cookie **em dias**
 * @returns true  - Caso todos os parametros estejam preenchidos para setar o cookie
 *          false - Caso algum parametro esteja vazio
 */
function setCookie(nome, valor, expiresTime, path) {
    if(typeof nome === "undefined" || typeof valor === "undefined" || typeof expiresTime === "undefined") {
        return false;
    }
    else {
        if(typeof path === "undefined") {
            path = "";
        }
        Cookies.set(nome, valor, {expires: expiresTime, path: path});
        return true;
    }
}

function getCookieValue(nome) {
    if(typeof nome === "undefined") {
        return false;
    }
    else {
        return Cookies.get(nome);
    }
}

/**
 * Remove um cookie setado anteriormente
 * @param String nome - Nome do cookie
 * @param String path - Caminho do cookie, caso vazio o caminho é a página atual
 * @returns true  - Caso o nome do cookie esteja preechido e consiga remover
 *          false - Caso o nome do cookie não esteja preechido
 */
function removeCookie(nome, path) {
    if(typeof nome === "undefined") {
        return false;
    }
    else {
        if(typeof path === "undefined") {
            path = "";
        }
        Cookies.remove(nome, path);
        return true;
    }
}

/**
 * Seta o ano atual na anotação de copyright no footer da página
 * @returns true  - Em encontrando o emelento, procura a string [[ano]] e substitui pelo ano
 *          false - Caso não encontre o elemento com id "copyright"
 */
function setCopyright() {
    var date = new Date();
    var element = $("#copyright");
    if(typeof element === "undefined") {
        return false;
    }
    else {
        var str = element.html();
        element.html( str.replace("[[ano]]", date.getFullYear()) );
        return true;
    }
}
