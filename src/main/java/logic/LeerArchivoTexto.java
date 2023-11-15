/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author klob
 */
public class LeerArchivoTexto {
    

    public static void main(String[] args) {
        // Obtiene la ruta del archivo en el directorio de recursos
        String nombreArchivo = "/DiccionarioLAST.txt";

        // Abre el archivo como un recurso del classpath
        try (InputStream is = LeerArchivoTexto.class.getResourceAsStream(nombreArchivo);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            // Lee el contenido del archivo línea por línea
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
