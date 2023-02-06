/*
    EQUIPO
    ALUMNO: JUAN GERARDO BARRON HERNANDEZ MATRICULA: 33142377
    ALUMNO: EMMANUEL DE JESUS VELASQUEZ MARTINEZ MATRICULA: 35161479
*/
public class ErroresSintacticos
{
      //SE IMPRIME EL ERROR QUE SE HAYA GENERADO EN LA GRAMATICA
	public Tabla Tab = new Tabla();
	public void ImprimirError(String nombre, int linea, int claveError, int error)
	{
		Tab.TablaDeSimbolos();
		switch (error) {
            case 1:  
            System.out.println("Programa Correcto!");
            System.exit(0);
            break;
            case 2:  
            System.out.println("Programa Incorrecto token sobrante ! \n\t"+Tab.RetornoDelToken(claveError) + "\n\t^");
            System.exit(0);
            break;
            case 3:  
            System.out.println(nombre+": Error en la linea "+ linea +": Se esperaba un "+ Tab.RetornoDelToken(18) +" \n\t "+ Tab.RetornoDelToken(claveError) +" \n\t ^");
            System.exit(0);
            break;
            case 4:
            System.out.println(nombre+": Error en la linea "+ linea +": Se esperaba un "+ Tab.RetornoDelToken(21) +" \n\t "+ Tab.RetornoDelToken(claveError) +" \n\t ^");
            System.exit(0);
            break;
            case 5:
            System.out.println(nombre+": Error en la linea "+ linea +": Se esperaba un "+ Tab.RetornoDelToken(19) +" \n\t "+ Tab.RetornoDelToken(claveError) +" \n\t ^");
            System.exit(0);
            break;
            case 6:
            System.out.println(nombre+": Error en la linea "+ linea +": Se esperaba un "+ Tab.RetornoDelToken(16) +" \n\t "+ Tab.RetornoDelToken(claveError) +" \n\t ^");
            System.exit(0);
            break;
            case 7:
            System.out.println(nombre+": Error en la linea "+ linea +": Se esperaba un "+ Tab.RetornoDelToken(16) +" o un "+ Tab.RetornoDelToken(17) +" \n\t "+ Tab.RetornoDelToken(claveError) +" \n\t ^");
            System.exit(0);
            break;
            case 8:
            System.out.println(nombre+": Error en la linea "+ linea +": Se esperaba un ("+Tab.RetornoDelToken(4)+","+Tab.RetornoDelToken(16)+","+Tab.RetornoDelToken(7)+","+Tab.RetornoDelToken(6)+","+Tab.RetornoDelToken(8)+","+Tab.RetornoDelToken(9)+","+Tab.RetornoDelToken(11)+","+Tab.RetornoDelToken(13)+") \n\t "+ Tab.RetornoDelToken(claveError) +" \n\t ^");
            System.exit(0);
            break;
            case 9:
            System.out.println(nombre+": Error en la linea "+ linea +": Se esperaba un "+ Tab.RetornoDelToken(14) +" o un "+Tab.RetornoDelToken(15)+" \n\t "+ Tab.RetornoDelToken(claveError) +" \n\t ^");
            System.exit(0);
            break;
            case 10:
            System.out.println(nombre+": Error en la linea "+ linea +": Se esperaba un "+ Tab.RetornoDelToken(17) +" \n\t "+ Tab.RetornoDelToken(claveError) +" \n\t ^");
            System.exit(0);
            break;
            case 11:
            System.out.println(nombre+": Error en la linea "+ linea +": Se esperaba un signo de coparacion ("+Tab.RetornoDelToken(24)+","+Tab.RetornoDelToken(25)+","+Tab.RetornoDelToken(26)+","+Tab.RetornoDelToken(27)+","+Tab.RetornoDelToken(28)+","+Tab.RetornoDelToken(29)+") \n\t "+ Tab.RetornoDelToken(claveError) +" \n\t ^");
            System.exit(0);
            break;
            case 12:
            System.out.println(nombre+": Error en la linea "+ linea +": Se esperaba un "+ Tab.RetornoDelToken(5) +" \n\t "+ Tab.RetornoDelToken(claveError) +" \n\t ^");
            System.exit(0);
            break;
            case 13:
            System.out.println(nombre+": Error en la linea "+ linea +": Se esperaba un "+ Tab.RetornoDelToken(10) +" \n\t "+ Tab.RetornoDelToken(claveError) +" \n\t ^");
            System.exit(0);
            break;
            case 14:
            System.out.println(nombre+": Error en la linea "+ linea +": Se esperaba un "+ Tab.RetornoDelToken(12) +" \n\t "+ Tab.RetornoDelToken(claveError) +" \n\t ^");
            System.exit(0);
            break;
            case 15:
            System.out.println(nombre+": Error en la linea "+ linea +": Se esperaba un "+ Tab.RetornoDelToken(12) +" o un "+Tab.RetornoDelToken(claveError-1)+" \n\t "+ Tab.RetornoDelToken(claveError) +" \n\t ^");
            System.exit(0);
            break;
            case 16:
            System.out.println(nombre+": Error en la linea "+ linea +": Se esperaba un "+ Tab.RetornoDelToken(23) +" \n\t "+ Tab.RetornoDelToken(claveError) +" \n\t ^");
            System.exit(0);
            break;
        }
	}
}