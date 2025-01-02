package Module4;

public class Unix {

    public String simplifyPath(String path) {
        //creamos una variable que nos permita tomar los caracteres entre los // para posteriormente determinar a que categoria funcionan
        String caracteres = "";
        String finalChain = "";
        path = path + "/";
        for (int i = 0; i < path.length(); i++) {
           char elemento =  path.charAt(i);


           if(finalChain == "" && elemento == '/'){
               finalChain = "" + elemento;
           }

           if(elemento != '/'){
               caracteres = caracteres + elemento;
           }

           if((caracteres != "") && elemento == '/' ){
               //en este punto caracteres no esta vacio y el siguiente elemento es un / por lo que encontramos una
               //cadena entre dos / /
               finalChain = finalChain.equals("/") ? "" : finalChain;
               finalChain = finalChain + comprobateChain(caracteres);
               caracteres = "";
           }

        }
        return finalChain;

    }


    private String comprobateChain(String chane){
        System.out.println(chane);
        if(chane.equals("..") || chane.equals(".")){
            return "";
        }else{
            return "/" + chane;
        }
    }


}
